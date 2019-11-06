package componentes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import interfaz.Panel;
/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


public class MyButton extends JButton implements MouseMotionListener{

   //variable global que almacena el estado del botón
   private boolean moviendo;
   //cada bton tiene un jpanel
   private Panel lienzo;
   
    public MyButton() {

        setContentAreaFilled(false);

        Dimension tamano = getPreferredSize();
        //el ancho y alto del boton serán iguales
        tamano.width = tamano.height = Math.max(tamano.width, tamano.height);
        setPreferredSize(tamano);
        //por defecto el booton no se encuentra en movimiento
        moviendo = false;

        addMouseMotionListener(this);

    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());

    }

    public void mouseDragged(MouseEvent mme) {
        //mueve el boton mientras sea arrastrado
        setLocation(
                this.getX() + mme.getX() - this.getWidth() / 2,
                this.getY() + mme.getY() - this.getHeight() / 2
        );
        //cambia el estado del botón a  en movimiento
        moviendo = true;

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    
    }

    public boolean isMoviendo() {
        return moviendo;
    }

    public void setMoviendo(boolean moviendo) {
        this.moviendo = moviendo;
    }

    public Panel getLienzo() {
        return lienzo;
    }

    public void setLienzo(Panel lienzo) {
        this.lienzo = lienzo;
    }
    
    
    
}
