package pif.physics;

public class Vector3D {
	
	private double x;
	private double y;
	private double z;
	
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
		return new Vector3D(this.x + v.getX(), this.y + v.getY(), this.z + v.getZ());
	}
	
	
	public Vector3D scalarMultiplication (double k) {
		
		return new Vector3D( k*x, k*y, k*z);
		
	}
	
	public  static Vector3D scalarMultiplication (Vector3D v, double k) {
		
		return new Vector3D( k*v.getX(), k*v.getY(), k*v.getZ());
		
	}
	
	public double dotProduct (Vector3D v) {
		return v.x * x + v.y * y + v.z * z;
	}
	
	
	
	public static void toString (Vector3D v) {
		System.out.println("[X="+v.x+" Y="+v.y+" Z="+v.z+"]");
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
