package primitives;

import java.util.List;
import geometries.Intersectable.GeoPoint;

public class Ray {
	Point3D p0;
	Vector dir;

	/**
	 * Ray constructor receiving the point of beginning and a director vector
	 * 
	 * @param p0  the point of the beginning of the ray
	 * @param dir the director vector
	 */
	public Ray(Point3D p0, Vector dir) {
		dir.normalize();
		this.p0 = p0;
		this.dir = dir;
	}

	/**
	 * function get
	 * 
	 * @return p0 the point of the beginning of the ray
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * function get
	 * 
	 * @return dir the director vector of the ray
	 */
	public Vector getDir() {
		return dir;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (p0 == null) {
			if (other.p0 != null)
				return false;
		} else if (!p0.equals(other.p0))
			return false;
		if (dir == null) {
			if (other.dir != null)
				return false;
		} else if (!dir.equals(other.dir))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", direction=" + dir + "]";
	}


	public Point3D getPoint(double t) 
	{
		return p0.add(dir.scale(t));
	}
	
	/**	
	 * function findClosestPoint
	 * 
	 * @param l list of points
	 * @return closest point of p0
	 */
	public Point3D findClosestPoint (List<Point3D> l){
		if (l.isEmpty()) 
			return null;	
		Point3D pointMin = l.get(0);						//we initialize the closest point with the first value of the list
		double distanceMin = p0.distance(pointMin);			//we calculate its distance to p0
		for (int i=1; i<l.size(); i++) {					//for all the others points
			   if(p0.distance(l.get(i)) < distanceMin)		//if they are closest to p0 than the min 
		           pointMin = l.get(i);						//we change the min
			   	   distanceMin= p0.distance(pointMin);		//and the distanceMin
		}
		return pointMin;									//return the closest point to p0 of the list
	}
	
	
	/**	
	 * function findClosestGeoPoint
	 * 
	 * @param l list of points
	 * @return closest GeoPoint of p0
	 */
	public GeoPoint findClosestGeoPoint (List<GeoPoint> l){
		if (l.isEmpty()) 
			return null;	
		GeoPoint pointMin = l.get(0);						//we initialize the closest point with the first value of the list
		double distanceMin = p0.distance(pointMin.point);			//we calculate its distance to p0
		for (int i=1; i<l.size(); i++) {					//for all the others points
			   if(p0.distance(l.get(i).point) < distanceMin)		//if they are closest to p0 than the min 
		           pointMin = l.get(i);						//we change the min
			   	   distanceMin= p0.distance(pointMin.point);		//and the distanceMin
		}
		return pointMin;									//return the closest point to p0 of the list
	}
	
	
}