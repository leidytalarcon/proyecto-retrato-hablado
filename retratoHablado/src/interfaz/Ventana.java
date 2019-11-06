/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import archivos.Captura;
import componentes.MyButton;
import componentes.MyMouseListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import pojo.ObjetoControl;
/**
 *
 * @author Leidy Alarcon Y Andres Acosta
 */


public class Ventana extends javax.swing.JFrame implements Runnable{

    private Panel lienzo;
    private MyButton btn[][];
    private JButton botonMusica;
    private ActionListener actionListener;
    private MouseListener mouseListener;
    private static ObjetoControl objetoControlMusica;
    private int i,j;

    /**
     * Creates new form Interfaz
     */
    public Ventana(ObjetoControl objetoControlMusica) {
        
        //recibe el objeto que almacena el estado del sonido
        this.objetoControlMusica = objetoControlMusica;
        initComponents();
        
        //Se inicia el jframe, su titulo y tamaño
        setTitle("Face´s search");
        this.setExtendedState(MAXIMIZED_BOTH);
        setSize(1000, 700);
        jPanel1.setSize(this.getSize());
        //se crea la instancia del panel que dibujara las partes del rostro
        lienzo = new Panel();

        //acciones de los controles "MyButton" para tomar captura de pantalla, y dar play o pause a la musica
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String comando = e.getActionCommand();

                if (comando.equals("screenShot")) {
                    capturaPantalla();
                }else if(comando.equals("pause")){
                    detenerMusica();
                }else if(comando.equals("play")){
                    continuarMusica();
                }
                
            }

        };

        //añade el panel que dibujara las pasrtes del rostro al panel principal
        this.jPanel1.add(lienzo);

        //matriz de controles de MyButton
        btn = new MyButton[8][6];

        //crea los botones para tomar captura de pantalla, y dar play o pause a la musica
        botonesUsuario();
        
        //crea los botones que sotraran las partes del rostro
        botonesRasgos();
        
    }
    
    private void botonesUsuario(){
        JButton captura = new JButton();
        //nombre de la acción que realizara el botón
        captura.setActionCommand("screenShot");
        captura.setSize(new Dimension(50, 40));
        captura.setPreferredSize(new Dimension(50, 40));
        lienzo.setLayout(null);
        //ubica el botón en la parte superior del panel
        captura.setLocation(200, 20);
        captura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_captura.png")));
        captura.addActionListener(actionListener);
        //texto que aparece al pasar el mouse sobre el botón
        captura.setToolTipText("Captura pantalla");
        lienzo.add(captura);
        
        botonMusica = new JButton();
        //nombre de la acción inicial que realizara el botón
        botonMusica.setActionCommand("pause");
        botonMusica.setSize(new Dimension(50, 40));
        botonMusica.setPreferredSize(new Dimension(50, 40));
        //ubica el botón en la parte superior del panel
        botonMusica.setLocation(400,20);
        botonMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_pause.png")));
        botonMusica.addActionListener(actionListener);
        botonMusica.setToolTipText("Pausa musica");
        lienzo.add(botonMusica);
    }
    //Crea la matriz de controlos y añade propiedades
    private void botonesRasgos() {
        String action = "";
        
        //Crea una matriz de botones
        for (i = 0; i < 8; i++)//filas
        {
            for (j = 0; j < 6; j++)//columnas
            {
                //inicia el objeto de tipo MyButton
                btn[i][j] = new MyButton();
                btn[i][j].setSize(new Dimension(70, 80));
                btn[i][j].setPreferredSize(new Dimension(70, 80));
                //se ubica el boton según la fila y columna
                btn[i][j].setLocation(setLocationX(j),setLocationY(i));
                btn[i][j].setText("");
                btn[i][j].setBackground(Color.white);
                switch (i) {//Nombres de los eventos
                    case 0:
                        action = "ojos";
                        break;
                    case 1:
                        action = "labios";
                        break;
                    case 2:
                        action = "nariz";
                        break;
                    case 3:
                        action = "cabello";
                        break;
                    case 4:
                        action = "cabeza";
                        break;
                    case 5:
                        action = "mandibula";
                        break;
                    case 6:
                        action = "cejas";
                        break;
                    case 7:
                        action = "bigote";
                        break;
                }
                //texto que aparece al pasar el mouse sobre el boton
                btn[i][j].setToolTipText(action);
                //el comando se compone del rasgo del boton y el index que representa
                btn[i][j].setActionCommand(action + "_" + (j + 1));//se crea comando
                btn[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/" + action + "/jface_" + (j + 1) + "_t.png")));
                //se envia el panel que dibuja las partes del rostro
                //para que se puede modificar el indice de la parte del rostro a la que hace referencia el botón arrasytado
                //luego invoca al metodo dibujar del panel
                btn[i][j].setLienzo(lienzo);
                //se le agrega un mouselistener al botón para poder detectar cuando el botón se deja de arrastrar
                btn[i][j].addMouseListener(new MyMouseListener(btn[i][j]));
                jPanel1.add(btn[i][j]);//se añade al JPanel contenedor

            }
        }
    }
    
    public int setLocationX(int j){
        //los botones siempre empiezan a 602 pixeles a la derecha
        int x=602;
        
        //dependiendo de la columna del botón se mueve más hacía la derecha
        return x+(j*77);
    }

     public int setLocationY(int i){
         //los botones siempre empiezan a 4 pixeles en el amrgen superior
        int y=4;
        
        //dependiendo de la fila del botón se mueve más hacía abajo
        return y+(i*87);
    }

    public void capturaPantalla() {
        
        //invoca a la clase capturar pantalla
        //le envía el panel que sera guardado como archivo de imagen
        //con todos sus componentes dibujados actualmente
        Captura capturar = new Captura();
        capturar.getScreenShot(jPanel1);
        
    }
    
    public void detenerMusica(){
        //modifica el estado del sonido a en pausa
        objetoControlMusica.setEstadoMusica(false);
        
        //modifica la acción del botón y la imagen
        botonMusica.setActionCommand("play");
        botonMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_play.png")));
        botonMusica.setToolTipText("Reproducir musica");
        
        //el hilo del reproductor de sonido detectara que se cambio el estado del sonido
        //se detendra el hilo que reproduce el sonido
    }
    
    public void continuarMusica(){
        //modifica el estado del sonido a reproduciendo
        objetoControlMusica.setEstadoMusica(true);
        //modifica la acción del botón y la imagen
        botonMusica.setActionCommand("pause");
        botonMusica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_pause.png")));
        botonMusica.setToolTipText("Pausa musica");
        
        //notifica al hilo que reproduce el sonido que puede continuar ejecutandose
        //el hilo que reproduce el sonido detectara el cambio en el estado del sonido
        //continuara reproduciendo la musíca
        synchronized(objetoControlMusica){
                objetoControlMusica.notify();
        }
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    //metodo que se ejecuta al iniciar el hilo
    @Override
    public void run() {
       this.setVisible(true);
    }
}
