package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import commands.ChoiceListener;
import commands.DocumentToSpeech;
import commands.EditDocument;
import commands.LineToSpeech;
import commands.OpenDocument;
import commands.ReverseDocument;
import commands.ReverseLine;
import commands.SaveDocument;
import commands.TuneEncoding;
import model.Document;
import text2speechAPI.FreeTTSAdapter;
import text2speechAPI.TextToSpeechAPI;

import javax.swing.JLabel;


public class Text2SpeechEditorView extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private  JFrame frame;
	private JTextArea textAreaVar;
	private Document document;
	private boolean newDocument;
	private JLabel label;
	private TextToSpeechAPI api;
	private ArrayList<ActionEvent> replayCommands;
	private boolean replayFlag = false;
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextArea getTextArea() {
		return textAreaVar;
	}
	
	public Document getDocument() {
		return document;
	}

	/**
	 * Launch the application.
	 */
	public Text2SpeechEditorView() {
		document = new Document();
		api = new FreeTTSAdapter();
		replayCommands = new ArrayList<ActionEvent>();
		newDocument = true;
		createFrame();
		createTextArea();
		createMenuBar();
	}
	
	private void createTextArea() {
		frame=this;
		textAreaVar = new JTextArea();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void createFrame() {
		frame = this;
		setTitle("Text2SpeechEditor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	}
	
	private void createMenuBar() {
		frame=this;
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss");
		document.setCreationDate(df.format(new Date()));
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem btnOpenFile = new JMenuItem("Open");
		menuFile.add(btnOpenFile);
		btnOpenFile.addActionListener(this);
		
		JMenuItem btnSaveToDisk = new JMenuItem("Save to Disk");
		menuFile.add(btnSaveToDisk);
		btnSaveToDisk.addActionListener(this);
		
		JMenu menuAudio = new JMenu("Audio");
		menuBar.add(menuAudio);
		
		JMenuItem btnDocumentAudio = new JMenuItem("Document");
		menuAudio.add(btnDocumentAudio);
		btnDocumentAudio.addActionListener(this);
		
		JMenuItem btnReverseDocAudio = new JMenuItem("Reverse Document");
		menuAudio.add(btnReverseDocAudio);
		btnReverseDocAudio.addActionListener(this);
		
		JMenuItem btnLineAudio = new JMenuItem("Line");
		menuAudio.add(btnLineAudio);
		btnLineAudio.addActionListener(this);
		
		JMenuItem btnReverseLineAudio = new JMenuItem("Reverse Line");
		menuAudio.add(btnReverseLineAudio);
		btnReverseLineAudio.addActionListener(this);
		
		JMenu menuEncode = new JMenu("Encode");
		menuBar.add(menuEncode);
		
		JMenuItem btnAtBashDocEncode = new JMenuItem("AtBash Document");
		menuEncode.add(btnAtBashDocEncode);
		btnAtBashDocEncode.addActionListener(this);
		
		JMenuItem btnAtBashLineEncode = new JMenuItem("AtBash Line");
		menuEncode.add(btnAtBashLineEncode);
		btnAtBashLineEncode.addActionListener(this);
		
		JMenuItem btnRot13DocEncode = new JMenuItem("Rot-13 Document");
		menuEncode.add(btnRot13DocEncode);
		btnRot13DocEncode.addActionListener(this);
		
		JMenuItem btnRot13LineEncode = new JMenuItem("Rot-13 Line");
		menuEncode.add(btnRot13LineEncode);
		btnRot13LineEncode.addActionListener(this);
		
		JMenu menuSettings = new JMenu("Settings");
		menuBar.add(menuSettings);
		
		JMenuItem btnAudioVolume = new JMenuItem("Audio Volume");
		menuSettings.add(btnAudioVolume);
		btnAudioVolume.addActionListener(this);
		
		JMenuItem btnSpeechRate = new JMenuItem("Speech Rate");
		menuSettings.add(btnSpeechRate);
		btnSpeechRate.addActionListener(this);
		
		JMenuItem btnPitch = new JMenuItem("Pitch");
		menuSettings.add(btnPitch);
		btnPitch.addActionListener(this);
		
		JMenuItem btnClose = new JMenuItem("Close");
		menuBar.add(btnClose);
		btnClose.addActionListener(this);
		
		JButton btnSaveTemp = new JButton("Save Temporary");
		btnSaveTemp.addActionListener(this);
		
		JButton btnReplayCommand = new JButton("Replay Commands");
		btnReplayCommand.addActionListener(this);
		/*
		 * Einai gia na kanei resize ta panta otan megalwnei to parathuro
		 */
		
		label = new JLabel("");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 321, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addComponent(btnSaveTemp, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReplayCommand, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
							.addGap(39))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSaveTemp, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReplayCommand, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		textAreaVar = new JTextArea();
		scrollPane.setViewportView(textAreaVar);
		contentPane.setLayout(gl_contentPane);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (replayFlag == false && !e.getActionCommand().equals("Replay Commands"))
			replayCommands.add(e);
		Text2SpeechEditorView text2SpeechEditorView = this;
		TuneEncoding tune;
		String choice = e.getActionCommand();
		switch (choice) {
		case "Close":
			frame.setVisible(false);
			break;
		case "Open":
			document = new Document();
			this.getTextArea().setText("");
			newDocument = false;
			executeCommand(new OpenDocument(text2SpeechEditorView));
			setDates();
			break;
		case "Save to Disk":
			SaveDocument saveDocument = new SaveDocument(text2SpeechEditorView);
			saveDocument.setNewDocument(newDocument);
			executeCommand(saveDocument);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss");
			document.setLastModified(df.format(new Date()));
			setDates();
			break;
		case "Save Temporary":
			executeCommand(new EditDocument(text2SpeechEditorView));
			break;
		case "Document":
			executeCommand(new DocumentToSpeech(text2SpeechEditorView));
			break;
		case "Line":
			executeCommand(new LineToSpeech(text2SpeechEditorView));
			break;
		case "Reverse Document":
			executeCommand(new ReverseDocument(text2SpeechEditorView));
			break;
		case "Reverse Line":
			executeCommand(new ReverseLine(text2SpeechEditorView));
			break;
		case "AtBash Document":
			tune = new TuneEncoding(text2SpeechEditorView);
			tune.setEncoding("AtBash Document");
			executeCommand(tune);
			break;
		case "Rot-13 Document":
			tune = new TuneEncoding(text2SpeechEditorView);
			tune.setEncoding("Rot-13 Document");
			executeCommand(tune);
			break;
		case "AtBash Line":
			tune = new TuneEncoding(text2SpeechEditorView);
			tune.setEncoding("AtBash Line");
			executeCommand(tune);
			break;
		case "Rot-13 Line":
			tune = new TuneEncoding(text2SpeechEditorView);
			tune.setEncoding("Rot-13 Line");
			executeCommand(tune);
			break;
		case "Audio Volume":
			float volume = Float.parseFloat(JOptionPane.showInputDialog("Please type "
					+ "desired volume:"));
			setSettings(volume,"Audio Volume");
			break;
		case "Speech Rate":
			float rate = Float.parseFloat(JOptionPane.showInputDialog("Please type "
					+ "desired Speech Rate:"));
			setSettings(rate,"Speech Rate");
			break;
		case "Pitch":
			float pitch = Float.parseFloat(JOptionPane.showInputDialog("Please type "
					+ "desired Pitch:"));
			setSettings(pitch,"Pitch");
			break;
		case "Replay Commands":
			replayFlag = true;
			for (ActionEvent event : replayCommands) {
				actionPerformed(event);
			}
			replayFlag = false;
			replayCommands.clear();
			break;
		default:
			System.out.println("Not valid choice...");
			break;
		}
	}

	private void executeCommand(ChoiceListener choiceListener) {
		choiceListener.actionPerformed(document);
	}
	
	private void setDates() {
		label.setText("<html>Author:\t" + document.getAuthor() + "<br/>" +
				"Title:\t" + document.getTitle() + "<br/>" +
				"Creation Date:\t" + document.getCreationDate() + "<br/>" +
				"Last Modified:\t" + document.getLastModified() + "</html>");
	}
	
	private void setSettings(float num, String type) {
		switch (type) {
		case "Audio Volume":
			api.setVolume(num);
			break;
		case "Speech Rate":
			api.setRate(num);
			break;
		case "Pitch":
			api.setPitch(num);
			break;
		default:
			System.out.println("Not valid setting...");
			break;
		}
		document.setAudioManager(api);
	}
}
