package pif.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import pif.points.Matrix;
import pif.points.Point3D;

public class Polygon3D {
	
	private final static int HEIGHT = 500;
	private final static int WIDTH = 1000;
	
	
	Point3D[] pts;
	
	public Polygon3D (Point3D...pts) {
		
		this.pts = pts;
		
	}
	
	public void render(Graphics2D g2d) {
		Polygon polygon = new Polygon();
		Point[] p = (Point[]) Matrix.to2d(pts);
		for (int i = 0; i < pts.length; i++) {
			polygon.addPoint(meterToPixel(p[i].x) , meterToPixely(p[i].y));
			
			
			
		}
		g2d.draw(polygon);
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
