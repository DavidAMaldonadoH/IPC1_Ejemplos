package Vehiculo;

public class Moto extends Vehiculo {
    private int numAsientos;

    public Moto(String ID, String marca, String modelo, String color, boolean mecanico, double precio, int numAsientos) {
        super(ID, marca, modelo, color, mecanico, precio, "Moto");
        this.numAsientos = numAsientos;
    }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }
}
