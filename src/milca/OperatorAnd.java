package milca;


class OperatorAnd extends OperatorBinary {
	
	public boolean get(){
		return left.get() && right.get();
	}

	public static final String[] identifiers = {
		"&", "∧"
	};

}
