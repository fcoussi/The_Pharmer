/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista.paneles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author DeadPoint
 */
public class PanelGrafico extends JPanel{
    
 private ArrayList<String> archivos;
 private ArrayList<Integer> cantidad;
    
   
    public PanelGrafico(){
    this.archivos= new ArrayList<>();
    this.cantidad=new ArrayList<>();
    
    calcularPorcentaje();
    crearGrafico();
    }
    
    public void calcularPorcentaje(){
    int contador=0;
    String path="data\\BaseDeDatos";    
    String files;
    File folder= new File(path);
    File[] listOfFiles =folder.listFiles();
    
     for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {                
                archivos.add(listOfFiles[i].getName());                
            }
            
        } 
     
        for (int i = 0; i < archivos.size(); i++) {
        String archivo = "data\\BaseDeDatos\\"+archivos.get(i);
        BufferedReader lector= null;
        
        try{
            lector = new BufferedReader(new FileReader(archivo));
            String linea=lector.readLine();
            
            while(linea!= null){
            contador++;
            linea=lector.readLine();
             }            
            this.cantidad.add(contador);
            contador=0;
        }catch(IOException ex){
            
        }
        }
        
        
        
           for (int i = 0; i < archivos.size(); i++) {
            System.out.println(archivos.get(i));
            
        }
    
    }
    
    public void crearGrafico(){
        DefaultPieDataset data=new DefaultPieDataset();
        for (int i = 0; i < archivos.size(); i++) {
            data.setValue(archivos.get(i),cantidad.get(i));
            
        }

        
        JFreeChart chart = ChartFactory.createPieChart("Grafico por tipo de animal",data,true,true,false);
        ChartPanel charPanel= new ChartPanel(chart);
        this.add(charPanel);
    }
    
}
