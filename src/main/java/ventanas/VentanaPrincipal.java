/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import ventanas.VentanaGrafico;
import ventanas.VentanaFormulario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import logica.GestorArchivo;
import paneles.PanelBoton;
import paneles.PanelBoton;
import paneles.PanelGeneral;
import paneles.PanelTabla;
import paneles.PanelTabla;

/**
 *
 * @author DeadPoint
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private ImageIcon logoPrograma;
    private Icon icono;
    private PanelBoton panelStartNorte;
    private PanelBoton panelSur;
    private PanelTabla panelCenter;
    private PanelGeneral panelNorte;

    // private PanelBoton panelNorteIzquierdo;
    private PanelBoton panelNorteCentro;
    private PanelBoton panelNorteDerecho;

    private PanelGeneral panelDerecho;

    public VentanaPrincipal() {
        inicializarComponente();
    }

    public void inicializarComponente() {

        setTitle("The Pharmer");
        setSize(640, 500);
        setLocationRelativeTo(null);

        crearLogo();
        this.setIconImage(this.logoPrograma.getImage());

        // Creando panel Norte       
        GridLayout distribucion = new GridLayout();
        this.panelNorte = new PanelGeneral(distribucion, null, null);

//        this.panelNorteIzquierdo = new PanelBoton(1, 1);
//        this.panelNorteIzquierdo.agregarLabel();
//        
        this.panelNorteCentro = new PanelBoton(1, 0);
        this.panelNorteCentro.agregarLabel();

        this.panelNorteDerecho = new PanelBoton(2, 3);
        this.panelNorteDerecho.agregarJTextField(10);
        this.panelNorteDerecho.agregarBoton("Buscar");

//        this.panelNorte.add(this.panelNorteIzquierdo);
        this.panelNorteCentro.setSize(60, 20);
        this.panelNorte.add(panelNorteCentro);
        this.panelNorte.add(panelNorteDerecho);
        this.add(this.panelNorte, BorderLayout.NORTH);

        //       this.panelNorteIzquierdo.botones.get(0).addActionListener(this);
        this.panelNorteDerecho.botones.get(0).addActionListener(this);

        this.panelCenter = new PanelTabla();
        this.add(this.panelCenter, BorderLayout.WEST);

        String btnDerecho[] = {"Modificar", "Eliminar"};
        this.panelDerecho = new PanelGeneral(btnDerecho);

        this.panelDerecho.crearBotones(0);
        this.panelDerecho.crearBotones(1);

        this.add(this.panelDerecho);
        this.setBackground(Color.DARK_GRAY);
        this.add(this.panelDerecho, BorderLayout.EAST);

        this.panelDerecho.botones.get(0).addActionListener(this);
        this.panelDerecho.botones.get(1).addActionListener(this);

        //Creando panel Sur
        String nombre[] = {"Grafico", "Agregar"};
        this.panelSur = new PanelBoton(nombre, 3, 10);
        this.add(this.panelSur, BorderLayout.SOUTH);

        this.panelSur.botones.get(0).addActionListener(this);
        this.panelSur.botones.get(1).addActionListener(this);

        setVisible(true);
    }

    public void crearLogo() {
        this.logoPrograma = new ImageIcon("data\\Logo.png");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.panelNorteDerecho.botones.get(0) == e.getSource()) {
            String palabra = this.panelNorteDerecho.texto.get(0).getText();
            realizarComparacion(palabra);
        }

        if (this.panelSur.botones.get(0) == e.getSource()) {
            VentanaGrafico vtn = new VentanaGrafico(this, logoPrograma);
        }

        if (this.panelSur.botones.get(1) == e.getSource()) {
            VentanaFormulario vtn = new VentanaFormulario(this, logoPrograma);
            vtn.agregarListener();
        }

        if (this.panelDerecho.botones.get(0) == e.getSource()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea modificar los datos?", "Alerta", JOptionPane.YES_NO_OPTION);
            String[] datos = new String[6];
            if (respuesta == 0) {

                int fila = this.panelCenter.getTabla().getSelectedRow();
                datos[0] = (String) this.panelCenter.getTabla().getValueAt(fila, 0);
                datos[1] = (String) this.panelCenter.getTabla().getValueAt(fila, 1);
                datos[2] = (String) this.panelCenter.getTabla().getValueAt(fila, 2);
                datos[3] = (String) this.panelCenter.getTabla().getValueAt(fila, 3);
                datos[4] = (String) this.panelCenter.getTabla().getValueAt(fila, 4);
                datos[5] = (String) this.panelCenter.getTabla().getValueAt(fila, 5);

                for (int i = 0; i < datos.length; i++) {
                    System.out.println("datos :" + datos[i]);

                }

                VentanaModificar vtn = new VentanaModificar(this, logoPrograma);
                vtn.modificarDatos(datos);

            }
        }

        if (this.panelDerecho.botones.get(1) == e.getSource()) {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar los datos?", "Alerta", JOptionPane.YES_NO_OPTION);
            // this.panelCenter = new PanelTabla();
            if (respuesta == 0) {

                int fila = this.panelCenter.getTabla().getSelectedRow();
                this.panelCenter.getModelo().removeRow(fila);

                if (fila != -1) {

                } else {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");

                }
            }

        }
    }

    public void realizarComparacion(String palabra) {
        GestorArchivo g1 = new GestorArchivo();
        g1.leerArchivo(palabra, this.panelCenter);

    }

}
