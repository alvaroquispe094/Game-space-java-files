/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packjuego;

import javax.swing.JFrame;
/**
 *
 * @author Master
 */
public class MainPrincipal extends JFrame{ 
    private static String nombre;
    private boolean B=true;
    private audio audi_pear;
    private int key;
    
    
    
    public MainPrincipal()  {
      
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
     Escena E = new Escena();
     
     add(E);
     setTitle("Mover Sprites");
     setSize(645, 718);
     setLocationRelativeTo(null);
     //setVisible(true);
     setResizable(false);
    }
 

}   
   

