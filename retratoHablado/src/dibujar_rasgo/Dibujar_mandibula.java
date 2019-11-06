/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujar_rasgo;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class Dibujar_mandibula extends Dibujar_abstract implements Dibujar_interface{
    
   private BufferedImage[] imagenes;  
   private int index=0;

    public Dibujar_mandibula() {
        super();
        imagenes = load_images("mandibula"); 
    }
    
   @Override
    public void cambiar_parte_del_rostro(String value){
       index = Integer.valueOf(value);
           
    }

   @Override
   public Image getImagen(){
        return imagenes[this.index];
   }
   
   @Override
   public int getIndex(){
       return this.index;
   }
}
