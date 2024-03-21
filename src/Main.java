import UI.HilosFrame;
import Usuario.Agencia;
import Util.Estado;
import Vehiculo.Carro;
import Vehiculo.Moto;
import laboratorios.EjemploHilo;
import laboratorios.EjemploRunnable;

import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
//        Estado.registrarUsuario(Estado.usuarioAdmin);
//        try {
//            FileInputStream fileInputStream = new FileInputStream("agencia.bin");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//            Agencia agencia = (Agencia) objectInputStream.readObject();
//            Estado.registrarUsuario(agencia);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        MainFrame mainFrame = new MainFrame("Distribuidora de Vehiculos");
//        for (int i = 0; i < 5; i++) {
//            EjemploRunnable ejemploRunnable = new EjemploRunnable();
//            Thread thread = new Thread(ejemploRunnable);
//            thread.start();
//        }
        new HilosFrame("Hilos en Java");
    }
}
