package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry {
	private double radius;
	private Point3D center;

	public Sphere(Point3D center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public Point3D getCenter() {
		return center;
	}

	@Override
	public String toString() {
		return "Sphere [radius=" + radius + ", center=" + center + "]";
	}

	public Vector getNormal(Point3D pnt) {
		return null;
	}

}
