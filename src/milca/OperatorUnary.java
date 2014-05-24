package milca;


class OperatorUnary extends Argument {
	/**
	 * Unary operator. Can function as bracket enclosure.
	 */
	protected Argument right;
	
	public boolean get(){
		return right.get();
	}
	
}
