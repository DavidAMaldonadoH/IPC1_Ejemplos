import Usuario.Agencia;
import Util.Estado;
import Vehiculo.Carro;
import Vehiculo.Moto;

public class Main {

    public static void main(String[] args) {
        Estado.registrarUsuario(Estado.usuarioAdmin);

        Carro rayoMcQueen = new Carro("C0001", "Toyota", "Deportivo", "Rojo", true, 5000, 2);
        Moto moto1 = new Moto("M0002", "Harley Davidson", "Chopper", "Negro", true, 4500, 2);

        Agencia miAgencia = new Agencia("agen02", "Mi Garage",  "pass1234");
        miAgencia.agregarVehiculo(rayoMcQueen);
        miAgencia.agregarVehiculo(moto1);

        Estado.registrarUsuario(miAgencia);

        MainFrame mainFrame = new MainFrame("Distribuidora de Vehiculos");
    }
}
