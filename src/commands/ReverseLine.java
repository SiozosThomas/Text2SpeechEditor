package commands;

import model.Document;
import view.Text2SpeechEditorView;

public class ReverseLine extends ChoiceListener {

	public ReverseLine(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
	}

	@Override
	public boolean actionPerformed(Document document) {
		int line;
		line = playLine(document);
		if (line != -1) {
			if (document.playReverseLine(line)) return true;
		}
		return false;
	}

}
