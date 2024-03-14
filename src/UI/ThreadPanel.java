package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ThreadPanel extends javax.swing.JPanel {
    JLabel image;
    public ThreadPanel() {
        BorderLayout borderLayout = new BorderLayout(32, 0);
        this.setBackground(Paleta.fondo);
        this.setBorder(new EmptyBorder(16, 24, 16, 24));
        this.setLayout(borderLayout);
        // buttons
        JButton btStart = new JButton("Iniciar");
        btStart.setBackground(Paleta.secundario);
        btStart.setForeground(Paleta.texto);
        btStart.setFont(Fuentes.titulo2);
        btStart.setPreferredSize(new Dimension(152, 80));
        btStart.addActionListener(this::onBtStartClick);
        JButton btReturn = new JButton("Regresar");
        btReturn.setBackground(Paleta.secundario);
        btReturn.setForeground(Paleta.texto);
        btReturn.setFont(Fuentes.titulo2);
        btReturn.setPreferredSize(new Dimension(152, 80));
        btReturn.addActionListener(this::onBtReturnClick);
        this.add(btStart, BorderLayout.WEST);
        this.add(btReturn, BorderLayout.EAST);
        // create image
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        JPanel panelImage = new JPanel(flowLayout);
        panelImage.setBackground(Paleta.fondo);
        image = new JLabel();
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("src\\assets\\leopard.png"));
            Image resizedImage = bufferedImage.getScaledInstance(128, 128, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(resizedImage);
            image.setIcon(imageIcon);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            image.setText("Image");
        }
        image.setPreferredSize(new Dimension(128, 128));
        panelImage.add(image);
        this.add(panelImage, BorderLayout.CENTER);
    }

    private void onBtStartClick(ActionEvent e) {
        if (image.getBounds().x == 5 && image.getBounds().y == 5) {
            Thread returnThread = new Thread(() -> {
                for (int i = 5; i <= 349; i += 4) {
                    image.setBounds(i, 5, 128, 128);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                    image.repaint();
                }
            });
            returnThread.start();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "You can't start, you are not in the start position!"
            );
        }
    }

    private void onBtReturnClick(ActionEvent e) {
        if (image.getBounds().x == 349 && image.getBounds().y == 5) {
            Thread returnThread = new Thread(() -> {
                for (int i = 349; i >= 5; i -= 4) {
                    image.setBounds(i, 5, 128, 128);
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException exception) {
                        System.out.println(exception.getMessage());
                    }
                    image.repaint();
                }
            });
            returnThread.start();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "You can't return, you are not in the return position!"
            );
        }
    }
}
