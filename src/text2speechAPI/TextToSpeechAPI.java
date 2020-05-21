package text2speechAPI;

public abstract class TextToSpeechAPI {
	
	public abstract boolean play(String text);
	public abstract void setVolume(float volume);
	public abstract void setPitch(float pitch);
	public abstract void setRate(float rate);
	public abstract float getVolume();
	public abstract float getPitch();
	public abstract float getRate();

}
