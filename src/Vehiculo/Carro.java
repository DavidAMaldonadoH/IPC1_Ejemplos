package Vehiculo;

public class Carro extends Vehiculo {
    private int numPuertas;

    public Carro(String marca, String modelo, String color, boolean mecanico, double precio, int numPuertas) {
        super(marca, modelo, color, mecanico, precio, "Carro");
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
