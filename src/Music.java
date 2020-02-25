import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music {

    private static Clip clip;

    //opens .wav file and and playing music while playing
    public Music() {
        try {
            String fileName = "Music.wav";
            AudioInputStream sound = AudioSystem.getAudioInputStream(this.getClass().getResource(fileName));
            clip = AudioSystem.getClip();
            clip.open(sound);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //starts the music
    public static void play() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    //stops the music
    public static void stop() {
        clip.stop();
    }

}
