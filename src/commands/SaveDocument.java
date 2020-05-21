package commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import model.Document;
import view.Text2SpeechEditorView;

public class SaveDocument extends ChoiceListener {
	
	private boolean newDocument;

	public SaveDocument(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
		newDocument = false;
		// TODO Auto-generated constructor stub
	}
	
	public void setNewDocument(boolean newDocument) {
		this.newDocument = newDocument;
	}

	@Override
	public boolean actionPerformed(Document document) {
		if(newDocument == true) {
			String authorUserInput = null;
			String titleUserInput = null;
			authorUserInput = JOptionPane.showInputDialog("Please type an author:");
			titleUserInput = JOptionPane.showInputDialog("Please type a title:");
			document.setAuthor(authorUserInput);
			document.setTitle(titleUserInput);
		}
		final JFileChooser SaveAs = new JFileChooser();
		SaveAs.setApproveButtonText("Save");
		int actionDialog = SaveAs.showOpenDialog(text2SpeechEditorView);
		if (actionDialog != JFileChooser.APPROVE_OPTION) {
		   return false;
		}
		
		File fileName = new File(SaveAs.getSelectedFile() + ".txt");
		BufferedWriter outFile = null;
		try {
		   outFile = new BufferedWriter(new FileWriter(fileName));
		
		   text2SpeechEditorView.getTextArea().write(outFile);   // *** here: ***
		
		} catch (IOException ex) {
		   ex.printStackTrace();
		} finally {
		   if (outFile != null) {
		      try {
		         outFile.close();
		      } catch (IOException e) {
		          // one of the few times that I think that it's OK
		    	  // to leave this blank
		      }
		   }
		}
		return false;
	}

}
