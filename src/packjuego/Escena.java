/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packjuego;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Master
 */
public class Escena extends JPanel implements ActionListener {
     private Timer timer;
     private Nave N;
     private enemigo1 E1;
     private enemigo2 E2;
     private enemigo3 E3;
     private enemigo4 E4;
     private enemigo5 E5;
     private audio audi;
     private audio audi_pear;
     private JButton cmd;
     private JPanel panel;
     ImageIcon image_icon;
     boolean control=false;
     boolean toca=false;
     public int x;
     public int contador=0;
     public int seguidas;
     public int multiplicador=1; 
     public boolean ended=false;
     public boolean AA = false;
     public int puntos = 0;
     private int subir=0;
     private final audio efecto1;
     private final audio efecto2;
     private final audio efecto3;
     private final audio efecto4;
     private final audio efecto5;
     private final audio efecto_error1;
     private final audio efecto_error2;
     private final audio efecto_error3;
     private final audio efecto_error4;
     private final audio efecto_error5;
     private final audio efecto_item1;
     private final audio efecto_item2;
     private final audio efecto_item3;
     private final audio efecto_item4;
     private final audio efecto_item5;
     private final audio efecto_boom;
     private final audio efecto_laser;
     private final Image puntaje;
     private Image imagen;
     private Image barra_verde;
     private Image barra_rojo;
     private Image barra_amarillo;
     public int pos_x1=515;
     public int pos_y1=560;
     public int pos_x2;
     public int pos_y2;
     public boolean control1=false;
     public String nombre;
     public int cont1=0;
     public int cont2=0;
     public int cont3=0;
     public int cont4=0;
     public int cont5=0;
     public int slow=0;
     public int bombas=0;
     public int key;
    private boolean B;
    private boolean S;
    private Icon unIcono;
    private boolean R=false;
    public int clave = 0;
    public boolean controlA=false;
    public boolean controlB=false;
    private boolean control17;
    public int max_p = 0;
    public String max_nom="";
    public int max_clave=0;
    public int posi[] = new int[100];
    public String nom[] = new String[100];
    public int pun[] = new int[100];
    public String cadena[] = new String[11];
    private int longitud;
    int x1;
    private JList lista;
     
     public Escena(){
     //nombre = JOptionPane.showInputDialog( "Ingrese su nombre" ); //ingresa el nombre 
     setDoubleBuffered(true);
     setFocusable(true);
       
     //cmd = new JButton();//Crea el boton para reiniciar el juego
     //panel = new JPanel();
    // add(panel);
     //setLayout(new BorderLayout());
     //setBounds (0, 0 , 645, 625);
     N = new Nave();  //constructor
     E1 = new enemigo1(); 
     E2 = new enemigo2();
     E3 = new enemigo3();
     E4 = new enemigo4();
     E5 = new enemigo5();
     addKeyListener(new TAdapter());
     addMouseMotionListener( new TMotionAdapter());
     addMouseListener(new TMotion());
     image_icon = new ImageIcon(this.getClass().getResource("imagen/fondo.png"));
     ImageIcon l1 = new ImageIcon(this.getClass().getResource("imagen/puntaje.png"));
     puntaje=l1.getImage();
     ImageIcon l2 = new ImageIcon(this.getClass().getResource("imagen/barra_verde.png"));
     barra_verde=l2.getImage();
     ImageIcon l3 = new ImageIcon(this.getClass().getResource("imagen/barra_amarillo.png"));
     barra_amarillo=l3.getImage();
     ImageIcon l4 = new ImageIcon(this.getClass().getResource("imagen/barra_rojo.png"));
     barra_rojo=l4.getImage();
     imagen = barra_amarillo;
     audi = new audio();
     audi.sonido.loop();
     efecto1 = new audio();
     efecto2 = new audio();
     efecto3 = new audio();
     efecto4 = new audio();
     efecto5 = new audio();
     efecto_error1 = new audio();
     efecto_error2 = new audio();
     efecto_error3 = new audio();
     efecto_error4 = new audio();
     efecto_error5 = new audio();
     efecto_item1 = new audio();
     efecto_item2 = new audio();
     efecto_item3 = new audio();
     efecto_item4 = new audio();
     efecto_item5 = new audio();
     efecto_boom = new audio();
     efecto_laser = new audio();
     
      pos_x1=567;
      pos_y1=618;
      pos_x2=567;
      pos_y2=575;
  
     timer = new Timer(15, this);
     timer.start();      
     
    }
    
    public void paint(Graphics g) {
     super.paint(g);
      
     Graphics2D g2d = (Graphics2D)g;
    
     g2d.drawImage(image_icon.getImage(), 0, 0, this);//dibuja el fondo del juego
     g2d.drawImage(puntaje, 505, 360, this);
     g2d.drawImage(get_image(), 505, 550, this);
     //g2d.drawImage(N.getImage(), N.getX(), N.getY(), this);//dibuja la seleccion de columna
     if (E1.bool==false)
     {
     g2d.drawImage(E1.get_image(), E1.GetX(), E1.GetY(), this);
     }
     if (E2.bool==false)
     {
     g2d.drawImage(E2.get_image(), E2.GetX(), E2.GetY(), this);
     }
     if (E3.bool==false)
     {
     g2d.drawImage(E3.get_image(), E3.GetX(), E3.GetY(), this);
     }
     if (E4.bool==false)
     {
     g2d.drawImage(E4.get_image(), E4.GetX(), E4.GetY(), this);
     }
     if (E5.bool==false)
     {
     g2d.drawImage(E5.get_image(), E5.GetX(), E5.GetY(), this);
    }
     
     ArrayList<shot> lasers = N.getLasers();//====
        for(int i = 0; i < lasers.size(); i++){
            shot l = lasers.get(i);
            g2d.drawImage(l.getImagen(), l.getX(), l.getY(), this);
            
        }
     
    //escritura en el panel puntajes nmbre etc. 
     g2d.setFont( new Font( "Verdana", Font.BOLD, 22 ) );
     g2d.setColor(Color.GREEN);
     g2d.drawString(Integer.toString(puntos), 515, 388);
     g2d.setFont( new Font( "Verdana", Font.BOLD, 30 ) );
     g2d.setColor(Color.ORANGE);
     g2d.drawString(Integer.toString(multiplicador), 552, 440);
     g2d.setColor(Color.BLACK);
     BasicStroke stroke = new BasicStroke(4.0f); 
     g2d.setStroke(stroke);
     g2d.drawLine(pos_x1, pos_y1, pos_x2, pos_y2);
     g2d.setFont( new Font( "Verdana", Font.BOLD, 24 ) );
     g2d.setColor(Color.BLACK);
     g2d.drawString("Jugador", 510, 40);
     g2d.setFont( new Font( "Verdana", Font.BOLD, 20 ) );
     //g2d.drawString(nombre, 535, 70);
     g2d.drawString("Relentizador", 495, 120);
     g2d.drawString(Integer.toString(slow), 535, 140);
     g2d.drawString("Bombas", 510, 180);
     g2d.drawString(Integer.toString(bombas), 535, 220);
     //g2d.drawString(Double.toString(E1.SPEED), 435, 260);
     //g2d.drawString(Integer.toString(pos_x2), 390, 388);
     //g2d.drawString(Integer.toString(pos_y2), 450, 388);
     g2d.drawImage(N.getImage(), N.getX(), N.getY(), this);//dibuja la nave     
     
     Toolkit.getDefaultToolkit().sync();
     g.dispose();
    }
    
    
      public void actionPerformed(ActionEvent e){
       
       N.logic();
       
       ArrayList<shot> lasers = N.getLasers();
        for(int i = 0; i < lasers.size(); i++){
            shot l = lasers.get(i);
            if(l.isVisible())
                l.update();
            else
                
                lasers.remove(i);
                
        }
       velocidad();//regula la velocidad del juego comforme pasa el tiempo
       finalizar();//finaliza el juego cuando pierda todas las vidas
       cambio_salud();
       multiplicador();//calcula el multiplicador de puntaje
       
       Thread nuevoHilo1 = new Thread(E1);
       nuevoHilo1.start();
       
       Thread nuevoHilo2 = new Thread(E2);
       nuevoHilo2.start(); 
       
       Thread nuevoHilo3 = new Thread(E3);
       nuevoHilo3.start(); 
       
       Thread nuevoHilo4 = new Thread(E4);
       nuevoHilo4.start();
      
       Thread nuevoHilo5 = new Thread(E5);
       nuevoHilo5.start(); 
       
       //declaracion de variables para calculo de colision barra con figuras
       Rectangle rectangle_escudo = N.getBounds();
       Rectangle rectangle_shot = N.getBounds();
       Rectangle rectangle_enemigo1 = E1.getBounds();    
       Rectangle rectangle_enemigo2 = E2.getBounds();
       Rectangle rectangle_enemigo3 = E3.getBounds();
       Rectangle rectangle_enemigo4 = E4.getBounds();
       Rectangle rectangle_enemigo5= E5.getBounds();
      
       
       
       //colision laser con enemigo1
       for(int li = 0; li < lasers.size(); li++){
          
        shot l = lasers.get(li);
        if(l.getBounds().intersects(rectangle_enemigo1) && E1.control==false )
        {
         if(E1.control==false)
         { 
           //E1.control=true;  
              if(E1.imagen==E1.ayuda)
              {
                 efecto_error1.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                  
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             if(E1.imagen==E1.medicina)
             {
                 efecto_error1.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                   
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             
             if(E1.imagen==E1.ping)
             {    
             E1.imagen = E1.ping2;
             efecto1.efecto.play();
             
             
             }
             
             if(E1.imagen==E1.ayuda)
             {    
             E1.imagen = E1.ayuda_fin;
           
             }
             
             if(E1.imagen==E1.medicina)
             {    
             E1.imagen = E1.medicina_fin;
           
             }
             
             if(E1.imagen==E1.ping3 )
             {  
                cont1=cont1+1;
                if(E1.imagen==E1.ping3 && cont1==2)
                {
                cont1=0;    
                E1.imagen = E1.ping4;
              
                efecto1.efecto.play();
                }
             }
             
            
       
       
        ////segunda parte de la aguja
       
        if(E1.imagen==E1.ping2 )
        {
           subir=subir+1;
         if(subir==5)
         {
           if(pos_x2>=567 && pos_x2<607)
           {    
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2+2;
         
           }
           if(pos_x2<567)
           {
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2-2;  
           }  
           subir=0;
         }
           
           seguidas=seguidas+1;
        
       }
          //claculo del puntaje segun el multiplicador  
            if(multiplicador==1)   
            {    
            puntos = puntos+1;
            }
            if(multiplicador==2)   
            {    
            puntos = puntos+2;
            }
            if(multiplicador==3)   
            {    
            puntos = puntos+3;
            }
            if(multiplicador==4)   
            {    
            puntos = puntos+4;
            }
         E1.control=true;
         /*if(E1.imagen!=E1.ping3)
         {    
         efecto1.efecto.play();
         }*/
         }
         
        
          l.setVisible(false);
        }
       
       }//fin calculo laser con meteoro
       
       if(rectangle_shot.intersects(rectangle_enemigo1)==false && E1.control==true )
        {
          if(cont1==1)
          {
            E1.control=false;  
          }
        }
       
       if(rectangle_escudo.intersects(rectangle_enemigo1) && E1.controlN==false )//calculo de la nave al tocar un item 
         {
           
           if(E1.controlN==false)
           { 
               E1.controlN=true;
            if(E1.imagen==E1.ping)
             {
                efecto_error1.efecto_error.play();
               
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            if(E1.imagen==E1.ping3)
             {
                efecto_error1.efecto_error.play();
               
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            E1.controlN=true;
           
           
         
            if(E1.imagen==E1.ayuda && E1.controlT==false)
             {
               efecto_item1.efecto_item.play();
               E1.bool = true;
               E1.controlN = true;
               E1.control=true;
               puntos = puntos + 50;
               E1.controlT=true;
                     
            }
            if(E1.imagen==E1.medicina && E1.controlT==false)
             {
              efecto_item1.efecto_item.play();
               E1.bool = true;
               E1.controlN = true;
               E1.control=true;
               puntos = puntos + 50;
               E1.controlT=true;
                      
            }
             if(E1.imagen==E1.slow && E1.controlT==false)
             {
                 efecto_item1.efecto_item.play();
                E1.bool = true; 
                E1.controlN = true;
                 E1.control=true;
                slow=slow+1; 
                E1.controlT=true;
             }
             if(E1.imagen==E1.bomba && E1.controlT==false)
             {
                 efecto_item1.efecto_item.play();
                 E1.bool = true;
                E1.controlN = true;
                 E1.control=true;
                bombas=bombas+1; 
                E1.controlT=true;
             }
            
            E1.controlN=true;
           }
         
         }//fin calculo cuando nave toca un item
       
       if(rectangle_escudo.intersects(rectangle_enemigo1)==false && E1.controlN==true )//para volver a tocar un meteoro despues de dejar de tocarlo
         {
           E1.controlN=false;
       }
       
       
        if(E1.y>630 && E1.imagen==E1.ping)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error1.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
        
         }
         else
         {
           efecto_error1.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       }  
        
        if(E1.y>630 && E1.imagen==E1.ping3)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error1.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
        
         }
         else
         {
           efecto_error1.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       } 
                   
               
                
       
       //colision laser con enemigo2
       for(int li = 0; li < lasers.size(); li++){
          
                    shot l = lasers.get(li);
                    if(l.getBounds().intersects(rectangle_enemigo2) && E2.control==false)
        {
         if(E2.control==false)
         { 
           //E2.control=true;  
              if(E2.imagen==E2.ayuda)
             {
                 efecto_error2.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                   
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             if(E2.imagen==E2.medicina)
             {
                 efecto_error2.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    //vidas = vidas-1;
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             
              if(E2.imagen==E2.ping)
              {    
               E2.imagen = E2.ping2;
               efecto2.efecto.play();
              } 
             
            
             
             if(E2.imagen==E2.ayuda)
             {    
             E2.imagen = E2.ayuda_fin;
          
             }
              if(E2.imagen==E2.medicina)
             {    
             E2.imagen = E2.medicina_fin;
          
             }
              
              if(E2.imagen==E2.ping3 )
             {  
                cont2=cont2+1;
                if(E2.imagen==E2.ping3 && cont2==2)
                {  
                cont2=0;
                E2.imagen = E2.ping4;
                
                efecto2.efecto.play();
                }
             }
             
            
       
       
        ////segunda parte de la aguja
       
        if(E2.imagen==E2.ping2 )
       {
           subir=subir+1;
         if(subir==5)
         {
           if(pos_x2>=567 && pos_x2<607)
           {    
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2+2;
          
           }
           if(pos_x2<567)
           {
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2-2;  
           }  
           subir=0;
         }
           
           seguidas=seguidas+1;
        
       }
          //claculo del puntaje segun el multiplicador  
            if(multiplicador==1)   
            {    
            puntos = puntos+1;
            }
            if(multiplicador==2)   
            {    
            puntos = puntos+2;
            }
            if(multiplicador==3)   
            {    
            puntos = puntos+3;
            }
            if(multiplicador==4)   
            {    
            puntos = puntos+4;
            }
         E2.control=true;
      
         /*if(E2.imagen!=E2.ping3)
         {    
         efecto2.efecto.play();
         }*/
         }
         
         l.setVisible(false);
         
        }
       }
        if(rectangle_shot.intersects(rectangle_enemigo2)==false && E2.control==true )
        {
          if(cont2==1)
          {
            E2.control=false;  
          }
        }
       
       if(rectangle_escudo.intersects(rectangle_enemigo2) && E2.controlN==false )//calculo de la nave al tocar un item 
         {
           if(E2.controlN==false)
           {
                E2.controlN=true;
            if(E2.imagen==E2.ping)
             {
                efecto_error2.efecto_error.play();
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            if(E2.imagen==E2.ping3)
             {
                efecto_error2.efecto_error.play();
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            E2.controlN=true;
           
           
         
            if(E2.imagen==E2.ayuda && E2.controlT==false)
             {
              efecto_item2.efecto_item.play();
               E2.bool = true;
               E2.controlN = true;
               E2.control=true;
               puntos = puntos + 50;
               E2.controlT=true;
                 
            }
            if(E2.imagen==E2.medicina && E2.controlT==false)
             {
               efecto_item2.efecto_item.play();
               E2.bool = true;
               E2.controlN = true;
               E2.control=true;
               puntos = puntos + 50;
               E2.controlT=true;
                     
            }
            if(E2.imagen==E2.slow && E2.controlT==false)
             {
                 efecto_item2.efecto_item.play();
                 E2.bool = true;
                E2.controlN = true; 
                E2.control=true;
                slow=slow+1; 
                E2.controlT=true;
             }
             if(E2.imagen==E2.bomba && E2.controlT==false)
             {
                 efecto_item2.efecto_item.play();
                 E2.bool = true;
                E2.controlN = true;
                E2.control=true;
                bombas=bombas+1; 
                E2.controlT=true;
             }
           E2.controlN=true;
           }
         }
       
       if(rectangle_escudo.intersects(rectangle_enemigo2)==false && E2.controlN==true )//calculo de la nave al tocar un item 
         {
           E2.controlN=false;
       }
       
        if(E2.y>630 && E2.imagen==E2.ping)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error2.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
        
         }
         else
         {
           efecto_error2.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       } 
        if(E2.y>630 && E2.imagen==E2.ping3)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error2.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
        
         }
         else
         {
           efecto_error2.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       }
                   
               
                
       
       //colision laser con enemigo3
       for(int li = 0; li < lasers.size(); li++){
          
                    shot l = lasers.get(li);
                    if(l.getBounds().intersects(rectangle_enemigo3) && E3.control==false)
        {
         if(E3.control==false)
         { 
            //E3.control=true; 
              if(E3.imagen==E3.ayuda)
             {
                 efecto_error3.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             if(E3.imagen==E3.medicina)
             {
                 efecto_error3.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             
             if(E3.imagen==E3.ping)
              {    
              E3.imagen = E3.ping2;
              efecto3.efecto.play();
              }
             
             
             if(E3.imagen==E3.ayuda)
             {    
             E3.imagen = E3.ayuda_fin;
          
             }
              if(E3.imagen==E3.medicina)
             {    
             E3.imagen = E3.medicina_fin;
           
             }
              
              if(E3.imagen==E3.ping3 )
             {  
                cont3=cont3+1;
                if(E3.imagen==E3.ping3 && cont3==2)
                { 
                cont3=0;    
                E3.imagen = E3.ping4;
                efecto3.efecto.play();
                }
             } 
             
            
       
       
        ////segunda parte de la aguja
       
        if(E3.imagen==E3.ping2 )
       {
           subir=subir+1;
         if(subir==5)
         {
           if(pos_x2>=567 && pos_x2<607)
           {    
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2+2;
           
           }
           if(pos_x2<567)
           {
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2-2;  
           }  
           subir=0;
         }
           
           seguidas=seguidas+1;
        
       }
          //claculo del puntaje segun el multiplicador  
            if(multiplicador==1)   
            {    
            puntos = puntos+1;
            }
            if(multiplicador==2)   
            {    
            puntos = puntos+2;
            }
            if(multiplicador==3)   
            {    
            puntos = puntos+3;
            }
            if(multiplicador==4)   
            {    
            puntos = puntos+4;
            }
         E3.control=true;
       
        /* if(E3.imagen!=E3.ping3)
         {    
         efecto3.efecto.play();
         }*/
         }
        
        
          l.setVisible(false);
        }
       }
        if(rectangle_shot.intersects(rectangle_enemigo3)==false && E3.control==true )
        {
          if(cont3==1)
          {
            E3.control=false;  
          }
        }
       
       if(rectangle_escudo.intersects(rectangle_enemigo3) && E3.controlN==false )//calculo de la nave al tocar un item 
         {
           if(E3.controlN==false)
           {
               E3.controlN=true;
            if(E3.imagen==E3.ping)
             {
                efecto_error3.efecto_error.play();
                 
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                   
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            if(E3.imagen==E3.ping3)
             {
                efecto_error3.efecto_error.play();
                 
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                   
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            E3.controlN=true;
           
           
          
            if(E3.imagen==E3.ayuda && E3.controlT==false)
             {
               efecto_item3.efecto_item.play();
               E3.bool = true;
               E3.controlN = true;
               E3.control=true;
               puntos = puntos + 50;
               E3.controlT=true;
                   
            }
            if(E3.imagen==E3.medicina && E3.controlT==false)
             {
               efecto_item3.efecto_item.play();
               E3.bool = true;
               E3.controlN = true;
               E3.control=true;
               puntos = puntos + 50;
               E3.controlT=true;
                       
            }
            if(E3.imagen==E3.slow && E3.controlT==false)
             {
                 efecto_item3.efecto_item.play();
                 E3.bool = true;
                E3.controlN = true;
                E3.control=true;
                slow=slow+1; 
                E3.controlT=true;
             }
             if(E3.imagen==E3.bomba && E3.controlT==false)
             {
                 efecto_item3.efecto_item.play();
                 E3.bool = true;
                E3.controlN = true;
                E3.control=true;
                bombas=bombas+1; 
                E3.controlT=true;
             }
          E3.controlN=true;
           }
         }
       if(rectangle_escudo.intersects(rectangle_enemigo3)==false && E3.controlN==true )//calculo de la nave al tocar un item 
         {
           E3.controlN=false;
       }
       
        if(E3.y>630 && E3.imagen==E3.ping)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error3.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
         
         }
         else
         {
           efecto_error3.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       } 
        
        if(E3.y>630 && E3.imagen==E3.ping3)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error3.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
         
         }
         else
         {
           efecto_error3.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       }  
                  
               
                
       
       //colision laser con enemigo4
       for(int li = 0; li < lasers.size(); li++){
          
                    shot l = lasers.get(li);
                    if(l.getBounds().intersects(rectangle_enemigo4) && E4.control==false)
        {
         if(E4.control==false)
         { 
           //E4.control=true;  
              if(E4.imagen==E4.ayuda)
             {
                 efecto_error4.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             if(E4.imagen==E4.medicina)
             {
                 efecto_error4.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
             
             if(E4.imagen==E4.ping)
             {    
             E4.imagen = E4.ping2;
             efecto4.efecto.play();
             }
             
             if(E4.imagen==E4.ayuda)
             {    
             E4.imagen = E4.ayuda_fin;
           
             }
              if(E4.imagen==E4.medicina)
             {    
             E4.imagen = E4.medicina_fin;
           
             }
              
              if(E4.imagen==E4.ping3 )
             {  
                cont4=cont4+1; 
                if(E4.imagen==E4.ping3 && cont4==2)
                { 
                cont4=0;    
                E4.imagen = E4.ping4;
                efecto4.efecto.play();
                }
             }
             
            
       
       
        ////segunda parte de la aguja
       
        if(E4.imagen==E4.ping2 )
       {
           subir=subir+1;
         if(subir==5)
         {
           if(pos_x2>=567 && pos_x2<607)
           {    
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2+2;
          
           }
           if(pos_x2<567)
           {
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2-2;  
           }  
           subir=0;
         }
           
           seguidas=seguidas+1;
        
       }
          //claculo del puntaje segun el multiplicador  
            if(multiplicador==1)   
            {    
            puntos = puntos+1;
            }
            if(multiplicador==2)   
            {    
            puntos = puntos+2;
            }
            if(multiplicador==3)   
            {    
            puntos = puntos+3;
            }
            if(multiplicador==4)   
            {    
            puntos = puntos+4;
            }
         E4.control=true;
      
         /*if(E4.imagen!=E4.ping3)
         {    
         efecto4.efecto.play();
         }*/
         }
         
        
          l.setVisible(false);
        }
       }
        if(rectangle_shot.intersects(rectangle_enemigo4)==false && E4.control==true )
        {
          if(cont4==1)
          {
            E4.control=false;  
          }
        }
       
       if(rectangle_escudo.intersects(rectangle_enemigo4) && E4.controlN==false )//calculo de la nave al tocar un item 
         {
           if(E4.controlN==false)
           {
               E4.controlN=true;
            if(E4.imagen==E4.ping)
             {
                efecto_error4.efecto_error.play();
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            if(E4.imagen==E4.ping3)
             {
                efecto_error4.efecto_error.play();
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            E4.controlN=true;
           
           
        
            if(E4.imagen==E4.ayuda && E4.controlT==false)
             {
               efecto_item4.efecto_item.play();
               E4.bool = true;
               E4.controlN = true;
               E4.control=true;
               puntos = puntos + 50;
               E4.controlT=true;
                    
            }
            if(E4.imagen==E4.medicina && E4.controlT==false)
             {
               efecto_item4.efecto_item.play();
               E4.bool = true;
               E4.controlN = true;
               E4.control=true;
               puntos = puntos + 50;
               E4.controlT=true;
                      
            }
            if(E4.imagen==E4.slow && E4.controlT==false)
             {
                 efecto_item4.efecto_item.play();
                E4.bool = true; 
                E4.controlN = true; 
                E4.control=true;
                slow=slow+1; 
                E4.controlT=true;
             }
             if(E4.imagen==E4.bomba && E4.controlT==false)
             {
                 efecto_item4.efecto_item.play();
                 E4.bool = true;
                E1.controlN = true;
                E4.control=true;
                bombas=bombas+1;
                E4.controlT=true;
             }
          E4.controlN=true;
           }
         }
        if(rectangle_escudo.intersects(rectangle_enemigo4)==false && E4.controlN==true )//calculo de la nave al tocar un item 
         {
           E4.controlN=false;
       }
       
        if(E4.y>630 && E4.imagen==E4.ping)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error4.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
         
         }
         else
         {
           efecto_error4.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       }
        
        if(E4.y>630 && E4.imagen==E4.ping3)
       {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error4.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
         
         }
         else
         {
           efecto_error4.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       } 
              
               
                
       
       //colision laser con enemigo5
       for(int li = 0; li < lasers.size(); li++){
          
                    shot l = lasers.get(li);
                    if(l.getBounds().intersects(rectangle_enemigo5) && E5.control==false)
        {
         if(E5.control==false)
         { 
           //E5.control=true;  
              if(E5.imagen==E5.ayuda)
             {
                 efecto_error5.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
            
              if(E5.imagen==E5.medicina)
             {
                 efecto_error5.efecto_error.play();
                 if(multiplicador==1)   
                 {    
                 puntos = puntos-1;
                 }
                 if(multiplicador==2)   
                 {    
                 puntos = puntos-2;
                 }
                 if(multiplicador==3)   
                 {    
                 puntos = puntos-3;
                }
                if(multiplicador==4)   
                {    
                puntos = puntos-4;
                }
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                   
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0;
             }
              
             if(E5.imagen==E5.ping)
              {    
               E5.imagen = E5.ping2;
               efecto5.efecto.play();
              }       
             
             
             if(E5.imagen==E5.ayuda)
             {    
             E5.imagen = E5.ayuda_fin;
            
             }
             
             if(E5.imagen==E5.medicina)
             {    
             E5.imagen = E5.medicina_fin;
            
             }
             
             if(E5.imagen==E5.ping3 )
             {  
                cont5=cont5+1; 
                if(E5.imagen==E5.ping3 && cont5==2)
                {
                cont5=0;    
                E5.imagen = E5.ping4;
                efecto5.efecto.play();
                }
             }
             
            
       
       
        ////segunda parte de la aguja
       
        if(E5.imagen==E5.ping2 )
       {
           subir=subir+1;
         if(subir==5)
         {
           if(pos_x2>=567 && pos_x2<607)
           {    
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2+2;
           
           }
           if(pos_x2<567)
           {
           pos_x2 = pos_x2+4;
           pos_y2 = pos_y2-2;  
           }  
           subir=0;
         }
           
           seguidas=seguidas+1;
        
       }
          //claculo del puntaje segun el multiplicador  
            if(multiplicador==1)   
            {    
            puntos = puntos+1;
            }
            if(multiplicador==2)   
            {    
            puntos = puntos+2;
            }
            if(multiplicador==3)   
            {    
            puntos = puntos+3;
            }
            if(multiplicador==4)   
            {    
            puntos = puntos+4;
            }
         E5.control=true;
       
         /*if(E5.imagen!=E5.ping3)
         {    
         efecto5.efecto.play();
         }*/
         }
        
        
          l.setVisible(false);
        }
       }
       
        if(rectangle_shot.intersects(rectangle_enemigo5)==false && E5.control==true )
        {
          if(cont5==1)
          {
            E5.control=false;  
          }
        }
       
       if(rectangle_escudo.intersects(rectangle_enemigo5) && E5.controlN==false )//calculo de la nave al tocar un item 
         {
           if(E5.controlN==false)
           {
            E5.controlN=true;
            if(E5.imagen==E5.ping)
             {
                efecto_error5.efecto_error.play();
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            if(E5.imagen==E5.ping3)
             {
                efecto_error5.efecto_error.play();
                
                if(pos_x2<=567)
                   {     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2+2;
                    
                   }
                   else
                   {
                     
                     pos_x2 = pos_x2-4;
                     pos_y2 = pos_y2-2;   
                    }
                 seguidas=0;
                 subir=0; 
             }
            
           E5.controlN=true;
           
          
            if(E5.imagen==E5.ayuda && E5.controlT==false)
             {
               efecto_item5.efecto_item.play();
               E5.bool = true;
               E5.controlN = true;
               E5.control=true;
               puntos = puntos + 50;
               E5.controlT=true;
                       
            }
            if(E5.imagen==E5.medicina && E5.controlT==false)
             {
               efecto_item5.efecto_item.play();
               E5.bool = true;
               E5.controlN = true;
               E5.control=true;
               puntos = puntos + 50;
               E5.controlT=true;
                         
            }
            if(E5.imagen==E1.slow && E5.controlT==false)
             {
                 efecto_item5.efecto_item.play();
                 E5.bool = true;
                E5.controlN = true;
                E5.control=true;
                slow=slow+1; 
                E5.controlT=true;
             }
             if(E5.imagen==E5.bomba && E5.controlT==false)
             {
                 efecto_item5.efecto_item.play();
                 E5.bool = true;
                E5.controlN = true;//evita que cuente varias veces cuando esta encima
                E5.control=true;
                bombas=bombas+1; 
                E5.controlT=true;//evita que toque varias veces estando invisible
             }
            E5.controlN=true;
           }
        }
       
       if(rectangle_escudo.intersects(rectangle_enemigo5)==false && E5.controlN==true )//calculo de la nave al tocar un item 
         {
           E5.controlN=false;
       }
       
        if(E5.y>630 && E5.imagen==E5.ping)
        {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error5.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
         
         }
         else
         {
           efecto_error5.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       }  
       
         if(E5.y>630 && E5.imagen==E5.ping3)
        {
           subir=0;
           seguidas=0;
         if(pos_x2<=567)
         {    
         efecto_error5.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2+2;
         
         }
         else
         {
           efecto_error5.efecto_error.play();
         pos_x2 = pos_x2-4;
         pos_y2 = pos_y2-2;   
         }
       }
                   
               
                
       
      
       
      repaint();
      } 
 
     public Image get_image(){
        return imagen;
    }
     
     public void multiplicador(){
         if (seguidas==0)
         {
           multiplicador=1;  
         }
         if(seguidas==10)
         {  
           multiplicador=2;
         }
         if(seguidas==20)
         {
           multiplicador=3;
         }
         if(seguidas==30)
         {
           multiplicador=4;
         }
         
     }
      
     public void finalizar(){
         if (pos_x2<531)
         {
         ended=true;
         audi.sonido.stop();
         
         audi_pear = new audio();
         audi_pear.sonido_pear.loop();
         timer.stop();
     do
     {
     nombre = JOptionPane.showInputDialog( "Ingrese su nombre","unknow" ); //ingresa el nombre    
     }while((nombre==null) || (nombre=="")) ;  
     guardar();//guarda el nombre y puntuacion en el archivo
     
     nombre = "";
     puntos = 0;
     do
     {   
      int seleccion = JOptionPane.showOptionDialog(
      null,
      "Seleccione opcion", 
      "Selector de opciones",
      JOptionPane.YES_NO_CANCEL_OPTION,
      JOptionPane.QUESTION_MESSAGE,
      unIcono,    // null para icono por defecto.
      new Object[] { "Jugar", "Posiciones", "Salir" },   // null para YES, NO y CANCEL
      "opcion 1");
 
   if (seleccion == 0)
    {
       reiniciar();
       R=true;
    }
   if (seleccion == 1)
    {
       
       ordenar();
       tabla();
       //new puntuacion();
  
    }
   if (seleccion == 2)
    {
        System.exit(0);
    }
     }while(R==false);
     R=false;
   
     
     }
     }
     
public void guardar(){


int aux_clave = 0; 
String aux_nom = "";
int aux_puntaje = 0;

long tregistro=58;
long cregistros=0;
//nombre = "";

//puntos = 0;

// creando objeto teclado

BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

// abriendo archivo, capturando y grabando datos

try {

//* Creando y grabando a un archivo, esta larga la instrucci처n*/

File arch=new File("puntuacion.dat");

RandomAccessFile archivo=new RandomAccessFile(arch,"rw");

clave = 0;
//dejando string en 25 caracteres

if (nombre.length() < 25)

{ 
    for(int i=nombre.length(); i <25; i++)
      nombre=nombre+" ";
}

else
  { 
      nombre=nombre.substring(0,25); 
  }


  
if (archivo.length()!= 0)
     {
         archivo.seek( archivo.length() );
     }

archivo.writeInt(clave);

// y recordar que cada caracter se graba en dos bytes

archivo.writeChars(nombre);

archivo.writeInt(puntos);



archivo.close();

  }


catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }

catch (IOException ioe) { /* Error al escribir */ }





     }

public void ordenar(){
    
    
    int clave=1;
    puntos=0;
    nombre="";
    int aux_clave = 0; 
    String aux_nom ="";
    int aux_puntaje = 0;
    //boolean aux_control17;
    long tregistro=58;
    long cregistros=0;
    
    
    int pos=0;
    try {

//* Creando y leyendo archivo, esta larga la instrucci처n*/

      File arch=new File("puntuacion.dat");

      RandomAccessFile archivo=new RandomAccessFile(arch,"rw");
      
      cregistros=archivo.length()/tregistro;

      
    }
    catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }

    catch (IOException ioe) { /* Error al escribir */ }
    
}
     
 public void tabla(){
         
//lectura de registros
// creando e inicializando los campos del registro

// observar que se debe usar clases numericas apropiadas
 
  
 int aux_clave = 0; 
 String aux_nom="" ;
 int aux_puntaje = 0;
 int x1=0;
 clave=0;

 nombre="";

 puntos=0;
 
 

//recordar que un caracter son dos bytes en archivo

long tregistro=58;

long cregistros=0;
 int lim=0;
// creando objeto teclado



// abriendo archivo, capturando y grabando datos

try {

//* Creando y leyendo archivo, esta larga la instrucci처n*/

File arch=new File("puntuacion.dat");

RandomAccessFile archivo=new RandomAccessFile(arch,"rw");

File arch_ordenado=new File("archivo_ordenado.dat");
RandomAccessFile archivo1=new RandomAccessFile(arch_ordenado,"rw"); 

//calulando cantidad de registros

cregistros=archivo.length()/tregistro;
lim=(int)cregistros;

for (int r=0; r < cregistros; r++)

{

clave=archivo.readInt();

//leyendo string

for(int i = 0; i < 25; ++i)

{
    nombre += archivo.readChar(); 
}

puntos=archivo.readInt();


// limpiar strings o java encadena con la siguiente
          posi[r]=clave;
          nom[r]=nombre;
          pun[r]=puntos;
nombre="";

}
archivo.close();

//comienzo muestra del archivo ordenado
clave=0;

 nombre="";

 puntos=0;
cregistros=archivo1.length()/tregistro;

//ordenamiento de los array con los datos del archivo
for (int a=0; a <lim-1 ; a++)
  {
     for (int b=0; b <(lim-1)-a ; b++)
       {
           if(pun[b]<pun[b+1])
             {
               aux_clave=posi[b];
               posi[b]=posi[b+1];
               posi[b+1]=aux_clave;
               
               aux_nom=nom[b];
               nom[b]=nom[b+1];
               nom[b+1]=aux_nom;
               
               aux_puntaje=pun[b];
               pun[b]=pun[b+1];
               pun[b+1]=aux_puntaje;

             }
      
       }
  }



//paso valores de array a el array de string para mostrarlo
for (int s=0; s <10 ; s++)
  {
      x1=x1+1;
      cadena[s]= x1+"�   "+nom[s]+ "   "+pun[s];
  }

JList list = new JList(cadena);

JOptionPane.showMessageDialog(null,list);
archivo1.close();

arch_ordenado.delete();
}
catch(FileNotFoundException fnfe) { /* Archivo no encontrado */ }

catch (IOException ioe) { /* Error al escribir */ }
}
     
     public void reiniciar(){
         controlB=false;
         audi_pear.sonido_pear.stop();
                    audi.sonido.loop();
                   
                    puntos=0;
                    N = new Nave();  //constructor
                    E1 = new enemigo1(); 
                    E2 = new enemigo2();
                    E3 = new enemigo3();
                    E4 = new enemigo4();
                    E5 = new enemigo5();
                    pos_x1=567;
                    pos_y1=618;
                    pos_x2=567;
                    pos_y2=575;
                    imagen=barra_amarillo;
                    timer.start();  
     }
     
     public void cambio_salud(){
         if(pos_x2<552)
         {
             imagen = barra_rojo;
         }
          if(pos_x2>588)
         {
             imagen = barra_verde;
         }
          if(pos_x2<588 && pos_x2>552)
         {
             imagen = barra_amarillo;
         }
     }
         
    
     private class TAdapter extends KeyAdapter{//clase privada que codifica los movimientos
         public void keyPressed(KeyEvent e){
           
           N.keyPressed(e);  
           Pressed(e);
          
    }
         public void keyReleased(KeyEvent e){
           N.keyReleased(e);  
           Released(e);
        }
        
     }
     
     public void Pressed(KeyEvent e){
        key = e.getKeyCode();
        if(key == KeyEvent.VK_ENTER)
         {
             timer.stop();
         }
        if(key == KeyEvent.VK_ESCAPE)
         {
             timer.start();
         }
        if(key == KeyEvent.VK_A && B==false)
         {
           if(bombas>0)
           {   
            if(E1.imagen==E1.ping) 
            {
               E1.imagen=E1.ping2;
              
               E1.control=true;
            }
            if(E2.imagen==E2.ping) 
            {
               E2.imagen=E2.ping2;
              
               E2.control=true;
            }
            if(E3.imagen==E3.ping) 
            {
               E3.imagen=E3.ping2;
             
               E3.control=true;
            }
            if(E4.imagen==E4.ping) 
            {
               E4.imagen=E4.ping2;
           
               E4.control=true;
            }
            if(E5.imagen==E5.ping) 
            {
               E5.imagen=E5.ping2;
          
               E5.control=true;
            }
            //explosion para meteoro grande
            if(E1.imagen==E1.ping3) 
            {
               E1.imagen=E1.ping4;
              
               E1.control=true;
            }
            if(E2.imagen==E2.ping3) 
            {
               E2.imagen=E2.ping4;
              
               E2.control=true;
            }
            if(E3.imagen==E3.ping3) 
            {
               E3.imagen=E3.ping4;
             
               E3.control=true;
            }
            if(E4.imagen==E4.ping3) 
            {
               E4.imagen=E4.ping4;
           
               E4.control=true;
            }
            if(E5.imagen==E5.ping3) 
            {
               E5.imagen=E5.ping4;
          
               E5.control=true;
            }
             bombas=bombas-1;
           efecto_boom.efecto_boom.play();  
           } 
            B=true;
            
          }
         if(key == KeyEvent.VK_S && S==false)
          {
           if(slow>0)
           {
             slow=slow-1;  
             E1.SPEED=E1.SPEED-0.2;
             E2.SPEED=E2.SPEED-0.2;
             E3.SPEED=E3.SPEED-0.2;
             E4.SPEED=E4.SPEED-0.2;
             E5.SPEED=E5.SPEED-0.2; 
             E1.cont=0;
             E2.cont=0;
             E3.cont=0;
             E4.cont=0;
             E5.cont=0;   
           }
           S=true;
          }
     }
     public void Released(KeyEvent e){
        key = e.getKeyCode();
        if(key == KeyEvent.VK_A)
          {
            B=false;
          }
        if(key == KeyEvent.VK_S)
          {
            S=false;
          }
         
     }  
     
     class TMotionAdapter extends MouseMotionAdapter {
        public void mouseMoved( MouseEvent evt ) {
        // Guarda la posici처n durante el movimiento del rat처n
           N.mouseMoved(evt);
          
        }
        

}
     
     class TMotion extends MouseAdapter {
     
        public void mousePressed( MouseEvent evt ) {
        // Guarda la posici처n durante el movimiento del rat처n
           N.mousePressed(evt);  
        }
        public void mouseReleased( MouseEvent evt ) {
        // Guarda la posici처n durante el movimiento del rat처n
           N.mouseReleased(evt);  
        }

}
     
         
      
      public void cambiar_sprite(){
          E1.imagen = E1.ping2;
      }
      
      public void velocidad(){
       contador = E1.cont+E2.cont+E3.cont+E4.cont+E5.cont;   
       if(contador==10)
       {
          E1.SPEED=E1.SPEED+0.2;
          E2.SPEED=E2.SPEED+0.2;
           E3.SPEED=E3.SPEED+0.2;
            E4.SPEED=E4.SPEED+0.2;
             E5.SPEED=E5.SPEED+0.2; 
             E1.cont=0;
             E2.cont=0;
             E3.cont=0;
             E4.cont=0;
             E5.cont=0;
       }
      
      }
      
      
}
