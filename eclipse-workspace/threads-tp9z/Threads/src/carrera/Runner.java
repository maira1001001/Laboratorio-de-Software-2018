package carrera;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Runner extends JPanel implements Runnable {

	private int runner;
	
	public Runner(int runner) {
		this.runner = runner;
	}
	
	@Override
	public void run() {
		while (!Carrera.esLaMeta()) {
			System.out.print("-");
		}
	}
	



}
