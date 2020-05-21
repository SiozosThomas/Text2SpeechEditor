package commands;

import model.Document;
import view.Text2SpeechEditorView;

public class DocumentToSpeech extends ChoiceListener{
	public DocumentToSpeech(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean actionPerformed(Document document) {
		if (document.playContents()) return true;
		return false;
	}

}
