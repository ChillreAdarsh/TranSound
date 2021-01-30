package com.test;
/* Project TranSound

This project intends to solve language problem faced by professionals accross the globe. This mainly uses Google Cloud platform to Transcribe, Translate and Synthesise the voice spoken in another language to intended language.

Created by Adarsh
Date: 26/1/2021

This file has the main function that is executed as app.
*/
import com.example.*;

class Execute {
	public static void main (String[] args) {
		//Initialise
		int i = 0;

		//Loop 10 times for now
		while (i<10) {
		//Read Audio data
			ReadAudio reader = new ReadAudio ();
			reader.startRead (5000);

		//Transound

		//Output to relavant device
            PlayBack player = new PlayBack();
            player.startPlayback("tmp.wav");
            i++;
		}
	}
}
