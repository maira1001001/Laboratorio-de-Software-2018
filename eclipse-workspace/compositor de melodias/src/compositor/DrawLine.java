package compositor;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawLine extends JPanel {
	
	/*
	 * (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		 
//	     //vertical line
//	     g.setColor(Color.red);
//	     g.drawLine(20, 20, 20, 120);
//	 
	     //horizontal line
	     g.setColor(Color.green);
	     g.drawLine(20, 20, 420, 20);
	 
//	     //diagonal line 
//	     g.setColor(Color.blue);
//	     g.drawLine(20, 20, 120, 120);

	 
	}
	
	public static void main(String[] args) {
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Draw Line");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.white);
	    frame.setSize(200, 200);
	    DrawLine panel = new DrawLine();
	    frame.add(panel);
	    frame.setVisible(true);
	  }

}
