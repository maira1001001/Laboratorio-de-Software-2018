package compositor;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class CompositorWindow {

	private JFrame frame;
	private FigurePanel figurePanel; 
	private PentagramPanel pentagramPanel;
	private JPanel melodyWritePanel;
	private JPanel melodyRawPanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompositorWindow window = new CompositorWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CompositorWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setUpFrame();
		drawFigurePanel(); 
		drawPentagramPanel();
		drawMelodyRawPanel();
		drawMelodyWritePanel();
		launchFrame();
	}

	private void setUpFrame() {
		//JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.white);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));	
		frame.getContentPane().setLayout(new FlowLayout());
	}
	
	/**
	 * Dibuja la sección "Figuras" que contiene las figuras musicales
	 */
	private void drawFigurePanel() {
		figurePanel = new FigurePanel();
		figurePanel.initializeComponent();
		figurePanel.drawComponent();	
	}
	
	/**
	 * Dibuja la sección "Pentagrama"
	 */
	private void drawPentagramPanel() {
		pentagramPanel = new PentagramPanel();
		pentagramPanel.initializeComponent();
		pentagramPanel.drawComponent();
	}
	
	/**
	 * Dibuja la sección "Melodías Resultantes (sólo lectura)"
	 */
	private void drawMelodyRawPanel() {
		melodyRawPanel = new JPanel();
		Border lineaRoja = BorderFactory.createLineBorder(Color.red);
		TitledBorder title = BorderFactory.createTitledBorder(lineaRoja, "Melodía Resultante (sólo lectura)");
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitleColor(Color.red);
		melodyRawPanel.setBorder(title);
		//campo texto que muestra la melodia que se va generando
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		melodyRawPanel.add(textField);
		//boton play
		JButton playButton = new JButton("Play");
		melodyRawPanel.add(playButton);
		//boton clear
		JButton clearButton = new JButton("Clear");
		melodyRawPanel.add(clearButton);
		//boton undo
		JButton undoButton = new JButton("Undo");
		melodyRawPanel.add(undoButton);	
	}

	/**
	 * Dibuja la sección "Melodías Resultantes (sólo lectura)"
	 */
	private void drawMelodyWritePanel() {
		melodyWritePanel = new JPanel();
	}
	
	private void launchFrame() {
		frame.add(figurePanel);
		frame.add(pentagramPanel);
		frame.add(melodyRawPanel);
		frame.add(melodyWritePanel);
	}
	
}
