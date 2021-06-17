/**
 * 
 */
package unittests;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;


public class MiniProject1Tests {
	private Scene scene = new Scene("Test scene").setNumOfRays(5).setAmbientLight(new AmbientLight (new Color (java.awt.Color.WHITE), 0.1));
	
	/**
	 * Produce a picture of a sphere lighted by a spot light
	 */
	@Test
	public void manySpheres() {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);
		
		scene.geometries.add( //
				
				
				
				
//	   new Sphere( new Point3D(-65, 40, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-60, 40, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-55, 40, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-60, 35, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-60, 30, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-60, 25, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-62.5, 20, -50),2.5) //
//				.setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//		new Sphere( new Point3D(-65, 20, -50),2.5) //
//			    .setEmission(new Color(java.awt.Color.BLUE)) //
//				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
//				
//				
//				
//				
//				
//			new Sphere( new Point3D(-20, 40, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-22.5, 35, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-17.5, 35, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-25, 30, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-15, 30, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-21.5, 30, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-18.5, 30, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-27.5, 25, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-13.5, 25, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-30, 20, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//			new Sphere( new Point3D(-10, 20, -50),2.5) //
//					.setEmission(new Color(java.awt.Color.BLUE)) //
//					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
//					
				
				
				
			new Sphere( new Point3D(20, 20, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(17.5, 25, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(22.5, 25, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(15, 30, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(25, 30, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(12.5, 35, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(26.5, 35, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(10, 40, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
			new Sphere( new Point3D(30, 40, -50),2.5) //
					.setEmission(new Color(java.awt.Color.BLUE)) //
					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
					
					
					
					
					
					
					
//				
//					
//					
//					new Sphere( new Point3D(60, 40, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(57.5, 35, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(62.5, 35, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(55, 30, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(65, 30, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(58.5, 30, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(62.5, 30, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(52.5, 25, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(66.5, 25, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(50, 20, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(70, 20, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//							
//					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
//				new Sphere( new Point3D(-60, 30, -50),20) //
//							.setEmission(new Color(java.awt.Color.BLUE))
//							.setMaterial(new Material().setKd(0.2).setKs(0.2).setnShininess(30).setkT(0.6).setkGlossy(0.07)),
////				
//				new Plane (new Point3D(0,0,0), new Vector (0,1,0.001))		
//						.setMaterial(new Material().setkR(0.5).setkGlossy(0.07))
//						.setEmission(new Color(192, 192,192 )),
//							
						new Plane(new Point3D(0,0,0), new Vector(0,1,0.001)).setEmission(new Color(java.awt.Color.BLUE))
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30))
					
				
//				new Sphere( new Point3D(0, 0, -50),15) //
//						.setEmission(new Color(java.awt.Color.BLUE)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
//				new Sphere( new Point3D(0, 0, -50),5) //
//						.setEmission(new Color(java.awt.Color.RED)) //
//						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
//				new Sphere( new Point3D(-30, 0, -50),15) //
//						.setEmission(new Color(java.awt.Color.BLUE)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
//				new Sphere( new Point3D(-30, 0, -50),5) //
//						.setEmission(new Color(java.awt.Color.RED)) //
//						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
//				new Sphere( new Point3D(30, 0, -50),15) //
//						.setEmission(new Color(java.awt.Color.BLUE)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
//				new Sphere( new Point3D(30, 0, -50),5) //
//						.setEmission(new Color(java.awt.Color.RED)) //
//						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
//				new Sphere( new Point3D(-60,0, -50),15) //
//						.setEmission(new Color(java.awt.Color.BLUE)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
//				new Sphere( new Point3D(-60, 0, -50),5) //
//						.setEmission(new Color(java.awt.Color.RED)) //
//						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
//			    new Sphere( new Point3D(60, 0, -50),15) //
//						.setEmission(new Color(java.awt.Color.BLUE)) //
//						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
//				new Sphere( new Point3D(60, 0, -50),5) //
//						.setEmission(new Color(java.awt.Color.RED)) //
//						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100))
				//new Triangle(new Point3D(-10000, 10000, 10), new Point3D(10000, 10000, 10), new Point3D(-10000, -10000, 10))
				//		.setMaterial(new Material().setkT(0.8).setkGlossy(0.07)).setEmission(new Color(10, 10, 10))
				//new Plane (new Point3D(0,0,10), new Vector (0,0, -1))				
				//		.setMaterial(new Material().setkT(0.8).setkGlossy(0.07)).setEmission(new Color(10, 10, 10))
						);
		
		scene.lights.add( //
				new SpotLight(new Color(1000, 600, 0), new Point3D(200, 200, 500), new Vector(-1, -1, -2)) //
						.setKl(0.0004).setKq(0.0000006));
		
//		scene.lights.add( //
//				new SpotLight(new Color(255, 255, 255), new Point3D(-1, -1, 200), new Vector(0,0,-1)) //
//						.setKl(0.0004).setKq(0.0000006));

		Render render = new Render() //
				.setImageWriter(new ImageWriter("mini project", 500, 500)) //
				.setCamera(camera) //
				.setMultithreading(3)
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}

	
}