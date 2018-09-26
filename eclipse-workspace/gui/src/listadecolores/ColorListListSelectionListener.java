package listadecolores;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ColorListListSelectionListener implements ListSelectionListener {

	private JButton button;
	
	ColorListListSelectionListener(JButton button) {
		super();
		this.button = button;
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		System.out.println("Funciona ColorListListSelectionListener y recibe el button correspondiente");
	}

}
