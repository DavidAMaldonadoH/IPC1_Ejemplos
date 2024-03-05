package UI;

import Usuario.Agencia;
import Util.Estado;
import Vehiculo.Vehiculo;
import Vehiculo.Carro;
import Vehiculo.Moto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class FrameEditar extends JFrame implements ActionListener {
    private Vehiculo vehiculo;
    private int row;
    private final JButton btEditar;
    private final JTextField marca;
    private final JTextField modelo;
    private final JTextField color;
    private final JCheckBox mecanico;
    private final JTextField precio;
    private final JTextField asientos_puertas;
    private DefaultTableModel tableModel;
    public FrameEditar(Vehiculo vehiculo, DefaultTableModel tableModel, int row) throws HeadlessException {
        this.vehiculo = vehiculo;
        this.row = row;
        this.tableModel = tableModel;
        setTitle("Editar Vehiculo");
        setSize(500, 750);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        GridLayout gridLayout = new GridLayout(8, 1, 24, 24);
        JPanel jPanel = new JPanel(gridLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        this.add(jPanel);

        JLabel lblTitulo = new JLabel("Editar Vehiculo", SwingConstants.CENTER);
        lblTitulo.setFont(Fuentes.titulo);
        lblTitulo.setForeground(Paleta.texto);
        jPanel.add(lblTitulo);

        marca = new JTextField(vehiculo.getMarca());
        Entrada entradaMarca = new Entrada("Marca", marca);
        modelo = new JTextField(vehiculo.getModelo());
        Entrada entradaModelo = new Entrada("Modelo", modelo);
        color = new JTextField(vehiculo.getColor());
        Entrada entradaColor = new Entrada("Color", color);
        mecanico = new JCheckBox();
        mecanico.setSelected(vehiculo.isMecanico());
        mecanico.setBackground(Paleta.fondo);
        Entrada entradaMecanico = new Entrada("Es Mecanico", mecanico);
        precio = new JTextField(Double.toString(vehiculo.getPrecio()));
        Entrada entradaPrecio = new Entrada("Precio", precio);
        if (vehiculo.getTipo().equals("Carro")) {
            Carro tmp = (Carro) vehiculo;
            asientos_puertas = new JTextField(Integer.toString(tmp.getNumPuertas()));
        } else {
            Moto tmp = (Moto) vehiculo;
            asientos_puertas = new JTextField(Integer.toString(tmp.getNumAsientos()));
        }
        String labelEntrada = vehiculo.getTipo().equals("Carro") ? "Numero de Puertas" : "Numero de Asientos";
        Entrada entradaPuertasAsientos = new Entrada(labelEntrada, asientos_puertas);
        jPanel.add(entradaMarca);
        jPanel.add(entradaModelo);
        jPanel.add(entradaColor);
        jPanel.add(entradaMecanico);
        jPanel.add(entradaPrecio);
        jPanel.add(entradaPuertasAsientos);

        btEditar = new JButton("Editar Vehiculo");
        btEditar.setBackground(Paleta.secundario);
        btEditar.setForeground(Paleta.texto);
        btEditar.setFont(Fuentes.titulo2);
        btEditar.addActionListener(this);
        jPanel.add(btEditar);
        setVisible(true);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btEditar) {
            Agencia agencia = (Agencia) Estado.getUsuarioActual();
            String _modelo = modelo.getText();
            String _marca = marca.getText();
            String _color = color.getText();
            boolean _mecanico = mecanico.isSelected();
            double _precio = Double.parseDouble(precio.getText());
            int _asientos_puertas = Integer.parseInt(asientos_puertas.getText());
            agencia.updateVehiculo(this.vehiculo.getID(), _modelo, _marca, _color, _mecanico, _precio, _asientos_puertas);
            this.tableModel.setValueAt(_marca, row, 1);
            this.tableModel.setValueAt(_modelo, row, 2);
            this.tableModel.setValueAt(_color, row, 3);
            this.tableModel.setValueAt(precio.getText(), row, 4);
            this.tableModel.setValueAt(asientos_puertas.getText(), row, 4);
            this.dispose();
        }
    }
}
