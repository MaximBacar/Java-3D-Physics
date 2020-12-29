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
	
	private static int HEIGHT = 1000;
	private static int WIDTH = 1000;
	
	private Thread processusAnim;
	
	static boolean running = false;
	
	double tempsTotalEcoule = 0;
	private double deltaT = 0.01;
	
	Cube c;
	Cube c2;
	Cube c3;
	Collider col;
	
	
	public Render () {
		
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				System.out.println(e.getX());
			}
		}); 	
	
		
		
		c = new Cube(0,10,0,0,45,0);
		c2 = new Cube();
		c3 = new Cube(-0,20,0);
		
		
		
		col = new Collider(c,c2, c3);
		
		processusAnim = new Thread(this);
		processusAnim.start();
		
	}

	@Override
	public void run() {
		while (true) {
			if (running) {
				
				
				
				calculerUneIterationPhysique(deltaT);
				
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
		
		
		//col.update();
		
	}
	
	public void calculerUneIterationPhysique(double deltaT) {
		tempsTotalEcoule += deltaT;
		c.oneStep(deltaT);
		c2.oneStep(deltaT);
		c3.oneStep(deltaT);


		//System.out.println("\nTemps total simulé écoulé: "  + String.format("%.3f",tempsTotalEcoule) + "sec (en temps simulé!)");
	}
	
	
	
	public static int meterToPixel(double d) {
		double met = d;
		
		return (int) ((met + WIDTH/20)*10)-5;
	}
	public static int meterToPixely(double d) {
		double met = -d;
		
		return (int) ((met + HEIGHT/20)*10)-5;
	}
	
	public static void start () {
		running = true;
	}
	

}
