package commands;

import java.util.Scanner;
import model.Document;
import view.Text2SpeechEditorView;

public class LineToSpeech extends ChoiceListener {

	Scanner myObj = new Scanner(System.in);
	public LineToSpeech(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean actionPerformed(Document document) {
		int line;
		line = playLine(document);
		if (line != -1) {
			if (document.playLine(line)) return true;
		}
		return false;
	}

}
