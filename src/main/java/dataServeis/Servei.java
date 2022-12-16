package dataServeis;

public class Servei {

    private Data dataFi;		// ultima data d'activacio servei
    private String titol;
    private boolean estat;
    private int intercanvis;

    public Servei(Data dataFi, String titol, boolean estat, int intercanvis) {

        this.dataFi=dataFi;
        this.titol=titol;
        this.estat=estat;
        this.intercanvis=intercanvis;
    }

    /** getter que obtiene la fecha final
     *
     * @return fecha final
     */
    public Data getDataFi() {
        return dataFi;
    }
    /** getter que obte el nombre de intercanvis
     *
     * @return intercanvis
     */
    public int getIntercanvis() {
        return intercanvis;
    }
    /** getter que obte el estado de activacion
     *
     * @return estat
     */
    public boolean getEstat(boolean estat) {
        return estat;
    }

    /** Método que hace la copia de Servei
     *
     * @return duplicado de la instancia de Servei
     */
    public Servei copia() {
        Servei aux=new Servei(dataFi, titol,estat,intercanvis);
        return aux;
    }

    /** Método que muestra Serevi
     *
     * @return String con toda la información
     */
    public String toString() {
        return "Servei [dataFi=" + dataFi + ", titol=" + titol+ ", activacio=" +estat+ ", intercanvis=" +intercanvis;
    }

    public void desactivaServei( ) {
        estat=false;
    }




}

