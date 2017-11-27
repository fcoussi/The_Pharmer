/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DeadPoint
 */
public class PanelTabla extends JPanel {

    private String[][] filaDatos;
    private String[] columna;
    private JScrollPane scrollPane;
    private JTable tabla;
    private DefaultTableModel modelo;

    public PanelTabla() {

        inicializarComponente();
    }

    public void inicializarComponente() {

        //array de String's con los tÌtulos de las columnas
        String[] columnNames = {"Nombre", "Edad", "Sexo",
            "Fecha Nac", "Raza", "Nº arete"};
        this.columna = columnNames;

        //se crea la Tabla
        int contador = 0;
        completarFilasPorDefecto(contador);
        this.modelo = new DefaultTableModel(filaDatos, columna);
        this.tabla = new JTable(this.modelo);
        this.tabla.setPreferredScrollableViewportSize(new Dimension(500, 300));
        this.scrollPane = new JScrollPane(this.tabla);
        this.add(scrollPane, BorderLayout.CENTER);

    }

    public void completarFilasPorDefecto(int contador) {
        this.filaDatos = new String[40][6];

        for (int i = contador; i < 20; i++) {
            for (int j = 0; j < 6; j++) {
                this.filaDatos[i][j] = "";
            }
        }
    }

    public JTable getTabla() {

        return this.tabla;
    }

    public DefaultTableModel getModelo() {

        return this.modelo;
    }

    public void completarInformacion(int fila, String[] dato) {
        Object[] filas = new Object[6];
        filas[0] = dato[0];
        filas[1] = dato[1];
        filas[2] = dato[2];
        filas[3] = dato[3];
        filas[4] = dato[4];
        filas[5] = dato[5];
        this.modelo.addRow(filas);
    }

    public void eliminarTodasFilas() {

        try {
            int filas = this.tabla.getRowCount();
            for (int i = 0; i < filas; i++) {
                this.modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar tabla");
        }

    }

}
