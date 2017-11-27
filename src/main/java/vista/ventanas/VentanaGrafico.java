/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import vista.paneles.PanelGeneral;
import vista.paneles.PanelGeneral;
import vista.paneles.PanelGrafico;

/**
 *
 * @author castillo
 */
public class VentanaGrafico extends JFrame {

    private JFrame ventana;
    private PanelGrafico grafico;

    public VentanaGrafico(JFrame ventana, ImageIcon icono) {
        this.setIconImage(icono.getImage());

        inicializarComponente();

    }

    public void inicializarComponente() {

        this.setTitle("The Pharmer");
        this.setSize(new Dimension(615, 500));
        this.setLocation(new Point(460, 130));
        this.setResizable(false);
        this.grafico = new PanelGrafico();
        this.add(this.grafico, BorderLayout.CENTER);
        setVisible(true);
    }

}
