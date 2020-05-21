package view;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.Text2SpeechEditorView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class StartMenuView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frameStart;
	private JPanel startPane;
	@SuppressWarnings("unused")
	private Text2SpeechEditorView frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartMenuView window = new StartMenuView();
					window.frameStart.setLocationRelativeTo(null);
					window.frameStart.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartMenuView() {
		initialize();
		makeNewbt();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		startPane = new JPanel();
		frameStart = new JFrame();
		frameStart.getContentPane();
		frameStart.setBounds(100, 100, 659, 482);
        frameStart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStart.setContentPane(startPane);
        startPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/images/start.png"));
		lblNewLabel.setBounds(10, 11, 623, 360);
		startPane.add(lblNewLabel);
	}

	public void makeNewbt() {
		JButton btnNewStart = new JButton("Start");
		btnNewStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame = new Text2SpeechEditorView();
				frameStart.setVisible(false);
			}
		});
	        btnNewStart.setBounds(263, 382, 115, 50);
	        startPane.add(btnNewStart);
		}
}
