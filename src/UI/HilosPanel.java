package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

public class HilosPanel extends JPanel {
    JLabel image;

    public HilosPanel() {
        BorderLayout borderLayout = new BorderLayout(32, 0);
        this.setBackground(Paleta.fondo);
        this.setBorder(new EmptyBorder(16, 24, 16, 24));
        this.setLayout(borderLayout);

        JButton btInicio = new JButton("Inicio");
        btInicio.setForeground(Paleta.fondo);
        btInicio.setBackground(Paleta.secundario);
        btInicio.setFont(Fuentes.normal);
        btInicio.addActionListener(this::onBtInicioClick);
        this.add(btInicio, BorderLayout.WEST);

        JButton btRegreso = new JButton("Regresar");
        btRegreso.setForeground(Paleta.fondo);
        btRegreso.setBackground(Paleta.secundario);
        btRegreso.setFont(Fuentes.normal);
        btRegreso.addActionListener(this::onBtRegresoClick);
        this.add(btRegreso, BorderLayout.EAST);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        JPanel panelImagen = new JPanel(flowLayout);
        panelImagen.setBackground(Paleta.fondo);
        image = new JLabel();
        BufferedImage bufferedImage = null;
//        try {
//            bufferedImage = ImageIO.read(new File(getClass().getClassLoader().getResource("assets\\leopardo.png")));
//            Image nuevaImagen = bufferedImage.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("assets/leopardo.png"));
            Image _image = imageIcon.getImage(); // Transform it
            Image newImg = _image.getScaledInstance(128, 128, java.awt.Image.SCALE_SMOOTH);
            image.setIcon(new ImageIcon(newImg));
//        } catch (IOException exception) {
//            System.out.println(exception.getMessage());
//            image.setText("Imagen");
//        }
        image.setPreferredSize(new Dimension(128, 128));

        panelImagen.add(image);
        this.add(panelImagen, BorderLayout.CENTER);
    }

    public void onBtInicioClick(ActionEvent e) {
        if (image.getBounds().x == 5 && image.getBounds().y == 5) {
            Thread hilioInicio = new Thread(() -> {
                for (int i = 5; i <= 384; i += 4) {
                    image.setBounds(i, 5, 128, 128);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                    image.repaint();
                }
            });
            hilioInicio.start();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede inciar, no te encuentras en la posicion inicial!"
            );
        }
    }


    public void onBtRegresoClick(ActionEvent e) {
        if (image.getBounds().x == 381 && image.getBounds().y == 5) {
            Thread hilioInicio = new Thread(() -> {
                for (int i = 381; i >= 5; i -= 4) {
                    image.setBounds(i, 5, 128, 128);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                    image.repaint();
                }
            });
            hilioInicio.start();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede regresar, no te encuentras en la posicion final!"
            );
        }
    }
}
