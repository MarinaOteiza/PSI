package dataServeis;

public class LlistaServeis {
    public Servei[] llista;
    public int nElem;

    public LlistaServeis(int elem) {
        nElem = 0;
        llista = new Servei[elem];
    }

    /**
     * Método que permite mostrar por pantalla LlistaServeis
     *
     * @return String con toda la informacion de la lista
     */
    public String toString() {
        String aux = "LLista Serveis => Serveis: " + nElem;
        for (int j = 0; j < nElem; j++) {
            aux = aux + "\n\tServei " + (j + 1) + "\t " + llista[j];
        }
        return aux;
    }

    /**
     * Método que añade un servicio al final de la lista
     *
     * @param nuevoServicio contiene lel nuevo servicio que queremos añadir
     */
    public void afegirServei(Servei nuevoServicio) {
        if (nElem <= llista.length) {
            llista[nElem] = nuevoServicio;
            llista[nElem] = nuevoServicio.copia();
            nElem++;
        }
    }

    /**
     * Método que indica cuál es el servicio con mas intercambios
     *
     * @return la copia de la instancia del servicio
     */
    public Servei mesIntercanvis() {
        int numIntercanvis, n = 0, l = 0;
        numIntercanvis = llista[n].getIntercanvis();
        for (n = 0; n < nElem; n++) {
            if (numIntercanvis <= llista[n].getIntercanvis()) { //si el numero de inetrcanvis  es inferior al numero de intercanvis de la posicion analizada
                numIntercanvis = llista[n].getIntercanvis(); //actualizamos el numero de dias max del cartel
                l = n; //guardamos la posicion de numIntercanvis en l
            }
        }
        return llista[l].copia(); //Se muestra por pantalla el servicio (con el numero de intercanvis)
    }

    public boolean desactivaServei(String titol,Data data2) {
        boolean trobat = false;
        for (int n=0; n < nElem; n++) {
            if (llista[n].esTrobaEnAquestTitol(titol))
                llista[n].desactivaServei();
                llista[n].canviaData(data2);
        }
        return trobat;
    }
    public String mostraServeisActius( ){
        LlistaServeis aux = new LlistaServeis(nElem);
        int i=0;
        while(i<nElem){
            if(llista[i].getEstat( )){
                    aux.afegirServei(llista[i]);    //Se desplaza el resto de la lista para eliminarla y no dejar huecos
            }
            i++;
        }
        return aux.toString();
    }

}






