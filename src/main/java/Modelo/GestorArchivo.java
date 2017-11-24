/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import paneles.PanelTabla;

/**
 *
 * @author DeadPoint
 */
public class GestorArchivo {

    private Animal p1;

    public GestorArchivo(Animal p1) {
        this.p1 = p1;
    }
    
    public GestorArchivo(){
        
    }
    public void escribirArchivo(String raza) {

        String texto = ("");
        FileWriter fw;

        try {
            fw = new FileWriter("data\\BaseDeDatos\\"+raza+".txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.p1.toString());
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            System.out.println("Error al manejar el archivo");
        }

    }

    public void leerArchivo(String palabra,PanelTabla t) {
       
        String archivo = "data\\BaseDeDatos\\" + palabra + ".txt";
        BufferedReader lector = null;
        int contador=0;
       t.completarFilasPorDefecto(contador);
         t.eliminarTodasFilas();
        try {
            lector = new BufferedReader(new FileReader(archivo));
            String linea = lector.readLine();
            while (linea != null) {
               // System.out.println(linea);
                
                String []datos=linea.split(";");
                for (int i = 0; i < datos.length; i++) {
                    System.out.println(datos[i]);
                        
                    
                } 
              
                t.completarInformacion(contador,datos);
                contador++;
                linea = lector.readLine();


            }
            //t.completarFilasPorDefecto(contador);
            
            

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}

