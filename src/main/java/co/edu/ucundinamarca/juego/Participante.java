/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.juego;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class Participante extends Thread{

    private byte numParticipante;
    private Object testigo;
    private byte posicion;
    private byte posicionFinal;
    private Equipo equipo;

    public Participante(Object testigo, Equipo equipo, byte numParticipante) {
        
        this.testigo = testigo;
        this.equipo = equipo;
        this.numParticipante = numParticipante;
        
        switch(this.numParticipante){
            
            case 1:
                this.posicion = 1;
                this.posicionFinal = CampoDeJuego.POSICION_FINAL_ZONA1;
                break;
            case 2:
                this.posicion = (byte)(CampoDeJuego.POSICION_FINAL_ZONA1+1);
                this.posicionFinal = CampoDeJuego.POSICION_FINAL_ZONA2;
                break;
            case 3:
                this.posicion = (byte)(CampoDeJuego.POSICION_FINAL_ZONA2+1);
                this.posicionFinal = CampoDeJuego.LONGITUD;
            
        }
        
    }
    
    public void correr(){
        
        try {
        
            synchronized(this.testigo){

                this.testigo.wait();

            }

            byte velocidad = (byte)(Math.random()*3+1);

            while(this.getPosicion() < posicionFinal){

                Thread.sleep(1000);


                if(this.getPosicion() + velocidad > posicionFinal)
                    this.posicion = posicionFinal;
                else
                    this.posicion += velocidad;

            }

            if(this.numParticipante == 3){

                System.out.println("¡¡¡El " + this.equipo.getNombre() +  " es el ganador!!!");

            }

            synchronized(this.testigo){

                this.testigo.notify();

            }
        
        } catch (InterruptedException ex) {
            System.out.println("El " + this.equipo.getNombre() + " lamenta su derrota");
        }
        
    }
    
    @Override
    public void run() {
        
        super.run(); //To change body of generated methods, choose Tools | Templates.
        
        this.correr();
        
    }

    /**
     * @return the posicion
     */
    public byte getPosicion() {
        return posicion;
    }

    /**
     * @return the equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }
    
    
}
