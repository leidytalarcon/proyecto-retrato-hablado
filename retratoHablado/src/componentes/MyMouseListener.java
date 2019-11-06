/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


public class MyMouseListener implements MouseListener {

    //variables globales con las coordenadas del btón
    int x_inicial = 0;
    int y_inicial = 0;

    MyButton boton = new MyButton();
    public MyMouseListener(MyButton boton) {
        this.boton = boton;
       
        //obtiene la ubicación inicial del btón
        x_inicial = this.boton.getLocation().x;
        y_inicial = this.boton.getLocation().y;
    }

    
    
    //evento que se ejecuta cuando se suelta el ckilck sobre el botón
    @Override
    public void mouseReleased(MouseEvent mme) {
        
        //devuelve el bton a su estado inicial cuandod eja de arrastrarse
     boton.setLocation(x_inicial, y_inicial);
     
     //si el botón se encuentra en movimiento modifica la parte del rostro a la cual hace referencia el botón
     if(boton.isMoviendo()){
         String comando = boton.getActionCommand();
         
         //cambia el indice de la parte del rostro a la que hace referencia el botón
         boton.getLienzo().rostro.cambiar_rostro(comando);
          
         //invoca al metodo dbuhjar del panel que dibuja las partes del rostro
         boton.getLienzo().repaint();
     }
     boton.setMoviendo(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
