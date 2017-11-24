/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Modelo.vista.*;
import logica.*;

/**
 *
 * @author DeadPoint
 */
public class Animal {
        
    private String nombre;
    private String edad;
    private String sexo;    
    private String fechaNacimiento;
    private String raza;
    private String numeroArete;
    
    public Animal(String []datos){
        
        this.nombre=datos[0];
        this.edad=datos[1];
        this.sexo=datos[2];
        this.fechaNacimiento=datos[3];
        this.raza=datos[4];
        this.numeroArete=datos[5];
        
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    public String getRaza(){
        return this.raza;
    }

    public void setNumeroArete(String numeroArete) {
        this.numeroArete = numeroArete;
    }

    @Override
    public String toString() {
        return ""+nombre + ";" + edad + ";"+ sexo + ";" + fechaNacimiento + ";" + raza + ";" + numeroArete;
    }

   
    
    
    
    
    
}
