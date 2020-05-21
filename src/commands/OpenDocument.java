package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Document;
import view.Text2SpeechEditorView;

public class OpenDocument extends ChoiceListener {
	
	public OpenDocument(Text2SpeechEditorView text2SpeechEditorView) {
		super(text2SpeechEditorView);
	}

	@Override
	public boolean actionPerformed(Document document) {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(text2SpeechEditorView);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try { 
				BufferedReader reader = new BufferedReader(
											new FileReader(selectedFile));
				setData(selectedFile, document);
                String line = reader.readLine();
                while(line != null) {
                	document.setLine(line);
                	text2SpeechEditorView.getTextArea().append(line + "\n");
                	line = reader.readLine();
                }
            	reader.close();
            	document.printDocument();
            	return true;
            } catch (Exception evt) { 
                JOptionPane.showMessageDialog(text2SpeechEditorView.getFrame(),
                				evt.getMessage()); 
            }
        } else
            JOptionPane.showMessageDialog(text2SpeechEditorView.getFrame(),
            		"The user cancelled the operation..."); 
		return false;
	}
	
	private void setData(File selectedFile, Document document) {
		try {
			BasicFileAttributes attrs = Files.readAttributes
					(selectedFile.toPath(), BasicFileAttributes.class);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss");
			document.setLastModified(df.format((attrs.lastModifiedTime().toMillis())));
			document.setCreationDate(df.format(attrs.creationTime().toMillis()));
			document.setTitle(selectedFile.getName());
			document.setAuthor("administrator");
		} catch (IOException e) {
			System.out.println("Error on getting dates from file...");
			e.printStackTrace();
		}
	}
}
