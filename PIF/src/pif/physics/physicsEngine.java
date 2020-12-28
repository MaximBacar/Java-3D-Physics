package pif.physics;



public class physicsEngine {
	
	private static double ACCEL_GRAV = 9.8066;
	private static final double EPSILON = 1e-10; 
	
	
	public static Vector3D calculAcceleration(Vector3D sommeDesForces, double masse) throws Exception { 
		if(masse < EPSILON) 
			throw new Exception("Error: the mass is null");
		else
			return new Vector3D( sommeDesForces.getX()/masse , sommeDesForces.getY()/masse , sommeDesForces.getZ()/masse );	
	}
	
	public static Vector3D calculTorqueAcceleration(Vector3D torque, double inertia) throws Exception { 
		
		if(inertia < EPSILON) 
			throw new Exception("Error: the inertia is null");
		else
			return new Vector3D( torque.getX()/inertia , torque.getY()/inertia , torque.getZ()/inertia );	
	}

	
	public static Vector3D calculVitesse(double deltaT, Vector3D vitesse, Vector3D accel) {
		Vector3D deltaVitesse = Vector3D.scalarMultiplication(accel, deltaT);
		Vector3D resultVit = vitesse.add( deltaVitesse );
		return new Vector3D(resultVit.getX(), resultVit.getY(), resultVit.getZ());
		
	}
	
	public static Vector3D angularVelocity (double deltaT, Vector3D angularVelocity, Vector3D accel){
			
		
		Vector3D deltaVelocity = Vector3D.scalarMultiplication(accel, deltaT);
		Vector3D result = angularVelocity.add(deltaVelocity);
		return new Vector3D(result.getX(), result.getY(), result.getZ());
		
		
	}
	
	public static Vector3D orientation (double deltaT, Vector3D orientation, Vector3D angualrVelocity) {
		
		Vector3D deltaOrientation = Vector3D.scalarMultiplication(angualrVelocity, deltaT);
		Vector3D resultOr = orientation.add(deltaOrientation); 
		return new Vector3D(resultOr.getX(), resultOr.getY(), resultOr.getZ());
		
	}
	
	
	public static Vector3D calculPosition(double deltaT, Vector3D position, Vector3D vitesse) {
		Vector3D deltaPosition = Vector3D.scalarMultiplication(vitesse, deltaT);
		Vector3D resultPos = position.add(deltaPosition); 
		return new Vector3D(resultPos.getX(), resultPos.getY(), resultPos.getZ());
		
	}
	
	
	
	public static Vector3D calculForceGrav(double masse) {
		return new Vector3D( 0, 0, -ACCEL_GRAV * masse); 
	}

	
	public static Vector3D calculForceNormale(double masse) {
		return new Vector3D( 0,0, ACCEL_GRAV * masse); 
	}
	
	
	
	
	public static Vector3D calculForceFriction(double mu, double masse, Vector3D vitesse) {
		if (vitesse.getX() > 0 ) {
			return new Vector3D(0,-mu*(ACCEL_GRAV*masse),0); 
		} else { 
			return new Vector3D(0,mu*(ACCEL_GRAV*masse),0); 
		}
	}

	
	public static double getEpsilon() {
		return EPSILON;
	}
	

}
