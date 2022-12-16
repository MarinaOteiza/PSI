package Peticiones;

public class LlistaPeticiones {
    private Peticiones LlistaP[];
    private int numllist;

    public LlistaPeticiones(int num){
        LlistaP= new Peticiones[num];
        numllist=0;
    }

    public void addP(Peticiones p1){
        if(numllist<=LlistaP.length){
            LlistaP[numllist]=p1;
            numllist++;
        }
    }
}
