package UI;

import Usuario.Agencia;
import Util.Estado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAgencia extends JFrame {

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

        Agencia agencia = (Agencia) Estado.getUsuarioActual();
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
        DefaultTableModel tableModel = new DefaultTableModel(data, columns);
        JTable jTable = new JTable(tableModel);
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
        JButton btElminar = new JButton("Eliminar");
        btElminar.setBackground(Paleta.primario);
        btElminar.setForeground(Paleta.fondo);
        JButton btEditar = new JButton("Editar");
        btEditar.setBackground(Paleta.secundario);
        btEditar.setForeground(Paleta.texto);
        buttonsPanel.add(btElminar);
        buttonsPanel.add(btEditar);
        buttonsPanel.setBackground(Paleta.fondo);
        btElminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(jTable.getSelectedRow() != -1) {
                    agencia.eliminarVehiculo(jTable.getSelectedRow());
                    tableModel.removeRow(jTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
                agencia.mostrarVehiculos();
            }
        });

        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jTable.getSelectedRow());
            }
        });
        jPanel.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
        revalidate();
        repaint();
    }
}
