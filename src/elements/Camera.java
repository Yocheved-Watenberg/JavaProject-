package elements;

import primitives.*;

/**
 * @author Avigail Amar & Yocheved Watenberg
 *
 */
public class Camera {

	/**
	 * Class camera 
	 */
	
	private Point3D p0;				//camera localization 
	private Vector vTo;				//vector director "to" of the camera
	private Vector vUp;				//vector director "up" of the camera
	private Vector vRight;			//vector director "right" of the camera 
	private double width;			//width of the view plane 
	private double height;			//height of the view plane 
	private double distance;		//distance from the camera to the view plane 
	
	
	
	@Override
	public String toString() {
		return "Camera [p0=" + p0 + ", vTo=" + vTo + ", vUp=" + vUp + ", vRight=" + vRight + ", width=" + width
				+ ", height=" + height + ", distance=" + distance + "]";
	}


	/**
	 * @return the p0
	 */
	public Point3D getp0() {
		return p0;
	}


	/**
	 * @return the vTo
	 */
	public Vector getvTo() {
		return vTo;
	}


	/**
	 * @return the vUp
	 */
	public Vector getvUp() {
		return vUp;
	}


	/**
	 * @return the vRight
	 */
	public Vector getvRight() {
		return vRight;
	}

	/**
	 * @param p0
	 * @param vTo
	 * @param vUp
	 */
	public Camera(Point3D p0, Vector vTo, Vector vUp) {
		if (vUp.dotProduct(vTo)==0) {
		this.p0 = p0;
		this.vTo = vTo;
		this.vUp = vUp;	
		this.vRight= vTo.crossProduct(vUp);
		this.vTo.normalize();
		this.vUp.normalize();
		this.vRight.normalize();
		}
		else {
			throw new IllegalArgumentException("The vector vUp have to be orthogonal to vto");
		}
	}
	
	/** 
	 * 
	 * @param width
	 * @param height
	 * @return the object Camera
	 */
	public Camera setViewPlaneSize(double width, double height) {
		this.width=width;
		this.height=height;
		return this; 
	}
	

	/** 
	 * 
	 * @param distance
	 * @return the object Camera
	 */
	public Camera setDistance(double distance) 
	{
		this.distance=distance;
		return this;
	}
	
	
	/**
	 * 
	 * @param nX : number of columns : width of a row
	 * @param nY : number of rows : height of a column
	 * @param j : column of the pixel
	 * @param i : row of the pixel
	 * @return the Ray constructed through the pixel
	 */
	public Ray constructRayThroughPixel(int nX, int nY, int j, int i) 
	{
	Point3D Pc=p0.add(vTo.scale(distance));					//center 
	double Ry=height/nY;									//pixel height
	double Rx=width/nX;										//pixel width 
	double xj=(j-(nX-1)/2.0)*Rx;							//how much we move horizontally
	double yi=-(i-(nY-1)/2.0)*Ry;							//how much we move vertically
	Point3D Pij=Pc;											
	if(!Util.isZero(xj)) Pij=Pij.add(vRight.scale(xj));  	//move horizontally 
	if(!Util.isZero(yi)) Pij=Pij.add(vUp.scale(yi));		//move vertically 
	Vector Vij=p0.subtract(Pij); 							//Pij-p0
	return new Ray(p0,Vij); 		//return the ray with p0 and the vector director (normalized by the ctor of ray) 
	}

}