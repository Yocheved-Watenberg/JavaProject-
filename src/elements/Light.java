package elements;

import primitives.Color;

/**
 * Abstract Class Light 
 *
 */
abstract class Light {
	
	private Color intensity; 

	/**
	 * Light constructor 
	 * @param intensity
	 */
	protected Light(Color intensity) {
		this.intensity = intensity;
	}

	/**
	 * @return the intensity
	 */
	public Color getIntensity() {
		return intensity;
	}
	
	
}
