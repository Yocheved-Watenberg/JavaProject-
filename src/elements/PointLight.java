package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 *
 */
public class PointLight extends Light implements LightSource {

	
	private Point3D position; 
	private double kC = 1;
	private double kL = 0;
	private double kQ = 0;
	
	
	
	/**
	 * PointLight ctor 
	 * 
	 * @param intensity
	 * @param position
	 * @param kC
	 * @param kL
	 * @param kQ
	 */
	protected PointLight(Color intensity, Point3D position, double kC, double kL, double kQ) {
		super(intensity);
		this.position = position;
		this.kC = kC;
		this.kL = kL;
		this.kQ = kQ;
	}

	/**
	 * @param kC the kC to set
	 */
	public PointLight setkC(double kC) {
		this.kC = kC;
		return this;
	}

	/**
	 * @param kL the kL to set
	 */
	public PointLight setkL(double kL) {
		this.kL = kL;
		return this;
	}

	/**
	 * @param kQ the kQ to set
	 */
	public PointLight setkQ(double kQ) {
		this.kQ = kQ;
		return this;
	}

	@Override
	public Color getIntensity(Point3D p) 
	{
		double distance=getL(p).length();
		return intensity.reduce(kC+kL*distance+kQ*distance*distance) ;
	}

	@Override
	public Vector getL(Point3D p) {
		return position.subtract(p);
	}

}
