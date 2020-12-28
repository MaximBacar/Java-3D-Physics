package pif.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import pif.objects.Cube;
import pif.objects.Polygon3D;
import pif.physics.Collisions;

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
	Cube c3;
	Collider col;
	
	
	public Render () {
		
		addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				running = (running) ? false : true;
			}
		});
		
		
			
				
				 	
		
		
		c = new Cube(0,3000,000,0,0,25);
		c2 = new Cube();
		c3 = new Cube(0,-2000,0);
		
		col = new Collider(c, c2);
		
		processusAnim = new Thread(this);
		processusAnim.start();
		
	}

	@Override
	public void run() {
		int st = 0;
		while (true) {
			
			
			
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
		
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, //Anti-Aliasing
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.setColor(Color.gray);
		c.render(g2d);
		c2.render(g2d);
		c3.render(g2d);
		col.update();
		
	}
	
	public void calculerUneIterationPhysique(double deltaT) {
		tempsTotalEcoule += deltaT;
		c.oneStep(deltaT);
		c2.oneStep(deltaT);


		//System.out.println("\nTemps total simul� �coul�: "  + String.format("%.3f",tempsTotalEcoule) + "sec (en temps simul�!)");
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
