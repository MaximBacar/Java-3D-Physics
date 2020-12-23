package pif.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import pif.objects.Cube;

public class Render extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Thread processusAnim;
	
	Cube c;
	
	public Render () {
		
		
		
		c = new Cube();
		
		processusAnim = new Thread(this);
		processusAnim.start();
		
	}

	@Override
	public void run() {
		float i = 1;
		while (true) {
			
			i++;
			c.setzDegrees(i);
			c.setPosZ(2);
			repaint();
			//c.translate(0, (int)-i, 0);
			
			try {
				Thread.sleep(1000/100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.red);
		//g2d.drawRect(100, 100, 200, 200);
		c.render(g2d);
		
		
	}
	
	

}
