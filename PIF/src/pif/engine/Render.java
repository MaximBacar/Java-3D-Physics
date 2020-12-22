package pif.engine;

import javax.swing.JPanel;

public class Render extends JPanel implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Thread processusAnim;
	
	
	
	public Render () {
		
		processusAnim = new Thread(this);
		processusAnim.start();
		
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("percs");
		}
		
	}

}
