package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight {

	private Vector direction; 
	
	/**
	 * SpotLight Ctor
	 * 
	 * @param intensity
	 * @param position
	 * @param direction
	 */
	public SpotLight(Color intensity, Point3D position, Vector direction) {
		super(intensity, position);
		this.direction = direction;
	}
	@Override
	public Color getIntensity(Point3D p) 
	{
		double max=direction.dotProduct(getL(p).normalize());
		if (max<0) max=0;
		return super.getIntensity(p).scale(max) ;	
	}
	
}
