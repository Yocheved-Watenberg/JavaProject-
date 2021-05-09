package geometries;

import primitives.*;

/**
 *Geometry interface for all the geometries that have a normal  
 * @author Avigail Amar & Yocheved Watenberg 
 */

public abstract class Geometry implements Intersectable {
	
	private Material material= new Material(); 
	protected Color emission=Color.BLACK;
	
	
	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}
	
	/**
	 * @return the emission
	 */
	public Color getEmission() {
		return emission;
	}
	
	/**
	 * @param material: the material to set
	 */
	public Geometry setMaterial(Material material) {
		this.material = material;
		return this; 
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
