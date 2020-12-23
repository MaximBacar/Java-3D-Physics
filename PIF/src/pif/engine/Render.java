package pif.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import pif.objects.Cube;

public class Render extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int HEIGHT = 800;
	private static int WIDTH = 1000;
	
	private Thread processusAnim;
	
	boolean running = false;
	
	double tempsTotalEcoule = 0;
	private double deltaT = 0.010;
	
	Cube c;
	
	public Render () {
		
		addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				running = (running) ? false : true;
			}
		});
			
				
				 	
		
		
		c = new Cube();
		
		processusAnim = new Thread(this);
		processusAnim.start();
		
	}

	@Override
	public void run() {
		while (true) {
			
			
			
			if (running)calculerUneIterationPhysique(deltaT);
			
			
			repaint();
			
			
			try {
				Thread.sleep(1000/500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.green);
		c.render(g2d);
		
		
	}
	
	public void calculerUneIterationPhysique(double deltaT) {
		tempsTotalEcoule += deltaT;
		c.oneStep(deltaT);


		System.out.println("\nTemps total simulé écoulé: "  + String.format("%.3f",tempsTotalEcoule) + "sec (en temps simulé!)");
	}
	
	public static int meterToPixel(double d) {
		double met = d/100;
		
		return (int) ((met + WIDTH/20)*10)-5;
	}
	public static int meterToPixely(double d) {
		double met = -d/100;
		
		return (int) ((met + HEIGHT/20)*10)-5;
	}
	
	

}
