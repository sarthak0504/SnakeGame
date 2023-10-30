import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound  {

    public Sound() {

                playButtonClickSound();
    }

    public void playButtonClickSound() {
        try {
            String soundFile = "wave/clicked.wav"; // Path to the sound file

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(Sound.class.getResource(soundFile));
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
    }
}

}