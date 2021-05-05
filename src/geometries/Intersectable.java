package geometries;

import java.util.List;

import primitives.*;

/**
 *Intersectable interface for all the geometries that it should be an intersection  
 * @author Avigail Amar & Yocheved Watenberg 
 */

public interface Intersectable {

	/**
	 * 
	 * si tu pe mettre toi stp 
	 */
	public static class GeoPoint 
	{
	    
		public Geometry geometry;
	    public Point3D point;
	    /**
	     * Constructor of Geo points with 2 parameters:
		 * @param geometry
		 * @param point
		 */
		public GeoPoint(Geometry geometry, Point3D point) {
			super();
			this.geometry = geometry;
			this.point = point;
		}
		/**
		 * Equals to compare the parameters of two objects of type GeoPoints
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeoPoint other = (GeoPoint) obj;
			if (geometry == null) {
				if (other.geometry != null)
					return false;
			} else if (!geometry.equals(other.geometry))
				return false;
			if (point == null) {
				if (other.point != null)
					return false;
			} else if (!point.equals(other.point))
				return false;
			return true;
		}
		
	}

	/**
	 *function to find intersections with a ray 
	 *@param ray which intersect 
	 *@return a list of intersections points 
	 * 
	 */
	List<Point3D> findIntersections(Ray ray);
	List<GeoPoint> findGeoIntersections(Ray ray);
}
