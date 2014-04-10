/**
 ****************************************************
 * @author     : AGOZZINO Terencio - PIZZIRUSSO Loris
 * @email      : agozzino.pizzirusso@gmail.com
 * @file       : AudioMp3.java
 * @date       : 15 May 2014
 * @project    : BoxOfGames
 *****************************************************
 */

package be.umons.utility;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * <b> AudioMp3 is the class that permit to play a soundtrack. </b>
 * 
 * @author AGOZZINO Terencio - PIZZIRUSSO Loris
 */

public class AudioMp3 {

	// NOTE: This method don't working. 

	public void playSound(String soundName) {
		try  {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile( ));
			Clip clip = AudioSystem.getClip( );
			clip.open(audioInputStream);
			clip.start( );
		} catch(Exception ex) {
			System.out.println("Error with playing sound.");
			ex.printStackTrace( );
		}
	}
}