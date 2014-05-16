/**
 **************************************************
 * @author     : AGOZZINO Terencio 
 * @email      : agozzino.terencio@gmail.com
 * @file       : Sound.java
 * @date       : 16 May 2014
 * @project    : BoxOfGames
 ***************************************************
 */

package be.umons.utility;

import javazoom.jl.player.advanced.*;
import java.io.*;

/**
 * This class is from "agent24". 
 * 
 * <b> Link: </b> http://fr.openclassrooms.com/forum/sujet/
 * 					comment-utiliser-la-librairie-jlayer-75459
 */

public class Sound {
	public Sound(String path) throws Exception {
		InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
		player = new AdvancedPlayer(in);
	}

	public Sound(String path,PlaybackListener listener) throws Exception {
		InputStream in = (InputStream)new BufferedInputStream(new FileInputStream(new File(path)));
		player = new AdvancedPlayer(in);
		player.setPlayBackListener(listener);
	}

	public void play() throws Exception {
		if (player != null) {
			isPlaying = true;
			player.play();
		}
	}

	public void play(int begin,int end) throws Exception {
		if (player != null) {
			isPlaying = true;
			player.play(begin,end);
		}
	}

	public void stop() throws Exception {
		if (player != null) {
			isPlaying = false;
			player.stop();
		}
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	private boolean isPlaying = false;
	private AdvancedPlayer player = null;
}