package listadecolores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ActionButtons extends JPanel {
	
	private JButton addButton;
    private JButton deleteButton;
	
	public ActionButtons() {
		addButton = new JButton("Agregar");
		deleteButton = new JButton("Borrar");
		add(addButton);
		add(deleteButton);
	}
	
	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	public void enableDeleteButton() {
		deleteButton.setEnabled(true);
	}
	
	public void addActionToAddButton(ColorList colorList, JTextField textField) {
		addButton.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e) {
				String newColor = textField.getText();
				if (!newColor.isEmpty()) {
					colorList.addColor(newColor);
				}
				textField.setText("");
			}
	      });
	}
	
	public void addActionToDeleteButton(ColorList colorList) {
		deleteButton.addActionListener(new ActionListener() {
	        @Override
			public void actionPerformed(ActionEvent e) {
	        	if (colorList.aColorIsSelected()) {
	        		colorList.deleteColorSelected();
	        	}
			}
	      });
	}
	
	
	
	
	
	
}
