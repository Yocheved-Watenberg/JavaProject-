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
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K = 1.0;

	/**
	 * Constant for the principal moving rays for the shading rays
	 */

	/**
	 * Unshading test operation between a point and the source of the light
	 * 
	 * @param light
	 * @param l
	 * @param n
	 * @param geopoint
	 * @return true if unshaded
	 * @return false if there is a shadow
	 */
	private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Ray lightRay = new Ray(geopoint.point, lightDirection, n); // refactored ray head move
		// Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
		// Point3D point = geopoint.point.add(delta);
		// Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);

		if (intersections == null)
			return true;
		double lightDistance = light.getDistance(geopoint.point);
		for (GeoPoint gp : intersections) {
			if (Util.alignZero(gp.point.distance(geopoint.point) - lightDistance) <= 0
					&& gp.geometry.getMaterial().kT == 0)
				return false;
		}
		return true;

	}

	/**
	 * Unshading test operation between a point and the source of the light for a
	 * partial shadow
	 * 
	 * @param ls:      light source
	 * @param l
	 * @param n        : normal
	 * @param geopoint
	 * @return a number between 0 and 1 to the intensity of the shadow
	 */
	private double transparency(LightSource ls, Vector l, Vector n, GeoPoint geoPoint) {
		Vector lightDirection = l.scale(-1); // from point to light source
		Ray lightRay = new Ray(geoPoint.point, lightDirection, n); // refactored ray head move
		double lightDistance = ls.getDistance(geoPoint.point);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);

		if (intersections == null)
			return 1.0;
		double ktr = 1.0;
		for (GeoPoint gp : intersections) {
			if (Util.alignZero(gp.point.distance(geoPoint.point) - lightDistance) <= 0) {
				ktr *= gp.geometry.getMaterial().kT;
				if (ktr < MIN_CALC_COLOR_K)
					return 0.0;
			}
		}
		return ktr;

	}

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
	// public Color traceRay(Ray ray) {
	// List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray); //
	// Find the intersection and the
	// scene?s geometries
	// if (intersections == null)
	// return scene.background; // If there is no intersection, return the
	// background color
	// closestPoint = ray.findClosestGeoPoint(intersections); // Find the closest
	// intersection point
	// return calcColor(closestPoint, ray); // Find the color of the intersection
	// point (Ambient light)
	// }
	public Color traceRay(Ray ray) {
		GeoPoint closestPoint = findClosestIntersection(ray);
		return closestPoint == null ? scene.background : calcColor(closestPoint, ray);
	}

	/***
	 * 
	 * @param point
	 * @return the color of a pixel
	 */
	// private Color calcColor(GeoPoint intersection, Ray ray) {
	// return
	// scene.ambientLight.getIntensity().add(intersection.geometry.getEmission())
	// add calculated light contribution from all light sources
	// .add(calcLocalEffects(intersection, ray));
	// }
	private Color calcColor(GeoPoint geopoint, Ray ray) {
		return calcColor(findClosestIntersection(ray), ray, MAX_CALC_COLOR_LEVEL, INITIAL_K)
				.add(scene.ambientLight.getIntensity());
	}

	/**
	 * function calcColor non recursive
	 * 
	 * @param geoPoint, ray, where to stop the recursia: level, double k
	 * @return the color obtained by the reflection,refraction,diffusive and
	 *         specular rays
	 */
	private Color calcColor(GeoPoint intersection, Ray ray, int level, double k) {
		Color color = intersection.geometry.getEmission();
		color = color.add(calcLocalEffects(intersection, ray, k));
		return level == 1 ? color : color.add(calcGlobalEffects(intersection, ray.getDir(), level, k));
	}

	/**
	 * Recursive function which calls the function calcGlobalEffect
	 * 
	 * @param GeoPoint, Vector v, int level, double k
	 * @return the color obtained by the reflection and refraction rays
	 *
	 */
	private Color calcGlobalEffects(GeoPoint gp, Vector v, int level, double k) {
		Color color = Color.BLACK;
		Vector n = gp.geometry.getNormal(gp.point);
		Material material = gp.geometry.getMaterial();
		double kkr = k * material.kR;
		if (kkr > MIN_CALC_COLOR_K ){
			Ray reflected = constructReflectedRay(gp.point, v, n);
			List<Ray> rays = reflected.splitRay(scene.numOfRays, gp.geometry.getMaterial().getkGlossy());
			Color reflectedColor = Color.BLACK;
			for(var ray : rays) {
				reflectedColor = reflectedColor.add(calcGlobalEffect(ray, level, material.kR, kkr));//if there are a beam of reflected rays instead of one ray
			}
			color = color.add(reflectedColor.reduce(rays.size()));
		}
		double kkt = k * material.kT;
		if (kkt > MIN_CALC_COLOR_K) {
			Ray refracted = constructRefractedRay(gp.point, v, n);
			List<Ray> rays = refracted.splitRay(scene.numOfRays, gp.geometry.getMaterial().getkGlossy());
			Color refractedColor = Color.BLACK;
			for(var ray : rays) {																	//if there are a beam of refracted rays instead of one ray
				refractedColor = refractedColor.add(calcGlobalEffect(ray, level, material.kT, kkt));
			}
			color = color.add(refractedColor.reduce(rays.size()));
		}
		return color;
	}

	/**
	 *
	 * @param ray, level, kx, kkx
	 * @return the color obtained by the reflection and refraction rays
	 */
	private Color calcGlobalEffect(Ray ray, int level, double kx, double kkx) {
		GeoPoint gp = findClosestIntersection(ray);
		return (gp == null ? scene.background : calcColor(gp, ray, level - 1, kkx)).scale(kx);
	}

	/**
	 * @param intersection and a ray
	 * @return the color calculated by the diffused and specular ray
	 * 
	 */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray, double k) {
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
			if (nl * nv > 0) { // sign(nl) == sing(nv)
				double ktr = transparency(lightSource, l, n, intersection);
				if (ktr * k > MIN_CALC_COLOR_K) {
					Color lightIntensity = lightSource.getIntensity(intersection.point).scale(ktr);
					l = l.normalize();
					n = n.normalize();
					double dp = l.dotProduct(n); // help parameter for the next functions
					color = color.add(calcDiffusive(material.kD, lightIntensity, dp),
							calcSpecular(material.kS, l, n, v, material.nShininess, lightIntensity, dp));

				}
			}
		}
		return color;
	}

	/***
	 * 
	 * @params kS(reduction factor)
	 * @param l(ray                                 from the lamp to the object)
	 * @param n(normal),nShininess(shininess),light intensity
	 * @param dp(dot                                product between l and v)
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
	 * @param light        intensity
	 * @param dp(dot       product between l and v)
	 * @return the color changed by the diffusion
	 */
	Color calcDiffusive(double kD, Color lightIntensity, double dp) {
		return lightIntensity.scale(kD * Math.abs(dp));
	}

	/**
	 * @param the point from where to do the reflected ray, ray from the light to
	 *            the object,normal
	 * @return the reflected ray from the point +- the normal
	 */
	Ray constructReflectedRay(Point3D p, Vector v, Vector n) {
		v = v.normalize();
		double vn = v.dotProduct(n);
		if (Util.isZero(vn))
			return null;
		Ray r = new Ray(p, v.subtract(n.scale(2d * vn)).normalized(), n);
		return r;
	}

	/**
	 * @param the point from where to do the refracted ray, ray from the light to
	 *            the object,normal
	 * @return the reflected ray from the point +- the normal
	 */
	Ray constructRefractedRay(Point3D p, Vector v, Vector n) {
		return new Ray(p, v.normalize(), n); // r
	}

	/**
	 *
	 * @param ray calculates all the intersections of a ray on an object and
	 * @return the closest intersection to the head of the ray
	 */
	private GeoPoint findClosestIntersection(Ray ray) {
		// return ray.findClosestGeoPoint(scene.geometries.findGeoIntersections(ray));
		if (scene.geometries.findGeoIntersections(ray) != null) {
			double distance = ray.getP0().distance(scene.geometries.findGeoIntersections(ray).get(0).point);
			GeoPoint myPoint = scene.geometries.findGeoIntersections(ray).get(0);
			for (GeoPoint g : scene.geometries.findGeoIntersections(ray)) {
				if (ray.getP0().distance(g.point) < distance) {
					distance = ray.getP0().distance(g.point);
					myPoint = g;
				}
			}
			return myPoint;

		}
		return null;
	}

}