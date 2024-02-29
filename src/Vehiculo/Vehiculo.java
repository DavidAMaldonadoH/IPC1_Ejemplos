package Vehiculo;

public abstract class Vehiculo {
    private String ID;
    private String marca;
    private String modelo;
    private String color;
    private boolean mecanico;
    private double precio;

    private String tipo;

    public Vehiculo(String ID, String marca, String modelo, String color, boolean mecanico, double precio, String tipo) {
        this.ID = ID;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.mecanico = mecanico;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public boolean isMecanico() {
        return mecanico;
    }

    public void setMecanico(boolean mecanico) {
        this.mecanico = mecanico;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
