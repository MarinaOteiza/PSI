package Peticiones;

public class LlistaFisic extends Peticiones {
    private Fisic LlistaF[];
    private int numllist;

    public LlistaFisic(String codi, String usuari, String producte, String tipus_producte, int num){
        super(codi,usuari,producte,tipus_producte);
        LlistaF= new Fisic[num];
        numllist=0;
    }

    public void addF(Fisic f1){
        int i=0;
        boolean trobat=false;
        if(numllist<=LlistaF.length){
            while (i<numllist && !trobat){
                if(LlistaF[i].getPeticio()==true){
                    trobat=true;
                }
            }
            if(!trobat){
                LlistaF[numllist]=f1;
                numllist++;
            }
        }
    }
}
