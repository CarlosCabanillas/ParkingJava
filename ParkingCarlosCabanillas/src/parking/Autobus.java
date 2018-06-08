/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

/**
 *
 * @author Carlos Cabanillas
 */
public class Autobus extends Vehiculo{
    private int plazas;
    private String compañia;
    //constructor clase autobus el cual hereda de la clase vehiculo
    public Autobus(int plazas, String compañia, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.plazas = plazas;
        this.compañia = compañia;
    }
    //Getters y Setters
    public int getPlazas() {
        return plazas;
    }

    public String getCompañia() {
        return compañia;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public void setCompañia(String compañia) {
        this.compañia = compañia;
    }
    
    
    
}
