package Peticiones;

public class LlistaServei extends Peticiones {
    private Servei LlistaS[];
    private int numllist;

    public LlistaServei(String codi, String usuari, String producte, String tipus_producte, int num){
        super(codi,usuari,producte,tipus_producte);
        LlistaS= new Servei[num];
        numllist=0;
    }

    public void addS(Servei s1){
        if(numllist<=LlistaS.length){
            LlistaS[numllist]=s1;
            numllist++;
        }
    }

}
