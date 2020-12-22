package pif.points;


public class Point3D {
	
	public int x = 0;
	public int y = 0;
	public int z = 0;
	
	
	
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
	
	public int getX () {
		return x;
	}
	

	
	public float distance (Point3D p) {
		
		return (float) Math.sqrt(Math.pow(x - p.x , 2) + Math.pow(y - p.y , 2) + Math.pow(z - p.z , 2));
		
	}
	
	
	public static void toString(Point3D p) {
		System.out.println("[X="+p.getX());
	}
	
	public void setX(int x) {
		this.x = x;
	}



}

