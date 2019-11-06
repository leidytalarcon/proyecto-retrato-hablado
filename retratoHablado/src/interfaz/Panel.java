package interfaz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class Panel extends JPanel {

    private BufferedImage Imagen_en_memoria;
    private Graphics2D g2d;
    public Dibujar_rostro rostro;    

    //constructor principal
    public Panel() {
        //Configura el tamaño del panel
        this.setSize(600,700);
        this.setPreferredSize(this.getSize());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rostro = new Dibujar_rostro();        
    }    

    @Override
    public void paintComponent(Graphics g) {        
        Graphics2D g2 = (Graphics2D)g;
        //imagen en memoria para dibujar en segundo plano
        //el tamaño de la imagen es igual al del panel
        Imagen_en_memoria = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        
     
        g2d = Imagen_en_memoria.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.white);
        g2d.fill(new Rectangle2D.Double(0,0,this.getWidth(), this.getHeight()));
        
        //dibuja la imagen
        rostro.dibujar(g2d);
        //dibuja todo  en el panel
        g2d.setFont( new Font("Arial",Font.BOLD, 15) );
        g2d.setColor(Color.black);
        g2d.drawString("imagenes tomadas y editadas de faces 3.0 ", 20, 15);
        g2.drawImage(Imagen_en_memoria, 0, 0, this);
       
    }

}