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
		float i = 1;
		while (true) {
			
			if (running)i++;
			
			if (i > 360) i = 0;
				
			
			c.setxDegrees(0);
			c.setyDegrees(i);
			c.setzDegrees(i);
			
			
			c.setPosZ(-1000);
			c.setPosY(-1000);
			repaint();
			
			
			try {
				Thread.sleep(1000/140);
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
	
	public static int meterToPixel(double d) {
		double met = d/100;
		
		return (int) ((met + WIDTH/20)*10)-5;
	}
	public static int meterToPixely(double d) {
		double met = -d/100;
		
		return (int) ((met + HEIGHT/20)*10)-5;
	}
	
	

}
