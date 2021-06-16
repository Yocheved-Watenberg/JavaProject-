/**
 * 
 */
package scene;

import java.util.LinkedList;
import java.util.List;

import elements.AmbientLight;
import elements.LightSource;
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
	public AmbientLight ambientLight = new AmbientLight();
	public Geometries geometries = new Geometries();  
	public List<LightSource> lights = new LinkedList<LightSource>(); 
	public int numOfRays = 0;
	
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
	

	/**
	 * @param lights the lights to set
	 * @return the scene 
	 */
	public Scene setLights(List<LightSource> lights) {
		this.lights = lights;
		return this;
	}
	
	/**
	 * @param numOfRays the num of rays for blurry
	 * @return the scene 
	 */
	public Scene setNumOfRays(int numOfRays) {
		this.numOfRays = numOfRays;
		return this;
	}

	@Override
	public String toString() {
		return "Scene [name=" + name + ", background=" + background + ", ambientLight=" + ambientLight + ", geometries="
				+ geometries + "]";
	}
	
	

	
}
