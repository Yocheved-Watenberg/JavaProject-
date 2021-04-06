package geometries;

import primitives.*;

public class Plane implements Geometry {
	private Point3D point3d;
	private Vector vector;

	public Plane(Point3D point3d, Vector vector) 
	{
		super();
		this.point3d = point3d;
		this.vector = vector;
	}
	public Plane(Point3D myPoint3D1,Point3D myPoint3D2,Point3D myPoint3D3){
		point3d=myPoint3D1;
		Triangle tr=new Triangle(myPoint3D1,myPoint3D2,myPoint3D3);
		vector=tr.getNormal(point3d);
	}

	public Point3D getPoint3d() {
		return point3d;
	}

	public void setPoint3d(Point3D point3d) {
		this.point3d = point3d;
	}

	public Vector getVector() {
		return vector;
	}

	public void setVector(Vector vector) {
		this.vector = vector;
	}

	@Override
	public String toString() {
		return "Plane [point3d=" + point3d + ", vector=" + vector + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point3d == null) ? 0 : point3d.hashCode());
		result = prime * result + ((vector == null) ? 0 : vector.hashCode());
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
		if (vector == null) {
			if (other.vector != null)
				return false;
		} else if (!vector.equals(other.vector))
			return false;
		return true;
	}

	public Vector getNormal(Point3D pnt)
	{
		Vector v=getPoint3d().substract(pnt);
		return vector.crossProduct(v);
	}
}