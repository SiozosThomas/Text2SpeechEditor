package commands;

import javax.swing.JOptionPane;

import model.Document;
import view.Text2SpeechEditorView;

public class TuneEncoding extends ChoiceListener {
	
	private String encode;
	
	public TuneEncoding(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
	}

	public void setEncoding(String encode) {
		this.encode = encode;
	}

	@Override
	public boolean actionPerformed(Document document) {
		if(encode.equals("AtBash Document")) {
			document.encodeAtBashDoc();
		} else if (encode.equals("AtBash Line") || encode.equals("Rot-13 Line")) {
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
			if (encode.equals("AtBash Line")) {
				document.encodeAtBashLine(line);
			} else if (encode.equals("Rot-13 Line")) {
				document.encodeRot13Line(line);
			}
		} else if (encode.equals("Rot-13 Document")) {
			document.encodeRot13Doc();
		}
		text2SpeechEditorView.getTextArea().setText(document.getDocumentForTextArea());
		return false;
	}

}
