package milca;


class SyntaxError extends Exception {

	int errorPos;
	int errorLength;
	
	public SyntaxError(String description, int start, int length){
		super("Invalid Syntax: " + description);
		errorPos = start;
		errorLength = length;
	}
	
	private static final long serialVersionUID = -1190043192007646209L;
	
}