package elements;

import primitives.Point3D;
import primitives.Vector;

/**
 * @author Avigail Amar & Yocheved Watenberg
 *
 */
public class Camera {

	/**
	 * Class camera 
	 */
	
	private Point3D place;
	private Vector vt0;
	private Vector vup;
	private Vector vright;
	
	
	/**
	 * @return the place
	 */
	public Point3D getPlace() {
		return place;
	}


	/**
	 * @return the vt0
	 */
	public Vector getVt0() {
		return vt0;
	}


	/**
	 * @return the vup
	 */
	public Vector getVup() {
		return vup;
	}


	/**
	 * @return the vright
	 */
	public Vector getVright() {
		return vright;
	}

	/**
	 * @param place
	 * @param vt0
	 * @param vup
	 */
	public Camera(Point3D place, Vector vt0, Vector vup) {
		if (vup.dotProduct(vt0)==0) {
		this.place = place;
		this.vt0 = vt0;
		this.vup = vup;	
		this.vright= vt0.crossProduct(vup);
		this.vt0.normalize();
		this.vup.normalize();
		this.vright.normalize();
		}
		else {
			throw new IllegalArgumentException("The vector vup have to be orthogonal to vto");
		}
	}
	
	public Camera setViewPlaneSize(double width, double height) {
		return this; 
	}

}