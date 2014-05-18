package milca;


class OperatorImplicates extends OperatorBinary {
	
	public boolean get(){
		return !left.get() || right.get();
	}

	public static final String identifier = "->";

}
