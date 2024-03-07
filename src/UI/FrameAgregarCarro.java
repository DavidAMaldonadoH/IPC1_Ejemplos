package UI;

import Usuario.Agencia;
import Util.Estado;
import Vehiculo.Carro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAgregarCarro extends JFrame implements ActionListener {
    private final JButton btAgregar;
    private final JTextField marca;
    private final JTextField modelo;
    private final JTextField color;
    private final JCheckBox mecanico;
    private final JTextField precio;
    private final JTextField numPuertas;
    private final DefaultTableModel tableModel;

    public FrameAgregarCarro(String title, DefaultTableModel tableModel) {
        super(title);
        this.tableModel = tableModel;
        setSize(500, 750);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        GridLayout gridLayout = new GridLayout(8, 1, 24, 24);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        this.add(jPanel);

        JLabel lblTitulo = new JLabel("Agregar Carro", SwingConstants.CENTER);
        lblTitulo.setFont(Fuentes.titulo);
        lblTitulo.setForeground(Paleta.texto);
        jPanel.add(lblTitulo);

        marca = new JTextField();
        Entrada entradaMarca = new Entrada("Marca", marca);
        modelo = new JTextField();
        Entrada entradaModelo = new Entrada("Modelo", modelo);
        color = new JTextField();
        Entrada entradaColor = new Entrada("Color", color);
        mecanico = new JCheckBox();
        mecanico.setBackground(Paleta.fondo);
        Entrada entradaMecanico = new Entrada("Es Mecanico", mecanico);
        precio = new JTextField();
        Entrada entradaPrecio = new Entrada("Precio", precio);
        numPuertas = new JTextField();
        Entrada entradaNumPuertas = new Entrada("Numero de Puertas", numPuertas);
        jPanel.add(entradaMarca);
        jPanel.add(entradaModelo);
        jPanel.add(entradaColor);
        jPanel.add(entradaMecanico);
        jPanel.add(entradaPrecio);
        jPanel.add(entradaNumPuertas);

        btAgregar = new JButton("Agregar Carro");
        btAgregar.setBackground(Paleta.secundario);
        btAgregar.setForeground(Paleta.texto);
        btAgregar.setFont(Fuentes.titulo2);
        btAgregar.addActionListener(this);
        jPanel.add(btAgregar);
        setVisible(true);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btAgregar) {
            Agencia agencia = (Agencia) Estado.getUsuarioActual();
            String ID = String.format("C%03d", agencia.getCantidadVehiculosDispobibles() + 1);
            agencia.agregarVehiculo(new Carro(
                    ID,
                    marca.getText(),
                    modelo.getText(),
                    color.getText(),
                    mecanico.isSelected(),
                    Double.parseDouble(precio.getText()),
                    Integer.parseInt(numPuertas.getText())
            ));
            this.tableModel.addRow(new String[]{
                    agencia.getVehiculosDisponibles().getLast().getID(),
                    agencia.getVehiculosDisponibles().getLast().getMarca(),
                    agencia.getVehiculosDisponibles().getLast().getModelo(),
                    agencia.getVehiculosDisponibles().getLast().getColor(),
                    Double.toString(agencia.getVehiculosDisponibles().getLast().getPrecio()),
                    agencia.getVehiculosDisponibles().getLast().getTipo()});
            JOptionPane.showMessageDialog(null, "Carro agregado con exito");
            this.dispose();
        }
    }
}
