package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import text2speechAPI.FakeFreeTTSAdapter;
import view.Text2SpeechEditorView;

class EncodeDocumentTest {

	private Text2SpeechEditorView editor;
	private FakeFreeTTSAdapter fake;
	private OpenDocument open;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Encoded Document to Speech..");
	}
	
	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		fake = new FakeFreeTTSAdapter();
		open = new OpenDocument(editor);
	}
	
	@Test
	void testAtBash() {
		StringBuilder text = new StringBuilder("TVILTRZ TLLW TRIO\n" + 
				"BLF ZIV MLG TLLW YLB\n" + 
				"GSLNZH RH GSV YVHG YLB?\n" + 
				"EZMVHHZ rh evib yvzfgrufo!");
		open.actionPerformed(editor.getDocument());
		editor.getDocument().encodeAtBashDoc();
		fake.play(editor.getDocument().getDocumentForTextArea());
		assertEquals(text.toString(),fake.getText());
	}
	
	void testAtRot13() {
		StringBuilder text = new StringBuilder("TREBTVN TBBQ TVEY\n" + 
				"LBH NER ABG TBBQ OBL\n" + 
				"GUBZNF VF GUR ORFG OBL?\n" + 
				"INARFFN vf irel ornhgvshy!");
		open.actionPerformed(editor.getDocument());
		editor.getDocument().encodeRot13Doc();
		fake.play(editor.getDocument().getDocumentForTextArea());
		assertEquals(text.toString(),fake.getText());
	}
}
