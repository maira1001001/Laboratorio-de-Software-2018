package selectfiles;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;

public class SelectFiles {

	private JFrame frame;
	private JButton fileButton;
	private File selectedFile;
	private ArrayList<String> data;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFiles window = new SelectFiles();
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
	public SelectFiles() {
		initialize();
		createAndInitializeComponents();
		launchApplication();
	}
	
	private void launchApplication() {
		frame.add(fileButton);
	}

	public void createAndInitializeComponents() {
		fileButton = new JButton("Seleccionar Archivo");
		fileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
	}
			
	public void openFile( ) {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		int returnValue = jfc.showOpenDialog(null);
		switch (returnValue) {
        case JFileChooser.APPROVE_OPTION: 
        	//selecciona el archivo deseado
        	selectedFile = jfc.getSelectedFile();
			if(processFile()) {
				buildTableFromFile();
			}
            break;
        case JFileChooser.CANCEL_OPTION: 
        	System.out.println("cancel option");
        	break;
        case JFileChooser.ERROR_OPTION: 
        	System.out.println("error option");
        	break;
		}
	}
	
	public boolean processFile() {
		//lo almacena en memoria para leerlo
		try {
			FileReader fileReader = new FileReader(selectedFile);
			BufferedReader bufferedReader =new BufferedReader(fileReader);
			String line;
			data = new ArrayList<String>();
			//lee cada línea del archivo y lo almacena en un arraylist
	        while ((line = bufferedReader.readLine()) != null) {     
	        	data.add(line);
	        	line = bufferedReader.readLine();
	        }
		} 
		catch (FileNotFoundException ex) { ex.printStackTrace();}
		catch (IOException ex) { ex.printStackTrace();}
		return !data.isEmpty();
	}

	public void buildTableFromFile() {	
		String[] columnNames = {"C1","C2","C3","C4","C5","C6","C7","C8","C9","C10"};
		Object[][] rows = {};
		for (int i = 0; i < data.size(); i++) {
			String[] l = data.get(i).split(":");
			for (int j = 0; j < l.length; j++) {
				rows[i][j] = l;
			}
		}
		table = new JTable(rows, columnNames);
		frame.add(table);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Seleccionar Archivos y procesarlos TP4#3");
		frame.setBounds(100, 100, 850, 180);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
	}

}
