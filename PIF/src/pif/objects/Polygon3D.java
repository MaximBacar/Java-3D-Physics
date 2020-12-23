package pif.objects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;

import pif.engine.Render;
import pif.points.Matrix;
import pif.points.Point3D;

public class Polygon3D {
	
	Point3D[] pts;
	
	
	public Polygon3D (Point3D...pts) {
		
		this.pts = pts;
		
	}
	
	public void newPts (Point3D...pts) {
		this.pts = pts;
	}
	
	public void render(Graphics2D g2d) {
		Polygon polygon = new Polygon();
		Point[] p = (Point[]) Matrix.to2d(pts);
		for (int i = 0; i < pts.length; i++) {
			polygon.addPoint(Render.meterToPixel(p[i].x) , Render.meterToPixely(p[i].y));
			
			
			
		}
		g2d.draw(polygon);
	}
	
	

}
