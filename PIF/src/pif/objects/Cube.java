package pif.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

import pif.points.Matrix;
import pif.points.Point3D;

public class Cube {
	
	
	int [][] pos = {
			
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
	
	
	
	
	private float xDegrees;
	private float yDegrees;
	private float zDegrees;
	
	private int posX;
	private int posY;
	private int posZ;
	
	ArrayList<Point3D> pts;
	Polygon3D p1;
	
	public Cube() {
		
		pts = new ArrayList<Point3D>();
		
		
		
		for (int i = 0; i < pos.length; i++) {
			

			pts.add(new Point3D(pos[i][0], pos[i][1], pos[i][2]));
		}
		
		xDegrees = 0;
		yDegrees = 0;
		zDegrees = 0;
		
		posX = 0;
		posY = 0;
		posZ = 0;
		
		
		p1 = new Polygon3D(pts.get(1), pts.get(2), pts.get(6), pts.get(5));
		
	}
	
	public Cube(int x, int y, int z) {
		
		for (int i = 0; i < pts.size(); i++) {
			
			pts.get(i).x = pos[i][0];
			pts.get(i).y = pos[i][1];
			pts.get(i).z = pos[i][2];
			
		}
		
		xDegrees = 0;
		yDegrees = 0;
		zDegrees = 0;
		
		posX = x;
		posY = y;
		posZ = z;
		translate(posX, posY, posZ);
		
	}
	
	public void rotate (float degX, float degY, float degZ) {
		
		Matrix.rotation(degX, degY, degZ, pts.toArray(new Point3D[pts.size()]));
		
		
	}
	
	public void translate (int dx, int dy, int dz) {
		Matrix.translation(dx, dy, dz, pts.toArray(new Point3D[pts.size()]));
	}
	
	
	

	public float getxDegrees() {
		return xDegrees;
	}

	public void setxDegrees(float xDegrees) {
		this.xDegrees = xDegrees;
		rotate(this.xDegrees, this.yDegrees, this.zDegrees);
	}

	public float getyDegrees() {
		return yDegrees;
	}

	public void setyDegrees(float yDegrees) {
		this.yDegrees = yDegrees;
		rotate(this.xDegrees, this.yDegrees, this.zDegrees);
	}

	public float getzDegrees() {
		return zDegrees;
	}

	public void setzDegrees(float zDegrees) {
		this.zDegrees = zDegrees;
		rotate(this.xDegrees, this.yDegrees, this.zDegrees);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
		translate(this.posX, this.posY, this.posZ);
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
		translate(this.posX, this.posY, this.posZ);
	}

	public int getPosZ() {
		return posZ;
	}

	public void setPosZ(int posZ) {
		this.posZ = posZ;
		translate(this.posX, this.posY, this.posZ);
	}

	public Point3D[] getPts() {
		return pts.toArray(new Point3D[pts.size()]);
	}
	
	
	public void render(Graphics2D g2d) {
		p1.render(g2d);
	}
	
	
	
	
	
	

	
	

}
