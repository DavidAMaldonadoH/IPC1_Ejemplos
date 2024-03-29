package UI;

import Usuario.Agencia;
import Util.Estado;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FrameAgencia extends JFrame implements ActionListener {

    Agencia agencia = (Agencia) Estado.getUsuarioActual();
    JButton btEliminar;
    JButton btAgregarMoto;
    JButton btAgregarCarro;
    JButton btEditar;
    JTable jTable;
    DefaultTableModel tableModel;
    DefaultCategoryDataset datos;

    public FrameAgencia(String title) throws HeadlessException {
        super(title);
        setSize(1250, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BorderLayout borderLayout = new BorderLayout(16, 24);

        JPanel jPanel = new JPanel(borderLayout);
        jPanel.setBackground(Paleta.fondo);
        jPanel.setBorder(new EmptyBorder(16, 24, 16, 24));
        add(jPanel);

        JLabel titulo = new JLabel("Bienvenido " + Estado.getUsuarioActual().getNombre());
        titulo.setForeground(Paleta.texto);
        titulo.setFont(Fuentes.titulo);
        titulo.setHorizontalAlignment(JLabel.CENTER);
        jPanel.add(titulo, BorderLayout.NORTH);

        String[] columnNames = {"ID", "Marca", "Modelo", "Color", "Precio", "Tipo"};
        String[][] data = new String[agencia.getCantidadVehiculosDispobibles()][6];

        for (int i = 0; i < agencia.getCantidadVehiculosDispobibles(); i++) {
            data[i][0] = agencia.getVehiculo(i).getID();
            data[i][1] = agencia.getVehiculo(i).getMarca();
            data[i][2] = agencia.getVehiculo(i).getModelo();
            data[i][3] = agencia.getVehiculo(i).getColor();
            data[i][4] = Double.toString(agencia.getVehiculo(i).getPrecio());
            data[i][5] = agencia.getVehiculo(i).getTipo();
        }

        tableModel = new DefaultTableModel(data, columnNames);
        jTable = new JTable(tableModel);
        jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jPanel.add(jTable, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Paleta.fondo);

        btEliminar = new JButton("Eliminar");
        btEliminar.setForeground(Paleta.fondo);
        btEliminar.setBackground(Paleta.texto);
        btEliminar.setFont(Fuentes.normal);
        btEliminar.addActionListener(this);
        buttonsPanel.add(btEliminar);

        btAgregarCarro = new JButton("Agregar Carro");
        btAgregarCarro.setForeground(Paleta.fondo);
        btAgregarCarro.setBackground(Paleta.secundario);
        btAgregarCarro.setFont(Fuentes.normal);
        btAgregarCarro.addActionListener(this);
        buttonsPanel.add(btAgregarCarro);

        btAgregarMoto = new JButton("Agregar Moto");
        btAgregarMoto.setForeground(Paleta.fondo);
        btAgregarMoto.setBackground(Paleta.secundario);
        btAgregarMoto.setFont(Fuentes.normal);
        btAgregarMoto.addActionListener(this);
        buttonsPanel.add(btAgregarMoto);

        btEditar = new JButton("Editar");
        btEditar.setForeground(Paleta.fondo);
        btEditar.setBackground(Paleta.primario);
        btEditar.setFont(Fuentes.normal);
        btEditar.addActionListener(this);
        buttonsPanel.add(btEditar);
        jPanel.add(buttonsPanel, BorderLayout.SOUTH);

        datos = new DefaultCategoryDataset();
        datos.addValue(agencia.getCantidadCarrosDisponibles(), "Carros", "Total");
        datos.addValue(agencia.getCantidadMotosDisponibles(), "Motos", "Total");

        JFreeChart chart = ChartFactory.createBarChart(
                "Carros vs Motos",
                "Vehiculos",
                "Cantidad",
                datos,
                PlotOrientation.VERTICAL,
                true, true, false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(250, 500));
        jPanel.add(chartPanel, BorderLayout.EAST);

        this.addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       try {
                                           FileOutputStream fileOutputStream = new FileOutputStream("agencia.bin", true);
                                           ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                           objectOutputStream.writeObject(agencia);
                                           objectOutputStream.flush();
                                           objectOutputStream.close();
                                           agencia.generarReporte();
                                       } catch (Exception ex) {
                                           System.out.println(ex.getMessage());
                                       }
                                   }
                               }
        );

        setVisible(true);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btEliminar) {
            if (jTable.getSelectedRow() != -1) {
                boolean esCarro = agencia.getVehiculo(jTable.getSelectedRow()).getTipo().equals("Carro");
                agencia.eliminarVehiculo(jTable.getSelectedRow());
                tableModel.removeRow(jTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Vehiculo eliminado con exito");
                if (esCarro)
                    datos.setValue(agencia.getCantidadCarrosDisponibles(), "Carros", "Total");
                else
                    datos.setValue(agencia.getCantidadMotosDisponibles(), "Motos", "Total");
            }
        } else if (e.getSource() == btAgregarCarro) {
            new FrameAgregarCarro("Agregar Carro", tableModel, datos);
        } else if (e.getSource() == btAgregarMoto) {
            new FrameAgregarMoto("Agregar Moto", tableModel, datos);
        } else if (e.getSource() == btEditar) {
            if (jTable.getSelectedRow() != -1) {
                new FrameEditar(agencia.getVehiculo(jTable.getSelectedRow()), tableModel, jTable.getSelectedRow());
            }
        }
    }
}
