package pif.objects;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Point2D;

import pif.engine.Render;
import pif.points.Matrix;
import pif.points.Point3D;

public class Polygon3D {
	
	Point3D[] pts;
	Polygon poly2d;
	
	
	public Polygon3D (Point3D...pts) {
		
		this.pts = pts;
		
	}
	
	public void newPts (Point3D...pts) {
		this.pts = pts;
	}
	
	public void render(Graphics2D g2d) {
		Polygon polygon = new Polygon();
		Point2D.Double[] p = Matrix.to2d(pts);
		for (int i = 0; i < pts.length; i++) {
			polygon.addPoint(Render.meterToPixel(p[i].x) , Render.meterToPixely(p[i].y));
		
			
		}
		poly2d = polygon;
		g2d.draw(poly2d);
	}
	
	public Polygon getPolygon2D () {
		return poly2d;
	}
	
	public Point3D[] getPoints() {
		return pts;
	}
	
	public Point3D getAveragePoints() {
		double sumX = 0;
		double sumY = 0;
		double sumZ = 0;
		
		for (int i = 0; i< pts.length; i++) {
			sumX = sumX + pts[i].getX();
			sumY = sumY + pts[i].getY();
			sumZ = sumZ + pts[i].getZ();
		}
		
		return new Point3D(sumX/pts.length, sumY/pts.length, sumZ/pts.length);
		
	}
	

}
