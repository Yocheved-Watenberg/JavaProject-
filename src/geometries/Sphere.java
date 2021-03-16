package geometries;

import primitives.Coordinate;
import primitives.Point3D;
import primitives.Vector;

public class Sphere implements Geometry{
	private double radius;
	private Point3D center;
	
	
	public Sphere( double radius, Point3D center) {
		super();
		this.radius = radius;
		this.center = center;
	}
	
	public Sphere() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sphere(Sphere sphe) {
		this.setRadius(sphe.getRadius());
		this.setCenter(sphe.getCenter());
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public Point3D getCenter() {
		return center;
	}
	public void setCenter(Point3D center) {
		this.center = center;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Sphere other = (Sphere) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Sphere [radius=" + radius + ", center=" + center + "]";
	}
	
	public Vector getNormal(Point3D pnt){
	return null; 	
	}

}
