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
				new Sphere( new Point3D(-30, 0, 0),10) 
						.setEmission(new Color(java.awt.Color.BLUE)) 
						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.8)),
				new Sphere( new Point3D(0, 0, 0),10) 
						.setEmission(new Color(java.awt.Color.BLUE)) 
						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100)),
				new Sphere( new Point3D(30, 0, 0),10) 
						.setEmission(new Color(java.awt.Color.BLUE)) 
						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkR(0.8)));

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
				new Sphere( new Point3D(-30, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.BLUE)) 
				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.8)),
		new Sphere( new Point3D(0, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.BLUE)) 
				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100)),
		new Sphere( new Point3D(30, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.BLUE)) 
				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkR(0.8)));

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
	
	
	@Test
	public void Aude() {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(500);

		scene.geometries.add( //
				new Triangle(new Point3D(  -500, 500,-1000),
						 new Point3D( 500, 500,-1000),
						 new Point3D(  0,  200, -1000)).setEmission(new Color(0, 0, 255)),
				 new Triangle( new Point3D(  0, 200, -1000),
						  new Point3D( 500, 500, -1000),
						  new Point3D( 0, 0, -1000)).setEmission(new Color(0, 255, 0)),
				 new Triangle(new Point3D(  0, 200, -1000),
						  new Point3D( -500,  500,-1000),
						  new Point3D( 0,0,-1000 )).setEmission(new Color(255, 0, 0)),
				 new Sphere( new Point3D(0, -250, -1000), 150).setEmission(new Color(0, 100, 100))
				 .setMaterial(new Material().setnShininess(20).setkT(0.5)) );

		scene.lights.add( //
				new SpotLight(new Color(255, 100, 100), new Point3D(200, 200, -150), new Vector(-2, -2, -3)) //
						.setKl( 0.00001).setKq(0.000005).setKc(0.1));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("aude", 500, 500)) //
				.setCamera(camera) //
				.setRayTracerBase(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();

	}
	
}
