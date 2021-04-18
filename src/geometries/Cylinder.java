package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * Tube class extends tube
 * @author Avigail Amar and Yocheved Wattenberg
 */
public class Cylinder extends Tube {
	
	double height;

	/**
	 * Cylinder constructor to create a cylinder = tube + height 
	 * @param myAxisRay : to create the tube
	 * @param myRadius : to create the tube
	 * use the constructor of tube with these 2 params 
	 * @param myHeight : in addition to the tube
	 */
	public Cylinder(Ray myAxisRay, double myRadius, double myHeight) {
		super(myAxisRay, myRadius);
		height = myHeight;
	}

	/**
	 * function get to get the height of the cylinder 
	 * @return height 
	 */
	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", axisRay=" + axisRay + ", radius=" + radius + "]";
	}

	/**
	 * function getNormal to get the normal of a cylinder on a Point3D
	 * @param myPoint3D
	 * @return the normal vector
	 */
	public Vector getNormal(Point3D myPoint3D) {
		return null;
	}

}
