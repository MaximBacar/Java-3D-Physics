package pif.points;


public class Point3D {
	
	private int x = 0;
	private int y = 0;
	private int z = 0;
	
	
	
	public Point3D () {
		x = 0;
		y = 0;
		z = 0;
	}
	
	
	public Point3D (int x, int y, int z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	

	

	
	public float distance (Point3D p) {
		
		return (float) Math.sqrt(Math.pow(x - p.x , 2) + Math.pow(y - p.y , 2) + Math.pow(z - p.z , 2));
		
	}
	
	
	public static void toString(Point3D p) {
		System.out.println("[X="+p.x+" Y="+p.y+" Z="+p.z+"]");
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getZ() {
		return z;
	}


	public void setZ(int z) {
		this.z = z;
	}
	
	
	



}

