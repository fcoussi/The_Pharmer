/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DeadPoint
 */
public class PanelGeneral extends JPanel {

    private ArrayList<JLabel> etiquetas;
    public ArrayList<JButton> botones;
    public ArrayList<JTextField> txtDatos;
    private String[] nombreBtn;
    private String[] nombreEtiqueta;

    public PanelGeneral() {

        JLabel t = new JLabel();
        this.add(t);
        this.setSize(610, 400);
    }

    public PanelGeneral(String[] nom) {

        BoxLayout distribucion = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(distribucion);
        this.botones = new ArrayList<>();
        this.nombreBtn = nom;
    }

    public PanelGeneral(LayoutManager distribucion, String[] etiqueta, String[] label) {
        this.setLayout(distribucion);
        // this.setPreferredSize(new Dimension(0, 45));
        this.nombreBtn = label;
        this.nombreEtiqueta = etiqueta;
        this.etiquetas = new ArrayList<>();
        this.botones = new ArrayList<>();
        this.txtDatos = new ArrayList<>();

    }

    public void crearBordes(String titulo) {
        TitledBorder border = BorderFactory.createTitledBorder(titulo);
        border.setTitleColor(Color.BLUE);
        setBorder(border);
    }

    public void crearEtiquetas(int indice) {
        this.etiquetas.add(new JLabel(this.nombreEtiqueta[indice]));
        this.add(etiquetas.get(indice));

    }

    public void crearLabelVacios() {
        JLabel etiqueta = new JLabel();
        this.add(etiqueta);
    }

    public void crearBotones(int indice) {
        this.botones.add(new JButton(this.nombreBtn[indice]));
        this.add(botones.get(indice));

    }

    public void crearTextField(int indice) {
        this.txtDatos.add(new JTextField());
        this.txtDatos.get(indice).setPreferredSize(new Dimension(200, 50));
        this.add(txtDatos.get(indice));

    }
    
    public void setTxtDatos(int n, String dato){
        this.txtDatos.get(n).setText(dato);
    }

    public void modificarTamaño() {

        for (int i = 0; i < this.txtDatos.size(); i++) {

            this.txtDatos.get(i).setPreferredSize(new Dimension(200, 25));

        }
    }

}
