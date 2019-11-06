/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class ObjetoControl {
    
    //este objeto es usado para conocer ele stado del sonido(play o pause)
    private boolean estadoMusica;

    public ObjetoControl() {
        estadoMusica = true;
    }
    
    public boolean isEstadoMusica() {
        return estadoMusica;
    }

    public void setEstadoMusica(boolean estadoMusica) {
        this.estadoMusica = estadoMusica;
    }
    
}
