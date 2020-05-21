package encodingStrategies;

public class Rot13Encoding extends TemplateEncoding {

	public Rot13Encoding(String text) {
		super(text);
	}

	@Override
	public String encode() {
		char c;
		for (int i = 0; i < this.getText().length(); i++) {
			c = this.getText().charAt(i);
			if (c >= 'a' && c <= 'm') c += 13;
			else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;
			this.setCharAtText(c, i);
		}
		return this.getText();
	}
}
