package milca;


class OperatorNot extends OperatorUnary {
	
	public boolean get(){
		return !arg.get();
	}

	public static final String identifier = "!";
	
}
