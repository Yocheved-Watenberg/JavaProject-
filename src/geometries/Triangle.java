package geometries;

import java.util.List;
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

	/**
	 * function findIntersections to find the intersections of a triangle by a ray 
	 * 
	 * @return list of intersection points
	 */
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		// First check the intersections with the plane
		Point3D point3d = vertices.get(0);
		Vector v = vertices.get(0).subtract(vertices.get(1));
		Vector w = vertices.get(1).subtract(vertices.get(2));
		Vector normal = (v.crossProduct(w)).normalize();
		Plane plane = new Plane(point3d, normal);
		if (plane.findIntersections(ray) == null)
			return null;

		// After check if they're in the triangle
		Vector v1 = (ray.getP0().subtract(vertices.get(0)));
		Vector v2 = (ray.getP0().subtract(vertices.get(1)));
		Vector v3 = (ray.getP0().subtract(vertices.get(2)));
		Vector N1 = (v1.crossProduct(v2)).normalize();
		Vector N2 = (v2.crossProduct(v3)).normalize();
		Vector N3 = (v3.crossProduct(v1)).normalize();
		if (Util.alignZero(ray.getDir().dotProduct(N1)) == 0 || Util.alignZero(ray.getDir().dotProduct(N2)) == 0
				|| Util.alignZero(ray.getDir().dotProduct(N3)) == 0)
			return null;

		if ((ray.getDir().dotProduct(N1) > 0 && ray.getDir().dotProduct(N2) > 0 && ray.getDir().dotProduct(N3) > 0)
				|| (ray.getDir().dotProduct(N1) < 0 && ray.getDir().dotProduct(N2) < 0
						&& ray.getDir().dotProduct(N3) < 0)) {
			return plane.findIntersections(ray);
		}

		else
			return null;

	}

}