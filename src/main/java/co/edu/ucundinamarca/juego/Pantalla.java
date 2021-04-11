/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucundinamarca.juego;

/**
 * Clase que permite mostrar el progreso de cada participante en la carrera
 * @author Miguel Ángel Manrique Téllez
 * @since 1.0.0
 * @version 1.0.0
 */
public class Pantalla {

    /**
     * Es la matriz que posee a los participantes de la carrera de relevos
     */
    private Participante[][] participantes;
    
    
    /**
     * Constructor que inicializa a la pantalla para que tenga los datos necesarios para mostrar el progreso
     * @param participantes matriz que posee a los participantes de la carrera
     */
    public Pantalla(Participante[][] participantes) {
        
        this.participantes = participantes;
        
    }
    
    /**
     * Imprime gráficamente por consola la carrera de relevos
     */
    public void mostrarProgreso(){
        
        String[] progresoFilas = new String[3];
       
        //A cada cadena del arreglo, le asigna todas las posiciones con el carácter de espacio
        for(byte fila = 0; fila < progresoFilas.length; fila++){
            
            String progresoFila = "";
            
            for(byte posicion = 1; posicion <= CampoDeJuego.LONGITUD-1; posicion++){
                
                progresoFila += " ";
                
            }
            
            progresoFila += "|";
            
            progresoFilas[fila] = progresoFila;
            
        }
        
        //Reemplaza la posición de cada cadena en la que está el participante con un símbolo que lo representa
        for(byte numZona = 1; numZona <= 3; numZona++){
            
            for(byte numParticipante = 1; numParticipante <= 3; numParticipante++){
                
                StringBuilder filaParaModificar = new StringBuilder(progresoFilas[numZona-1]);
                filaParaModificar.setCharAt(participantes[numZona-1][numParticipante-1].getPosicion()-1, participantes[numZona-1][numParticipante-1].getEquipo().getSimbolo());
                
                progresoFilas[numZona-1] = filaParaModificar.toString();
                
            }
            
        }
        
        for (String progresoFila: progresoFilas) {
            
            System.out.println(progresoFila);
            
        }
        
    }
    
}
