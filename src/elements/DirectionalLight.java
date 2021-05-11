package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 *
 */
public class DirectionalLight extends Light implements LightSource{


	private Vector direction; 
	
	/**
	 * Directional ctor 
	 * 
	 * @param intensity
	 * @param direction
	 */
	public DirectionalLight(Color intensity, Vector direction) {
		super(intensity);
		this.direction = direction;
	}
	/**
	 * @param Point3D
	 * @return the intensity of the object on a specific point which is reduced by the distance of the point
	 */

	@Override
	public Color getIntensity(Point3D p) {
		return 	intensity;
	}
	/**
	 * @param Point3D 
	 * @return the vector direction 
	 */
	@Override
	public Vector getL(Point3D p) {
		return direction.normalize();
	}

}
