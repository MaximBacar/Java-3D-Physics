package pif.points;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Arrays;

public class Matrix {
	
	
	
	public static int [][] multiplyMat(int[][] pts, double[][] mat){
		int[][] nvxMat = new int[pts.length][3];
		
		for (int i = 0; i<pts.length; i++) {
			nvxMat[i][0] = (int) (mat[0][0] * pts[i][0] + mat[0][1]*pts[i][1] + mat[0][2]*pts[i][2]);
			nvxMat[i][1] = (int) (mat[1][0] * pts[i][0] + mat[1][1]*pts[i][1] + mat[1][2]*pts[i][2]);
			nvxMat[i][2] = (int) (mat[2][0] * pts[i][0] + mat[2][1]*pts[i][1] + mat[2][2]*pts[i][2]);
		}
		
		return nvxMat;
	}
	
	public static Point3D [] multiplyMat(Point3D[] pts, double[][] mat){
		int[][] newMat = new int[pts.length][3];
		Point3D[] newPoints = new Point3D[pts.length];
		
		for (int i = 0; i<pts.length; i++) {
			newPoints[i] = new Point3D();
			newMat[i][0] = (int) (mat[0][0] * pts[i].getX() + mat[0][1]*pts[i].getY() + mat[0][2]*pts[i].getZ());
			newMat[i][1] = (int) (mat[1][0] * pts[i].getX() + mat[1][1]*pts[i].getY() + mat[1][2]*pts[i].getZ());
			newMat[i][2] = (int) (mat[2][0] * pts[i].getX() + mat[2][1]*pts[i].getY() + mat[2][2]*pts[i].getZ());
		}
		
		for (int i = 0; i<pts.length; i++) {
			newPoints[i].setX(newMat[i][0]);
			newPoints[i].setY(newMat[i][1]);
			newPoints[i].setZ(newMat[i][2]);
		}
		
		
		return newPoints;
	}
	
	
	
	
	
	public static Point2D[] to2d (Point3D[] pts) {
		
		Point2D[] p = new Point[pts.length];
		double e = 	6500;
		
		
		for (int i = 0; i<p.length; i++) {
			p[i] = new Point();
		}
		
		for (int i = 0; i<pts.length; i++) {
			
			p[i].setLocation( (-1*e*(pts[i].getY())) / (pts[i].getX()-e), (-1*e*(pts[i].getZ() - 0)) / (pts[i].getX()-e));
		}
		
		
		return p;
	}

}
