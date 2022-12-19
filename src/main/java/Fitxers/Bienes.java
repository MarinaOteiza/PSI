package Fitxers;

public class Bienes {
    private int cod;
    private String descripcion;
    private String tipus;
    private Data oferta;
    private Data intercanvi;
    private int alt;
    private int amp;
    private int fons;
    private float pes;
    public Bienes(int codi, String descrip, String type, Data off, int altu, int ampli , int fond, float pes2) {
        cod= codi;
        descripcion=descrip;
        tipus=type;
        oferta=off;
        intercanvi=null; // en el constructor no rebem cap data d'intercanvi , les afegim despres
        alt=altu;
        amp=ampli;
        fons=fond;
        pes=pes2;

    }

    public int GetCod() {
        return cod;
    }
    public String GetDesc() {
        return descripcion;
    }
    public String GetTipus() {
        return tipus;

    }
    public Data GetOff() {
        return oferta;
    }
    public Data GetInt() {
        return intercanvi;
    }
    public int GetAlt() {
        return alt;
    }
    public int GetAmp() {
        return amp;
    }
    public int GetFons() {
        return fons;
    }
    public float GetPes() {
        return pes;
    }

    public void afegirIntercanvi(Data inter) {
        intercanvi=inter.copia();

    }
    public Bienes copia() {
        Bienes aux=new Bienes(cod, descripcion, tipus, oferta,alt,amp, fons, pes );
        aux.afegirIntercanvi(intercanvi);
        return aux;
    }


}



