/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.texto;

import java.util.ArrayList;
import java.util.List;
import pojo.Rasgo;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class PrecargarLista {
    
    //Crea una lista de rasgos
    public List<Rasgo> cargarLista(){
        List<Rasgo> rasgos = new ArrayList<Rasgo>();
        
        //vector de strings con cada rasgo
        String[] tipoRasgos = new String[8];
        tipoRasgos[0] = "cabello";
        tipoRasgos[1] = "cabeza";
        tipoRasgos[2] = "nariz";
        tipoRasgos[3] = "ojos";
        tipoRasgos[4] = "labios";
        tipoRasgos[5] = "mandibula";
        tipoRasgos[6] = "cejas";
        tipoRasgos[7] = "bigote";
        
        for(String tipoRasgo : tipoRasgos){
            for(int i=1; i<=6;i++){
                Rasgo rasgo = new Rasgo();
                rasgo.setNombre_rasgo(tipoRasgo);
                rasgo.setIndex(i);
                //guarda la url de la imagen que coincida con el rasgo y el indice
                rasgo.setUrl("/imagenes/"+ tipoRasgo +"/jface_" + i + ".png");
              
                //agregar el objeto a la lista
                rasgos.add(rasgo);
            }
        }
        
        return rasgos;
        
    }
    
}
