package pif.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

import pif.points.Matrix;
import pif.points.Point3D;

public class Cube {
	
	
	final int [][] pos = {
			
//			x	 y	  z
			 {-500,-500 ,-500},
			 {500,-500,-500},
			 {500,500,-500},
			 {-500,500,-500},
			 {-500,-500,500},
			 {500,-500,500},
			 {500,500,500},
			 {-500,500,500},

	};
	
	Polygon3D[] polygons;
	
	private float xDegrees;
	private float yDegrees;
	private float zDegrees;
	
	private int posX;
	private int posY;
	private int posZ;
	
	
	private Point3D[] points;
	private Point3D[] newPoints;
	
	public Cube() {
		
	
		
		points = new Point3D[pos.length];
		polygons = new Polygon3D[6];
		
		newPoints = new Point3D[pos.length];
		
		for (int i = 0; i<pos.length; i++) {
			points[i] = new Point3D();
			points[i].setX(pos[i][0]);
			points[i].setY(pos[i][1]);
			points[i].setZ(pos[i][2]);
		}
		
		
		for (int i = 0; i<pos.length; i++) {
			newPoints[i] = new Point3D();
			newPoints[i].setX(points[i].getX());
			newPoints[i].setY(points[i].getY());
			newPoints[i].setZ(points[i].getZ());
		}
		
		
		xDegrees = 0;
		yDegrees = 0;
		zDegrees = 0;
		
		posX = 0;
		posY = 0;
		posZ = 0;
		 
		
		
	}
	
	public Cube(int dx, int dy, int dz) {
		
	
		
		points = new Point3D[pos.length];
		
		newPoints = new Point3D[pos.length];
		
		for (int i = 0; i<pos.length; i++) {
			points[i] = new Point3D();
			points[i].setX(pos[i][0]);
			points[i].setY(pos[i][1]);
			points[i].setZ(pos[i][2]);
		}
		
		
		for (int i = 0; i<pos.length; i++) {
			newPoints[i] = new Point3D();
			newPoints[i].setX(points[i].getX());
			newPoints[i].setY(points[i].getY());
			newPoints[i].setZ(points[i].getZ());
		}
		
		
		xDegrees = 0;
		yDegrees = 0;
		zDegrees = 0;
		
		posX = dx;
		posY = dy;
		posZ = dz;
		 
		
		
	}
	

	
	public void rotateTranslate (float degX, float degY, float degZ, int dx, int dy, int dz) {
		
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
		
		
		Point3D[] pt = Matrix.multiplyMat(points, matRotZ);
		
		
		
		
		for (int j  = 0 ; j<pt.length; j++) {
			
			pt[j].setX(pt[j].getX() * -1);
			pt[j].setY(pt[j].getY() * -1);
			pt[j].setZ(pt[j].getZ() * -1);
			
		}
		
		pt = Matrix.multiplyMat(pt, matRotY);
		

		
		for (int j  = 0 ; j<pt.length; j++) {
			
			pt[j].setX(pt[j].getX() * -1);
			pt[j].setY(pt[j].getY() * -1);
			pt[j].setZ(pt[j].getZ() * -1);
			
			
		}
		
		
		
		pt = Matrix.multiplyMat(pt, matRotX);
		
		for (int i = 0 ; i < pos.length; i++) {
			
			pt[i].setX((int)(pt[i].getX()+dx));
			pt[i].setY((int)(pt[i].getY()+dy));
			pt[i].setZ((int)(pt[i].getZ()+dz));
			
		}
		
		newPoints = pt;
			
	}
	

	public float getxDegrees() {
		return xDegrees;
	}

	public void setxDegrees(float xDegrees) {
		this.xDegrees = xDegrees;
		
	}

	public float getyDegrees() {
		return yDegrees;
	}

	public void setyDegrees(float yDegrees) {
		this.yDegrees = yDegrees;
		
	}

	public float getzDegrees() {
		return zDegrees;
	}

	public void setzDegrees(float zDegrees) {
		this.zDegrees = zDegrees;
		
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
		
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
		
	}

	public int getPosZ() {
		return posZ;
	}

	public void setPosZ(int posZ) {
		this.posZ = posZ;
		
	}

	
	
	public void render(Graphics2D g2d) {
		rotateTranslate(xDegrees, yDegrees, zDegrees, posX, posY, posZ);
		
		
		polygons[0] = new Polygon3D(newPoints[0], newPoints[1], newPoints[2], newPoints[3]);
		polygons[1] = new Polygon3D(newPoints[1], newPoints[2], newPoints[6], newPoints[5]);
		polygons[2] = new Polygon3D(newPoints[4], newPoints[5], newPoints[6], newPoints[7]);
		polygons[3] = new Polygon3D(newPoints[0], newPoints[3], newPoints[7], newPoints[4]);
		polygons[4] = new Polygon3D(newPoints[0], newPoints[1], newPoints[5], newPoints[4]);
		polygons[5] = new Polygon3D(newPoints[2], newPoints[3], newPoints[7], newPoints[6]);
		
		
		
		
		
		for (Polygon3D poly : polygons) {
			poly.render(g2d);
		}
	}
	
	
	
	
	
	

	
	

}
