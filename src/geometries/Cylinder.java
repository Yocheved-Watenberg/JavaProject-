package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube {
	
	double height;

	public Cylinder(Ray myAxisRay, double myRadius, double myHeight) {
		super(myAxisRay, myRadius);
		height = myHeight;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Cylinder [height=" + height + ", axisRay=" + axisRay + ", radius=" + radius + "]";
	}

	public Vector getNormal(Point3D myPoint3D) {
		return null;
	}

}
