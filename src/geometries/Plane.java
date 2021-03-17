package geometries;

import primitives.*;

public class Plane implements Geometry {
	private Point3D point3d;
	private Vector vector;

	public Plane(Point3D point3d, Vector vector) {
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
	
	public Vector getVector() {
		return vector;
	}

	@Override
	public String toString() {
		return "Plane [point3d=" + point3d + ", vector=" + vector + "]";
	}

	public Vector getNormal(Point3D pnt) {
		return null;
	}
}