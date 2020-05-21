package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.EditDocument;
import model.Document;
import view.Text2SpeechEditorView;

class EditDocumentTest {
	
	private EditDocument editDocument;
	private Text2SpeechEditorView editor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing EditDocument..");
	}

	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		editDocument = new EditDocument(editor);
	}
	@Test
	void testEditDocument() {
		Document document = new Document();
		String text = "Hello World this is a test\n"
				+ "This is the second part of test";
		editor.getTextArea().setText(text);
		assertEquals(true, editDocument.actionPerformed(document));
		assertEquals(text,document.getDocumentForTextArea());
	}

}
