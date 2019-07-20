/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packjuego;

import java.applet.AudioClip;
import java.io.*;
import sun.audio.*;
/**
 *
 * @author Master
 */
public class audio {
    public AudioClip sonido;
    public AudioClip sonido_pear;
    public AudioClip efecto;
    public AudioClip efecto_error;
    public AudioClip efecto_item;
    public AudioClip efecto_boom;
    public AudioClip efecto_laser;
   
    
    public audio(){
        /*String sonido = "C:/users/master/desktop/audio.Wav";
        
        ImputStream in = new FileImputStream(sonido);
        AudioStream audio = new AudioStream(in);
        AudioPlayer.player.start(audio);
        **/
       //AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("sonido/audio.wav"));
        sonido_pear = java.applet.Applet.newAudioClip(getClass().getResource("sonido/papapear.wav"));
        efecto = java.applet.Applet.newAudioClip(getClass().getResource("sonido/bien.wav"));
        efecto_error = java.applet.Applet.newAudioClip(getClass().getResource("sonido/error.wav"));
        efecto_laser = java.applet.Applet.newAudioClip(getClass().getResource("sonido/laser.wav"));
        efecto_item = java.applet.Applet.newAudioClip(getClass().getResource("sonido/item.wav"));
        efecto_boom = java.applet.Applet.newAudioClip(getClass().getResource("sonido/explosion.wav"));
       
    }
    
    
}
