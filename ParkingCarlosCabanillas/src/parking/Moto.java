
package parking;


public class Moto extends Vehiculo {
    private int cilindrada;
    //Constructor de moto el cual hereda de moto
    public Moto(int cilindrada, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.cilindrada = cilindrada;
    }
    //getters y setters
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }
}
