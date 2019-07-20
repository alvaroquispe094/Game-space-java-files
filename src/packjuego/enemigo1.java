/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packjuego;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Master
 */
public class enemigo1 extends Thread {
    public double SPEED = 2; 
    public int x;
    public int y;
    public int cont=0;
    boolean linea = false;
    boolean bool = false;
    boolean tocada;
    boolean forma=true;
    boolean pulsada=false;
    Image cuadrado;
    Image circulo;
    Image rectangulo;
    Image rombo;
    Image triangulo;
    Image ping;
    Image ping2;
    Image imagen;
    public int puntos;
    public boolean control;
    public boolean controlN=false;
    public boolean controlT=false;
    Image ayuda;
    Image ayuda_fin;
    Image medicina;
    Image medicina_fin;
    Image ping3;
    Image ping4;
    Image bomba;
    Image slow;
    
 
    
    
    
    public enemigo1(){
        
        ImageIcon l6 = new ImageIcon(this.getClass().getResource("imagen/meteoro.png"));
        ping = l6.getImage();
        ImageIcon l7 = new ImageIcon(this.getClass().getResource("imagen/meteoro_fin.png"));
        ping2 = l7.getImage();
        ImageIcon l8 = new ImageIcon(this.getClass().getResource("imagen/ayuda.png"));
        ayuda = l8.getImage();
        ImageIcon l9 = new ImageIcon(this.getClass().getResource("imagen/ayuda_fin.png"));
        ayuda_fin = l9.getImage();
        ImageIcon l10 = new ImageIcon(this.getClass().getResource("imagen/medicina.png"));
        medicina = l10.getImage();
        ImageIcon l11 = new ImageIcon(this.getClass().getResource("imagen/medicina_fin.png"));
        medicina_fin = l11.getImage();
        ImageIcon l12 = new ImageIcon(this.getClass().getResource("imagen/meteoro2.png"));
        ping3 = l12.getImage();
        ImageIcon l13 = new ImageIcon(this.getClass().getResource("imagen/meteoro2_fin.png"));
        ping4 = l13.getImage();
        ImageIcon l14 = new ImageIcon(this.getClass().getResource("imagen/bomba.png"));
        bomba = l14.getImage();
        ImageIcon l15 = new ImageIcon(this.getClass().getResource("imagen/slow.png"));
        slow = l15.getImage();
       
        ayuda_fin = l9.getImage();
        imagen = ping;
        x=20;
        y=-63;
        cont=0;
        
    }
    
    public void run(){ 

         if (y<= 630)
        {   
         y += SPEED; 
         
        }
        else
        {
         
      linea=true; 
         controlT=false;
         control=false;//cotrol cuando el circulo llega hasta el borde inferior
         imagen = ping;
         y=0;
         cont = cont+1;
         bool=false;
         random();
         
        } 
    }
    
     public void keyPressed(KeyEvent e){
    
        int key = e.getKeyCode();
    
        if(key == KeyEvent.VK_SPACE)
            //puntos = puntos+1;
            pulsada=true;
    }
  

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE)
            pulsada=false;
        
        
       
    }
    public void random(){
      int T = (int) (Math.random() * 20);
        if(T==5)
        {
         imagen=ayuda; 
        }
        if(T==2)
        {
         imagen=ping3; 
        }
        if(T==15)
        {
         imagen=medicina; 
        }
      random_item();
    }
    public void random_item(){
        int x = (int) (Math.random() * 30);
        if(x==7)
        {
         imagen=bomba; 
         control=true;
        }
        if(x==13)
        {
         imagen=slow; 
         control=true;
        }
       
    }
    
    
    public int GetX(){
       if (linea==true)
       { 
        linea=false;   
        int z = (int) (Math.random() * 6);
        if(z==1)
        {
         x=20;   
        }
        if(z==2)
        {
         x=120;   
        }
        if(z==3)
        {
         x=220;   
        }
        if(z==4)
        {
         x=320;   
        }
        if(z==5)
        {
         x=420;   
        }
        
       }
      
        return x;
    }

    public int GetY(){
        return y;
    }
    
   
    public Image get_image(){
        return imagen;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, imagen.getWidth(null), imagen.getHeight(null));
    }
    
}
