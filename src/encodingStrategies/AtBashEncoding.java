package encodingStrategies;

public class AtBashEncoding extends TemplateEncoding {

	public AtBashEncoding(String text) {
		super(text);
	}

	@Override
	public String encode() {
		char c;
		int count;
		for (int i = 0; i < this.getText().length(); i++) {
			c = this.getText().charAt(i);
			if (c >= 'a' && c <= 'z') {
				count = (int) (c - 'a');
				c = (char) ('z' - count);
			} else if (c >= 'A' && c <= 'Z') {
				count = (int) (c - 'A');
				c = (char) ('Z' - count);
			}
			this.setCharAtText(c, i);
		}
		return this.getText();
	}

}
