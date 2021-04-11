/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.juego;

/**
 * Clase que permite crear equipos para la carrera de relevos
 * @author Miguel Ángel Manrique Téllez
 * @since 1.0.0
 * @version 1.0.0
 */
public class Equipo {
 
    /**
     * Es el nombre del equipo para la carrera
     */
    private String nombre;
    
    /**
     * Es el símbolo que representa a los jugadores del equipo en la pantalla
     */
    private char simbolo;

    /**
     * Constructor que inicializa el equipo
     * @param nombre variable que tiene el nombre del equipo
     * @param simbolo variable que tiene el símbolo que representa al equipo
     */
    public Equipo(String nombre, char simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    /**
     * Retorna el nombre del equipo
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el símbolo que representa al equipo
     * @return simbolo
     */
    public char getSimbolo() {
        return simbolo;
    }

}
