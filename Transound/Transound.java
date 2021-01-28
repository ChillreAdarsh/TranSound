/* class Transound 

*/

class Transound {
	Transcribe transcriber;
	Translate transtor;
	Synthesise synthesiser;

	/* Audio to Text converter 
	Inout: File
	Output: Text buffer */
	public void audioToText () {

		/* TODO: Call GCP Transcribe API */
	}

	/* Translating from one language to another 
	Inout: Text buffer
	Output: Translated Text buffer */
	public void translateText () {

		/* TODO: Call GCP Translate API */
	}

	/* Text to Audio converter 
	Inout: Text buffer
	Output: Audio file */
	public void syntesiseText () {

		/* TODO: Call GCP Synthesise API */
	}

}