package listadecolores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorListMouseListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("MouseListener mouseClicked");				
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("MouseListener mousePressed");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("MouseListener mouseReleased");
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("MouseListener mouseEntered");		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("MouseListener mouseExited");
	}
}
