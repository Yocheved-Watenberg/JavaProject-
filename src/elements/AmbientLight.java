/**
 * 
 */
package elements;

import primitives.Color;

/**
 * @author Avigail Amar and Yocheved Wattenberg 
 *
 */
public class AmbientLight {

	/**
	 * Class AmbientLight 
	 */
	Color intensity;
	
	
	/**
	 * Constructor AmbientLight 
	 * 
	 * @param Ia the original fill light (light intensity according to RGB components) 
	 * @param kA the filling light attenuation coefficient
	 * intensity = Ia * kA
	 */
	public AmbientLight(Color Ia, double kA) {
		intensity = Ia.scale(kA);
	}


	/**
	 * @return the intensity
	 */
	public Color getIntensity() {
		return intensity;
	}


}
