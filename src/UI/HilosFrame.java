package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HilosFrame extends javax.swing.JFrame {

    public HilosFrame(String title) throws HeadlessException {
        super(title);
        this.setSize(new Dimension(960, 512));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        GridLayout gridLayout = new GridLayout(3, 1, 80, 4);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));

        this.setContentPane(jPanel);
        this.add(new HilosPanel());
        this.add(new HilosPanel());
        this.add(new HilosPanel());
        this.setVisible(true);
    }
}
