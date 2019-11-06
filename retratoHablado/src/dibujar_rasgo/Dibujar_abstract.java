/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujar_rasgo;

import archivos.texto.Ficheros;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import pojo.Rasgo;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


//Clase abstracta
public abstract class Dibujar_abstract {
    
    //objeto tipo url donde se obtendra la ruta de las imagenes
    private URL url_imagen;
    //objeto para obtener la lista de rasgos de un archivo de texto
    private Ficheros ficheros;
    //lista global donde se guardara la lista obtenida del archivo de tezto
    List<Rasgo> rasgos;

    public Dibujar_abstract() {
        ficheros = new Ficheros();
        rasgos = new ArrayList<Rasgo>();
        rasgos = ficheros.LeerRasgos();
    }
    
     //carga todas las imagenes en memoria
   protected BufferedImage[] load_images( String miembro){
        BufferedImage[] imagenes = new BufferedImage[7];
        //se llena el buffer con la imagen
        for(int i=1; i<=6;i++){
            try {
                //obtiene las imagenes que coincidan con el rasgo que se está buscando
                for(Rasgo rasgo : rasgos){
                    if(rasgo.getIndex() == i && rasgo.getNombre_rasgo().equals(miembro)){
                        url_imagen = new URL(getClass().getResource(rasgo.getUrl()).toString());
                        
                        imagenes[i] = ImageIO.read(url_imagen); 
                    }
                }
                              
            } catch (Exception ex) {
                System.out.println(ex+miembro); 
            }
            
        }
        return imagenes;
    }
    
    
    
}
