package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 *Interface LightSource 
 */
public interface LightSource {
	
	/**
	 * 
	 * @param p : the point 
	 * @return its color
	 */
	public Color getIntensity(Point3D p);
	
	/**
	 * 
	 * @param p : a point 
	 * @return the direction of the light source 
	 */
	public Vector getL(Point3D p);
}