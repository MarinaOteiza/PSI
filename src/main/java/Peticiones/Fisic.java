package Peticiones;

public class Fisic {

    private String peticio_interc;
    private String usuari_petic;
    private int valoracio_usuari;
    private int valoracio_usupetic;
    private boolean peticio_AoD;            //Peticio acceptada o denegada

    public Fisic(String petiint, String usupeti){
        peticio_interc=petiint;
        usuari_petic=usupeti;
        valoracio_usuari=0;
        valoracio_usupetic=0;
        peticio_AoD=false;
    }

    public void contestarF(Fisic f1, boolean AoD){
        if(AoD==true){
            f1.peticio_AoD=true;
        }
    }

    public void valoracioF(int valUsu, int valClient){
        valoracio_usuari=valUsu;
        valoracio_usupetic=valClient;
    }

    public boolean getPeticio(){
        return(peticio_AoD);
    }
}
