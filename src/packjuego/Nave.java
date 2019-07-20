/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packjuego;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author Master
 */
public class Nave {
    public Image image;
    public int max;
    public int min;
    public int dx;
    public int dy;
    public int x;
    public int y;
    private ArrayList lasers;//define el array
    private final audio efecto_laser;
    public final int SPEED = 10;
    private int mouse_mov;
    private int mouse_X;
    private int mouse_Y;
    public boolean click = false;
    boolean romper = false;
    public int key;
    public boolean pulsacion=false;
    public boolean shot;
    
    Image nave;
    Image nave_fin;
    
    public Nave(){
      ImageIcon image_icon = new ImageIcon(this.getClass().getResource("imagen/nave.png"));
      nave = image_icon.getImage();
      ImageIcon l15 = new ImageIcon(this.getClass().getResource("imagen/nave_fin.png"));
      nave_fin = l15.getImage();
      image=nave;
      lasers = new ArrayList();//crea el array
      shot = true;
      efecto_laser = new audio();
      x=10;
      y=600;
      min=40;
      max=457;
    }
    
    public void logic(){ // Toda la logica la pondre aca
        if((x>0 && dx<0) || (x<585 && dx>0))
            x += dx;
        if((y>0 && dy<0) || (y<415 && dy>0))
            y += dy;
    }
    
    
    
  public void mouseMoved( MouseEvent evt ) {
        mouse_X = evt.getX()-23;
        mouse_Y = evt.getY()-35;
        
        if(mouse_X>max)
        {
          x=max;  
        }
        else
         {
             y = mouse_Y;
             x = mouse_X;
         }
        
       click = false;
             
  }
  
  
  
  public void mousePressed( MouseEvent evt ) {
      
       click = true;
      
     
            
  } 
   public void mouseReleased( MouseEvent evt ) {
       
       click = false;
                
  }
 
  public void keyPressed(KeyEvent e){
    
         key = e.getKeyCode();
    
        if(key == KeyEvent.VK_RIGHT) 
          dx = SPEED ;  
        if(key == KeyEvent.VK_LEFT)
          dx =  SPEED * -1;
        if(key == KeyEvent.VK_DOWN)
          dy = SPEED ;
        if(key == KeyEvent.VK_UP)
          dy = SPEED * -1;
       
        if(key == KeyEvent.VK_SPACE && shot==true)
        {
            lasers.add(new shot(x + image.getWidth(null)/2, y));
            shot = false;
            efecto_laser.efecto_laser.stop();
            efecto_laser.efecto_laser.play();
        }
       
    }
  

    public void keyReleased(KeyEvent e){
         key = e.getKeyCode();

        if(key == KeyEvent.VK_LEFT && dx < 0)
            dx = 0;
        if(key == KeyEvent.VK_RIGHT && dx > 0)
           dx = 0;
        if(key == KeyEvent.VK_UP && dy < 0)
           dy = 0;
        if(key == KeyEvent.VK_DOWN && dy > 0)
            dy = 0;
        if(key == KeyEvent.VK_SPACE)
            shot = true;
    } 
   
    public ArrayList getLasers(){
        return lasers;
    }
    
    public Image getImage(){
      return image;
    }
    
   public int getX(){
     return x;
   }
   public int getY(){
     return y;
   }
   
   public Rectangle getBounds(){
      return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
      
    }
    
}
