package audio;

import java.awt.event.ActionEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.util.Duration;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class Player {
    private String bip;
    private MediaPlayer mediaPlayer;
    Duration currentTime;
    Duration duration;
    
    public void atulizarBarra(Duration duration, int atualizacao)
    {
        mediaPlayer.seek(duration.multiply((double) (atualizacao / 100.0)));
    }
    private String formatTime(Duration elapsed, Duration duration) {
        int intElapsed = (int) Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        if (elapsedHours > 0) {
            intElapsed -= elapsedHours * 60 * 60;
        }
        int elapsedMinutes = intElapsed / 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60
                - elapsedMinutes * 60;

        if (duration.greaterThan(Duration.ZERO)) {
            int intDuration = (int) Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            if (durationHours > 0) {
                intDuration -= durationHours * 60 * 60;
            }
            int durationMinutes = intDuration / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60
                    - durationMinutes * 60;
            if (durationHours > 0) {
                return String.format("%d:%02d:%02d/%d:%02d:%02d",
                        elapsedHours, elapsedMinutes, elapsedSeconds,
                        durationHours, durationMinutes, durationSeconds);
            } else {
                return String.format("%02d:%02d/%02d:%02d",
                        elapsedMinutes, elapsedSeconds, durationMinutes,
                        durationSeconds);
            }
        } else {
            if (elapsedHours > 0) {
                return String.format("%d:%02d:%02d", elapsedHours,
                        elapsedMinutes, elapsedSeconds);
            } else {
                return String.format("%02d:%02d", elapsedMinutes,
                        elapsedSeconds);
            }
        }
    }
    public void barraCorrer(Duration currentTime, Duration duration, JLabel jLabel1, JSlider jSlider1){

                mediaPlayer.currentTimeProperty().addListener((ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) -> {
                    currentTime = mediaPlayer.getCurrentTime();
                    duration = mediaPlayer.getTotalDuration();
                    jLabel1.setText(formatTime(currentTime, duration));
                    jSlider1.setValue((int) (currentTime.divide(duration).toMillis() * 100));

                });
            
       
    }
    
    private void rodar(String bip){
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
    
    public void tocarMusica(String file) {
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
    public void tocarVinheta(String file) {
        rodar(file);
    }

    public void pausar(MediaPlayer mediaPlayer) {
        double volume = 1.0;
        for (int x = 0; x < 10; x++) {
            mediaPlayer.setVolume(volume);
            volume -= 0.1;
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        mediaPlayer.pause();
        mediaPlayer.setVolume(1.0);
    }

}
