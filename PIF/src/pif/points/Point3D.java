package pif.points;


public class Point3D {
	
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	
	
	public Point3D () {
		x = 0;
		y = 0;
		z = 0;
	}
	
	
	public Point3D (double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	
	public float distance (Point3D p) {
		
		return (float) Math.sqrt(Math.pow(x - p.x , 2) + Math.pow(y - p.y , 2) + Math.pow(z - p.z , 2));
		
	}
	
	
	public static void toString(Point3D p) {
		System.out.println("[X = "+p.x+", Y = "+p.y+", Z ="+p.z+"]");
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public double getZ() {
		return z;
	}


	public void setZ(double z) {
		this.z = z;
	}
	
	
	



}

