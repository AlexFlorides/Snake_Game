import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class EatSound {

    private static Clip clip;

    //opens .wav file and and playing sound when called
    public EatSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("eat.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //plays the sound
    public static void play() {
        clip.start();
    }

    //stops the sounds from playing
    public static void stop() {
        clip.stop();
        clip.close();
    }
}
