package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Tube class implements geometry (have a function getNormal)
 * @author Avigail Amar and Yocheved Wattenberg
 */
public class Tube implements Geometry {

	/**
	 * axis ray for the center of the tube
	 */
	Ray axisRay;

	/**
	 * radius of the tube
	 */
	double radius;

	/**
	 * Tube constructor to create a tube with a axis ray and a radius
	 * @param axisRay
	 * @param radius
	 */
	public Tube(Ray axisRay, double radius) {
		this.axisRay = axisRay;
		this.radius = radius;
	}

	/**
	 * function get to get the axis ray
	 * @return axisRay
	 */
	public Ray getAxisRay() {
		return axisRay;
	}

	/**
	 * function get to get the radius of the tube
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "Tube [axisRay=" + axisRay + ", radius=" + radius + "]";
	}

	/**
	 * function getNormal to get the normal of the tube on a Point3D
	 * @param myPoint3D
	 * @return the normal vector
	 */
	@Override
	public Vector getNormal(Point3D myPoint3D) { 
		// First we try to find the center of the tube,so:
		Vector vector1 = axisRay.getP0().substract(myPoint3D);  // we create a vector which is a difference between the
																// center of the ray and the point sent
		Vector vector2 = axisRay.getDir().normalized(); 		// we normalize the axis Ray
		double t = vector1.dotProduct(vector2); 				// t=0 if vector 1 and 2 are orthogonal
		Point3D myCenter;
		if (t != 0) {
			myCenter = axisRay.getP0().add((vector2).scale(t)); // we start by P0 and we continue in the direction of
																// the axisRay t times
		} else {
			myCenter = axisRay.getP0();							// if 2 vectors are orthogonal, add 0
		}
		return (myCenter.substract(myPoint3D).normalize());
	}
}
