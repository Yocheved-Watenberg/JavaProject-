package geometries;

import primitives.*;

/**
 *Geometry interface for all the geometries that have a normal  
 * @author Avigail Amar & Yocheved Watenberg 
 */

public interface Geometry extends Intersectable {
	
	/**
	 *function to find the normal in a point 
	 *@param point 
	 *@return the normal of the geometry
	 */
	public Vector getNormal(Point3D myPoint3D);
}
