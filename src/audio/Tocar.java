package audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tocar {
    static String bip;
    static MediaPlayer mediaPlayer;
    

    private static void rodar(String bip){
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    
    public static void tocar(String file) {
        if(bip == null){
            bip = file;
            rodar(bip);
        }
        else if(!file.equals(bip)){
            mediaPlayer.dispose();
            rodar(file);
        }
        else{
            mediaPlayer.dispose();
            rodar(bip);
        }
    }

    public void pausar(MediaPlayer mediaPlayer) {
        double volume = 1.0;
        for (int x = 0; x < 10; x++) {
            mediaPlayer.setVolume(volume);
            volume -= 0.1;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tocar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mediaPlayer.pause();
        mediaPlayer.setVolume(1.0);
    }

}
