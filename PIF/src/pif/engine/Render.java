package pif.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import pif.objects.Cube;

public class Render extends JPanel implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int HEIGHT = 800;
	private static int WIDTH = 1000;
	
	private Thread processusAnim;
	
	boolean running = false;
	
	double tempsTotalEcoule = 0;
	private double deltaT = 0.01;
	
	Cube c;
	Cube c2;
	
	
	public Render () {
		
		addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				running = (running) ? false : true;
			}
		});
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
			}
			
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				int k = e.getKeyCode();
				System.out.println(k);
			}
		});
			
				
				 	
		
		
		c = new Cube(0,3000,000);
		c2 = new Cube();
		
		
		processusAnim = new Thread(this);
		processusAnim.start();
		
	}

	@Override
	public void run() {
		float i = 45;
		int st = 0;
		while (true) {
			
			//c.setxDegrees(i);
			c.setyDegrees(i);
			c.setzDegrees(i);
			
			if (running) {
				
				
				
				calculerUneIterationPhysique(deltaT);
			}
			
			if(c.getPosZ() <= -2610f ) {
				
				if (st - c.getPosZ()  == 0) {
					running = false;
				}
				st = c.getPosZ();
				
				
			}
			
			
			repaint();
			
			
			try {
				Thread.sleep(1000/144);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		
		
		g2d.setColor(Color.gray);
		c.render(g2d);
		c2.render(g2d);
		
	}
	
	public void calculerUneIterationPhysique(double deltaT) {
		tempsTotalEcoule += deltaT;
		c.oneStep(deltaT);
		c2.oneStep(deltaT);


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
