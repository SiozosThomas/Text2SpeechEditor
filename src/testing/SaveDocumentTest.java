package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.EditDocument;
import commands.SaveDocument;
import view.Text2SpeechEditorView;

class SaveDocumentTest {

	private Text2SpeechEditorView editor;
	private SaveDocument save;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing SaveDocument..");
	}
	
	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		save = new SaveDocument(editor);
	}
	
	@Test
	void testSaveDocument() {
		EditDocument edit = new EditDocument(editor);
		String text = "This is a test for SaveDocument\n"
				+ "Hello World";
		editor.getTextArea().setText(text);
		edit.actionPerformed(editor.getDocument());
		save.actionPerformed(editor.getDocument());
		StringBuilder builder = new StringBuilder();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("georgia.txt"));
			String line;
			try {
				while((line = br.readLine()) != null){
					builder.append(line + "\n");
				}
				builder.setLength(builder.length() - 1);	//Delete new line at the end
				assertEquals(editor.getDocument().getDocumentForTextArea(),builder.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
