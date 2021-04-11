/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.carrerarelevos;

import co.edu.ucundinamarca.juego.Equipo;
import co.edu.ucundinamarca.juego.Pantalla;
import co.edu.ucundinamarca.juego.Participante;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class Principal {

    public Principal() {
        
        iniciar();
        
    }
    
    public static void main(String[] args) {
        
        new Principal();
        
    }
    
    private void iniciar(){
        
        Equipo equipo1 = new Equipo("Equipo 1", 'x');
        Equipo equipo2 = new Equipo("Equipo 2", 'w');
        Equipo equipo3 = new Equipo("Equipo 3", 'o');
        
        Object testigo1 = new Object();
        Object testigo2 = new Object();
        Object testigo3 = new Object();
        
        Participante[][] participantes = new Participante[3][3];
        
        //Equipo 1
        
        participantes[0][0] = new Participante(testigo1, equipo1, (byte)1);
        participantes[0][1] = new Participante(testigo1, equipo1, (byte)2);
        participantes[0][2] = new Participante(testigo1, equipo1, (byte)3);
        
        //Equipo 2
        
        participantes[1][0] = new Participante(testigo2, equipo2, (byte)1);
        participantes[1][1] = new Participante(testigo2, equipo2, (byte)2);
        participantes[1][2] = new Participante(testigo2, equipo2, (byte)3);
        
        //Equipo 3
        
        participantes[2][0] = new Participante(testigo3, equipo3, (byte)1);
        participantes[2][1] = new Participante(testigo3, equipo3, (byte)2);
        participantes[2][2] = new Participante(testigo3, equipo3, (byte)3);
        
        for(byte fila = 0; fila < participantes.length; fila++){
            
            for(byte columna = 0; columna < participantes[fila].length; columna++){
            
                participantes[fila][columna].start();
            
            }
            
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        synchronized(testigo1){
        
            testigo1.notify();
        
        }
        
        synchronized(testigo2){
        
            testigo2.notify();
        
        }
        
        synchronized(testigo3){
        
            testigo3.notify();
        
        }
        
        Pantalla pantalla = new Pantalla(participantes);
        
        while(participantes[0][2].isAlive() && participantes[1][2].isAlive() && participantes[2][2].isAlive()){

            for(byte i=0; i<9; i++){
                
                System.out.println("");
                
            }
            
            pantalla.mostrarProgreso();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        for(byte numEquipo=0; numEquipo < 3; numEquipo++){
            
            if(participantes[numEquipo][2].isAlive()){
                
                participantes[numEquipo][2].interrupt();
                
            }
            
        }
        
    }
    
}
