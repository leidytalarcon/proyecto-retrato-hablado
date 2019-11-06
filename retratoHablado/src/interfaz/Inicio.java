/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;
/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


public class Inicio {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //metodo inicial, no se pueden iniciar hilos dentro del main
        Principal iniciar_hilo = new Principal();
        iniciar_hilo.iniciarTodo();
         
    }
}
