package geometries;

import primitives.*;

/**
 * Plane class implements geometry (have a function getNormal)
 * 
 * @author Avigail Amar and Yocheved Wattenberg
 */
public class Plane implements Geometry {
	private Point3D point3d;
	private Vector normal;

	/**
	 * Plane constructor to create a plane with a point and a normal
	 * 
	 * @param point3d
	 * @param normal
	 */
	public Plane(Point3D point3d, Vector normal) {
		this.point3d = point3d;
		this.normal = normal;
	}

	/**
	 * Plane constructor to create a plane with 3 points
	 * 
	 * @param myPoint3D1
	 * @param myPoint3D2
	 * @param myPoint3D3
	 */
	public Plane(Point3D myPoint3D1, Point3D myPoint3D2, Point3D myPoint3D3) {
		point3d = myPoint3D1;
		Vector v1 = myPoint3D1.substract(myPoint3D2);
		Vector v2 = myPoint3D1.substract(myPoint3D3);
		normal = (v1.crossProduct(v2)).normalize();
	}

	/**
	 * function get to get the point that defines the plane
	 * 
	 * @return point3d
	 */
	public Point3D getPoint3d() {
		return point3d;
	}

	/**
	 * function set to set the point that defines the plane
	 * 
	 * @param point3d
	 */
	public void setPoint3d(Point3D point3d) {
		this.point3d = point3d;
	}

	/**
	 * function get to get the normal that defines the plane
	 * 
	 * @return normal
	 */
	public Vector getVector() {
		return normal;
	}

	/**
	 * function set to set the normal that defines the plane
	 * 
	 * @param normal
	 */
	public void setVector(Vector normal) {
		this.normal = normal;
	}

	@Override
	public String toString() {
		return "Plane [point3d=" + point3d + ", normal=" + normal + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plane other = (Plane) obj;
		if (point3d == null) {
			if (other.point3d != null)
				return false;
		} else if (!point3d.equals(other.point3d))
			return false;
		if (normal == null) {
			if (other.normal != null)
				return false;
		} else if (!normal.equals(other.normal))
			return false;
		return true;
	}

	/**
	 * function getNormal to get the normal of a plane in a specific point
	 * 
	 * @param pnt : a point for a specific normal
	 * @return the normal vector
	 */
	public Vector getNormal(Point3D pnt) {
		return normal;
	}

	/**
	 * function getNormal to get a normal of a plane
	 * 
	 * @return the normal vector
	 */
	public Vector getNormal() {
		return normal;
	}
}