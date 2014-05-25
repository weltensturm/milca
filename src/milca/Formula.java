package milca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Formula {
	
	protected Argument root;
	protected List<Variable> variables;
	protected List<Class<?>> operators;
	
	public Formula(){
		operators = new ArrayList<Class<?>>();
		// least binding first
		operators.add(OperatorEquivalent.class);
		operators.add(OperatorImplicates.class);
		operators.add(OperatorOr.class);
		operators.add(OperatorAnd.class);
		operators.add(OperatorNot.class);
		variables = new ArrayList<Variable>();
	}
	
	public void setVariable(String name, boolean state) throws Exception {
		if(root == null)
			throw new Exception("No formula loaded");
		for(Variable v: variables){
			if(v.name.equals(name)){
				v.state = state;
				return;
			}
		}
		throw new Exception("No variable \"" + name + "\"");
	}
	
	public void setFormula(String formula){
		try {
			root = parse(formula.toLowerCase(), 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean calculate(){
		return root.get();
	}
	
	public Argument parse(String text, int parsestart) throws Exception {
		// find weakest binding operator
		System.out.println("Parsing " + text);

		for(Class<?> cls: operators){
			String[] ids = (String[])cls.getField("identifiers").get(null);
			int weakestPos = -1;
			String opstr = "";
			for(String str: ids){
				int pos = findOperator(text, str);
				if((weakestPos < 0 || pos < weakestPos) && pos >= 0){
					opstr = str;
					weakestPos = pos;
				}
			}
			if(weakestPos >= 0){
				System.out.println("Found " + opstr);
				int rightStart = weakestPos+opstr.length();
				if(OperatorBinary.class.isAssignableFrom(cls)){
					OperatorBinary result = (OperatorBinary)cls.newInstance();
					result.left = parse(text.substring(0, weakestPos), 0);
					result.right = parse(text.substring(rightStart, text.length()), rightStart);
					return result;
				}else{
					String left = text.substring(0, weakestPos);
					if(left.trim().length() != 0)
						throw new Exception("Invalid Syntax (garbage left of unary operator) at " + parsestart+weakestPos);
					OperatorUnary result = (OperatorUnary)cls.newInstance();
					result.right = parse(text.substring(rightStart, text.length()), rightStart);
					return result;
				}
			}
		}

		int bracketLevel = 0;
		int parallelBrackets = 0;
		char varchar = '0';
		
		int i=0;
		for(char c: text.toCharArray()){
			if(c == '(')
				bracketLevel++;
			else if(c == ')'){
				bracketLevel--;
				if(bracketLevel == 0)
					parallelBrackets++;
			}
			else if(c == ' ')
				continue;
			else if(c >= 'a' && c <= 'z'){
				if(bracketLevel == 0){
					if(varchar != '0')
						throw new Exception("Invalid Syntax (too many variables) at " + (i+parsestart));
					varchar = c;
				}
			}else
				if(bracketLevel == 0)
					throw new Exception("Invalid Syntax (unknown character \"" + c + "\") at " + (i+parsestart));
			i++;
		}
		
		if(bracketLevel > 0)
			throw new Exception("Invalid Syntax (too many brackets)");
		if(parallelBrackets > 1)
			throw new Exception("Invalid Syntax, Brackets not connected with operator");
		
		if(varchar == '0'){
			return parse(stripOuterBrackets(text), parsestart);
		}
		Variable arg;
		arg = new Variable();
		arg.name = "" + varchar;
		variables.add(arg);
		return arg;

	}
	
	protected int findOperator(String where, String op){
		int start = 0;
		int level = 0;
		for(int i=0; i<where.length(); i++){
			if(where.charAt(i) == '(')
				level++;
			else if(where.charAt(i) == ')')
				level--;
			else if(level == 0)
				if(where.charAt(i) == op.charAt(start)){
					start++;
				}else
					start = 0;
				if(start == op.length())
					return i-start+1;
		}
		return -1;
	}

	protected String stripOuterBrackets(String text){
		text = text.trim();
		if(text.charAt(0) == '(' && text.charAt(text.length()-1) == ')'){
			return text.substring(1,text.length()-1);
		}
		return text;
	}
	
}

/*
f = (p | (r -> s)) & q

parse(f)
	arg1 = parse(p | (r -> s))
		arg1 = p
		operator = |
		arg2 = parse(r -> s)
			arg1 = r
			operator = ->
			arg2 = s
	operator = &
	arg2 = q
*/


