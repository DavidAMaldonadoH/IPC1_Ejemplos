import Vehiculo.Carro;
import Vehiculo.Moto;
import Vehiculo.Vehiculo;

public class Main {

    public static void main(String[] args) {

        Carro rayoMcQueen = new Carro("Toyota", "Deportivo", "rojo", 3, true);

        Moto moto1 = new Moto("Italica", "Pasola", 6, false, 1, 0);

        Vehiculo[] vehiculos = new Vehiculo[2];

        vehiculos[0] = rayoMcQueen;
        vehiculos[1] = moto1;

        for (Vehiculo vehiculo: vehiculos) {
            System.out.println("El color del vehiculo es: " + vehiculo.getColor());
            System.out.println("Y tambien es " + (vehiculo.isMecanico() ? "mecanico" : "automatico"));
        }

    }
}
