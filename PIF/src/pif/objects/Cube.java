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

public class Cube {
	
	
	final int [][] pos = {
			
//				x	 y	  z
			 {-5,-5 ,-5},
			 {5,-5,-5},
			 {5,5,-5},
			 {-5,5,-5},
			 {-5,-5,5},
			 {5,-5,5},
			 {5,5,5},
			 {-5,5,5},

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
	
	public Cube() {
		
		__init__();
		
	}
	
	public Cube(int dx, int dy, int dz) {
	
		__init__();
		posX = dx;
		posY = dy;
		posZ = dz;
		position.setX(posX);
		position.setY(posY);
		position.setZ(posZ);
		
		
		
	}
	
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
	

	
	public void rotateTranslate (double xDegrees2, double yDegrees2, double zDegrees2, double dx, double dy, double dz) {
		
		double[][] matRotZ = {
				 {Math.cos(Math.toRadians(zDegrees2)) , -Math.sin(Math.toRadians(zDegrees2)), 0},
				 {Math.sin(Math.toRadians(zDegrees2)) , Math.cos(Math.toRadians(zDegrees2)), 0},
				 {0,0,1}
		 };
		
		double[][] matRotY = {
				 {Math.cos(Math.toRadians(yDegrees2)) , 0, Math.sin(Math.toRadians(yDegrees2))},
				 {0 , 1, 0},
				 {-1.0000* Math.sin(Math.toRadians(yDegrees2)),0,Math.cos(Math.toRadians(yDegrees2))}
		 };
		
		double[][] matRotX = {
				{1 , 0, 0},
				{0, Math.cos(Math.toRadians(xDegrees2)), -Math.sin(Math.toRadians(xDegrees2))}, 
				{0, Math.sin(Math.toRadians(xDegrees2)),Math.cos(Math.toRadians(xDegrees2))}
		 };
		
		
		
		newPoints = Matrix.multiplyMat(points, matRotZ);
		newPoints = Matrix.multiplyMat(newPoints, matRotY);
		newPoints = Matrix.multiplyMat(newPoints, matRotX);
		
		for (int i = 0 ; i < pos.length; i++) {
			
			newPoints[i].setX((newPoints[i].getX()+dx));
			newPoints[i].setY((newPoints[i].getY()+dy));
			newPoints[i].setZ((newPoints[i].getZ()+dz));
			
		}
		
		Matrix.toString(newPoints);
		
		System.out.println(Render.meterToPixel(posY) + " " + Render.meterToPixely(posZ));
		
			
	}
	

	public double getxDegrees() {
		return xDegrees;
	}

	public void setxDegrees(float xDegrees) {
		this.xDegrees = xDegrees;
		orientation.setX(this.xDegrees);
		
		
	}

	public double getyDegrees() {
		return yDegrees;
	}

	public void setyDegrees(float yDegrees) {
		orientation.setY(this.yDegrees);
		
	}

	public double getzDegrees() {
		return zDegrees;
	}

	public void setzDegrees(float zDegrees) {
		
		orientation.setZ(this.zDegrees);
		
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
		
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
		
	}

	public double getPosZ() {
		return posZ;
	}

	public void setPosZ(double posZ) {
		this.posZ = posZ;
		
	}

	
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
		
//		if(posZ <= -50 ) {
//			
//			posZ = -50;
//		}

	}
	
	
	public Polygon3D[] getPolygon() {
		
		return polygons;
		
	}
	
	public void changeDir() {
		//velocity.setZ(velocity.getZ()*-0.5);
	}
	
	public void setTorque(double x, double y, double z) {
		
		torque.setX(x);
		torque.setY(y);
		torque.setZ(z);
		
	}
	
	
	
	
	

	
	

}
