package Vehiculo;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String marca, String modelo, int cilindraje, boolean mecanica, int tamanio, int kilometraje) {
        super(marca, modelo, "negro", tamanio, kilometraje, mecanica);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
