package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import text2speechAPI.FakeFreeTTSAdapter;
import view.Text2SpeechEditorView;

class EncodeLineTest {

	private Text2SpeechEditorView editor;
	private FakeFreeTTSAdapter fake;
	private OpenDocument open;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Encoded Line to Speech..");
	}
	
	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		fake = new FakeFreeTTSAdapter();
		open = new OpenDocument(editor);
	}
	
	@Test
	void testAtBash() {
		StringBuilder text = new StringBuilder("TVILTRZ TLLW TRIO");
		open.actionPerformed(editor.getDocument());
		editor.getDocument().encodeAtBashLine(0);
		fake.play(editor.getDocument().getLine(0).getLineAsString());
		assertEquals(text.toString(),fake.getText());
	}
	
	@Test
	void testAtRot13() {
		StringBuilder text = new StringBuilder("TREBTVN TBBQ TVEY");
		open.actionPerformed(editor.getDocument());
		editor.getDocument().encodeRot13Line(0);
		fake.play(editor.getDocument().getLine(0).getLineAsString());
		assertEquals(text.toString(),fake.getText());
	}
	

}
