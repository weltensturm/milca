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
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean calculate(){
		return root.get();
	}
	
	public Argument parse(String text) throws NoSuchFieldException, SecurityException {
		// find weakest binding operator
		for(Map.Entry<String,Class<Argument>> entry: operators.entrySet()){
			String operator = entry.getValue().getField("identifier").toString();
			int pos = text.indexOf(operator);
			if(pos < 0)
				continue;

			String[] args = new String[2];
			int active = 0;
			int brackets = 0;
			for(int i=0; i<text.length(); i++){
				if(text.charAt(i) == '(')
					brackets++;
				if(text.charAt(i) == ')')
					brackets--;
				args[active] += text.charAt(i);
			}
		}
		return parse(stripOuterBrackets(text));
		
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


