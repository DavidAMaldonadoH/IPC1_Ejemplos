import UI.Paleta;
import UI.Fuentes;
import Usuario.Usuario;
import Util.Estado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private final JPasswordField jPasswordField;
    private final JTextField jTFUserName;

    public MainFrame(String title) throws HeadlessException {
        super(title);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        GridLayout layout = new GridLayout();
        layout.setColumns(1);
        layout.setRows(6);
        layout.setVgap(20);

        JPanel jPanel = new JPanel(layout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        this.add(jPanel);

        JLabel lblTitulo = new JLabel("Inicio de Sesión", SwingConstants.CENTER);
        lblTitulo.setFont(Fuentes.titulo);
        lblTitulo.setForeground(Paleta.texto);
        jPanel.add(lblTitulo);

        JLabel lblUserName = new JLabel("Codigo de usuario", SwingConstants.LEFT);
        lblUserName.setFont(Fuentes.entrada);
        lblUserName.setForeground(Paleta.texto);
        jPanel.add(lblUserName);

        jTFUserName = new JTextField();
        jTFUserName.setFont(Fuentes.normal);
        jTFUserName.setForeground(Paleta.texto);
        jTFUserName.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Paleta.texto, 2),
                        new EmptyBorder(0, 16, 0, 16)
                )
        );
        jPanel.add(jTFUserName);

        JLabel lblPassword = new JLabel("Contraseña", SwingConstants.LEFT);
        lblPassword.setFont(Fuentes.entrada);
        lblPassword.setForeground(Paleta.texto);
        jPanel.add(lblPassword);

        jPasswordField = new JPasswordField();
        jPasswordField.setFont(Fuentes.normal);
        jPasswordField.setForeground(Paleta.texto);
        jPasswordField.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Paleta.texto, 2),
                        new EmptyBorder(0, 16, 0, 16)
                )
        );
        jPanel.add(jPasswordField);

        JButton btLogin = new JButton("Iniciar Sesion");
        btLogin.setBackground(Paleta.secundario);
        btLogin.setForeground(Paleta.texto);
        btLogin.setFont(Fuentes.titulo2);
        btLogin.addActionListener(this::onBtnLoginClick);
        jPanel.add(btLogin);

        this.setVisible(true);
        this.repaint();
        this.revalidate();
    }

    public void onBtnLoginClick(ActionEvent e) {
        for (Usuario usuario : Estado.getUsuariosRegistrados()) {
            if (jTFUserName.getText().equals(usuario.getCodigo()) &&
                    new String(jPasswordField.getPassword()).equals(usuario.getPassword())) {
                Estado.setUsuarioActual(usuario);
                this.setVisible(false);
                break;
            }
        }

        if (Estado.getUsuarioActual() == null) {
            JDialog jDialog = new JDialog(this, "Alerta");
            jDialog.setSize(256, 256);
            jDialog.add(new JLabel("Credenciales incorrectas"));
            jDialog.setVisible(true);
            return;
        }

        new UI.FrameAgencia();
    }
}
