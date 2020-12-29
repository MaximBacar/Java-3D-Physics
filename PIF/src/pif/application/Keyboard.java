package pif.application;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import pif.engine.Render;
import pif.objects.Polygon3D;

public class Keyboard implements KeyListener {
	
	
	public Keyboard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) Polygon3D.setxOffset(Polygon3D.getxOffset() - 1);
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) Polygon3D.setxOffset(Polygon3D.getxOffset() + 1);
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) Render.start();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}

}
