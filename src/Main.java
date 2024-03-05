import Usuario.Agencia;
import Vehiculo.Carro;
import Vehiculo.Moto;
import Util.Estado;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) {
        Estado.guardarUsuario(Estado.admin);

//        Carro rayoMcQueen = new Carro("C001", "Toyota", "Deportivo", "Rojo", true, 5000, 2);
//        Moto moto1 = new Moto("M002", "Harley Davidson", "Chopper", "Negro", true, 4500, 2);
//        Agencia miAgencia = new Agencia("agen02", "Mi Garage", "pass1234");
//        miAgencia.agregarVehiculo(rayoMcQueen);
//        miAgencia.agregarVehiculo(moto1);
//        Estado.guardarUsuario(miAgencia);

        try {
            FileInputStream fileInputStream = new FileInputStream("agencia.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Agencia miAgencia = (Agencia) objectInputStream.readObject();
            Estado.guardarUsuario(miAgencia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        MainFrame mainFrame = new MainFrame("Distribuidora de Vehiculos");
    }
}
