package milca;


class OperatorNot extends OperatorUnary {
	
	public boolean get(){
		return !right.get();
	}

	public static final String[] identifiers = {
		"!", "¬"
	};
	
}
