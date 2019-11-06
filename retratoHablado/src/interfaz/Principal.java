/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivos.sonido.ControlMusica;
import pojo.ObjetoControl;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class Principal {
    
    public void iniciarTodo(){
        
        //crea un objeto que almacenara el estado del sonido(play o pause)
        ObjetoControl objetoControl = new ObjetoControl();
        
        //crea un objeto del reprodutor de sonido y le envia el objeto que almacena el estado del sonido
        ControlMusica musica = new ControlMusica(objetoControl);
        
        //crea un objeto de el frame principal y le envia el objeto que almacena el estado del sonido
        Ventana j = new Ventana(objetoControl);
        
        //inicia el hilo del frame principal a travez de la interface runnable
        //para ejecutar un hilo que implementa a runnable
        //debe crear un objeto tipo thread y enviarle la clase que implementa a runnable
        Thread t = new Thread(j);
        t.start();
            
        //inicia el hilo del reproductor de musica a travez de la clase abstracta thread
        musica.start();
    }
    
}
