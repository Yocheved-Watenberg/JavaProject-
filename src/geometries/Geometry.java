package geometries;

import primitives.*;

/**
 *Geometry interface for all the geometries that have a normal  
 * @author Avigail Amar & Yocheved Watenberg 
 */

public abstract class Geometry implements Intersectable {
	protected Color emission=Color.BLACK;
	
	/**
	 * @return the emission
	 */
	public Color getEmission() {
		return emission;
	}

	/**
	 * @param emission: the emission to set
	 */
	public Geometry setEmission(Color emission) {
		this.emission = emission;
		return this; 
	}
	
	/**
	 *function to find the normal in a point 
	 *@param point 
	 *@return the normal of the geometry
	 */
	public abstract Vector getNormal(Point3D myPoint3D);
}
