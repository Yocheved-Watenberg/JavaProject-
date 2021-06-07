/**
 * 
 */
package unittests;

import org.junit.Test;

import elements.*;
import geometries.Sphere;
import geometries.Triangle;
import primitives.*;
import renderer.*;
import scene.Scene;

/**
 * Tests for reflection and transparency functionality, test for partial shadows
 * (with transparency)
 * 
 * BEAM OF RAYS
 * MINI PROJECT 1 
 * 
 */
public class MiniProject1ReflectionRefractionTests{
	private Scene scene = new Scene("Test scene");

	/**
	 */
	@Test
	public void OneRay() {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);

		scene.geometries.add( //
				new Sphere( new Point3D(0, 0, 0),50) 
						.setEmission(new Color(java.awt.Color.BLUE)) 
						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3)));

		scene.lights.add( //
				new SpotLight(new Color(1000, 600, 0), new Point3D(-100, -100, 500), new Vector(-1, -1, -2)) //
						.setKl(0.0004).setKq(0.0000006));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("OneRay", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBase(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}
	
	@Test
	public void BeamOfRay() {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);

		scene.geometries.add( //
				new Sphere( new Point3D(0, 0, 0),50) 
						.setEmission(new Color(java.awt.Color.BLUE)) 
						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3)));

		scene.lights.add( //
				new SpotLight(new Color(1000, 600, 0), new Point3D(-100, -100, 500), new Vector(-1, -1, -2)) //
						.setKl(0.0004).setKq(0.0000006));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("BeamOfRay", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBase(new RayTracerBasic(scene));
		render.renderImageBeamOfRay();
		render.writeToImage();
	}
	
}
