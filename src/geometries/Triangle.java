package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Triangle extends Polygon {

	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		super(p1, p2, p3);
	}

	@Override
	public String toString() {
		return "Triangle [p1=" + vertices.get(0) + ", p2=" + vertices.get(1) + ", p3=" + vertices.get(2) + "]";
	}

	public Vector getNormal(Point3D pnt) {
		return null;
	}

}
