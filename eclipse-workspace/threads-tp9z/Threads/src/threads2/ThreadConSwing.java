package threads2;

import java.awt.EventQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class ThreadConSwing implements Runnable {

	private JFrame frame;
    private Thread thread = null;
    private JLabel lblImgthreads;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadConSwing window = new ThreadConSwing();
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
	public ThreadConSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initializeFrame();
		initializeIntermittentImage();
		createAndStartThread();
	}

	private void initializeFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void createAndStartThread() {
		thread = new Thread(this, "imagenIntermitenteThread");
		thread.start();
	}

	private void initializeIntermittentImage() {
		lblImgthreads = new JLabel("Imagen Intermitente");
		lblImgthreads.setIcon(new ImageIcon("C:\\Users\\Alumnos\\Desktop\\mai\\Threads\\src\\Juana_Azurduy.jpg"));
		frame.getContentPane().add(lblImgthreads, BorderLayout.CENTER);
		lblImgthreads.setVisible(true);
	}
	
	private void toggleImage() {
		if (lblImgthreads.isVisible()) {
			lblImgthreads.setVisible(false);
		} else lblImgthreads.setVisible(true);
	}

	@Override
	public void run() {
		Thread myThread = Thread.currentThread();
		while (thread == myThread) {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				toggleImage();
			} catch (InterruptedException e) {}
		}
	}


}
