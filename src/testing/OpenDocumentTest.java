package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import view.Text2SpeechEditorView;

class OpenDocumentTest {
	
	private Text2SpeechEditorView editor;
	private OpenDocument open;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing OpenDocument class..");
	}

	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		open = new OpenDocument(editor);
	}
	
	@Test
	void testDocumentContents() {
		open.actionPerformed(editor.getDocument());
		System.out.println(editor.getTextArea().getText());
		try {
			BufferedReader reader = new  BufferedReader(new FileReader("georgia.txt"));
			String line;
			try {
				line = reader.readLine();
				int counter = 0;
				while(line != null) {
					assertEquals(line,editor.getDocument().getLine(counter).getLineAsString());
					counter += 1;
					line=reader.readLine();
				}
				reader.close();
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
