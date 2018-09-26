package listadecolores;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ListaDeColores {

	private JFrame frame;
	private ColorList colorList;
	private JTextField textField;
	private ActionButtons buttons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeColores window = new ListaDeColores();
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
	public ListaDeColores() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeFrameConfiguration();
		initializeComponents();
		addEventsToComponents();
		launchApplication();
	}
	
	private void initializeFrameConfiguration() {
		frame = new JFrame("Lista de Colores TP4#2");
		frame.setBounds(100, 100, 850, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		//frame.setIconImage(new ImageIcon(imgURL).getImage());
	}
	
	private void initializeComponents() {
		createAndInitializeColorList();
		createAndInitializeActionButtons();
		createAndInitializeInputText();
	}
	
	private void createAndInitializeColorList() {
		colorList = new ColorList(); 
		colorList.addDefaultColors();
	}
	
	private void createAndInitializeActionButtons() {
		buttons = new ActionButtons();
	}
	
	private void createAndInitializeInputText() {
		textField = new JTextField(20);
		textField.setPreferredSize(new Dimension(15,25));
	}
	
	private void addEventsToComponents() {
		colorList.addOnClickAction(buttons.getDeleteButton());
		buttons.addActionToAddButton(colorList, textField);
		buttons.addActionToDeleteButton(colorList);
	}

	private void launchApplication() {
		frame.add(colorList);
		frame.add(textField);
		frame.add(buttons);
	}

}
