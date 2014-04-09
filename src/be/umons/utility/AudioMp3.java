package be.umons.utility;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioMp3 {
	public void playSound() {
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(AudioMp3.class.getResource("Olympian.flac"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace();
		}
	}
}