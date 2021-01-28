/* class ReadAudio

class to read audio data from mic/input.
Currently it saves as a file.

TODO: Just provide the audio buffer
*/
package com.example;

import javax.sound.sampled.*;
import java.io.*;

public class ReadAudio {

	//Read 5 seconds
	static final int READ_TIME = 5000;

	//File to read
	File readFile = new File ("/home/prashant/workspace/Transound/sublime_text_3/tmp.wav");

	//File format
	AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

	//Data line
	TargetDataLine dataLine;

	/**
     * Defines an audio format
     */
    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }

    /* Function to read the data */
    public void startRead (int time) {
    	try {
    		AudioFormat audioFormat = getAudioFormat ();

    		DataLine.Info info = new DataLine.Info (TargetDataLine.class, audioFormat);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Capture Line not supported");
                System.exit(0);
            }

            dataLine = (TargetDataLine) AudioSystem.getLine(info);
            dataLine.open (audioFormat);

            //Start reading
            dataLine.start ();
            System.out.println ("Started Reading.....");

            //Save the captured data in File
            AudioInputStream audioInStream = new AudioInputStream(dataLine);
            AudioSystem.write (audioInStream, fileType, readFile);

            //Start a timer and stop when requested time in ms reached. If time=0 then it will never stop reading.
            if (time != 0) {
	            Thread timer = new Thread (new Runnable() {
	            public void run() {
	                try {
	                    Thread.sleep(time);
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	                stopRead();
	            }
	        });
	        timer.start ();
        }

    	} catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    //Stop reading
    public void stopRead () {
    	dataLine.stop ();
    	dataLine.close ();
    	System.out.println ("Read done!");
    }
}
