package geometries;

import primitives.*;

public class Plane implements Geometry {
	private Point3D point3d;
	private Vector normal;

	public Plane(Point3D point3d, Vector normal) 
	{
		super();
		this.point3d = point3d;
		this.normal = normal;
	}
	/**
	 * 
	 * @param myPoint3D1
	 * @param myPoint3D2
	 * @param myPoint3D3
	 * ecrire ce que la func fait 
	 * @return
	 */
	public Plane(Point3D myPoint3D1,Point3D myPoint3D2,Point3D myPoint3D3){ 
		point3d=myPoint3D1;
		Vector 	v1 = myPoint3D1.substract(myPoint3D2);
		Vector 	v2 = myPoint3D1.substract(myPoint3D3);
		normal= (v1.crossProduct(v2)).normalize();
	}

	public Point3D getPoint3d() {
		return point3d;
	}

	public void setPoint3d(Point3D point3d) {
		this.point3d = point3d;
	}

	public Vector getVector() {
		return normal;
	}

	public void setVector(Vector normal) {
		this.normal = normal;
	}

	@Override
	public String toString() {
		return "Plane [point3d=" + point3d + ", normal=" + normal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point3d == null) ? 0 : point3d.hashCode());
		result = prime * result + ((normal == null) ? 0 : normal.hashCode());
		return result;
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

	public Vector getNormal(Point3D pnt)
	{
		return normal;
	}
	
	public Vector getNormal()
	{
		return normal;
	}
}