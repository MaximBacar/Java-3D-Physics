package pif.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

import pif.engine.Render;
import pif.physics.Vector3D;
import pif.physics.physicsEngine;
import pif.points.Matrix;
import pif.points.Point3D;



/**
 * Cube class that contains the rendering and the properties of the cube
 * @author maxim
 *
 */

public class Cube {
	
	
	final int [][] pos = {
			
//			   x  y  z
			 {-5,-5,-5},
			 { 5,-5,-5},
			 { 5, 5,-5},
			 {-5, 5,-5},
			 {-5,-5, 5},
			 { 5,-5, 5},
			 { 5, 5, 5},
			 {-5, 5, 5},

	};
	
	Polygon3D[] polygons;
	
	private double xDegrees;
	private double yDegrees;
	private double zDegrees;
	
	private double posX;
	private double posY;
	private double posZ;
	
	
	private Point3D[] points;
	private Point3D[] newPoints;
	
	
	private double mass;
	private double inertia;
	
	private Vector3D position;
	private Vector3D velocity;
	private Vector3D acceleration;
	
	private Vector3D angularVelocity;
	private Vector3D torque;
	private Vector3D orientation;
	private Vector3D tAccel;
	
	private Vector3D frictionF;
	private Vector3D gravityF;
	private Vector3D totalForces;
	
	
	/**
	 * Initializes cube's properties
	 */
	private void __init__() {
		
		mass = 600;
		inertia = 3;
		
		points = new Point3D[pos.length];
		polygons = new Polygon3D[6];
		
		newPoints = new Point3D[pos.length];
		
		for (int i = 0; i<pos.length; i++) {
			points[i] = new Point3D();
			points[i].setX(pos[i][0]);
			points[i].setY(pos[i][1]);
			points[i].setZ(pos[i][2]);
		}
		
		
		for (int i = 0; i<pos.length; i++) {
			newPoints[i] = new Point3D();
			newPoints[i].setX(points[i].getX());
			newPoints[i].setY(points[i].getY());
			newPoints[i].setZ(points[i].getZ());
		}
		
		
		xDegrees = 0;
		yDegrees = 0;
		zDegrees = 0;
		
		posX = 0;
		posY = 0;
		posZ = 0;
		 
		position = new Vector3D(posX,posY,posZ);
		velocity = new Vector3D(0,0,0);
		acceleration = new Vector3D();
		angularVelocity = new Vector3D();
		torque = new Vector3D(0,0,0);
		orientation = new Vector3D();
		tAccel = new Vector3D();
		
		gravityF = physicsEngine.calculForceGrav(mass);
		frictionF = new Vector3D();
		
		polygons[0] = new Polygon3D(newPoints[0], newPoints[1], newPoints[2], newPoints[3]);
		polygons[1] = new Polygon3D(newPoints[1], newPoints[2], newPoints[6], newPoints[5]);
		polygons[2] = new Polygon3D(newPoints[4], newPoints[5], newPoints[6], newPoints[7]);
		polygons[3] = new Polygon3D(newPoints[0], newPoints[3], newPoints[7], newPoints[4]);
		polygons[4] = new Polygon3D(newPoints[0], newPoints[1], newPoints[5], newPoints[4]);
		polygons[5] = new Polygon3D(newPoints[2], newPoints[3], newPoints[7], newPoints[6]);
		
	}
	
	/**
	 * Creates a cube at the origin with no angles
	 */
	public Cube() {
		
		__init__();
		
	}
	
	/**
	 * Creates a cube at a certain position
	 * 
	 * @param dx The position of the cube on the X axis (in meters)
	 * @param dy The position of the cube on the Y axis (in meters)
	 * @param dz The position of the cube on the Z axis (in meters)
	 */
	public Cube(int dx, int dy, int dz) {
	
		__init__();
		posX = dx;
		posY = dy;
		posZ = dz;
		position.setX(posX);
		position.setY(posY);
		position.setZ(posZ);
		
	}
	
	/**
	 * Creates a cube at a certain position and at a certain angle
	 * 
	 * @param dx The position of the cube on the X axis (in meters)
	 * @param dy The position of the cube on the Y axis (in meters)
	 * @param dz The position of the cube on the Z axis (in meters)
	 * @param xdeg The angle of the cube on the X axis (in degrees)
	 * @param ydeg The angle of the cube on the Y axis (in degrees)
	 * @param zdeg The angle of the cube on the Z axis (in degrees)
	 */
	public Cube(double dx, double dy, double dz, double xdeg, double ydeg, double zdeg) {
		
		__init__();
		posX = dx;
		posY = dy;
		posZ = dz;
		position.setX(posX);
		position.setY(posY);
		position.setZ(posZ);
		
		
		xDegrees = xdeg;
		yDegrees = ydeg;
		zDegrees = zdeg;
		orientation.setX(xDegrees);
		orientation.setY(yDegrees);
		orientation.setZ(zDegrees);
		
		
		
		
	}
		
	/**
	 * Function that rotates and translate every points of the cube
	 * 
	 * @param xdeg The angle of the cube on the X axis (in degrees)
	 * @param ydeg The angle of the cube on the Y axis (in degrees)
	 * @param zdeg The angle of the cube on the Z axis (in degrees)
	 * @param dx The position of the cube on the X axis (in meters)
	 * @param dy The position of the cube on the Y axis (in meters)
	 * @param dz The position of the cube on the Z axis (in meters)
	 */
	public void rotateTranslate (double xDeg, double yDeg, double zDeg, double dx, double dy, double dz) {
		
		double[][] matRotZ = {
				 {Math.cos(Math.toRadians(zDeg)) , -Math.sin(Math.toRadians(zDeg)), 0},
				 {Math.sin(Math.toRadians(zDeg)) , Math.cos(Math.toRadians(zDeg)), 0},
				 {0,0,1}
		 };
		
		double[][] matRotY = {
				 {Math.cos(Math.toRadians(yDeg)) , 0, Math.sin(Math.toRadians(yDeg))},
				 {0 , 1, 0},
				 {-1.0000* Math.sin(Math.toRadians(yDeg)),0,Math.cos(Math.toRadians(yDeg))}
		 };
		
		double[][] matRotX = {
				{1 , 0, 0},
				{0, Math.cos(Math.toRadians(xDeg)), -Math.sin(Math.toRadians(xDeg))}, 
				{0, Math.sin(Math.toRadians(xDeg)),Math.cos(Math.toRadians(xDeg))}
		 };
		
		newPoints = Matrix.multiplyMat(points, matRotZ);
		newPoints = Matrix.multiplyMat(newPoints, matRotY);
		newPoints = Matrix.multiplyMat(newPoints, matRotX);
		
		for (int i = 0 ; i < pos.length; i++) {
			
			newPoints[i].setX((newPoints[i].getX()+dx));
			newPoints[i].setY((newPoints[i].getY()+dy));
			newPoints[i].setZ((newPoints[i].getZ()+dz));
			
		}
		
	}
	
	/**
	 * Returns the angle on the X axis
	 * 
	 * @return The angle on the X axis in degrees
	 */
	public double getxDegrees() {
		return xDegrees;
	}

	/**
	 * Sets the angle on the X axis
	 * 
	 * @param xDegrees The angle on the X axis in degrees
	 */
	public void setxDegrees(float xDegrees) {
		
		this.xDegrees = xDegrees;
		orientation.setX(this.xDegrees);
		
	}

	/**
	 * Returns the angle on the Y axis
	 * 
	 * @return  The angle on the Y axis in degrees
	 */
	public double getyDegrees() {
		return yDegrees;
	}

	/**
	 * Sets the angle on the Y axis
	 * 
	 * @param yDegrees The angle on the Y axis in degrees
	 */
	public void setyDegrees(float yDegrees) {
		orientation.setY(this.yDegrees);
		
	}

	/**
	 * Returns the angle on the Z axis
	 * 
	 * @return The angle on the Z axis in degrees
	 */
	public double getzDegrees() {
		return zDegrees;
	}

	/**
	 * Sets the angle on the Z axis
	 * 
	 * @param zDegrees The angle on the Z axis in degrees
	 */
	public void setzDegrees(float zDegrees) {
		orientation.setZ(this.zDegrees);
	}

	/**
	 * Returns the position on the X axis
	 * 
	 * @return The position on the X axis in meters
	 */
	public double getPosX() {
		return posX;
	}

	/**
	 * Sets the position on the X axis
	 * 
	 * @param posX The position on the X axis in meters
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}

	/**
	 * Returns the position on the Y axis
	 * 
	 * @return The position on the Y axis in meters
	 */
	public double getPosY() {
		return posY;
	}

	/**
	 * Sets the position on the Y axis
	 * 
	 * @param posY The position on the Y axis in meters
	 */
	public void setPosY(double posY) {
		this.posY = posY;
		
	}

	/**
	 * Returns the position on the Z axis
	 * 
	 * @return The position on the Z axis in meters
	 */
	public double getPosZ() {
		return posZ;
	}

	/**
	 * Sets the position on the Z axis
	 * 
	 * @param posZ The position on the Z axis in meters
	 */
	public void setPosZ(double posZ) {
		this.posZ = posZ;
	}
	
	/**
	 * Returns the 3D Polygons of the cube
	 * 
	 * @return The 3D Polygons of the cube
	 */
	public Polygon3D[] getPolygon() {
		return polygons;
	}
	
	/**
	 * Sets the torque of the Cube (only for tests)
	 * 
	 * @param x Torque on the X axis
	 * @param y Torque on the Y axis
	 * @param z Torque on the Z axis
	 */
	public void setTorque(double x, double y, double z) {
		
		torque.setX(x);
		torque.setY(y);
		torque.setZ(z);
		
	}

	/**
	 * Renders the cube to the screen 
	 * Renders the cube's polygon to create the shape
	 * 
	 * @param g2d The Graphics2D environment
	 */
	public void render(Graphics2D g2d) {
		
		rotateTranslate(xDegrees, yDegrees, zDegrees, posX, posY, posZ);
		
		polygons[0].newPts(newPoints[0], newPoints[1], newPoints[2], newPoints[3]);
		polygons[1].newPts(newPoints[1], newPoints[2], newPoints[6], newPoints[5]);
		polygons[2].newPts(newPoints[4], newPoints[5], newPoints[6], newPoints[7]);
		polygons[3].newPts(newPoints[0], newPoints[3], newPoints[7], newPoints[4]);
		polygons[4].newPts(newPoints[0], newPoints[1], newPoints[5], newPoints[4]);
		polygons[5].newPts(newPoints[2], newPoints[3], newPoints[7], newPoints[6]);
		
		g2d.setColor(Color.gray);
		
		for (Polygon3D poly : polygons) {
			
			poly.render(g2d);
		}
		
		g2d.setColor(Color.green);
		
		Point2D[] p2d = Matrix.to2d(newPoints);
		
		for (Point2D p : p2d) {
			g2d.fillRect(Render.meterToPixel(p.getX())-2, Render.meterToPixely(p.getY())-2, 4, 4);
		}
		
		g2d.fillOval(Render.meterToPixel(posY)-2, Render.meterToPixely(posZ)-2, 4, 4);
		
	}
	
	/**
	 * Calculates the physics of one step of a deltaT
	 * 
	 * @param deltaT The time period on which the physic is calculated
	 */
	public void oneStep(double deltaT) {
		
		
		totalForces = frictionF.add(gravityF);
		
		xDegrees = (orientation.getX());
		yDegrees = (orientation.getY());
		zDegrees = (orientation.getZ());
		
		

		try {
			acceleration = physicsEngine.calculAcceleration(totalForces, mass);
			tAccel = physicsEngine.calculTorqueAcceleration(torque, inertia);
		} catch (Exception e) {
			System.out.println("Erreur calcul accélération (masse nulle)");
		}
		velocity = physicsEngine.calculVitesse(deltaT, velocity, acceleration);
		position = physicsEngine.calculPosition(deltaT, position, velocity);
		
		angularVelocity = physicsEngine.angularVelocity(deltaT, angularVelocity, tAccel);
		orientation = physicsEngine.orientation(deltaT, orientation, angularVelocity);
		
		
		posX = ( position.getX());
		posY = (position.getY());
		posZ = (position.getZ());
		
		if(posZ <= -30 ) {
			
			velocity.setZ(-0.5*velocity.getZ());
			
		}
		
	}

}
