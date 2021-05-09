/**
 * 
 */
package elements;

import primitives.Color;

/**
 * @author Avigail Amar and Yocheved Wattenberg 
 *
 */
public class AmbientLight extends Light {

	/**
	 * Class AmbientLight extends Light
	 */
		
	
	/**
	 * Constructor AmbientLight 
	 * 
	 * Calls its father ctor
	 * 
	 * @param Ia the original fill light (light intensity according to RGB components) 
	 * @param kA the filling light attenuation coefficient
	 * intensity = Ia * kA
	 */
	public AmbientLight(Color Ia, double kA) {
		super(Ia.scale(kA)); 
	}
	
	/**
	 * Default constructor for AmbientLight 
	 * 
	 * Calls its father ctor 
	 * 
	 * initializes the above field to Color.BLACK 
	 */
	public AmbientLight() {
		super(Color.BLACK);
	}

}
