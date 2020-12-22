package pif.physics;

public class Vector3D {
	
	protected double x;
	protected double y;
	protected double z;
	
	public Vector3D () {
		
		this.x = 0;
		this.y = 0;
		this.z = 0;
		
	}
	
	public Vector3D (double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public Vector3D add (Vector3D v) {
		return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
	}
	
	public static Vector3D add (Vector3D v1, Vector3D v2) {
		
		return new Vector3D(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
		
	}
	

}
