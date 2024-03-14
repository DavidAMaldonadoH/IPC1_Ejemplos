import UI.ThreadFrame;
import Usuario.Agencia;
import Util.Estado;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
//        Estado.guardarUsuario(Estado.admin);
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream("agencia.txt");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            Agencia miAgencia = (Agencia) objectInputStream.readObject();
//            Estado.guardarUsuario(miAgencia);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        MainFrame mainFrame = new MainFrame("Distribuidora de Vehiculos");
        new ThreadFrame("Hilos en Java");
    }
}
