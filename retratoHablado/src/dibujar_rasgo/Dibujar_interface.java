/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujar_rasgo;

import java.awt.Image;
/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


//determina los metodos que debn ser usados por todas las clases que lo implementen
public interface Dibujar_interface {
    
    public void cambiar_parte_del_rostro(String value);

   public Image getImagen();
   
   public int getIndex();
   
}
