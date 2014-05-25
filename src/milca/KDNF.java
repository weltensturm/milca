package milca;

public class KDNF {
	public String calcKDNF(String ergebnis)
    {
        String kdnf ="";
        String var = "";
        if(ergebnis != null)
        {
            char erg[] = ergebnis.toCharArray();
            if(ergebnis.length() == 2 || ergebnis.length() == 4 || ergebnis.length() == 8 || ergebnis.length() == 16 || ergebnis.length() == 32 || ergebnis.length() == 64)
            {
                double h= Math.log((double) ergebnis.length()) / Math.log(2d);
                Wahrheitstabelle wahrheitstabelle = new Wahrheitstabelle((int) h);
                wahrheitstabelle.makeTabelleV();
                for(int i=0; i < erg.length; i++)
                {
                    if(erg[i] == 'f')
                    {
                        kdnf+="(";
                        for(int ti =0; ti < wahrheitstabelle.tabelle[i].length; ti++)
                        {
                            if(ti == 0)
                                var = "p";
                            if(ti == 1)
                                var = "q";
                            if(ti == 2)
                                var = "r";
                            if(ti == 3)
                                var = "s";
                            if(ti == 4)
                                var = "t";
                            if(ti == 5)
                                var = "u";
                            if(wahrheitstabelle.tabelle[i][ti])
                                kdnf+= var + "&";
                            else
                                kdnf+= "!" + var + "&";
                            }
                        kdnf= kdnf.substring(0, kdnf.length()-1);
                        kdnf+=") | ";
                    }
                }
                kdnf= kdnf.substring(0, kdnf.length()-3);
                return kdnf;
            }
            else
            {
                return "Eingegebene Werte müssen 2,4,8,16,32 oder 64 Zeichen haben";
            }
        }
        else
        {
            return "Kein wert eingegeben.";
        }
    }
}
