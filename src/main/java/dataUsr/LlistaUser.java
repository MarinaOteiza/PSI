package dataUsr;

/**
 *
 * @author Marina Oteiza
 *
 */
public class LlistaUser {
    private User[] llista;
    private int nElem;

    public LlistaUser(int elem){
        elem=100;//POR AHORA EL NUMERO QUE SEA
        nElem = 0;
        llista = new User[elem];
    }


    public void nuevoUsr(User u){
        if(nElem==0) {
            llista[nElem]=u.copia();
            nElem++;
        }else {
            if(usuarioRegistrado(u) && nElem<=llista.length) {
                llista[nElem]=u.copia();
                nElem++;
            }
        }
    }

    public boolean usuarioRegistrado(User u) {
        boolean trobat=false;
        for(int i=0;i<nElem;i++) {
            if(llista[i].getAlias().equals(u.getAlias())) trobat=true;
        }
        return(trobat);
    }
    public boolean usuarioRegistrado(String alias) {
        boolean trobat=false;
        for(int i=0;i<nElem;i++) {
            if(llista[i].getAlias().equals(alias)) trobat=true;
        }
        return(trobat);
    }

    public int quitaProducto(String alias, String p) {
        int correcto=-1, pos=0;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            if(llista[pos].prodTrobat(p)!=-1) {
                llista[pos].borraProd(p);
                correcto=1;	//intercambio encontrado
            }else correcto=0;//intercambio no encontrado
        }

        return correcto;
    }

    public int quitaIntercambio(String alias, String inter) {
        int correcto=-1, pos=0;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            if(llista[pos].intercambTrobat(inter)!=-1) {
                llista[pos].borraIntercamb(inter);
                correcto=1;	//intercambio encontrado
            }else correcto=0;//intercambio no encontrado
        }
        return correcto;
    }

    public boolean nuevoProducto(String alias, String p) {
        boolean correcto=false;
        int pos=0;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            llista[pos].newProd(p);
            correcto=true;
        }
        return correcto;
    }

    public boolean nuevoIntercambio(String alias, String inter) {
        boolean correcto=false;
        int pos=0;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            llista[pos].newIntercamb(inter);
            correcto=true;
        }
        return correcto;
    }

    public String muestraProd(String alias) {
        String aux;
        int pos=0;
        if(usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            aux = "Lista de productos de "+llista[pos].getAlias()+"\n";
            for(int i=0;i<nElem;i++) {
                aux=aux+"Usuario "+(i+1)+": "+llista[i].showProd()+"\n";
            }
        }else aux="El nombre de usuario no ha sido encontado. Por favor, intentelo de nuevo";
        return aux;
    }
    public String muestraIntercamb(String alias) {
        String aux;
        int pos=0;
        if(usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            aux = "Lista de intercambios de "+llista[pos].getAlias()+"\n";
            for(int i=0;i<nElem;i++) {
                aux=aux+"Usuario "+(i+1)+": "+llista[i].showIntercamb()+"\n";
            }
        }else aux="El nombre de usuario no ha sido encontado. Por favor, intentelo de nuevo";
        return aux;
    }
    private int posUsuario(String alias) {
        int pos=0;
        for(int i=0;i<nElem;i++) {
            if(llista[i].getAlias().equals(alias)) pos=i;
        }
        return pos;
    }

    public String toString() {
        String aux = "Lista de usuarios\n";
        for(int i=0;i<nElem;i++) {
            aux=aux+"Usuario "+(i+1)+": "+llista[i].toString()+"\n";
        }
        return aux;
    }

    public User[] getLlista() {
        return llista;
    }


    public void setLlista(User[] llista) {
        this.llista = llista;
    }


    public int getnElem() {
        return nElem;
    }


    public void setnElem(int nElem) {
        this.nElem = nElem;
    }

}
