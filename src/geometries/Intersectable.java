/**
 * 
 */

package geometries;

import java.util.List;

import primitives.*;

/**
 *Intersectable interface for all the geometries that it should be an intersection  
 * 
 * @author Avigail Amar & Yocheved Watenberg 
 */

public interface Intersectable {
	
	/**
	 *function to find intersections with a ray 
	 *@param ray which intersect 
	 *@return a list of intersections points 
	 * 
	 */
	List<Point3D> findIntersections(Ray ray);
}
