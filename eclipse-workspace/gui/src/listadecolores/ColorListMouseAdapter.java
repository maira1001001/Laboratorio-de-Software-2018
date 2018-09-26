package listadecolores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorListMouseAdapter extends MouseAdapter {
	
	public void mouseClicked(MouseEvent e) {
		System.out.println("MouseListener mouseClicked");					
	}
}
