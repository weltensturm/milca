package milca;

public class Wahrheitstabelle {
	public boolean [][] tabelle;
    private int next;
    
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
    
	public Wahrheitstabelle(int zahl)
    {
        if(zahl <=6 && zahl >0)
            tabelle= new boolean [(int) Math.pow(2d,zahl)][zahl];
        else
        {
            System.out.println("Falsche werte bei zahl");
            tabelle= new boolean [(int) Math.pow(2d,zahl)][6];
        }
    }

	public void makeTabelleV()
    {
        int h = tabelle[0].length;
        for(int i =0; i < tabelle.length; i++)
        {
            int k =0;
            for(int z=h-1; z >= 0; z--)
            {
                if((i/(int) Math.pow(2, z))%2==1)
                    tabelle[i][k]=true;
                else
                    tabelle[i][k]=false;
                k++;
            }
        }
    }
	
}
