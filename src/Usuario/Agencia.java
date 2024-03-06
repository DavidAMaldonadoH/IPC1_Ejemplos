package Usuario;

import Vehiculo.Vehiculo;
import Vehiculo.Carro;
import Vehiculo.Moto;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Agencia extends Usuario implements Serializable {
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

    public int getCantidadCarrosDisponibles() {
        int cantidad = 0;
        for (Vehiculo vehiculo : vehiculosDisponibles) {
            if (vehiculo.getTipo().equals("Carro")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int getCantidadMotosDisponibles() {
        int cantidad = 0;
        for (Vehiculo vehiculo : vehiculosDisponibles) {
            if (vehiculo.getTipo().equals("Moto")) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public void updateVehiculo(String ID, String modelo, String marca, String color, boolean mecanico, double precio, int asientos_puertas) {
        for (Vehiculo vehiculo : this.vehiculosDisponibles) {
            if (vehiculo.getID().equals(ID)) {
                vehiculo.setModelo(modelo);
                vehiculo.setMarca(marca);
                vehiculo.setColor(color);
                vehiculo.setMecanico(mecanico);
                vehiculo.setPrecio(precio);
                if (vehiculo.getTipo().equals("Carro")) {
                    Carro carro = (Carro) vehiculo;
                    carro.setNumPuertas(asientos_puertas);
                } else {
                    Moto moto = (Moto) vehiculo;
                    moto.setNumAsientos(asientos_puertas);
                }
                break;
            }
        }
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

    public void generarReporte() {
        try (FileWriter fileWriter = new FileWriter(new File("reporte" + this.getCodigo() + ".txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("digraph g {\n" +
                    "fontname=\"Helvetica,Arial,sans-serif\"\n" +
                    "node [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                    "edge [fontname=\"Helvetica,Arial,sans-serif\"]\n" +
                    "graph [\n" +
                    "rankdir = \"LR\"\n" +
                    "];\n" +
                    "node [\n" +
                    "fontsize = \"16\"\n" +
                    "shape = \"ellipse\"\n" +
                    "];\n" +
                    "edge [\n" +
                    "];");
            for (Vehiculo vehiculo : this.getVehiculosDisponibles()) {
                bufferedWriter.write(vehiculo.toString());
            }
            for (int i = 0; i < this.getCantidadVehiculosDispobibles() - 1; i++) {
                bufferedWriter.write("\"" + this.getVehiculo(i).getID() + "\" ->");
                bufferedWriter.write("\"" + this.getVehiculo(i + 1).getID() + "\" [\n");
                bufferedWriter.write("id = " + i + "\n];\n");
            }
            bufferedWriter.write("}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
