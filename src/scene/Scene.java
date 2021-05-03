/**
 * 
 */
package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

/**
 * @author Avigail Amar and Yocheved Wattenberg 
 *
 */
public class Scene {

	/**
	 * Class Scene 
	 * 
	 * This class is PDS so all fields with public permission, and there is no getters
	 *
	 */
	public String name; 
	public Color background = Color.BLACK;
	public AmbientLight ambientLight = new AmbientLight(Color.BLACK,0);
	public Geometries geometries = new Geometries();  
	
	/**
	 * Constructor scene 
	 * 
	 * @param name the name to set to the new scene 
	 */	
	public Scene(String name) {
		this.name = name; 
		this.geometries = new Geometries(); 
	}

	/**
	 * @param background the background to set
	 * @return the scene
	 */
	public Scene setBackground(Color background) {
		this.background = background;
		return this; 
	}

	/**
	 * @param ambientLight the ambientLight to set
	 * @return the scene
	 */
	public Scene setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
		return this; 
	}

	/**
	 * @param geometries the geometries to set
	 * @return the scene
	 */
	public Scene setGeometries(Geometries geometries) {
		this.geometries = geometries;
		return this; 
	}

	@Override
	public String toString() {
		return "Scene [name=" + name + ", background=" + background + ", ambientLight=" + ambientLight + ", geometries="
				+ geometries + "]";
	}
	
	

	
}
