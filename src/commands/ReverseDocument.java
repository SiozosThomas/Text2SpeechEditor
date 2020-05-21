package commands;

import model.Document;
import view.Text2SpeechEditorView;

public class ReverseDocument extends ChoiceListener {

	public ReverseDocument(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
	}

	@Override
	public boolean actionPerformed(Document document) {
		if (document.playReverseContents()) return true;
		return false;
	}

}
