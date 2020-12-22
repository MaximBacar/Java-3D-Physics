package pif.points;


public class Point3D {
	
	public int x;
	public int y;
	public int z;
	
	
	
	public Point3D () {
		
	}
	
	
	public Point3D (int x, int y, int z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	

	
	public float distance (Point3D p) {
		
		return (float) Math.sqrt(Math.pow(x - p.x , 2) + Math.pow(y - p.y , 2) + Math.pow(z - p.z , 2));
		
	}



}

