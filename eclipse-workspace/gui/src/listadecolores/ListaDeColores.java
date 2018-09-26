package listadecolores;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListaDeColores {

	private JFrame frame;
	private ColorList colorListPanel;
	private JTextField textField;
	private JPanel buttonsPanel;
	private JButton addButton;
	private JButton deleteButton;

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
		initializeColorListJlist();
		initializeInputTextJTextField();
		initializeAddDeleteJButton();
		launchApplication();
	}

	private void initializeFrameConfiguration() {
		frame = new JFrame("Lista de Colores TP4#2");
		frame.setBounds(100, 100, 650, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		//frame.setIconImage(new ImageIcon(imgURL).getImage());
	}
	
	private void initializeColorListJlist() {
		colorListPanel = new ColorList(); 
		colorListPanel.addDefaultColors();
		colorListPanel.getList().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				addButton.setEnabled(true);
			}
		});
//		addListSelectionListener(new ListSelectionListener() {
//		     public void valueChanged(ListSelectionEvent e) {
//		           deleteConfirmButton.setEnabled(true);//Enable here
//		 }
		
	}
	
	private void initializeAddDeleteJButton() {
		buttonsPanel = new JPanel();
	    addButton = new JButton("Agregar");
	    deleteButton = new JButton("Borrar");
	    deleteButton.setEnabled(false);
	    buttonsPanel.add(addButton);
	    buttonsPanel.add(deleteButton);
	    
	    addButton.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e) {
				String newColor = textField.getText();
				if (!newColor.isEmpty()) {
					colorListPanel.addColor(newColor);
				}
			}
	      });
	    
	    deleteButton.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e) {
				String newColor = textField.getText();
				colorListPanel.deleteColorSelected();
			}
	      });
	}

	private void initializeInputTextJTextField() {
		textField = new JTextField(20);
		textField.setPreferredSize(new Dimension(15,25));
	}
	
	private void launchApplication() {
		frame.add(colorListPanel);
		frame.add(textField);
		frame.add(buttonsPanel);
	}

}
