
package archivos.sonido;

import java.net.URL;
import javax.media.Manager;
import javax.media.Player;
import pojo.ObjetoControl;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


public class ControlMusica extends Thread{

    // Un objeto player reproduce archivos de sonido en formato .wav
    private Player reproductor;
    // Objeto que lleva el estado global en que se encuentra el sonido(play o pause)
    private static ObjetoControl objetoControlMusica;
    
    public ControlMusica(ObjetoControl objetoControlMusica) {
        this.objetoControlMusica = objetoControlMusica;
    }
    
    // Metodo que se ejecuta al dar start al hilo
    @Override
    public void run() {
        iniciarMusica();
        //se ejecuta la acción por siempre, validando el estado de el sonido
        do{
            //sincronizar la variable para evitar errores de concurrencia
            synchronized(objetoControlMusica){
                
                // El objeto modificado por la ventana
                if(!objetoControlMusica.isEstadoMusica()){
                    reproductor.stop();
                    try {
                        //detiene el hilo actual
                        objetoControlMusica.wait();
                    } catch (Exception ex) {
                        System.out.println(ex+" error");
                    }
                }else{
                    //cuando el estado de el sonido sea true
                    //continuara reproduciendose el sonido
                    reproductor.start();
                }
            }
        }while(true);
    }
    
    public void iniciarMusica() {
        try {
            //buscar ruta del archivo de sonidola caancion, la libreria solo permite archivos de audio .wav 
            URL url = new URL(this.getClass().getResource("/archivos/sonido/musica.wav").toString());

            //buscar el archivo de audio en la url especificada
            //Manager envia esta cancion al reproductor de audio
            reproductor = Manager.createRealizedPlayer(url);

        } catch (Exception ex) {
            System.err.printf("error" + ex);
        }

    }
    
    
}
