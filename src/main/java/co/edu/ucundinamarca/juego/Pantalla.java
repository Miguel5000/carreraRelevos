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
public class Pantalla {

    private Participante[] participantes;
    
    public Pantalla(Participante[] participantes) {
        
        this.participantes = participantes;
        
    }
    
    public void mostrarProgreso(){
        
        String[] progresoFilas = new String[3];
       
        for(byte fila = 0; fila < progresoFilas.length; fila++){
            
            String progresoFila = "";
            
            for(byte posicion = 1; posicion <= CampoDeJuego.LONGITUD-1; posicion++){
                
                progresoFila += " ";
                
            }
            
            progresoFila += "|";
            
            progresoFilas[fila] = progresoFila;
            
        }
        
        for(byte numZona = 1; numZona <= 3; numZona++){
            
            for(byte numParticipante = 1; numParticipante <= 3; numParticipante++){
                
                StringBuilder filaParaModificar = new StringBuilder(progresoFilas[numZona]);
                filaParaModificar.setCharAt(participantes[(numZona-1)*3+numParticipante].getPosicion(), participantes[(numZona-1)*3+numParticipante].getEquipo().getSimbolo());
                
                progresoFilas[numZona] = filaParaModificar.toString();
                
            }
            
        }
        
        for (String progresoFila: progresoFilas) {
            
            System.out.println(progresoFila);
            
        }
        
    }
    
}
