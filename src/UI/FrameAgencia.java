package UI;

import Usuario.Agencia;
import Util.Estado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAgencia extends JFrame implements ActionListener {

    private final JButton btElminar;
    private final JButton btEditar;
    private final JButton btAgregarMoto;
    private final JButton btAgregarCarro;
    private DefaultTableModel tableModel;
    private JTable jTable;
    Agencia agencia = (Agencia) Estado.getUsuarioActual();

    public FrameAgencia() throws HeadlessException {
        setTitle("Agencia " + Util.Estado.getUsuarioActual().getNombre());
        setResizable(false);
        setSize(1250, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        BorderLayout borderLayout = new BorderLayout(32, 32);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 40, 40);

        JPanel jPanel = new JPanel(borderLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        add(jPanel);


        String[] columns = {"ID", "Marca", "Modelo", "Color", "Precio", "Tipo"};
        String[][] data = new String[agencia.getVehiculosDisponibles().size()][6];
        for (int i = 0; i < agencia.getVehiculosDisponibles().size(); i++) {
            data[i][0] = agencia.getVehiculo(i).getID();
            data[i][1] = agencia.getVehiculo(i).getMarca();
            data[i][2] = agencia.getVehiculo(i).getModelo();
            data[i][3] = agencia.getVehiculo(i).getColor();
            data[i][4] = Double.toString(agencia.getVehiculo(i).getPrecio());
            data[i][5] = agencia.getVehiculo(i).getTipo();
        }
        tableModel = new DefaultTableModel(data, columns);
        jTable = new JTable(tableModel);
        jTable.setRowSelectionAllowed(true);
        ListSelectionModel selectionModel = jTable.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        jPanel.add(jScrollPane, BorderLayout.CENTER);

        JLabel titulo = new JLabel("Bienvenido " + Estado.getUsuarioActual().getNombre() + "!");
        titulo.setForeground(Paleta.texto);
        titulo.setFont(Fuentes.titulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(titulo, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel(flowLayout);

        btElminar = new JButton("Eliminar");
        btElminar.setBackground(Paleta.texto);
        btElminar.setForeground(Paleta.fondo);
        btElminar.setFont(Fuentes.normal);

        btEditar = new JButton("Editar");
        btEditar.setBackground(Paleta.secundario);
        btEditar.setForeground(Paleta.texto);
        btEditar.setFont(Fuentes.normal);

        btAgregarMoto = new JButton("Agregar Moto");
        btAgregarMoto.setBackground(Paleta.primario);
        btAgregarMoto.setForeground(Paleta.texto);
        btAgregarMoto.setFont(Fuentes.normal);
        btAgregarCarro = new JButton("Agregar Carro");
        btAgregarCarro.setBackground(Paleta.primario);
        btAgregarCarro.setForeground(Paleta.texto);
        btAgregarCarro.setFont(Fuentes.normal);
        buttonsPanel.add(btAgregarMoto);
        buttonsPanel.add(btAgregarCarro);
        buttonsPanel.add(btEditar);
        buttonsPanel.add(btElminar);
        buttonsPanel.setBackground(Paleta.fondo);
        btElminar.addActionListener(this);
        btEditar.addActionListener(this);
        btAgregarCarro.addActionListener(this);
        jPanel.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btElminar) {
            if (jTable.getSelectedRow() != -1) {
                agencia.eliminarVehiculo(jTable.getSelectedRow());
                tableModel.removeRow(jTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Vehiculo eliminado con exito");
            }
        } else if (e.getSource() == btEditar) {
            System.out.println(jTable.getSelectedRow());
            agencia.mostrarVehiculos();
        } else if (e.getSource() == btAgregarCarro) {
            new FrameAgregarCarro("Agregar Carro", tableModel);
        } else if (e.getSource() == btAgregarMoto) {
            System.out.println("Por Hacer");
        } else {
            System.out.println(e.getSource());
        }
    }
}
