package Vehiculo;

import java.io.Serializable;

public class Carro extends Vehiculo implements Serializable {
    private int numPuertas;

    public Carro(String ID, String marca, String modelo, String color, boolean mecanico, double precio, int numPuertas) {
        super(ID, marca, modelo, color, mecanico, precio, "Carro");
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
