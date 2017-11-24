/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import paneles.PanelBoton;
import paneles.PanelGeneral;
import paneles.PanelTabla;

/**
 *
 * @author castillo
 */
public class VentanaModificar extends JFrame  {
    
    private PanelGeneral panelCentro;
    private PanelBoton  panelSur;
    public VentanaModificar(JFrame ventana, ImageIcon icono){
        
        this.setIconImage(icono.getImage());
        inicializarComponente();
    }
    
    public void inicializarComponente(){
        
     GridLayout distribucion= new GridLayout(6,3);
    
    
    String[] etiquetas={"Nombre","Edad","Sexo","Fecha Nac","Raza","Nº Arete"};
    this.panelCentro=new PanelGeneral(distribucion, etiquetas,null);
    this.panelCentro.crearBordes("Formulario para modificar");
    
        for (int i = 0; i <6; i++) {
            this.panelCentro.crearEtiquetas(i);
            this.panelCentro.crearLabelVacios();
            this.panelCentro.crearTextField(i);
        }
    
    this.add(this.panelCentro,BorderLayout.CENTER);
    
    String[] nombreBtn ={"Modificar"};
    this.panelSur=new PanelBoton(nombreBtn,5,260);
    this.add(this.panelSur,BorderLayout.SOUTH);
       
        
        setSize(615,300);        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("The Pharmer");
        setVisible(true);
    }
    
    public void modificarDatos(String[] datoCelda){
        
        for (int i = 0; i < datoCelda.length; i++) {
        this.panelCentro.setTxtDatos(i,datoCelda[i]);                
        }        
        
    }
    
}
