package parking;



import java.util.*;
public class Utilidades {
    private static final Scanner TECLADO = new Scanner(System.in);
    //metodo para mostrar una linea por pantalla
    public static void p(String s) {
        System.out.print(s);
    }
    //metodo para mostrar una linea por pantalla con salto de linea
    public static void pln(String s) {
        System.out.println(s);
    }

    public static int entero() throws Exception {
        return entero("");
    }
    //metodo para introducir un entero
    public static int entero(String s) {
        int res = 0;
        boolean vale = true;
        do {
            vale = true;
            p(s);
            try {
                res = TECLADO.nextInt();
            } catch (Exception e) {
                vale = false;
                TECLADO.next();
            }
        } while (!vale);
        TECLADO.nextLine();
        return res;
    }
    
     public static String cadena() {
        return cadena("");
    }
    //metodo para introducir una cadena
    public static String cadena(String s) {
        String res = "";
        boolean vale = true;
        do {
            p(s);
            vale = true;
            try {
                res = res + TECLADO.nextLine();
                //p(res);
            } catch (Exception e) {
                vale = false;
                TECLADO.next();
            }
        } while (!vale);
//        teclado.nextLine();
        return res;

    }

}
