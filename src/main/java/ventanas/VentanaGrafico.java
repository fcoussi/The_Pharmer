/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

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
import paneles.PanelGeneral;
import paneles.PanelGeneral;
import paneles.PanelGrafico;

/**
 *
 * @author castillo
 */
public class VentanaGrafico extends JFrame {

    private JFrame ventana;
    private PanelGrafico grafico;

    public VentanaGrafico(JFrame ventana, ImageIcon icono) {
        this.setIconImage(icono.getImage());
//        GridLayout distribucion =new GridLayout();
//        this.panelVentana=new PanelGeneral(distribucion,null,null);
//        this.panelVentana.crearBordes("Grafico cantidad de animales por raza");
//        this.add(this.panelVentana);
        inicializarComponente();

    }

    public void inicializarComponente() {

        this.setTitle("THE PHARMER");
        this.setSize(new Dimension(615, 500));
        this.setLocation(new Point(460, 130));

        this.grafico = new PanelGrafico();
        this.add(this.grafico, BorderLayout.CENTER);
        setVisible(true);
    }

}
