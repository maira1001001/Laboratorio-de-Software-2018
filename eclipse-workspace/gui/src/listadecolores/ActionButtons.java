package listadecolores;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionButtons extends JPanel {
	
	private JButton addButton;
    private JButton deleteButton;
	
	public ActionButtons() {
		addButton = new JButton("Agregar");
		deleteButton = new JButton("Borrar");
		add(addButton);
		add(deleteButton);
	}
	
	public void enableDeleteButton() {
		deleteButton.setEnabled(true);
	}
	
	
	
	//agregar eventos 
	
	
}
