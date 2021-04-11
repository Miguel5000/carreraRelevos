/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.juego;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de manejar todo lo referente a los participantes de la carrera de relevos
 * @author Miguel Ángel Manrique Téllez
 * @since 1.0.0
 * @version 1.0.0
 */
public class Participante extends Thread{

    
    /**
     * Es el número que le da orden al participante en la carrera con respecto a su equipo
     */
    private byte numParticipante;
    
    /**
     * Es el objeto que representa al testigo en la carrera de relevos
     */
    private Object testigo;
    
    /**
     * Es la posición que tiene el participante en el campo de juego
     */
    private byte posicion;
    
    /**
     * Es la posición a la que debe llegar el participante en el campo de juego
     */
    private byte posicionFinal;
    
    /**
     * Es el equipo al que pertenece el participante
     */
    private Equipo equipo;

    /**
     * Constructor que inicializa al participante
     * @param testigo variable que representa el testigo en la carrera
     * @param equipo variable que indica el equipo del participante
     * @param numParticipante variable que indica el orden del participante en su equipo
     */
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
    
    /**
     * Se encarga de hacer que el participante se mueva una vez posee el testigo
     */
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
    
    /**
     * Inicia la ejecución del hilo
     */
    @Override
    public void run() {
        
        super.run(); //To change body of generated methods, choose Tools | Templates.
        
        this.correr();
        
    }

    /**
     * Retorna la posición que tiene el participante en el campo de juego
     * @return posicion
     */
    public byte getPosicion() {
        return posicion;
    }

    /**
     * Retorna el equipo al que pertenece el participante
     * @return equipo
     */
    public Equipo getEquipo() {
        return equipo;
    }
    
    
}
