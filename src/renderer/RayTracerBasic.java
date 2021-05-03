/**
 * 
 */
package renderer;

import java.util.List;

import primitives.Color;
import primitives.Point3D;
import primitives.Ray;
import scene.Scene;

/**Class RayTracerBasic 
 *
 */
public class RayTracerBasic extends RayTracerBase {

	/**
	 * the constructor inherits from his father 
	 */
	public RayTracerBasic(Scene scene) {
		super(scene);
	}

	/**
	 * function traceRay 
	 * @param ray 
	 * @return the color of of the intersection point through this ray  
	 * If there is no intersection with this ray, return the background color
	 * 
	 */
	@Override
	public Color traceRay(Ray ray) {
		 List<Point3D> intersections = scene.geometries.findIntersections(ray); //Find the intersection and the scene’s geometries
		 if (intersections == null) return scene.background;					//If there is no intersection, return the background color
		 Point3D closestPoint = ray.findClosestPoint(intersections);			//Find the closest intersection point
		 return calcColor(closestPoint);										//Find the color of the intersection point (Ambient light)
	}
	
	/***
	 * 
	 *
	 * @param point
	 * @return the color of a pixel
	 */
	private Color calcColor(Point3D point) {
			return scene.ambientLight.getIntensity();
	}

}
