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
    private String compa�ia;
    //constructor clase autobus el cual hereda de la clase vehiculo
    public Autobus(int plazas, String compa�ia, String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
        this.plazas = plazas;
        this.compa�ia = compa�ia;
    }
    //Getters y Setters
    public int getPlazas() {
        return plazas;
    }

    public String getCompa�ia() {
        return compa�ia;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public void setCompa�ia(String compa�ia) {
        this.compa�ia = compa�ia;
    }
    
    
    
}
