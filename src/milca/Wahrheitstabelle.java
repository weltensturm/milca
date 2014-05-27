package milca;


public class Wahrheitstabelle {
	
	public boolean [][] tabelle;

	public Wahrheitstabelle(int variables) throws Exception {
        if(variables > 6 || variables <= 0)
        	throw new Exception("Only 1-6 variables allowed, got " + variables);
        tabelle = new boolean[(int)Math.pow(2, variables)][variables];
    }

	public void makeTabelleV(){
		for(int i=0; i<tabelle.length; i++){
			for(int j=0; j<tabelle[i].length; j++){
				tabelle[i][j] = ((i >> j) & 1) == 1;
			}
		}
    }
	
}
