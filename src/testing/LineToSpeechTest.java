package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commands.OpenDocument;
import text2speechAPI.FakeFreeTTSAdapter;
import view.Text2SpeechEditorView;

class LineToSpeechTest {
	
	private Text2SpeechEditorView editor;
	private FakeFreeTTSAdapter fake;
	private OpenDocument open;


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Testing Line to Speech Class..");
	}
	
	@BeforeEach
	public void init() {
		editor = new Text2SpeechEditorView();
		fake = new FakeFreeTTSAdapter();
		open = new OpenDocument(editor);
	}

	@Test
	void test() {
		open.actionPerformed(editor.getDocument());
		fake.play(editor.getDocument().getLine(2).getLineAsString());
		assertEquals(editor.getDocument().getLine(2).getLineAsString(),fake.getText());
	}

}
