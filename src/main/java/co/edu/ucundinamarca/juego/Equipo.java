/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.juego;

/**
 *
 * @author Miguel
 */
public class Equipo {
 
    private String nombre;
    private char simbolo;

    public Equipo(String nombre, char simbolo) {
        this.nombre = nombre;
        this.simbolo = simbolo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the simbolo
     */
    public char getSimbolo() {
        return simbolo;
    }
    
    

}
