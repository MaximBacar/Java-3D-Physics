package pif.points;

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
		int[][] nvxMat = new int[pts.length][3];
		
		for (int i = 0; i<pts.length; i++) {
			nvxMat[i][0] = (int) (mat[0][0] * pts[i].x + mat[0][1]*pts[i].y + mat[0][2]*pts[i].z);
			nvxMat[i][1] = (int) (mat[1][0] * pts[i].x + mat[1][1]*pts[i].y + mat[1][2]*pts[i].z);
			nvxMat[i][2] = (int) (mat[2][0] * pts[i].x + mat[2][1]*pts[i].y + mat[2][2]*pts[i].z);
		}
		
		for (int i = 0; i<pts.length; i++) {
			pts[i].x = (nvxMat[i][0]);
			pts[i].y = (nvxMat[i][1]);
			pts[i].z = (nvxMat[i][2]);
		}
		
		return pts;
	}
	
	public static Point3D[] rotation (float degX, float degY, float degZ, Point3D[] pts){
		
		double[][] matRotZ = {
				 {Math.cos(Math.toRadians(degZ)) , -Math.sin(Math.toRadians(degZ)), 0},
				 {Math.sin(Math.toRadians(degZ)) , Math.cos(Math.toRadians(degZ)), 0},
				 {0,0,1}
		 };
		
		double[][] matRotY = {
				 {Math.cos(Math.toRadians(degY)) , 0, Math.sin(Math.toRadians(degY))},
				 {0 , 1, 0},
				 {-1.0000* Math.sin(Math.toRadians(degY)),0,Math.cos(Math.toRadians(degY))}
		 };
		
		double[][] matRotX = {
				{1 , 0, 0},
				{0, Math.cos(Math.toRadians(degX)), -Math.sin(Math.toRadians(degX))}, 
				{0, Math.sin(Math.toRadians(degX)),Math.cos(Math.toRadians(degX))}
		 };
		
		
		
		pts = multiplyMat(pts, matRotZ);
		
		
		
		for (int j  = 0 ; j<pts.length; j++) {
			
			pts[j].x = pts[j].x * -1;
			pts[j].y = pts[j].y * -1;
			pts[j].z = pts[j].z * -1;
			
		}
		
		pts = multiplyMat(pts, matRotY);
		

		
		for (int j  = 0 ; j<pts.length; j++) {
			
			pts[j].x = pts[j].x * -1;
			pts[j].y = pts[j].y * -1;
			pts[j].z = pts[j].z * -1;
			
		}
		
		pts = multiplyMat(pts, matRotX);
		
		
		return pts;
		
	}
	
	public static Point3D[] translation (int dx, int dy, int dz , Point3D[] pts) {
		
		for (int i = 0; i < pts.length; i++) {
			
			pts[i].x = pts[i].x + dx;
			pts[i].y = pts[i].y + dy;
			pts[i].z = pts[i].z + dz;
			
		}
		
		
		return pts;
		
	}

}
