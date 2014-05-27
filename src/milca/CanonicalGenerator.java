package milca;

public class CanonicalGenerator {
	
	public static String calcKKNF(String truthString) throws Exception {
		return calcCanonical(truthString, true);
	}
	
	public static String calcKDNF(String truthString) throws Exception {
		return calcCanonical(truthString, false);
	}
	
	protected static boolean isPowerOf2(int value){
		return ((value & -value) == value);
	}
	
	public static String calcCanonical(String truthString, boolean conjunctive) throws Exception {
		if(truthString == null)
			throw new Exception("truthString null");
		
        int length = truthString.length();
        
        if(!isPowerOf2(length))
        	throw new SyntaxError("String length not 2^n", 0, truthString.length()-1);

        String result = "";
        
        int variables = (int)(Math.log(length) / Math.log(2));
        Wahrheitstabelle table = new Wahrheitstabelle(variables);
        table.makeTabelleV();
        
        String not1 = (conjunctive ? "!" : "");
        String not2 = (conjunctive ? "" : "!");
        String inner = (conjunctive ? " & " : " | ");
        String outer = (conjunctive ? " | " : " & ");
        char lookFor = (conjunctive ? 'w' : 'f');
        
        for(int i=0; i<length; i++){
        	if(truthString.charAt(i) != lookFor)
        		continue;
        	result += "(";
        	for(int j=0; j<table.tabelle[i].length; j++){
        		result += (table.tabelle[i][j] ? not1 : not2) + (char)('p'+j) + inner;
        	}
    		result = result.substring(0, result.length() - 3);
        	result += ")" + outer;
        }
        return result.substring(0, result.length() - 3);
    }
}
