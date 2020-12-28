package pif.physics;

import java.awt.Polygon;
import java.awt.geom.Area;
import java.awt.geom.Point2D;

import pif.objects.Polygon3D;
import pif.points.Point3D;

public class Collisions {
	
	
	public static boolean pointPolygon3D (Point3D p, Polygon3D poly) {
		
		return false;
		
	}
	
	public static boolean pointPolygon (Point2D p, Polygon poly) {
		
		
		return true;
	}
	
	public static boolean polygonPolygon (Polygon poly, Polygon poly2) {
		
		boolean collision = false;
		
		Area a1 = new Area(poly);
		Area a2 = new Area(poly2);
		
		Area inter = a1;
		
		inter.intersect(a2);
		
		if (inter.isEmpty()) {
			collision = false;
		}
		else {
			collision = true;
			
		}
		return collision;
		
		
		
	}

}
