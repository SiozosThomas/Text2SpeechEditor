package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import text2speechAPI.FakeFreeTTSAdapter;
import view.Text2SpeechEditorView;

class ReverseDocumentTest {
	
	private Text2SpeechEditorView editor;
	private FakeFreeTTSAdapter fake;
	private OpenDocument open;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Reverse Document to Speech..");
	}
	
	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		fake = new FakeFreeTTSAdapter();
		open = new OpenDocument(editor);
	}
	
	@Test
	void test() {
		StringBuilder text = new StringBuilder("GEROGIA GOOD GIRL\n" + 
				"YOU ARE NOT GOOD BOY\n" + 
				"THOMAS IS THE BEST BOY?\n" + 
				"VANESSA is very beautiful!");
		text.reverse();
		open.actionPerformed(editor.getDocument());
		StringBuilder doc = new StringBuilder();
		doc.append(editor.getDocument().getDocumentForTextArea());
		doc = doc.reverse();
		fake.play(doc.toString());
		assertEquals(text.toString(),fake.getText());
		
	}

}
