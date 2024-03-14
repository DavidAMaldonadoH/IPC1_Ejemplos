package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ThreadFrame extends javax.swing.JFrame {

    public ThreadFrame(String title) throws HeadlessException {
        super(title);
        // basic frame configuration
        this.setSize(new Dimension(960, 512));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        // panel configuration
        GridLayout gridLayout = new GridLayout(3, 1, 80, 4);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        this.setContentPane(jPanel);
        this.add(new ThreadPanel());
        this.add(new ThreadPanel());
        this.add(new ThreadPanel());
        this.setVisible(true);
    }
}
