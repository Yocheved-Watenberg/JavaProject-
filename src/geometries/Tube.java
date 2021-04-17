package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Tube implements Geometry {
	Ray axisRay;
	double radius;

	public Tube(Ray axisRay, double radius)
	{
		this.axisRay = axisRay;
		this.radius = radius;
	}

	public Ray getAxisRay() 
	{
		return axisRay;
	}

	public double getRadius() 
	{
		return radius;
	}

	@Override
	public String toString() {
		return "Tube [axisRay=" + axisRay + ", radius=" + radius + "]";
	}

	@Override
	public Vector getNormal(Point3D myPoint3D) 
	{	//First we try to find the center of the tube,so:
		Vector vector1=axisRay.getP0().substract(myPoint3D)	;		//we create a vector which is a difference between the center of the ray and the point sent
		Vector vector2=axisRay.getDir().normalized();				//we normalize the axis Ray
		double t=vector1.dotProduct(vector2);
		Point3D	myCenter;
		if (t!=0) {
		myCenter=axisRay.getP0().add((vector2).scale(t));	//we start by P0 and we continue in the direction of the axisRay t times 
		}
		else {
		myCenter=axisRay.getP0(); 
		}
		return (myCenter.substract(myPoint3D).normalize());			
		}

}

