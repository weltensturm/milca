package milca;


public class Formula {
	
	protected Argument root;
	protected Variable[] variables;
	
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
	
	public boolean calculate(){
		return root.get();
	}
	
	public void parse(String text){
		
	}
	
}

