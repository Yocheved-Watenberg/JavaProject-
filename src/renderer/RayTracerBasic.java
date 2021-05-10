/**
 * 
 */
package renderer;

import java.util.List;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;
import primitives.*;
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
		 List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray); //Find the intersection and the scene’s geometries
		 if (intersections == null) return scene.background;						//If there is no intersection, return the background color
		 GeoPoint closestPoint = ray.findClosestGeoPoint(intersections);			//Find the closest intersection point
		 return calcColor(closestPoint,ray);											//Find the color of the intersection point (Ambient light)
	}
	
	/***
	 * 
	 * @param point
	 * @return the color of a pixel
	 */
	//private Color calcColor(GeoPoint gp,Ray ray ) {
	//		return scene.ambientLight.getIntensity().add(gp.geometry.getEmission());
	//}
	private Color calcColor(GeoPoint intersection, Ray ray) {
		return scene.ambientLight.getIntensity()
		.add(intersection.geometry.getEmission())
		// add calculated light contribution from all light sources)
		.add(calcLocalEffects(intersection, ray));
		}
	private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
		Vector v = ray.getDir (); 
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = Util.alignZero(n.dotProduct(v)); 
		if (nv == 0) return Color.BLACK;
		Material material = intersection.geometry.getMaterial();
		Color color = Color.BLACK;
		for (LightSource lightSource : scene.lights) {
		Vector l = lightSource.getL(intersection.point);
		double nl = Util.alignZero(n.dotProduct(l));
		if (nl * nv > 0) { // sign(nl) == sing(nv)
		Color lightIntensity = lightSource.getIntensity(intersection.point);
		color = color.add(calcDiffusive(material.kD, l, n, lightIntensity),
		calcSpecular(material.kS, l, n, v, material.nShininess, lightIntensity));
		}
		}
		return color;
		}
	Color calcSpecular(double kS,Vector l, Vector n, Vector v,int nShininess, Color lightIntensity)
	{
		Vector r= l.subtract(n.scale(2*l.dotProduct(n))) ;
		double max=(-1)*v.dotProduct(r);
		if(max<0)
		 max=0;
		return lightIntensity.scale(kS*Math.pow(max,nShininess));
	}
	Color calcDiffusive(double kD, Vector l, Vector n, Color lightIntensity)
	{
		return lightIntensity.scale(kD*(int)(l.dotProduct(n)));
	}




}
