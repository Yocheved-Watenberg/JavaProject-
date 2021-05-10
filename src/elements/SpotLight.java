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
	 * @param kC
	 * @param kL
	 * @param kQ
	 * @param direction
	 */
	protected SpotLight(Color intensity, Point3D position, double kC, double kL, double kQ, Vector direction) {
		super(intensity, position, kC, kL, kQ);
		this.direction = direction;
	}
	@Override
	public Color getIntensity(Point3D p) 
	{
		double max=direction.dotProduct(getL(p).normalize());
		if (max<0)
			max=0;
		return super.getIntensity(p).scale(max) ;
		
	}
	
}
