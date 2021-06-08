/**
 * 
 */
package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 *Class RayTracerBase to scan the rays 
 */
abstract public class RayTracerBase {


	protected Scene scene;
	
	/**
	 * Constructor of RayTracerBase 
	 * @param the scene 
	 * 
	 */
	public RayTracerBase(Scene myScene) {
		this.scene = myScene;
	}

	
	@Override
	public String toString() {
		return "RayTracerBase [myScene=" + scene + "]";
	}


	/**
	 * abstract function 
	 * @param ray 
	 * @return the color of the intersection point through this ray  
	 * 
	 */
	public abstract Color traceRay (Ray ray);
	
	
	/**
	 * abstract function traceBeamOfRayReflected
	 * @param ray 
	 * @return the color   
	 * 
	 */
	public abstract Color traceBeamOfRayReflected (Ray ray);
	
	
	/**
	 * abstract function traceBeamOfRayRefracted
	 * @param ray 
	 * @return the color   
	 * 
	 */
	public abstract Color traceBeamOfRayRefracted (Ray ray);
}
