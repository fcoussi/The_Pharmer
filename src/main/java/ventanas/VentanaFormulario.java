/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Modelo.Animal;
import Modelo.GestorArchivo;
import paneles.PanelBoton;
import paneles.PanelGeneral;

public class VentanaFormulario extends JFrame implements ActionListener {

    private JFrame ventPrin;
    private PanelGeneral panelNorte;
    private PanelGeneral panelVentana;
    private PanelBoton panelSur;

    public VentanaFormulario(JFrame ventana, ImageIcon icono) {
        this.setIconImage(icono.getImage());
        this.ventPrin = ventana;
        inicializarComponente();

        inicializarComponente();
        GridLayout distribucion = new GridLayout(6, 3);

        this.panelNorte = new PanelGeneral();
        this.panelNorte.setSize(615, 200);
        this.add(this.panelNorte, BorderLayout.NORTH);

        String[] etiquetas = {"Nombre", "Edad", "Sexo", "Fecha Nac", "Raza", "Nº Arete"};
        this.panelVentana = new PanelGeneral(distribucion, etiquetas, null);
        this.panelVentana.crearBordes("Formulario");

        for (int i = 0; i < 6; i++) {
            this.panelVentana.crearEtiquetas(i);
            this.panelVentana.crearLabelVacios();
            this.panelVentana.crearTextField(i);
            this.panelVentana.txtDatos.get(i).setPreferredSize(new Dimension(200, 50));
//            this.panelVentana.modificarTamaño();

        }
        this.add(this.panelVentana, BorderLayout.CENTER);

        String[] nombreBtn = {"Aseptar"};
        this.panelSur = new PanelBoton(nombreBtn, 5, 260);
        this.add(panelSur, BorderLayout.SOUTH);
    }

    public void agregarListener() {
        for (int i = 0; i < this.panelSur.botones.size(); i++) {

            this.panelSur.botones.get(i).addActionListener(this);
        }

    }

    private void inicializarComponente() {

        this.setTitle("The Pharmer");
        this.setSize(640, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.panelSur.botones.get(0) == e.getSource()) {

            String datos[] = new String[6];
            for (int i = 0; i < this.panelVentana.txtDatos.size(); i++) {

                if (rootPaneCheckingEnabled) {
                    datos[i] = this.panelVentana.txtDatos.get(i).getText();
                }

            }
            Animal animal = new Animal(datos);
            GestorArchivo g1 = new GestorArchivo(animal);
            g1.escribirArchivo(animal.getRaza());
            // g1.leerArchivo("vacuno");
            JOptionPane.showMessageDialog(null, "Datos guardados");

            for (int i = 0; i < this.panelVentana.txtDatos.size(); i++) {
                this.panelVentana.txtDatos.get(i).setText("");

            }
        }
    }

}
