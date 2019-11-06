 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class Rasgo implements Serializable{
    
    private String nombre_rasgo;
    private int index;
    private String url;

    //objeto utilziado para guardar la lista de reasgos en un archivo de texto
    //almacena el tipo de rasgo, el inidice y la url de la imagen del rasgo
    public String getNombre_rasgo() {
        return nombre_rasgo;
    }

    public void setNombre_rasgo(String nombre_rasgo) {
        this.nombre_rasgo = nombre_rasgo;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
