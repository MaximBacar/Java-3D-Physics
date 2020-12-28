package pif.points;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.Arrays;

public class Matrix {
	
	
	
	public static double [][] multiplyMat(double[][] pts, double[][] mat){
		double[][] nvxMat = new double[pts.length][3];
		
		for (int i = 0; i<pts.length; i++) {
			nvxMat[i][0] = (mat[0][0] * pts[i][0] + mat[0][1]*pts[i][1] + mat[0][2]*pts[i][2]);
			nvxMat[i][1] = (mat[1][0] * pts[i][0] + mat[1][1]*pts[i][1] + mat[1][2]*pts[i][2]);
			nvxMat[i][2] = (mat[2][0] * pts[i][0] + mat[2][1]*pts[i][1] + mat[2][2]*pts[i][2]);
		}
		
		return nvxMat;
	}
	
	
	public static Point3D [] multiplyMat(Point3D[] pts, double[][] mat){
		double[][] newMat = new double[pts.length][3];
		Point3D[] newPoints = new Point3D[pts.length];
		
		for (int i = 0; i<pts.length; i++) {
			newPoints[i] = new Point3D();
			newMat[i][0] = (mat[0][0] * pts[i].getX() + mat[0][1]*pts[i].getY() + mat[0][2]*pts[i].getZ());
			newMat[i][1] = (mat[1][0] * pts[i].getX() + mat[1][1]*pts[i].getY() + mat[1][2]*pts[i].getZ());
			newMat[i][2] = (mat[2][0] * pts[i].getX() + mat[2][1]*pts[i].getY() + mat[2][2]*pts[i].getZ());
		}
		
		for (int i = 0; i<pts.length; i++) {
			newPoints[i].setX(newMat[i][0]);
			newPoints[i].setY(newMat[i][1]);
			newPoints[i].setZ(newMat[i][2]);
		}
		
		
		return newPoints;
	}
	
	
	public static Point2D.Double[] to2d (Point3D[] pts) {
		
		Point2D.Double[] points = new Point2D.Double[pts.length];
		double e = 	50.00000;
		
		
		for (int i = 0; i<points.length; i++) {
			points[i] = new Point2D.Double();
		}
		
		for (int i = 0; i<pts.length; i++) {
			
			points[i].setLocation( (-1.00000f*e*(pts[i].getY())) / (pts[i].getX()-e), (-1.00*e*(pts[i].getZ())) / (pts[i].getX()-e));
		}
		
		
		return points;
	}
	
	public static void toString(Point3D[] m) {
		String mm = "";
		
		for (int i = 0; i < m.length; i++) {
			mm = mm + "["+m[i].getX()+" ";
			mm = mm + m[i].getY()+ " ";
			mm = mm + m[i].getZ()+ "]";
			mm = mm + "\n";
		}
		
		System.out.println(mm);
		
		
	}

}
