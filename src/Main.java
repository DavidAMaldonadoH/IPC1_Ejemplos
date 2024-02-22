import Usuario.Agencia;
import Vehiculo.Carro;
import Vehiculo.Moto;

public class Main {

    public static void main(String[] args) {

        Carro rayoMcQueen = new Carro("Toyota", "Deportivo", "Rojo", true, 5000, 2);
        Moto moto1 = new Moto("Harley Davidson", "Chopper", "Negro", true, 4500, 2);

        Agencia miAgencia = new Agencia("agen02", "Mi Garage",  "pass1234");
        miAgencia.agregarVehiculo(rayoMcQueen);
        miAgencia.agregarVehiculo(moto1);

        miAgencia.mostrarVehiculos();

        MainFrame mainFrame = new MainFrame("Distribuidora de Vehiculos");
    }
}
