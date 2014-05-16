package milca;


class OperatorOr extends OperatorBinary {

	public boolean get(){
		return left.get() || right.get();
	}

	public static final String identifier = "|";
	
}
