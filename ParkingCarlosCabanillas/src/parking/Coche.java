package parking;


public class Coche extends Vehiculo {
    private int dni;
    private boolean electrico;
    //Constructor de la clase coche el cual hereda de vehiculo
    public Coche(String matricula, String marca, String modelo,int dni,boolean electrico) {
        super(matricula, marca, modelo);
        this.dni=dni;
        this.electrico=electrico;
    }
    //Getters y Setters
    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public int getDni() {
        return dni;
    }

    public boolean isElectrico() {
        return electrico;
    }
    
    
}
