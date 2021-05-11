/**
 * 
 */
package renderer;

import java.util.List;

import elements.LightSource;
import geometries.Intersectable.GeoPoint;
import primitives.*;
import scene.Scene;

/**
 * Class RayTracerBasic
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
	 * 
	 * @param ray
	 * @return the color of of the intersection point through this ray If there is
	 *         no intersection with this ray, return the background color
	 * 
	 */
	@Override
	public Color traceRay(Ray ray) {
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray); // Find the intersection and the
																					// scene’s geometries
		if (intersections == null)
			return scene.background; // If there is no intersection, return the background color
		GeoPoint closestPoint = ray.findClosestGeoPoint(intersections); // Find the closest intersection point
		return calcColor(closestPoint, ray); // Find the color of the intersection point (Ambient light)
	}

	/***
	 * 
	 * @param point
	 * @return the color of a pixel
	 */
	private Color calcColor(GeoPoint intersection, Ray ray) {
		return scene.ambientLight.getIntensity().add(intersection.geometry.getEmission())
				// add calculated light contribution from all light sources
				.add(calcLocalEffects(intersection, ray));
	}

	/**
	 * @param intersection and a ray
	 * @return the color calculated by the diffused and refracted ray
	 * 
	 */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
		Vector v = ray.getDir();
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = Util.alignZero(n.dotProduct(v));
		if (nv == 0)
			return Color.BLACK;
		Material material = intersection.geometry.getMaterial();
		Color color = Color.BLACK;
		for (LightSource lightSource : scene.lights) {
			Vector l = lightSource.getL(intersection.point);
			double nl = Util.alignZero(n.dotProduct(l));
			if (nl * nv > 0) { 												// sign(nl) == sing(nv)
				Color lightIntensity = lightSource.getIntensity(intersection.point);
				l = l.normalize();
				n = n.normalize();
				double dp = l.dotProduct(n); 						// help parameter for the next functions 
				color = color.add(calcDiffusive(material.kD, lightIntensity, dp),
						calcSpecular(material.kS, l, n, v, material.nShininess, lightIntensity, dp));
			}
		}
		return color;
	}

	/***
	 * 
	 * @params kS(reduction factor)
	 * @param l(ray from the lamp to the object)
	 * @param n(normal),nShininess(shininess),light intensity 
	 * @param dp(dot product between l and v)
	 * @return the color changed by the refraction
	 */

	Color calcSpecular(double kS, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity, double dp) {
		v = v.normalize();
		Vector r = l.subtract(n.scale(2 * dp));
		return lightIntensity.scale(kS * Math.pow(Math.max(0, (-1) * v.dotProduct(r)), nShininess));
	}

	/**
	 * 
	 * @param kD(reduction factor)
	 * @param light intensity
	 * @param dp(dot product between l and  v)
	 * @return the color changed by the diffusion
	 */
	Color calcDiffusive(double kD, Color lightIntensity, double dp) {
		return lightIntensity.scale(kD * Math.abs(dp));
	}

}
