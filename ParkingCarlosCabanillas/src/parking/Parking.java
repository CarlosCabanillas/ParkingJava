package parking;


import java.*;

public class Parking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        //Inicializacion de la matriz del parking
        int filas, columnas;
        filas = 5;
        columnas = 10;
        char[][] parking = generarParking(filas, columnas);
        int recC, recM, recA;
        recC = 0;
        recM = 0;
        recA = 0;
        boolean salir = false;
        //menu del programa
        do {
            int n = Utilidades.entero("Introduzca la opcion que desea realizar\n"
                    + "1.	Ver el parking\n"
                    + "2.	Entrada de un coche\n"
                    + "3.	Entrada de una moto\n"
                    + "4.	Entrada de un autobus\n"
                    + "5.	Salida de un vehiculo\n"
                    + "6.	Ver recaudacion\n"
                    + "7.	Salir del programa\n");
            switch (n) {
                //caso para mostrar el parking
                case 1:
                    mostrarParking(parking);
                    break;
                //caso para añadir un coche
                case 2:
                    if (comprobarPlaza(parking, 'C')) {
                        recC += 5;
                    }
                    break;
                //caso para añadir una moto
                case 3:
                    if (comprobarPlaza(parking, 'M')) {
                        recM += 3;
                    }
                    break;
                //caso para añadir un autobus
                case 4:
                    if (comprobarPlaza(parking, 'A')) {
                        recA += 10;
                    }
                    break;
                //caso para eliminar un vehiculo
                case 5:
                    eliminarPlaza(parking);
                    break;
                //caso para mostrar la recaudacion
                case 6:
                    Utilidades.pln("Dinero recaudado por los coches: " + recC);
                    Utilidades.pln("Dinero recaudado por las motos: " + recM);
                    Utilidades.pln("Dinero recaudado por lo autobuses: " + recA);
                    Utilidades.pln("Recaudacion total: " + (recC + recM + recA));
                    break;
                //caso para finalizar el programa
                case 7:
                    Utilidades.pln("Hasta la proxima");
                    salir = true;
                    break;
                default:
                    Utilidades.pln("Opcion invalida");
                    break;

            }
        } while (!salir);
    }
    //metodo para generar el parking
    public static char[][] generarParking(int filas, int columnas) {
        char[][] parking = new char[filas][columnas];
        //recorremos la matriz e introducimos en cada caso la opcion correspondiente
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (i == 0 && j == 0 || i == 0 && j == 9 || i == 4 && j == 0 || i == 4 && j == 9 || i == 2 && j == 0) {
                    parking[i][j] = 'X';
                } else if (i == 1 && j == 0) {
                    parking[i][j] = 'E';
                } else if (i == 3 && j == 0) {
                    parking[i][j] = 'S';
                } else if (i == 0 && (j > 0 && j < 9) || i == 4 && ((j > 0 && j < 9)) || j == 9 && (i > 0 && i < 4)) {
                    parking[i][j] = 'P';
                } else {
                    parking[i][j] = '-';
                }

            }
        }

        return parking;
    }
    //metodo para mostrar el parking
    public static void mostrarParking(char[][] parking) {
        for (int i = 0; i < parking.length; i++) {
            System.out.print("|");
            for (int j = 0; j < parking[i].length; j++) {
                System.out.print(parking[i][j]);
                System.out.print("|");
            }
            System.out.println("\n");
        }
    }
    //metodo para comprobar una plaza y añadir un vehiculo segun corresponda
    public static boolean comprobarPlaza(char[][] parking, char opcion) {
        int fila = Utilidades.entero("Introduzca la fila\n");
        int columna = Utilidades.entero("Introduzca la columna\n");
        boolean libre = false;
        //comprobamos que la posicion introducida sea valida
        if (fila>parking.length ||columna>parking[0].length){
            Utilidades.pln("Plaza incorrecta");
        }else{
        //si la posicion esta vacia introducimos un vehiculo segun la opcion seleccionada
        if (parking[fila][columna] == '-') {
            libre = true;
            switch (opcion) {
                //introduccion del coche
                case 'C':
                    crearCoche();
                    parking[fila][columna] = opcion;
                    break;
                //introduccion de una moto
                case 'M':
                    crearMoto();
                    parking[fila][columna] = opcion;
                    break;
                //introduccion de un autobus
                case 'A':
                    crearAutobus();
                    parking[fila][columna] = opcion;
                    break;

            }
        } else {
            Utilidades.pln("Plaza ocupada");
        }}
        return libre;
    }
    //metodo para crear un coche
    public static void crearCoche() {
        String matricula = Utilidades.cadena("Introduzca la matricula\n");
        String marca = Utilidades.cadena("Introduzca la marca\n");
        String modelo = Utilidades.cadena("Introduzca el modelo\n");
        int dni = Utilidades.entero("Introduca el DNI (sin letra)\n");
        int electrico = 0;
        do {
            electrico = Utilidades.entero("Indique 1 para electrico 2 para gasolina\n");
        } while (electrico != 1 && electrico != 2);
        boolean electr = false;
        if (electrico == '1') {
            electr = true;
        }

        Coche c = new Coche(matricula, marca, modelo, dni, electr);
    }
    //metodo para crear una moto
    public static void crearMoto() {
        String matricula = Utilidades.cadena("Introduzca la matricula\n");
        String marca = Utilidades.cadena("Introduzca la marca\n");
        String modelo = Utilidades.cadena("Introduzca el modelo\n");
        int cilindrada = Utilidades.entero("Indique la cilindrada\n");
        Moto m = new Moto(cilindrada, matricula, marca, modelo);

    }
    //metodo para crear un autobus
    public static void crearAutobus() {
        String matricula = Utilidades.cadena("Introduzca la matricula\n");
        String marca = Utilidades.cadena("Introduzca la marca\n");
        String modelo = Utilidades.cadena("Introduzca el modelo\n");
        int plaza = Utilidades.entero("Indique el numero de plazas\n");
        String compañia = Utilidades.cadena("Indique la compañia\n");

        Autobus a = new Autobus(plaza, compañia, matricula, marca, modelo);

    }
    //metodo para eliminar un vehiculo del parking
    public static void eliminarPlaza(char[][] parking) {
        int fila = Utilidades.entero("Introduzca la fila\n");
        int columna = Utilidades.entero("Introduzca la columna\n");
        //si la posicion es valida y existe algun vehiculo dentro se elimina del parking
        if (fila>parking.length ||columna>parking[0].length){
            Utilidades.pln("Plaza incorrecta");
        }else{
        if (parking[fila][columna]=='C'||parking[fila][columna]=='A'||parking[fila][columna]=='M'){
            parking[fila][columna]='-';
        }else{
            Utilidades.pln("Plaza invalida");
        }
    }
    }

}
