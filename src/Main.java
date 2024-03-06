import Usuario.Agencia;
import Vehiculo.Carro;
import Vehiculo.Moto;
import Util.Estado;
import Vehiculo.Vehiculo;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Estado.guardarUsuario(Estado.admin);

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
