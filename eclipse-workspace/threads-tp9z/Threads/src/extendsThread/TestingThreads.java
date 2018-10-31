package extendsThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestingThreads implements Runnable{

    private Thread thread = null;
	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestingThreads window = new TestingThreads();
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
	public TestingThreads() {
		initialize();
		initializeWritterOnScreen();
		createAndStartThread();
	}

	private void createAndStartThread() {
		thread = new Thread(this, "thread esritor");
		thread.start();
	}

	private void initializeWritterOnScreen() {
		label = new JLabel();
	    label.setText("a");
	    label.setBounds(0, 0, 200, 50);
	    frame.getContentPane().add(label, BorderLayout.WEST);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		Thread myThread = Thread.currentThread();
		while (thread == myThread) {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				writeOnScreen();
			} catch (InterruptedException e) {}
		}
		
	}

	private void writeOnScreen() {
		label.setText(label.getText()+" a ");
	}

}
