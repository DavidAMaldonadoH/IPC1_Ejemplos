import UI.Fuentes;
import UI.Paleta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GridLayout gridLayout = new GridLayout(6, 1, 0, 16);

        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        add(jPanel);

        JLabel titulo = new JLabel("Iniciar Sesion");
        titulo.setForeground(Paleta.texto);
        titulo.setFont(Fuentes.titulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(titulo);

        JLabel codigo = new JLabel("Codigo");
        codigo.setForeground(Paleta.texto);
        codigo.setFont(Fuentes.entrada);
        jPanel.add(codigo);

        JTextField entradaCodigo = new JTextField();
        entradaCodigo.setSize(450, 50);
        jPanel.add(entradaCodigo);

        JLabel password = new JLabel("Password");
        password.setForeground(Paleta.texto);
        password.setFont(Fuentes.entrada);
        jPanel.add(password);

        JPasswordField entradaPassword = new JPasswordField();
        entradaPassword.setSize(450, 50);
        jPanel.add(entradaPassword);

        JButton btLogin = new JButton("Iniciar Sesion");
        btLogin.setForeground(Paleta.fondo);
        btLogin.setBackground(Paleta.secundario);
        btLogin.setFont(Fuentes.normal);
        btLogin.addActionListener(this::onBtnLoginClick);
        jPanel.add(btLogin);
        setVisible(true);
    }

    public void onBtnLoginClick(ActionEvent e){
        System.out.println("Se oprimido el boton");
    }
}
