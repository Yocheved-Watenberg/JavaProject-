package geometries;

import primitives.*;

/**
 * Triangle class extends Polygon
 * 
 * @author Avigail Amar and Yocheved Wattenberg
 */
public class Triangle extends Polygon {

	/**
	 * Triangle constructor to create a triangle with 3 points
	 * 
	 * @param p1 (first point)
	 * @param p2 (second point)
	 * @param p3 (third point)
	 */
	public Triangle(Point3D p1, Point3D p2, Point3D p3) {
		super(p1, p2, p3);
	}

	@Override
	public String toString() {
		return "Triangle [p1=" + vertices.get(0) + ", p2=" + vertices.get(1) + ", p3=" + vertices.get(2) + "]";
	}

}