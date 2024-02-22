package Vehiculo;

public class Moto extends Vehiculo {
    private int numAsientos;

    public Moto(String marca, String modelo, String color, boolean mecanico, double precio, int numAsientos) {
        super(marca, modelo, color, mecanico, precio, "Moto");
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }
}
