package model;

import java.util.ArrayList;
import encodingStrategies.AtBashEncoding;
import encodingStrategies.Rot13Encoding;
import encodingStrategies.TemplateEncoding;
import text2speechAPI.FreeTTSAdapter;
import text2speechAPI.TextToSpeechAPI;

public class Document {
	private String author;
	private String title;
	private String lastModified;
	private String creationDate;
	private ArrayList<Line> document;
	private TextToSpeechAPI audioManager;
	private TemplateEncoding templateEncoding;

	public Document() {
		author = null;
		title = null;
		lastModified = null;
		creationDate = null;
		document = new ArrayList<Line>();
		audioManager = new FreeTTSAdapter();
	}
	
	/*
	 * Setter for author.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/*
	 * Getter for author.
	 * @return String with author's name.
	 */
	public String getAuthor() {
		return author;
	}
	
	/*
	 * Setter for title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/*
	 * Getter for title.
	 * @return String with file's title.
	 */
	public String getTitle() {
		return title;
	}
	
	/*
	 * Setter for last modified date.
	 */
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	
	/*
	 * Getter for last modified date.
	 * @return String with last modified date.
	 */
	public String getLastModified() {
		return lastModified;
	}
	
	/*
	 * Setter for creation date.
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/*
	 * Getter for creation date.
	 * @return String with creation date.
	 */
	public String getCreationDate() {
		return creationDate;
	}
	
	public void setAudioManager(TextToSpeechAPI audioManager) {
		this.audioManager = audioManager;
	}
	
	/*
	 * Set a line for the document list with lines.
	 */
	public void setLine(String line) {
		Line lineOb = new Line();
		lineOb.setContent(line);
		document.add(lineOb);
	}
	
	public Line getLine(int n) {
		return document.get(n);
	}
	
	/*
	 * Prints the whole document.
	 */
	public void printDocument() {
		for (Line line : document) {
			System.out.println(line.getLine());
		}
	}
	
	/*
	 * Returns the number of file's lines
	 * @return The number of file's lines
	 */
	public int getDocumentLineSize() {
		return document.size();
	}
	
	/*
	 * Get the document list with lines in string.
	 * @return String with lines of document.
	 */
	public String getDocumentForTextArea() {
		StringBuilder doc = new StringBuilder();
		int count = 0;
		for (Line line : document) {
			if (count == 0) {
				doc.append(line.getLineAsString());
			} else {
				doc.append("\n" + line.getLineAsString());
			}
			count++;
		}
		return doc.toString();
	}
	
	/*
	 * Get a specific line of document.
	 * @return Line of document
	 */
	public String getSpecificLine(int n) {
		Line temp = document.get(n);
		return temp.getLine().toString();
	}
	
	/*
	 * Play contents of document
	 * @return True or False if it worked or not
	 */
	public boolean playContents() {
		if (audioManager.play(this.getDocumentForTextArea())) return true;
		return false;
	}
	
	/*
	 * Play a line of document
	 * @return True or False if it worked or not
	 */
	public boolean playLine(int line) {
		Line lineOb = new Line();
		lineOb.setContent(document.get(line).getLine().toString());
		System.out.println(document.get(line).getLine().toString());
		if (lineOb.playLine()) return true;
		return false;
	}
	
	/*
	 * Play reverse contents of document
	 * @return True or False if it worked or not
	 */
	public boolean playReverseContents() {
		StringBuilder doc = new StringBuilder();
		doc.append(this.getDocumentForTextArea());
		doc = doc.reverse();
		if (audioManager.play(doc.toString())) return true;
		return false;
	}
	
	/*
	 * Play reverse line of document
	 * @return True or False if it worked or not
	 */
	public boolean playReverseLine(int line) {
		Line lineOb = new Line();
		StringBuilder reverseLine = new StringBuilder();
		reverseLine.append(document.get(line).getLine().toString());
		reverseLine = reverseLine.reverse();
		System.out.println(reverseLine.toString());
		lineOb.setContent(reverseLine.toString());
		if (lineOb.playLine()) return true;
		return false;
	}
	
	/*
	 * Encode document with At Bash technique
	 */
	public void encodeAtBashDoc() {
		for (int i = 0; i < document.size(); i++) {
			encodeAtBashLine(i);
		}
	}
	
	/*
	 * Encode a line of document with At Bash technique
	 */
	public void encodeAtBashLine(int line) {
		templateEncoding = new AtBashEncoding(document.get(line).getLine().toString());
		String[] line_array = templateEncoding.encode().split(",");
		ArrayList<String> words = new ArrayList<String>();
		for (String word : line_array) {
			word = word.replace("[", "");
			word = word.replace("]", "");
			word = word.replace(" ", "");
			words.add(word);
			//System.out.println(words);
		}
		document.get(line).setLine(words);
	}
	
	/*
	 * Encode document with Rot-13 technique
	 */
	public void encodeRot13Doc() {
		for (int i = 0; i < document.size(); i++) {
			encodeRot13Line(i);
		}
	}
	
	/*
	 * Encode a line document with Rot-13 technique
	 */
	public void encodeRot13Line(int line) {
		templateEncoding = new Rot13Encoding(document.get(line).getLine().toString());
		String[] line_array = templateEncoding.encode().split(",");
		ArrayList<String> words = new ArrayList<String>();
		for (String word : line_array) {
			word = word.replace("[", "");
			word = word.replace("]", "");
			word = word.replace(" ", "");
			words.add(word);
		}
		document.get(line).setLine(words);
	}
}
