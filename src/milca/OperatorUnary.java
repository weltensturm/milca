package milca;


class OperatorUnary extends Argument {
	/**
	 * Unary operator. Can function as bracket enclosure.
	 */
	protected Argument arg;
	
	public boolean get(){
		return arg.get();
	}
	
}
