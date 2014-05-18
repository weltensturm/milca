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
		operators.add(OperatorEquivalent.class);
		operators.add(OperatorImplicates.class);
		operators.add(OperatorOr.class);
		operators.add(OperatorAnd.class);
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
			root = parse(formula, 0);
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
			String str = (String)cls.getField("identifier").get(null);
			int weakestPos = findOperator(text, str);
			if(weakestPos >= 0){
				System.out.println("Found " + str);
				OperatorBinary arg = (OperatorBinary)cls.newInstance();
				arg.left = parse(text.substring(0, weakestPos), 0);
				arg.right = parse(text.substring(weakestPos+str.length(), text.length()), weakestPos+str.length());
				return arg;
			}
	
		}

		int bracketLevel = 0;
		int parallelBrackets = 0;
		boolean invert = false;
		char varchar = '0';
		
		for(int i=0; i<text.length(); i++){
			switch(text.charAt(i)){
				case '(':
					bracketLevel++;
					break;
				case ')':
					bracketLevel--;
					if(bracketLevel == 0)
						parallelBrackets++;
					break;
				case ' ':
					continue;
				case '!':
					if(bracketLevel == 0){
						invert = !invert;
					}
					break;
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
					if(bracketLevel == 0){
						if(varchar != '0')
							throw new Exception("Invalid Syntax (too many variables) at " + (i+parsestart));
						varchar = text.charAt(i);
					}
					break;
				default:
					if(bracketLevel == 0)
						throw new Exception("Invalid Syntax (unknown character \"" + text.charAt(i) + "\") at " + (i+parsestart));
			}
		}
		if(parallelBrackets > 1)
			throw new Exception("Invalid Syntax (too many brackets)");
		
		if(varchar == '0'){
			return parse(stripOuterBrackets(text), parsestart);
		}
		if(invert){
			OperatorNot arg = new OperatorNot();
			Variable var = new Variable();
			var.name = "" + varchar;
			arg.arg = var;
			variables.add(var);
			return arg;
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
		return "wtf";
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


