package pif.objects;

import pif.points.Matrix;
import pif.points.Point3D;

public class Cube {
	
	private int [][] pos = {
			
	//			x	 y	  z
			 {-500,-500,-500},
			 { 500,-500,-500},
			 { 500, 500,-500},
			 {-500, 500,-500},
			 {-500,-500, 500},
			 { 500,-500, 500},
			 { 500, 500, 500},
			 {-500, 500, 500},

	};
	
	private Point3D [] pts = new Point3D [pos.length];
	
	
	private float xDegrees;
	private float yDegrees;
	private float zDegrees;
	
	private int posX;
	private int posY;
	private int posZ;
	
	public Cube() {
		
		for (int i = 0; i < pts.length; i++) {
			
			pts[i].x = pos[i][0];
			pts[i].y = pos[i][1];
			pts[i].z = pos[i][2];
			
		}
		
		xDegrees = 0;
		yDegrees = 0;
		zDegrees = 0;
		
		posX = 0;
		posY = 0;
		posZ = 0;
		
	}
	
	public void rotate (float degX, float degY, float degZ) {
		
		Matrix.rotation(degX, degY, degZ, pts);
		
	}
	
	private void translate (int dx, int dy, int dz) {
		Matrix.translation(dx, dy, dz, pts);
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
	
	

	
	

}
