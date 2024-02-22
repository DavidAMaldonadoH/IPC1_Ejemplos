package Usuario;

import Vehiculo.Vehiculo;

import java.util.ArrayList;

public class Agencia extends Usuario {
    private final ArrayList<Vehiculo> vehiculosDisponibles = new ArrayList<>();

    public Agencia(String codigo, String nombre, String password) {
        super(codigo, nombre, password, "Agencia");
    }

    public ArrayList<Vehiculo> getVehiculosDisponibles() {
        return vehiculosDisponibles;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculosDisponibles.add(vehiculo);
    }

    public void eliminarVehiculo(int indice) {
        this.vehiculosDisponibles.remove(indice);
    }

    public int getCantidadVehiculosDispobibles() {
        return this.vehiculosDisponibles.size();
    }

    public Vehiculo getVehiculo(int index) {
        return this.vehiculosDisponibles.get(index);
    }

    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : this.vehiculosDisponibles) {
            System.out.printf(
                    "%s, %s, %s, %f, %s \n",
                    vehiculo.getMarca(),
                    vehiculo.getModelo(),
                    vehiculo.getColor(),
                    vehiculo.getPrecio(),
                    vehiculo.getTipo()
            );
        }
    }
}
