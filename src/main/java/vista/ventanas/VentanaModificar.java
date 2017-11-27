/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import vista.paneles.PanelBoton;
import vista.paneles.PanelGeneral;
import vista.paneles.PanelTabla;

/**
 *
 * @author castillo
 */
public class VentanaModificar extends JFrame implements ActionListener {
    
    private  PanelTabla tablaModificar;
    private PanelGeneral panelCentro;
    private PanelBoton  panelSur;
    private int filaModificar;
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
            this.panelCentro. crearEtiquetas(i);
            this.panelCentro.crearLabelVacios();
            this.panelCentro.crearTextField(i);
        }
    
    this.add(this.panelCentro,BorderLayout.CENTER);
    
    String[] nombreBtn ={"Modificar"};
    this.panelSur=new PanelBoton(nombreBtn,5,260);
    this.add(this.panelSur,BorderLayout.SOUTH);
    
    this.panelSur.botones.get(0).addActionListener(this);
        setSize(600,250);        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("The Pharmer");
        setVisible(true);
    }
    
    public void modificarDatos(String[] datoCelda, int fila,PanelTabla tabla) throws IOException{    
        this.tablaModificar=tabla;
        this.filaModificar=fila;
        String linea=datoCelda[0]+";"+datoCelda[1]+";"+datoCelda[2]+";"+datoCelda[3]+";"+datoCelda[4]+";"+datoCelda[5];
        String linea2;
        for (int i = 0; i < datoCelda.length; i++) {
        this.panelCentro.setTxtDatos(i,datoCelda[i]);
        linea2=linea+datoCelda[i];
        linea2=linea2+";";                    
        }
   
        String ruta="data\\BaseDeDatos\\"+datoCelda[4]+".txt";
         
       // eliminarFila(ruta,linea);        
    }
    
     public void eliminarFila(String file, String palabraEliminar) throws IOException{
        try{
            File enArchivo= new File(file);
            if (!enArchivo.isFile()) {
                System.out.println("Parametros no existen dentro archivo");
                return;
            }
            File tempFile= new File(enArchivo.getAbsolutePath());
          
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            String linea;
            
            while((linea = br.readLine()) !=null){
                if (!linea.trim().equals(palabraEliminar)) {
                    pw.println(linea);
                    pw.flush();
                }
            }
            pw.close();
            br.close();
            
                    if (!enArchivo.delete()) {
                System.out.println("Colud not delete file");
                return;
            }

            if (!tempFile.renameTo(enArchivo)) {
                System.out.println("Colud not rename file");
            }
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (this.panelSur.botones.get(0)==e.getSource()) {
            
            for (int i = 0; i < 6; i++) {
                
              this.tablaModificar.getTabla().setValueAt(this.panelCentro.txtDatos.get(i).getText(),this.filaModificar,i );   
            }
             
            JOptionPane.showMessageDialog(null, "Datos modificados");

        }
    }
}
