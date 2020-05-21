package text2speechAPI;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTSAdapter extends TextToSpeechAPI {
	
	private VoiceManager vm;
	private Voice voice;
	
	public FreeTTSAdapter() {
		vm = VoiceManager.getInstance();
		voice = vm.getVoice("kevin16");
		voice.allocate();
	}

	@Override
	public boolean play(String text) {
		if (voice.speak(text)) return true;	//true an tre3ei
		return false;
	}

	@Override
	public void setVolume(float volume) {
		voice.setVolume(volume);
	}

	@Override
	public void setPitch(float pitch) {
		voice.setPitch(pitch);
	}

	@Override
	public void setRate(float rate) {
		voice.setRate(rate);
	}

	@Override
	public float getVolume() {
		return voice.getVolume();
	}

	@Override
	public float getPitch() {
		return voice.getPitch();
	}

	@Override
	public float getRate() {
		return voice.getRate();
	}
}
