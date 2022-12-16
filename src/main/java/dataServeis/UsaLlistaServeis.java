package dataServeis;
import java.util.Scanner;
public class UsaLlistaServeis {
    static Scanner teclat = new Scanner(System.in);

    public static void main(String[] args) {
        int nElem = 0;
        LlistaServeis llista = new LlistaServeis(nElem);
        boolean salir = false; //inicializamos un booleano para poder  salir en caso de que el usuario introduzca la opcio 9
        int opcio;

        do{
            mostraMenu();
            opcio = Integer.parseInt(teclat.nextLine());

            switch (opcio) {
                case 1:
                    opcio1(llista); //Mostra tots els serveis actius
                    esperar();
                    break;
                case 2:
                    opcio2(llista); //Afegir un servei
                    esperar();
                    break;
                case 3:
                    opcio3(llista); //Desactiva un servei
                    esperar();
                    break;
                case 4:
                    opcio4(llista); //Mostra el servei amb mes intercanvis
                    esperar();
                    break;
                case 5:
                    System.out.println("Has salido");
                    salir = true;
                    break;
            }

        }while(!salir);
        teclat.close();
    }

    /** Método que muestra el menú para interactuar con el usuario
     *
     */
    public static void mostraMenu() {
        System.out.println("\n\n Opcions de menu:");
        System.out.println("\n\t1.Mostrar tots els serveis actius");
        System.out.println("\t2. Afegir un servei");
        System.out.println("\t3. Desactivar un servei");
        System.out.println("\t4. Mostrar el servei amb mes intercanvis");
        System.out.println("\t5. Sortir");
        System.out.print("\n\t\t\tIndica opcio:\n");
    }

    /** Método que pide al usuario presionar enter para poder continuar con el programa.
     *Así el uasuario puede ver el resultado antes de que vuelva a aparecer el menú
     *
     */
    private static void esperar(){
        System.out.println("\n\t\tPRESIONE ENTER PARA CONTINUAR..."); //Mensaje en pantalla
        teclat.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
    }
    /** Mètode que mostra tots els serveis activats
     *
     * @param llista Llista de serveis
     */
    private static void opcio1(LlistaServeis llista){
    System.out.println(llista.mostraServeisActius());
    }
    /** Métode que afegeix un servei
     *
     * @param llista Llista de serveis
     */
    private static void opcio2(LlistaServeis llista){
        System.out.println("indica el titol del nou servei a afegir:");
        String titol=teclat.nextLine();
        System.out.println("Indica la data final del servei (dia, mes i any: 00/00/0000): ");
        String fecha2 = teclat.nextLine();
        String[] fechaPartida2 = fecha2.split("/"); //creamos una tabla con las fechas divididas segun "/"
        Data data2 = new Data (Integer.parseInt(fechaPartida2[0]), Integer.parseInt(fechaPartida2[1]), Integer.parseInt(fechaPartida2[2]));
        System.out.println("indica si el servei es troba activat o desactivat: activat=true, desactivat=false");
        boolean estat= Boolean.parseBoolean(teclat.nextLine());
        int intercanvis=0;
        Servei nuevoServicio=new Servei(data2,titol,estat,intercanvis);
        llista.afegirServei(nuevoServicio);
    }
    /** Métode que descativa un servei
     *
     * @param llista Llista de serveis
     */
    private static void opcio3(LlistaServeis llista){
        System.out.println("quin servei vols desactivar?");
        String titol = teclat.nextLine();
        System.out.println("Indica la data en la qual es vol desactivar el servei (dia, mes i any: 00/00/0000): ");
        String fecha2 = teclat.nextLine();
        String[] fechaPartida2 = fecha2.split("/"); //creamos una tabla con las fechas divididas segun "/"
        Data data2 = new Data (Integer.parseInt(fechaPartida2[0]), Integer.parseInt(fechaPartida2[1]), Integer.parseInt(fechaPartida2[2]));
        if(!llista.desactivaServei(titol,data2))
            System.out.println("no s'ha trobat el servei que es vol eliminar");
        }
    /** Mètode que mostra el servei amb més intercanvis
     *
     * @param llista Llista de serveis
     */
    private static void opcio4(LlistaServeis llista){
      System.out.println("El servei amb mes intercanvis es:"+llista.mesIntercanvis());

        }
    }



