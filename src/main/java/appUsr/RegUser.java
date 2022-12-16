package appUsr;

        import dataUsr.*;
        import java.io.*;
        import java.util.Scanner;

/**
 *
 * @author Marina Oteiza
 *
 */
public class RegUser{
    public static void main(String[] args) throws IOException{

        Scanner teclat = new Scanner(System.in);
        int opcion;
        boolean exit=false;
        LlistaUser llista = new LlistaUser(100);

        do{
            menu();
            opcion = Integer.parseInt(teclat.nextLine());
            switch(opcion) {
                case 1:
                    nuevoUsuario(llista);
                    break;
                case 2:
                    verUsers(llista);
                    break;
                case 3:
                    verProds(llista);
                    break;
                case 4:
                    verIntercamb(llista);
                    break;
                case 5:
                    sumaProd(llista);
                    break;
                case 6:
                    sumaIntercamb(llista);
                    break;
                case 7:
                    menosProd(llista);
                    break;
                case 8:
                    menosIntercamb(llista);
                    break;
                case 9:
                    System.out.println("Has salido");
                    exit=true;
                    break;
            }
        }while(!exit);
        teclat.close();
    }

    private static void menu() {
        System.out.println("Que quieres hacer? ");
        System.out.println("1-Nuevo registro ");
        System.out.println("2-Ver usuarios registados ");
        System.out.println("2-Ver productos ");
        System.out.println("2-Ver intercambios ");
        System.out.println("5-Sumar producto ");
        System.out.println("6-Sumar intercambio");
        System.out.println("7-Quitar producto ");
        System.out.println("8-Quitar intercambio");
        System.out.println("9-Salir ");
        System.out.print("\n\t\t\tIndica opcion:\n");
    }

    private static void nuevoUsuario(LlistaUser llista) {
        Scanner teclat = new Scanner(System.in);

        String alias=null, correo;
        int codiPost;
        User nou;
        //boolean llegit=false;

        System.out.println("REGISTRO NUEVO ");
//		if(llista.getnElem()==0) {
//			while(!llegit) {
//				try {
//					System.out.println("Introduce un alias: ");
//	        		alias=teclat.nextLine();
//				}catch(NoSuchElementException e){
//					System.out.println("no puedes introducir solo valores numéricos");
//				}
//				llegit=true;
//				System.out.println("Usuario válido");
//			}
//
//		}else {
//			while(!llegit) {
//
//		        	do{
//		        		try {System.out.println("Introduce un alias: ");
//		        		alias=teclat.nextLine();
//		        		}catch(NoSuchElementException e){
//							System.out.println("no puedes introducir solo valores numéricos");
//						}
//		        		if(llista.usuarioRegistrado(alias))
//		        			System.out.println("Lo sentimos pero ese nombre ya ha sido ocupado, "
//		        				+ "prueba con otro");
//		        		else {
//		        			System.out.println("Usuario válido");
//		        			llegit=true;
//		        		}
//		        	}while(llista.usuarioRegistrado(alias));
//			}
//		}



        System.out.println("Introduce un alias: ");
        alias=teclat.nextLine();
        System.out.println("CORREO ELECTRONICO: ");
        correo= teclat.nextLine();
        System.out.println("CODIGO POSTAL: ");
        codiPost=Integer.parseInt(teclat.nextLine());
        nou=new User(alias, correo, codiPost);
        llista.nuevoUsr(nou);
        System.out.println("Usuario guardado correctamente: "+llista.toString());
        teclat.close();
//
//        if(usuarioRegistrado(nou))System.out.println("Usuario guardado correctamente");
//

    }
    private static void sumaProd(LlistaUser llista) {
        Scanner teclat = new Scanner(System.in);
        String p;
        String a=pedirAlias(llista);
        System.out.println("Que producto quieres añadir? ");
        p=teclat.nextLine();
        if(llista.nuevoProducto(a, p)) System.out.println("Producto añadido correctamente");
        teclat.close();
    }
    private static void sumaIntercamb(LlistaUser llista) {
        Scanner teclat = new Scanner(System.in);
        String i;
        String a=pedirAlias(llista);
        System.out.println("Que intercambio quieres añadir? ");
        i=teclat.nextLine();
        if(llista.nuevoIntercambio(a, i)) System.out.println("Producto añadido correctamente");
        teclat.close();
    }
    private static void menosProd(LlistaUser llista) {
        Scanner teclat = new Scanner(System.in);
        String p;
        String a=pedirAlias(llista);
        System.out.println("Que intercambio quieres quitar? ");
        p=teclat.nextLine();
        if(llista.quitaProducto(a, p)==0) System.out.println("No se ha encontrado el producto");
        if(llista.quitaProducto(a, p)==1) System.out.println("Producto quitado correctamente");
        teclat.close();
    }
    private static void menosIntercamb(LlistaUser llista) {
        Scanner teclat = new Scanner(System.in);
        String i;
        String a=pedirAlias(llista);
        System.out.println("Que intercambio quieres quitar? ");
        i=teclat.nextLine();
        if(llista.quitaIntercambio(a, i)==0) System.out.println("No se ha encontrado el intercambio");
        if(llista.quitaIntercambio(a, i)==1) System.out.println("Intercambio quitado correctamente");
        teclat.close();
    }


    private static String pedirAlias(LlistaUser llista) {
        Scanner teclat = new Scanner(System.in);
        String a;
        do{
            System.out.println("Introduce un alias: ");
            a=teclat.nextLine();
            if(!llista.usuarioRegistrado(a))System.out.println("Usuario no encontrado, vuelve "
                    + "a intentarlo\n");
        }while(!llista.usuarioRegistrado(a));
        teclat.close();
        return a;
    }
    private static void verUsers(LlistaUser llista) {
        llista.toString();
    }
    private static void verProds(LlistaUser llista) {
        llista.muestraProd(pedirAlias(llista));
    }
    private static void verIntercamb(LlistaUser llista) {
        llista.muestraIntercamb(pedirAlias(llista));
    }
}