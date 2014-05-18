package milca;

import java.util.HashMap;
import java.util.Map;


public class Formula {
	
	protected Argument root;
	protected Variable[] variables;
	protected HashMap<String,Class<Argument>> operators;
	
	public void setVariable(String name, boolean state) throws Exception {
		if(root != null)
			throw new Exception("No formula loaded");
		for(int i=0; i<variables.length; i++){
			if(variables[i].name == name){
				variables[i].state = state;
				return;
			}
		}
		throw new Exception("No variable \"" + name + "\"");
	}
	
	public void setFormula(String formula){
		try {
			root = parse(formula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean calculate(){
		return root.get();
	}
	
	public Argument parse(String text, int parsestart){
		// find weakest binding operator
		try {
			for(Map.Entry<String,Class<Argument>> entry: operators.entrySet()){
				Class<?> cls = entry.getValue();
				String str = cls.getField("identifier").toString();

				str = cls.getField("identifier").toString();
				int weakestPos = findOperator(text, str);
				if(weakestPos >= 0){
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
						invert = !invert;
						break;
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
						if(varchar != '0')
							throw new Exception("Invalid Syntax (too many variables) at " + (i+parsestart));
						varchar = text.charAt(i);
						break;
					default:
						throw new Exception("Invalid Syntax (unknown character) at " + (i+parsestart));
				}
			}
			if(parallelBrackets > 1)
				throw new Exception("Invalid Syntax (too many brackets)");
			
			if(invert){
				OperatorNot arg = new OperatorNot();
				Variable var = new Variable();
				var.name = "" + varchar;
				arg.arg = var;
			}else{
				Argument arg;
				arg = new Variable();
			}	
			
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			return text.substring(1,text.length()-2);
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


