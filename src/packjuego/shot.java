/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packjuego;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Master
 */
public class shot {
    
    protected Image image;
    protected int x,y;
    private final int SPEED = 20        ;
    private boolean visible;

    public shot(int x, int y){
        ImageIcon ii = new ImageIcon(this.getClass().getResource("imagen/boom2.png"));
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public Image getImagen(){
        return image;
    }


    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }

    public boolean isVisible(){
        return visible;
    }

    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
     public void update(){
        y -= SPEED;
        if(y<0)
            visible = false;
        
    }
    
}
