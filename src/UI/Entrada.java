package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Entrada extends JPanel {

    public Entrada(String label, JTextField field) {
        GridLayout gridLayout = new GridLayout(2, 1, 0, 4);
        this.setLayout(gridLayout);
        this.setBackground(Paleta.fondo);
        JLabel lblMarca = new JLabel(label, SwingConstants.LEFT);
        lblMarca.setFont(Fuentes.entrada);
        lblMarca.setForeground(Paleta.texto);
        this.add(lblMarca);

        field.setFont(Fuentes.normal);
        field.setForeground(Paleta.texto);
        field.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Paleta.texto, 2),
                        new EmptyBorder(0, 16, 0, 16)
                )
        );
        this.add(field);
    }

    public Entrada(String label, JCheckBox field) {
        GridLayout gridLayout = new GridLayout(1, 2, 16, 0);
        this.setLayout(gridLayout);
        this.setBackground(Paleta.fondo);
        JLabel lblMarca = new JLabel(label, SwingConstants.LEFT);
        lblMarca.setFont(Fuentes.entrada);
        lblMarca.setForeground(Paleta.texto);
        this.add(lblMarca);

        field.setFont(Fuentes.normal);
        field.setForeground(Paleta.texto);
        field.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(Paleta.texto, 2),
                        new EmptyBorder(0, 16, 0, 16)
                )
        );
        this.add(field);
    }
}
