/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.paneles;

import java.awt.FlowLayout;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author DeadPoint
 */
public class PanelBoton extends JPanel {

    public ArrayList<JButton> botones;
    private ArrayList<JLabel> label;
    public ArrayList<JTextField> texto;
    private String[] nombres;
    private int cantidad;
    private int distancia;
    private FlowLayout btn;
    private JToolBar barra;
    
//    public PanelBoton(String nombre, int cantidad){
//        
//    }
//    
    
    public PanelBoton(int cantidad,int distancia){
        this.cantidad=cantidad;
        FlowLayout btn = new FlowLayout(this.cantidad);
        this.btn=btn;
        this.btn.setHgap(distancia);
        this.setLayout(this.btn);
        this.botones=new ArrayList<>(); 
        this.texto=new ArrayList<>();
    }
    public PanelBoton(String[] nombre, int cantidad, int distancia){
        this.botones = new ArrayList<>();
        this.nombres = nombre;
        this.cantidad = cantidad;
        this.distancia=distancia;
        this.texto=new ArrayList<>();
        inicializarComponente();
    }

    public void inicializarComponente() {

        FlowLayout btn = new FlowLayout(this.cantidad);
        btn.setHgap(this.distancia);
        this.setLayout(btn);

        for (int i = 0; i < this.cantidad - 1; i++) {

            if (i < this.nombres.length) {
                this.botones.add(new JButton(this.nombres[i]));
                this.add(this.botones.get(i));

            } else {

                this.add(new JLabel());
            }

        }
    }
    
    public void agregarBoton(String nombre){
        this.botones.add(new JButton(nombre));
        
        this.add(botones.get(0));
    }
    
    public void agregarBotonUrl(ImageIcon foto){
        this.add(new JButton(foto));
    }
    
    public void agregarLabel( ){
        this.add(new JLabel());
    }
    
    public void agregarJTextField(int largo){
        this.texto.add(new JTextField(largo));
        this.add(texto.get(0));
    }
    
    public void setDistancia(int distancia){
        this.distancia=distancia;
        this.btn.setHgap(this.distancia);
        this.setLayout(this.btn);
    }

}
