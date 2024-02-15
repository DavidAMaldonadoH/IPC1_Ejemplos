package Vehiculo;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String color;
    private int tamanio;
    private int kilometraje;
    private boolean mecanico;

    public Vehiculo(String marca, String modelo, String color, int tamanio, int kilometraje, boolean mecanico) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tamanio = tamanio;
        this.kilometraje = kilometraje;
        this.mecanico = mecanico;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    public boolean isMecanico() {
        return mecanico;
    }

    public void setMecanico(boolean mecanico) {
        this.mecanico = mecanico;
    }
}
