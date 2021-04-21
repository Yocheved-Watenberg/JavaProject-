package geometries;

import java.util.List;
import primitives.*;

/**
 * Sphere class implements geometry (have a function getNormal)
 * @author Avigail Amar and Yocheved Wattenberg
 */
public class Sphere implements Geometry {
	private double radius;
	private Point3D center;

	/**
	 * Sphere constructor to create a sphere with the center and a radius
	 * @param center : a point3D for the center
	 * @param radius : a number for the length of the radius
	 */
	public Sphere(Point3D center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	/**
	 * function get to get the radius of the sphere 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * function get to get the center of the sphere
	 * @return center 
	 */
	public Point3D getCenter() {
		return center;
	}

	@Override
	public String toString() {
		return "Sphere [radius=" + radius + ", center=" + center + "]";
	}

	/**
	 * function getNormal to get the normal of the sphere on a Point3D
	 * @param pnt : the point for the normal
	 * @return the normal vector
	 */
	public Vector getNormal(Point3D pnt) {
		return getCenter().subtract(pnt);
	}

	/**
	 * function findIntersections to find the intersections of a sphere by a ray
	 * 
	 * @return list of intersection points
	 */
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		if (ray.getP0().equals(center)) {
			return List.of(ray.getPoint(radius));
		} 
		else {
			Vector u = ray.getP0().subtract(center);
			double tm = u.dotProduct(ray.getDir());
			double d = Math.sqrt(u.lengthSquared() - (tm * tm));
			if (d >= radius)
				return null;
			double th = Math.sqrt((radius * radius) - (d * d));
			double t1 = th + tm;
			double t2 = tm - th;
			if (t1 <= 0 && t2 <= 0)
				return null;
			else {
				if (t1 > 0 && t2 > 0)
				 return List.of(ray.getPoint(t1),ray.getPoint(t2));
				else if (t1 > 0 )
					return List.of(ray.getPoint(t1));
				else if (t2 > 0)
					return List.of(ray.getPoint(t2));
			}
			return null; 
		}
	}

}