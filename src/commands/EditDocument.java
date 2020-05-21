package commands;

import model.Document;
import view.Text2SpeechEditorView;

public class EditDocument extends ChoiceListener {

	public EditDocument(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean actionPerformed(Document document) {
		String text = text2SpeechEditorView.getTextArea().getText().toString();
		String[] textList = text.split("\n");
		for(String textLine : textList) {
			document.setLine(textLine);
		}
		document.printDocument();
		return true;
	}
}
