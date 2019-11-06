/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */

public class Captura {

    /*
        recibe un componente, en este caso un jpanel
     */
    public boolean getScreenShot(Component component) {

        //Declara una imagen que se guardara del tamaño del panel, y a color
        BufferedImage image = new BufferedImage(600, 700, BufferedImage.TYPE_INT_RGB);

        // Imprime todos los componentes del panle dentro del canvas de la imagen a guardar
        component.printAll(image.getGraphics()); // alternately use .printAll(..)

        try {
            // guarda la iamgen creada en formato png
            ImageIO.write(image, "png", new File("screenshot.png"));
            //System.out.println("bien");
            JOptionPane.showMessageDialog(null, "Rostro guardado.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
