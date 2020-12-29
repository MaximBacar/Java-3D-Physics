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
	
	private static int xOffset = -40;
	private static int yOffset = 0;
	
	
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
		
		Polygon camera = new Polygon();
		
		for (int i = 0; i <poly2d.npoints; i++) {
			camera.addPoint(poly2d.xpoints[i] + xOffset, poly2d.ypoints[i] + yOffset);
		}
		g2d.draw(camera);
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

	public static int getxOffset() {
		return xOffset;
	}

	public static void setxOffset(int xOffset) {
		Polygon3D.xOffset = xOffset;
	}

	public static int getyOffset() {
		return yOffset;
	}

	public static void setyOffset(int yOffset) {
		Polygon3D.yOffset = yOffset;
	}
	
	
	

}
