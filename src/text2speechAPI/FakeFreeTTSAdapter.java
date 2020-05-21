package text2speechAPI;

public class FakeFreeTTSAdapter extends TextToSpeechAPI {
	
	private String text;
	private float volume;
	private float pitch;
	private float rate;
	
	public FakeFreeTTSAdapter() {
		text = "";
		volume = 0;
		pitch = 0;
		rate= 0;
	}
	public String getText() {
		return text;
	}
	
	public float getVolume() {
		return volume;
	}
	
	public float getPitch() {
		return pitch;
	}
	
	public float getRate() {
		return rate;
	}

	@Override
	public boolean play(String text) {
		this.text=text;
		return false;
	}

	@Override
	public void setVolume(float volume) {
		this.volume=volume;

	}

	@Override
	public void setPitch(float pitch) {
		this.pitch=pitch;

	}

	@Override
	public void setRate(float rate) {
		this.rate=rate;

	}


}
