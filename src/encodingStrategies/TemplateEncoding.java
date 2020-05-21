package encodingStrategies;

public abstract class TemplateEncoding {
	
	private String text;
	
	public TemplateEncoding(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public void setCharAtText(char c, int index) {
		StringBuilder t = new StringBuilder(text);
		t.setCharAt(index, c);
		text = t.toString();
	}
	
	public abstract String encode();

}
