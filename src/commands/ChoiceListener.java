package commands;

import javax.swing.JOptionPane;

import model.Document;
import view.Text2SpeechEditorView;

public abstract class ChoiceListener {
	
	public Text2SpeechEditorView text2SpeechEditorView;

	ChoiceListener(Text2SpeechEditorView text2SpeechEditorView) {
		this.text2SpeechEditorView = text2SpeechEditorView;
	}

	public abstract boolean actionPerformed(Document document);
	
	public int playLine(Document document) {
		String lineInput = null;
		int line = -1;
		lineInput = JOptionPane.showInputDialog("Please type "
				+ "the number of line:");
		line = Integer.parseInt(lineInput);
		line--;
		if (document.getDocumentLineSize() == 0) {
			JOptionPane.showMessageDialog(text2SpeechEditorView.getFrame(),
				"Not lines in document...Please write something "
				+ "and then click to hear a line...",
				"Warning" , JOptionPane.WARNING_MESSAGE);
		}
		while (line < 0 || line > document.getDocumentLineSize()) {
			lineInput = JOptionPane.
					showInputDialog("Please type again number of line:");
			line = Integer.parseInt(lineInput);
			line--;
		}
		return line;
	}
}
