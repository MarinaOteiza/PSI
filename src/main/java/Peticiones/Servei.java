package Peticiones;

public class Servei {
    private String peticio_interc;
    private String usuari_petic;
    private int valoracio_usuari;
    private int valoracio_usupetic;
    private boolean peticio_AoD;            //Peticio acceptada o denegada

    public Servei(String petiint, String usupeti){
        peticio_interc=petiint;
        usuari_petic=usupeti;
        valoracio_usuari=0;
        valoracio_usupetic=0;
        peticio_AoD=false;
    }

    public void contestarS(Servei s1, boolean AoD){
        if(AoD==true){
         s1.peticio_AoD=true;
        }
    }

    public void valoracioS(int valUsu, int valClient){
        valoracio_usuari=valUsu;
        valoracio_usupetic=valClient;
    }
}
