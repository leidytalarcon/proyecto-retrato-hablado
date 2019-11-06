package interfaz;
import dibujar_rasgo.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class Dibujar_rostro {
    //Partes del rostro
    private Dibujar_cabello cabello;
    private Dibujar_cabeza cabeza;
    private Dibujar_nariz nariz;
    private Dibujar_ojos ojos;
    private Dibujar_labios labios;
    private Dibujar_mandibula mandibula;
    private Dibujar_cejas cejas;
    private Dibujar_bigote bigote;

    public Dibujar_rostro(){
        cabello     = new Dibujar_cabello();
        cabeza      = new Dibujar_cabeza();
        nariz       = new Dibujar_nariz();
        ojos        = new Dibujar_ojos();
        labios      = new Dibujar_labios();
        mandibula   = new Dibujar_mandibula();
        cejas       = new Dibujar_cejas();
        bigote      = new Dibujar_bigote();
    }

    //Cambia una parte del rostro
    //Entrada: Parte-del-rostro y el index del botón arrastrado
    public void cambiar_rostro(String value){
        String[] val = value.split("_");//divide el comando en dos
        //valores, separados por _
        
        //si el bton arrastrado pertenece al rasgo nariz
        //el objeto obtiene todas las imagenes de nariz
        //y selecciona la imagen que corresponda con el indice
        if( val[0].equals("nariz"))        
            nariz.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("ojos"))
            ojos.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("labios"))
            labios.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("cabello"))
            cabello.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("cabeza"))
            cabeza.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("mandibula"))
            mandibula.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("cejas"))
            cejas.cambiar_parte_del_rostro(val[1]);
        else if( val[0].equals("bigote"))
            bigote.cambiar_parte_del_rostro(val[1]);       
    }

    public void dibujar(Graphics g) {
        //obtiene un canvas enviado
        Graphics2D g2 = (Graphics2D)g;
        
        //obtiene la lista de imagenes delr asgo
        //imprime en el canvas la imagen seleccionada en el objeto
        if(cabeza.getIndex() != 0){
            g2.drawImage(cabeza.getImagen(),0,0, null);
        }
        if(mandibula.getIndex() != 0){
            g2.drawImage(mandibula.getImagen(),0,0, null);
        }
        if(nariz.getIndex() != 0){
            g2.drawImage(nariz.getImagen(),0,0, null);
        }
        if(ojos.getIndex() != 0){
            g2.drawImage(ojos.getImagen(),0,0, null);
        }
        if(labios.getIndex() != 0){
            g2.drawImage(labios.getImagen(),0,0, null);
        }
        if(cabello.getIndex() != 0){
            g2.drawImage(cabello.getImagen(),0,0, null);
        }
        if(cejas.getIndex() != 0){
            g2.drawImage(cejas.getImagen(),0,0, null);
        }
        if(bigote.getIndex() != 0){
            g2.drawImage(bigote.getImagen(),0,0, null);
        }
    }

}