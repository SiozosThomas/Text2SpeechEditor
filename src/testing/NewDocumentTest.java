package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Document;

class NewDocumentTest {

	private Document document;
	
	@BeforeAll
	public static void setUp() throws Exception {
		System.out.println("Testing Document class..");		
	}
	
	@BeforeEach
	public void init() {
		document = new Document();
	}

	@Test
	void testNewDocument() {
		assertEquals(null, document.getAuthor());
		assertEquals(null, document.getTitle());
		assertEquals(null, document.getLastModified());
		assertEquals("", document.getDocumentForTextArea());
	}
	
	@Test
	void testNewDocumentDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss");
		document.setCreationDate(df.format(new Date()));
		assertEquals(df.format(new Date()), document.getCreationDate());
	}

	@Test
	void testAuthorTitle() {
		document.setAuthor("Georgia");
		document.setTitle("TEST");
		assertEquals("Georgia",document.getAuthor());
		assertEquals("TEST",document.getTitle());
	}
}
