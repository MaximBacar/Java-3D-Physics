package pif.engine;

import java.awt.Polygon;
import java.util.Arrays;

import pif.objects.Cube;
import pif.objects.Polygon3D;
import pif.physics.Collisions;
import pif.points.Point3D;

public class Collider {
	
	Cube[] cubes;
	
	public Collider (Cube... cubes) {
		
		this.cubes = cubes;
		
	}
	
	
	private int[] nearCubes () {
		int[] closeCubes = new int [2];
		if (cubes.length == 2){
			closeCubes[0] = 0;
			closeCubes[1] = 1;
		}
		
		else if (cubes.length < 2) {
			closeCubes[0] = 0;
			closeCubes[1] = 0; 
		}
		
		else {
			Point3D[] p = new Point3D[cubes.length];
			for (int i = 0; i<cubes.length; i++) {
				
				p[i] = new Point3D(cubes[i].getPosX(),cubes[i].getPosY(),cubes[i].getPosZ());
				
			}
			double distance = 1e100;
			
			for (int i = 0; i<cubes.length; i++) {
				for (int j = 0; j<cubes.length; j++) {
					
					if(p[i].distance(p[j]) < distance && p[i].distance(p[j])>0) {
						
						distance = p[i].distance(p[j]);
						
						closeCubes[0] = i;
						closeCubes[1] = j;
						
					}
					
					
				}
			}
		}
		
		
		return closeCubes;
	}
	
	private int[] nearPolygons(int[] cube) {
		Cube c1 = cubes[cube[0]];
		Cube c2 = cubes[cube[1]];
		
		Polygon3D[] p1 = c1.getPolygon();
		Polygon3D[] p2 = c2.getPolygon();
		
		double distance = 1e100;
		int[] closePoly = new int [2];
		
		for (int i = 0; i<p1.length; i++) {
			for (int j = 0; j<p2.length; j++) {
				double d = p1[i].getAveragePoints().distance(p2[j].getAveragePoints());
				if(d < distance && d > 0) {
					distance = d;
					closePoly[0] = i;
					closePoly[1] = j;
				}
			}
		}
		
		return closePoly;
		
	}
	
	public void update() {
		if (cubes.length>1) {
			Polygon p1 = cubes[nearCubes()[0]].getPolygon()[nearPolygons(nearCubes())[0]].getPolygon2D();
			Polygon p2 = cubes[nearCubes()[1]].getPolygon()[nearPolygons(nearCubes())[1]].getPolygon2D();
			
			if (Collisions.polygonPolygon(p1, p2) == true) {
				System.out.println("============================");
				
			}
		}
		
	}

}
