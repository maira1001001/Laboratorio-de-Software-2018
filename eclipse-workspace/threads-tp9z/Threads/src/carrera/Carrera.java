package carrera;

import java.awt.EventQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carrera {

	private JFrame frame;
	static final int N_RUNNERS = 5;
	private ExecutorService exec;
	private Runner[] runners;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carrera window = new Carrera();
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
	public Carrera() {
		initialize();
	}

	public static boolean esLaMeta() {
		return false;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		runners = new Runner[N_RUNNERS];
		initializeComponents();
		// initializeRunners();
		// createAndExecuteRunners();
	}

	private void createAndExecuteRunners() {
		exec = Executors.newFixedThreadPool(N_RUNNERS);
		for (int i = 0; i < N_RUNNERS; i++) {
			exec.execute(new Runner(i));
		}
	}

	private void initializeRunners() {
		runners = new Runner[N_RUNNERS];
		for (int i = 0; i < runners.length; i++) {
			runners[i] = new Runner(i);
			exec.execute(runners[0]);
		}
	}

	private void initializeComponents() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(runners[0]);

	}
}
