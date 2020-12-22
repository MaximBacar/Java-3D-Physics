package pif.points;


public class Point3D {
	
	int x;
	int y;
	int z;
	
	
	
	public Point3D () {
		
	}
	
	
	public Point3D (int x, int y, int z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public void setX (int x) {
		
		this.x = x;
		
	}
	
	public void setY (int y) {
		
		this.y = y;
		
	}
	
	public void setZ (int z) {
		
		this.z = z;
		
	}
	
	public int x () {
		
		return x;
		
	}
	
	public int y () {
		
		return y;
		
	}
	
	public int z () {
		
		return z;
		
	}
	
	public float distance (Point3D p) {
		
		return (float) Math.sqrt(Math.pow(x - p.x , 2) + Math.pow(y - p.y , 2) + Math.pow(z - p.z , 2));
		
	}



}

