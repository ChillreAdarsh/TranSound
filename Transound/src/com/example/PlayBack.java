package com.example;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

/* Project TranSound

This project intends to solve language problem faced by professionals accross the globe. This mainly uses Google Cloud platform to Transcribe, Translate and Synthesise the voice spoken in another language to intended language.

Created by Prashant
Date: 27/1/2021

This file has the play function that plays out audio data from a file.
*/

public class PlayBack implements LineListener {

	boolean playBackCompleted = false;

	public void startPlayback(String audioFilePath) {
		File audioFile = new File(audioFilePath);
        System.out.println("Opened file for reading");
		try {
		/* gets an audio stream of the file */
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

		/* Clip is something which loads the whole audio data onto it and plays the same
		For this it requires to know what format of audio hsa to be played. The below code gets
		the audio format of the audio dtaa present in the file */
		AudioFormat audioFormat = audioStream.getFormat();

		/* Creates a dataline for the given auioformat*/
		DataLine.Info dataLineInfo = new DataLine.Info(Clip.class, audioFormat);

		/* create a clip using the above data line */
		Clip audioClip  = (Clip) AudioSystem.getLine(dataLineInfo);

		audioClip.addLineListener(this);

		/* load the audio stream to the clip */
		audioClip.open(audioStream);

		audioClip.start();
        System.out.println("Statedplk");

		while(!playBackCompleted) {
				try {
        System.out.println("Sleeping for 1 second");
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
		}

		audioClip.close();

		audioStream.close();
		} catch (UnsupportedAudioFileException ex) {
            System.out.println("The specified audio file is not supported.");
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            System.out.println("Audio line for playing back is unavailable.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error playing the audio file.");
            ex.printStackTrace();
        }

	}

	
	@Override
	public void update(LineEvent event) {
	LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");
            playBackCompleted = false;
             
        } else if (type == LineEvent.Type.STOP) {
            playBackCompleted = true;
            System.out.println("Playback completed.");
        }
	}
}
