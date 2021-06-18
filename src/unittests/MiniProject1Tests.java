package unittests;

import org.junit.Test;

import elements.*;
import geometries.*;
import primitives.*;
import renderer.*;
import scene.Scene;



public class MiniProject1Tests {
	private Scene scene = new Scene("Test scene").setNumOfRays(5).setAmbientLight(new AmbientLight (new Color (java.awt.Color.WHITE), 0.1));
	
	 @Test
	 public void Image3()  {

	 Scene scene = new Scene("Test scene") //
	 .setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));
	 Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
	 .setViewPlaneSize(200, 200) //
	 .setDistance(1000);

	 Geometry triangle1 = new Triangle( //
	 new Point3D(-150, -150, -150), new Point3D(150, -150, -150), new Point3D(75, 75, -150));
	 Geometry triangle2 = new Triangle( //
	 new Point3D(-150, -150, -150), new Point3D(-70, 70, -50), new Point3D(75, 75, -150));
	 scene.geometries.add(triangle1.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(300)),
	 triangle2.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(300)));
	 scene.lights.add(new DirectionalLight(new Color(300, 150, 150), new Vector(0, -0.05, -1)));
	 scene.lights.add(new PointLight(new Color(100, 250, 250), new Point3D(50, -10, -130)) //
	 .setKl(0.0005).setKq(0.0005));
	 scene.lights.add(new SpotLight(new Color(500, 500, 500), new Point3D(-50, 50, -130), new Vector(-2, -2, -1)) //
	 .setKl(0.0001).setKq(0.000005));






	 scene.setNumOfRays(5);

	 scene.geometries.add( //
	 new Sphere( new Point3D(0, 0, -50),50) //
	 .setEmission(new Color(java.awt.Color.BLUE)) //
	 .setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
	 /*new Sphere( new Point3D(0, 0, -50),25) //
	 .setEmission(new Color(java.awt.Color.RED))
	 .setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)), */
	 new Triangle(new Point3D(-10000, 10000, 10), new Point3D(10000, 10000, 10), new Point3D(-10000, -10000, 10))
	 .setMaterial(new Material().setkT(0.8).setkGlossy(0.07)).setEmission(new Color(10, 10, 10))
	 //new Sphere( new Point3D(20, 0, -1000),500) //
	 // .setEmission(new Color(java.awt.Color.BLUE)) //
	 // .setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
	 //new Sphere( new Point3D(20, 0, -1000),250) //
	 // .setEmission(new Color(java.awt.Color.RED)) //
	 // .setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
	 //new Sphere( new Point3D(-20, 0, -1000),500) //
	 // .setEmission(new Color(java.awt.Color.BLUE)) //
	 // .setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
	 //new Sphere( new Point3D(-20, 0, -1000),250) //
	 // .setEmission(new Color(java.awt.Color.RED)) //
	 // .setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
	 //new Sphere( new Point3D(0, 20, -1000),500) //
	 // .setEmission(new Color(java.awt.Color.BLUE)) //
	 // .setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
	 //new Sphere( new Point3D(0, 20, -1000),250) //
	 // .setEmission(new Color(java.awt.Color.RED)) //
	 // .setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100))
	 );

	 //scene.lights.add( //
	 //new SpotLight(new Color(1000, 600, 0), new Point3D(-100, -100, 500), new Vector(-1, -1, -2)) //
	 // .setKl(0.0004).setKq(0.0000006));

	 Render render = new Render() //
	 .setImageWriter(new ImageWriter("refractionManySpheresGlossywithoutSS", 500, 500)) //
	 .setCamera(camera) //
	 .setRayTracer(new RayTracerBasic(scene)).setMultithreading(3).setDebugPrint();
	 render.renderImage();
	 render.writeToImage();
	 }

	 //
	 // @Test
	 // public void Image2() {
	 // Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
	 // .setViewPlaneSize(150, 150).setDistance(1000);
	 //
	 // scene.geometries.add( //
	 //// new Sphere( new Point3D(-50, 0, 0),10)
	 //// .setEmission(new Color(java.awt.Color.RED))
	 //// .setMaterial(new Material().setKd(1).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)),
	 // new Sphere( new Point3D(0, 0, 0),10)
	 // .setEmission(new Color(255,0,255))
	 // .setMaterial(new Material().setKd(1).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)),
	 //// new Sphere(new Point3D(50, 0, 0),10)
	 //// .setEmission(new Color(java.awt.Color.BLUE ))
	 //// .setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)),
	 // new Plane(new Point3D(0,-10,0), new Vector(0,1,0.1)).setEmission(new Color(0,0,0))
	 // .setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)));
	 //
	 // scene.lights.add( //
	 // new SpotLight(new Color(60, 60, 60), new Point3D(0, 0, 500), new Vector(0, 0, -1)) //
	 // .setKl(0.0004).setKq(0.0000006));
	 //
	 // Render render = new Render() //
	 // .setImageWriter(new ImageWriter("miniprojetc2", 500, 500)) //
	 // .setCamera(camera) //
	 // .setMultithreading(3).setDebugPrint()
	 // .setRayTracer(new RayTracerBasic(scene));
	 // render.renderImage();
	 // render.writeToImage();
	 // }
	 //
	 // 
	
	@Test
	public void BeamOfRayReflected() throws Exception {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);
	   //  scene.setBackground(new Color(255, 246, 200)).setNumOfRays(0);
		scene.geometries.add( //
				new Sphere( new Point3D(-50, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.RED)) 
				.setMaterial(new Material().setKd(1).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)),
		new Sphere( new Point3D(0, 0, 0),10) 
				.setEmission(new Color(255,0,255)) 
				.setMaterial(new Material().setKd(1).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)),
		new Sphere(new Point3D(50, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.BLUE )) 
				.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)),
		new Plane(new Point3D(0,-10,0), new Vector(0,1,0.1)).setEmission(new Color(0,0,0))
		.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30)));
		
		scene.lights.add( //
				new SpotLight(new Color(60, 60, 60), new Point3D(0, 0, 500), new Vector(0, 0, -1)) //
						.setKl(0.0004).setKq(0.0000006));
	
		scene.lights.add( //
				new SpotLight(new Color(60, 60, 60), new Point3D(0, 500, -500), new Vector(0, -0.5, 1)) //
						.setKl(0.0004).setKq(0.0000006));
		
		
		scene.lights.add(new PointLight(new Color(60, 60, 60), new Point3D(0, 500, 100))//
				.setKl(0.00001).setKq(0.000001));
			

		Render render = new Render() //
				.setImageWriter(new ImageWriter("mini project 3 boules", 500, 500)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}
	
	
	
	
	
	
//	/**
//	 * Produce a picture of a sphere lighted by a spot light
//	 */
//	@Test
//	public void manySpheres() {
//		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
//				.setViewPlaneSize(150, 150).setDistance(1000);
//		
//		scene.geometries.add( //		
////	   new Sphere( new Point3D(-65, 40, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-60, 40, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-55, 40, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-60, 35, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-60, 30, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-60, 25, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-62.5, 20, -50),2.5) //
////				.setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////		new Sphere( new Point3D(-65, 20, -50),2.5) //
////			    .setEmission(new Color(java.awt.Color.BLUE)) //
////				.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkR(0.3).setkGlossy(0.07)),
////				
////				
////				
////				
////				
////			new Sphere( new Point3D(-20, 40, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-22.5, 35, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-17.5, 35, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-25, 30, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-15, 30, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-21.5, 30, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-18.5, 30, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-27.5, 25, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-13.5, 25, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-30, 20, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(-10, 20, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkT(0.3).setkGlossy(0.07)),
////					
////				
////				
////				
////			new Sphere( new Point3D(20, 20, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(17.5, 25, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(22.5, 25, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(15, 30, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(25, 30, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(12.5, 35, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(26.5, 35, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(10, 40, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////			new Sphere( new Point3D(30, 40, -50),2.5) //
////					.setEmission(new Color(java.awt.Color.BLUE)) //
////					.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(5).setkR(0.3).setkGlossy(0.07)),
////					
////					
//					
//					
//					
//					
//					
//				
//					
////					
////					new Sphere( new Point3D(60, 40, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(57.5, 35, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(62.5, 35, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(55, 30, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(65, 30, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(58.5, 30, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.5).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(62.5, 30, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////				new Sphere( new Point3D(52.5, 25, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(66.5, 25, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
////					new Sphere( new Point3D(50, 20, -50),2.5) //
////							.setEmission(new Color(java.awt.Color.BLUE)) //
////							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//					new Sphere( new Point3D(70, 20, -50),2.5) //
//							.setEmission(new Color(java.awt.Color.BLUE)) //
//							.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(10).setkT(0.3).setkGlossy(0.07)),
//							
////								
////				new Sphere( new Point3D(-60, 30, -50),20) //
////							.setEmission(new Color(java.awt.Color.BLUE))
////							.setMaterial(new Material().setKd(0.2).setKs(0.2).setnShininess(30).setkT(0.6).setkGlossy(0.07)),
//////				
////				new Plane (new Point3D(0,0,0), new Vector (0,1,0.001))		
////						.setMaterial(new Material().setkR(0.5).setkGlossy(0.07))
////						.setEmission(new Color(192, 192,192 )),
////							
//						new Plane(new Point3D(0,0,0), new Vector(0,1,0.001)).setEmission(new Color(java.awt.Color.BLUE))
//						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkT(0.5).setkGlossy(30))
//					
//				
////				new Sphere( new Point3D(0, 0, -50),15) //
////						.setEmission(new Color(java.awt.Color.BLUE)) //
////						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
////				new Sphere( new Point3D(0, 0, -50),5) //
////						.setEmission(new Color(java.awt.Color.RED)) //
////						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
////				new Sphere( new Point3D(-30, 0, -50),15) //
////						.setEmission(new Color(java.awt.Color.BLUE)) //
////						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
////				new Sphere( new Point3D(-30, 0, -50),5) //
////						.setEmission(new Color(java.awt.Color.RED)) //
////						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
////				new Sphere( new Point3D(30, 0, -50),15) //
////						.setEmission(new Color(java.awt.Color.BLUE)) //
////						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
////				new Sphere( new Point3D(30, 0, -50),5) //
////						.setEmission(new Color(java.awt.Color.RED)) //
////						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
////				new Sphere( new Point3D(-60,0, -50),15) //
////						.setEmission(new Color(java.awt.Color.BLUE)) //
////						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
////				new Sphere( new Point3D(-60, 0, -50),5) //
////						.setEmission(new Color(java.awt.Color.RED)) //
////						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
////			    new Sphere( new Point3D(60, 0, -50),15) //
////						.setEmission(new Color(java.awt.Color.BLUE)) //
////						.setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(100).setkT(0.3).setkGlossy(0.07)),
////				new Sphere( new Point3D(60, 0, -50),5) //
////						.setEmission(new Color(java.awt.Color.RED)) //
////						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100))
//				//new Triangle(new Point3D(-10000, 10000, 10), new Point3D(10000, 10000, 10), new Point3D(-10000, -10000, 10))
//				//		.setMaterial(new Material().setkT(0.8).setkGlossy(0.07)).setEmission(new Color(10, 10, 10))
//				//new Plane (new Point3D(0,0,10), new Vector (0,0, -1))				
//				//		.setMaterial(new Material().setkT(0.8).setkGlossy(0.07)).setEmission(new Color(10, 10, 10))
//						);
//		
//		scene.lights.add( //
//				new SpotLight(new Color(1000, 600, 0), new Point3D(200, 200, 500), new Vector(-1, -1, -2)) //
//						.setKl(0.0004).setKq(0.0000006));
//		
////		scene.lights.add( //
////				new SpotLight(new Color(255, 255, 255), new Point3D(-1, -1, 200), new Vector(0,0,-1)) //
////						.setKl(0.0004).setKq(0.0000006));
//
//		Render render = new Render() //
//				.setImageWriter(new ImageWriter("mini project", 500, 500)) //
//				.setCamera(camera) //
//			//	.setMultithreading(3)
//				.setRayTracer(new RayTracerBasic(scene));
//		render.renderImage();
//		render.writeToImage();
//	}

	
}