package model;

import java.util.ArrayList;

import text2speechAPI.FreeTTSAdapter;
import text2speechAPI.TextToSpeechAPI;

public class Line {
	
	private ArrayList<String> words;
	private TextToSpeechAPI audioManager;
	
	public void setContent(String line) {
		words = new ArrayList<String>();
		String[] line_array =  line.split(" ");
		for (String word : line_array) {
			words.add(word);
		}
	}
	
	public ArrayList<String> getLine() {
		return words;
	}
	
	public String getLineAsString() {
		StringBuilder line = new StringBuilder();
		int count = 0;
		for (String word : words) {
			if (count == 0) {
				line.append(word);
			} else {
				line.append(" " + word);
			}
			count++;
		}
		return line.toString();
	}
	
	public void setLine(ArrayList<String> line) {
		words = line;
	}
	
	public boolean playLine() {
		audioManager = new FreeTTSAdapter();
		if (audioManager.play(this.getLine().toString())) return true;
		return false;
	}
}
