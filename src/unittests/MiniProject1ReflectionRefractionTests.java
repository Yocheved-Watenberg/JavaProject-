//**

package unittests;

import org.junit.Test;

import elements.*;
import geometries.Plane;
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
	private Scene scene = new Scene("Test scene").setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

	
	 
	@Test
	public void OneRay() throws Exception {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);

		scene.geometries.add( //
				new Sphere( new Point3D(-30, 0, 0),10) 
						.setEmission(new Color(java.awt.Color.RED)) 
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
				new Sphere( new Point3D(0, 0, 0),10) 
						.setEmission(new Color(255,0,255)) 
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
				new Sphere( new Point3D(30, 0, 0),10) 
						.setEmission(new Color(java.awt.Color.BLUE)) 
						.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
				new Plane(new Point3D(0,-10,0), new Vector(0,1,0.1)).setEmission(new Color(0,0,0))
				.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1)));

		
		scene.lights.add( //
				new SpotLight(new Color(60, 60, 60), new Point3D(0, 0, 500), new Vector(0, 0, -1)) //
						.setKl(0.0004).setKq(0.0000006));

		scene.lights.add( //
				new SpotLight(new Color(60, 60, 60), new Point3D(0, 500, -500), new Vector(0, -0.5, 1)) //
						.setKl(0.0004).setKq(0.0000006));
		
		scene.lights.add(new PointLight(new Color(300, 300, 300), new Point3D(0, 500, 100))//

				.setKl(0.00001).setKq(0.000001));
	

		Render render = new Render() //
				.setImageWriter(new ImageWriter("OneRay", 500, 500)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}
	
	
/*	
	@Test
	public void BeamOfRayRefracted() throws Exception {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);

		scene.geometries.add( //
				new Sphere( new Point3D(-30, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.RED)) 
				.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
		new Sphere( new Point3D(0, 0, 0),10) 
				.setEmission(new Color(255,0,255)) 
				.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
		new Sphere( new Point3D(30, 0, 0),10) 
				.setEmission(new Color(java.awt.Color.BLUE)) 
				.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100)),
		new Plane(new Point3D(0,-10,0), new Vector(0,1,0.1)).setEmission(new Color(0,0,0))
		.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkT(1)));
		
		scene.lights.add( //
				new SpotLight(new Color(60, 60, 60), new Point3D(0, 0, 500), new Vector(0, 0, -1)) //
						.setKl(0.0004).setKq(0.0000006));

		scene.lights.add( //
				new SpotLight(new Color(60, 60, 60), new Point3D(0, 500, -500), new Vector(0, -0.5, 1)) //
						.setKl(0.0004).setKq(0.0000006));
		
		scene.lights.add(new PointLight(new Color(300, 300, 300), new Point3D(0, 500, 100))//
				.setKl(0.00001).setKq(0.000001));
	

		Render render = new Render() //
				.setImageWriter(new ImageWriter("BeamOfRayRefractedv5", 500, 500)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}*/
	@Test
	public void BeamOfRayReflected() throws Exception {
		Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
				.setViewPlaneSize(150, 150).setDistance(1000);
	     scene.setBackground(new Color(255, 246, 200));
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
				.setImageWriter(new ImageWriter("BeamOfRayReflectedv3", 500, 500)) //
				.setCamera(camera) //
				.setRayTracer(new RayTracerBasic(scene));
		render.renderImage();
		render.writeToImage();
	}
	
	@Test
	public void BeamOfRayReflectedBoulesPlusHautes() throws Exception {
	Camera camera = new Camera(new Point3D(0, 0, 1000), new Vector(0, 0, -1), new Vector(0, 1, 0)) //
	.setViewPlaneSize(150, 150).setDistance(1000);

	scene.geometries.add( //
	new Sphere( new Point3D(-30, 10, 0),10)
	.setEmission(new Color(java.awt.Color.RED))
	.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkGlossy(30).setkR(1)),
	new Sphere( new Point3D(0, 10, 0),10)
	.setEmission(new Color(255,0,255))
	.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkGlossy(30).setkR(1)),
	new Sphere( new Point3D(30, 10, 0),10)
	.setEmission(new Color(java.awt.Color.BLUE ))
	.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkGlossy(30).setkR(1)),
	new Plane(new Point3D(0,-10,0), new Vector(0,1,0.1)).setEmission(new Color(0,0,0))
	.setMaterial(new Material().setKd(0.5).setKs(0.5).setnShininess(100).setkR(1).setkGlossy(10)));

	scene.lights.add( //
	new SpotLight(new Color(60, 60, 60), new Point3D(0, 0, 500), new Vector(0, 0, -1)) //
	.setKl(0.0004).setKq(0.0000006));

	scene.lights.add( //
	new SpotLight(new Color(60, 60, 60), new Point3D(0, 500, -500), new Vector(0, -0.5, 1)) //
	.setKl(0.0004).setKq(0.0000006));


	scene.lights.add(new PointLight(new Color(60, 60, 60), new Point3D(0, 500, 100))//
	.setKl(0.00001).setKq(0.000001));


	Render render = new Render() //
	.setImageWriter(new ImageWriter("BeamOfRayReflectedBoulesPlusHautes", 500, 500)) //
	.setCamera(camera) //
	.setRayTracer(new RayTracerBasic(scene));
	render.renderImage();
	render.writeToImage();
	}
	/*
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
	
@Test
    public void multiMirror()throws Exception {
		Camera camera = new Camera(new Point3D(50, 100, -11000), new Vector(0, 0, 1), new Vector(0, -1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(9000);
        Scene scene = new Scene("Test scene").setAmbientLight(new AmbientLight(new Color(0, 0, 0),0.1));
        //scene.set_camera(new Camera(new Point3D(50, 100, -11000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
       // scene.set_distance(9000);
       
        

        scene.geometries.add(
        	//	public Material(double _kD, double _kS, int _nShininess, double _KT, double _KR)
                new Sphere(new Point3D(-1000, -50, 1600),200).setEmission(new Color(0, 25, 51)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)),
                new Sphere(new Point3D(1000, -50, 1600),200).setEmission(new Color(0, 25, 51)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)), 
                new Sphere(new Point3D(0, -50, 1600),200).setEmission(new Color(0, 25, 51)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)), 
                new Triangle(new Point3D(40, -15, -8200),new Point3D(350, -15, -8200),new Point3D(350, 185, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setkGlossy(0)),
                new Triangle(new Point3D(40, -15, -8200),new Point3D(350, 185, -8200),new Point3D(-270, 185, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setkGlossy(15)),
                new Triangle(new Point3D(40, -15, -8200),new Point3D(-270, -15, -8200),new Point3D(-270, 185, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setkGlossy(30)),
               
                new Plane(new Point3D(1500, 1500, 0),new Point3D(-1500, -1500, 3850), new Point3D(-1500, 1500, 0)).setEmission(new Color(java.awt.Color.black).reduce(5)).setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(20000).setkT(0).setkR(0).setkGlossy(0)));



        scene.lights.add
                (//(Color _intensity, Point3D _position , Vector _direction, double _kC, double _kL, double kQ)
                  new SpotLight(new Color(1020, 400, 400),  new Point3D(0, 300, -400), new Vector(-1, 1, 4) ).setKc(1).setKl(0.00001).setKq(0.000005));
        scene.lights.add(new SpotLight(new Color(20, 40, 0),  new Point3D(800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
        scene.lights.add(new SpotLight(new Color(1020, 400, 400),  new Point3D(-800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
        scene.lights.add (new DirectionalLight(new Color(java.awt.Color.darkGray),new Vector(-0.5, 0.5, 0)));

      
        Render render = new Render()
        		.setImageWriter(new ImageWriter("multiMirrorTest",1000, 1000))
        		.setCamera(camera)
        		.setRayTracer(new RayTracerBasic(scene));
        
        render.renderImage();
        render.writeToImage();
    }

	/**
    * test multi shapes
    
   @Test
   public void test()throws Exception {
       Scene scene = new Scene("Test scene");
       Camera camera = new Camera(new Point3D(50, 100, -11000), new Vector(0, 0, 1), new Vector(0, -1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(9000);
       scene.setBackground(Color.BLACK);
       scene.setAmbientLight(new AmbientLight(new Color(0, 0, 0),0.1));

       scene.geometries.add(
    		  
               new Sphere(new Point3D(-950, 0, 1100),400).setEmission(new Color(21,0, 81).scale(1.5)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)),
               new Sphere(new Point3D(0, 500, 700),300).setEmission(new Color(102, 32, 20)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)),
//    public Material(double _kD, double _kS, int _nShininess, double _KT, double _KR, double _DiffusedAndGlossy) {

               new Sphere(new Point3D(1000, 50, 1100),450).setEmission(new Color(51, 0, 51)).setMaterial(new Material().setKd(0.8).setKs(0.25).setnShininess(120).setkT(0).setkR(0.7)),
               new Sphere(new Point3D(0, -500, 1700),600).setEmission(new Color(63, 120, 77)).setMaterial(new Material().setKd(0.85).setKs(0.25).setnShininess(700).setkT(0).setkR(0.7)),
               new Triangle(new Point3D(50, -215, -8200),new Point3D(380, -215, -8200),new Point3D(380, 285, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(24)),
               new Triangle( new Point3D(40, -215, -8200),new Point3D(370, 285, -8200),new Point3D(-270, 285, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(0)),
               new Triangle(new Point3D(30, -215, -8200),new Point3D(-280, -215, -8200),new Point3D(-280, 285, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(24)),
               new Plane(new Point3D(1500, 1500, 0),new Point3D(-1500, -1500, 3850), new Point3D(-1500, 1500, 0)).setEmission(new Color(java.awt.Color.black)).setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(20000).setkT(0).setkR(0.4).setDiffusedAndGlossy(200)));



       scene.lights.add
       (//(Color _intensity, Point3D _position , Vector _direction, double _kC, double _kL, double kQ)
         new SpotLight(new Color(1020, 400, 400),  new Point3D(0, 300, -400), new Vector(-1, 1, 4) ).setKc(1).setKl(0.00001).setKq(0.000005));
scene.lights.add(new SpotLight(new Color(20, 40, 0),  new Point3D(800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
scene.lights.add(new SpotLight(new Color(1020, 400, 400),  new Point3D(-800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
scene.lights.add (new DirectionalLight(new Color(java.awt.Color.darkGray),new Vector(-0.5, 0.5, 0)));

        
       ImageWriter imageWriter = new ImageWriter("our test",  1000, 1000);
      Render1 render = new Render1()
    		  .setImageWriter(imageWriter)
    		  .setCamera(camera)
       		  .setRayTracerBase(new RayTracerBasic(scene).setDistanceForDiffusedAndGlossy(5000.0).setAdaptiveDiffusedAndGlossyFlag(true).setMaxRaysForDiffusedAndGlossy(500));
//       render.setMultiThreading(5);
    //   render.setAdaptiveSuperSamplingFlag(true);
    //   render.setMaxRaysForSuperSampling(500);
       render.renderImageProj();
       render.writeToImage();
   }
  *
  
  @Test 
   public void multiMirror()throws Exception {
	   
	   
	   Camera camera = new Camera(new Point3D(50, 100, -11000), new Vector(0, 0, 1), new Vector(0, -1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(9000);
      Scene scene = new Scene("Test scene").setAmbientLight(new AmbientLight(new Color(0, 0, 0),0.1)).setBackground(Color.BLACK);
      //scene.set_camera(new Camera(new Point3D(50, 100, -11000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
     // scene.set_distance(9000); 
	   
	   
	   
	   
     /*  Scene scene = new Scene("Test scene");
       scene.set_camera(new Camera(new Point3D(50, 100, -11000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
       scene.set_distance(9000);
       scene.set_background(Color.BLACK);
       scene.set_ambientLight(new AmbientLight(0.1, new Color(0, 0, 0)));
       *
       scene.geometries.add(
              	//	public Material(double _kD, double _kS, int _nShininess, double _KT, double _KR)
                      new Sphere(new Point3D(-1000, -50, 1600),200).setEmission(new Color(0, 25, 51)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)),
                      new Sphere(new Point3D(1000, -50, 1600),200).setEmission(new Color(0, 25, 51)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)), 
                      new Sphere(new Point3D(0, -50, 1600),200).setEmission(new Color(0, 25, 51)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)), 
                      new Triangle(new Point3D(40, -15, -8200),new Point3D(350, -15, -8200),new Point3D(350, 185, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(0)),
                      new Triangle(new Point3D(40, -15, -8200),new Point3D(350, 185, -8200),new Point3D(-270, 185, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(15)),
                      new Triangle(new Point3D(40, -15, -8200),new Point3D(-270, -15, -8200),new Point3D(-270, 185, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(30)),
                     
                      new Plane(new Point3D(1500, 1500, 0),new Point3D(-1500, -1500, 3850), new Point3D(-1500, 1500, 0)).setEmission(new Color(java.awt.Color.black).reduce(5)).setMaterial(new Material().setKd(0.4).setKs(0.3).setnShininess(20000).setkT(0).setkR(0)));


          scene.lights.add
                  (//(Color _intensity, Point3D _position , Vector _direction, double _kC, double _kL, double kQ)
                    new SpotLight(new Color(1020, 400, 400),  new Point3D(0, 300, -400), new Vector(-1, 1, 4) ).setKc(1).setKl(0.00001).setKq(0.000005));
          scene.lights.add(new SpotLight(new Color(20, 40, 0),  new Point3D(800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
          scene.lights.add(new SpotLight(new Color(1020, 400, 400),  new Point3D(-800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
          scene.lights.add (new DirectionalLight(new Color(java.awt.Color.darkGray),new Vector(-0.5, 0.5, 0)));

       ImageWriter imageWriter = new ImageWriter("multiMirrorTest",1000, 1000);
       Render render = new Render(imageWriter, scene,camera);
       render.setDistanceForDiffusedAndGlossy(5000);
       render.renderImage();
       render.writeToImage();
   }
**
@Test
public void test()throws Exception {
	 Scene scene = new Scene("Test scene");
	 //a revoir 
     Camera camera = new Camera(new Point3D(-500 ,0, 0), new Vector(0.35, 0, -1), new Vector(0, -1, 0)) //
				.setViewPlaneSize(2500, 2500).setDistance(600);
     scene.setBackground(new Color(255, 246, 200));
     //scene.setAmbientLight(new AmbientLight(new Color(0, 0, 0),0.1));

     scene.geometries.add(
  		  
             new Sphere(new Point3D(-250, -250, -900),250).setEmission(new Color(0,0,100)).setMaterial(new Material().setKd(1).setnShininess(20).setkT(0.5).setkR(0.7)),
            // new Sphere(new Point3D(0, 500, 700),300).setEmission(new Color(102, 32, 20)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)),
//  public Material(double _kD, double _kS, int _nShininess, double _KT, double _KR, double _DiffusedAndGlossy) {

            // new Sphere(new Point3D(1000, 50, 1100),450).setEmission(new Color(51, 0, 51)).setMaterial(new Material().setKd(0.8).setKs(0.25).setnShininess(120).setkT(0).setkR(0.7)),
          //   new Sphere(new Point3D(0, -500, 1700),600).setEmission(new Color(63, 120, 77)).setMaterial(new Material().setKd(0.85).setKs(0.25).setnShininess(700).setkT(0).setkR(0.7)),
             new Triangle(new Point3D(1800, 0, -1500),new Point3D(-1000, 1500, -1500),new Point3D(-1000, -1500, -1500)).setEmission(new Color (28,52,255)).setMaterial(new Material().setKd(1).setkR(0.5).setkGlossy(24)),
             new Triangle( new Point3D(-1800, 0, -1505),new Point3D(1000, 1500, -1505),new Point3D(1000, -1500, -1505)).setEmission(new Color (28,52,255)).setMaterial(new Material().setKd(1).setKs(0).setnShininess(0).setkT(1).setkR(0.5).setkGlossy(0)),
          //   new Triangle(new Point3D(30, -215, -8200),new Point3D(-280, -215, -8200),new Point3D(-280, 285, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(24)),
             new Plane( new Point3D(-1500, 1500, 0),new Vector(0,1,0)).setEmission(new Color(60,60,60)).setMaterial(new Material().setkR(1)));



     scene.lights.add
     (//(Color _intensity, Point3D _position , Vector _direction, double _kC, double _kL, double kQ)
       new SpotLight(new Color(100, 100, 50),  new Point3D(50, 200, -150), new Vector(-1, -2, -3) ).setKc(0).setKl(0.00001).setKq(0.000005));
//scene.lights.add(new SpotLight(new Color(20, 40, 0),  new Point3D(800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
//scene.lights.add(new SpotLight(new Color(1020, 400, 400),  new Point3D(-800, 100, -300), new Vector(-1, 1, 4)).setKc(1).setKl(0.00001).setKq(0.000005));
//scene.lights.add (new DirectionalLight(new Color(java.awt.Color.darkGray),new Vector(-0.5, 0.5, 0)));

      
     ImageWriter imageWriter = new ImageWriter("our test",  1000, 1000);
    Render render = new Render()
  		  .setImageWriter(imageWriter)
  		  .setCamera(camera)
     		  .setRayTracer(new RayTracerBasic(scene));
//     render.setMultiThreading(5);
  //   render.setAdaptiveSuperSamplingFlag(true);
  //   render.setMaxRaysForSuperSampling(500);
     render.renderImage();
     render.writeToImage();

}
*/
	@Test
	public void test()throws Exception {
		 Scene scene = new Scene("Test scene");
		 //a revoir 
	     Camera camera = new Camera(new Point3D(-500 ,0, 0), new Vector(0.35, 0, -1), new Vector(0, -1, 0)) //
					.setViewPlaneSize(2500, 2500).setDistance(600);
	     scene.setBackground(new Color(255, 246, 200));

	     scene.geometries.add(
	  		  
	             new Sphere(new Point3D(-250, -250, -900),250).setEmission(new Color(0,0,100)).setMaterial(new Material().setKd(1).setnShininess(20).setkT(0.5).setkR(0.7)),
	            // new Sphere(new Point3D(0, 500, 700),300).setEmission(new Color(102, 32, 20)).setMaterial(new Material().setKd(0.8).setKs(0.8).setnShininess(200).setkT(0).setkR(0.7)),
	//  public Material(double _kD, double _kS, int _nShininess, double _KT, double _KR, double _DiffusedAndGlossy) {

	            // new Sphere(new Point3D(1000, 50, 1100),450).setEmission(new Color(51, 0, 51)).setMaterial(new Material().setKd(0.8).setKs(0.25).setnShininess(120).setkT(0).setkR(0.7)),
	          //   new Sphere(new Point3D(0, -500, 1700),600).setEmission(new Color(63, 120, 77)).setMaterial(new Material().setKd(0.85).setKs(0.25).setnShininess(700).setkT(0).setkR(0.7)),
	             new Triangle(new Point3D(1800, 0, -1500),new Point3D(-1000, 1500, -1500),new Point3D(-1000, -1500, -1500)).setEmission(new Color (28,52,255)).setMaterial(new Material().setKd(1).setkR(0.5).setkGlossy(24)),
	             new Triangle( new Point3D(-1800, 0, -1505),new Point3D(1000, 1500, -1505),new Point3D(1000, -1500, -1505)).setEmission(new Color (28,52,255)).setMaterial(new Material().setKd(1).setKs(0).setnShininess(0).setkT(1).setkR(0.5).setkGlossy(0)),
	          //   new Triangle(new Point3D(30, -215, -8200),new Point3D(-280, -215, -8200),new Point3D(-280, 285, -8200)).setEmission(new Color (java.awt.Color.WHITE).reduce(10)).setMaterial(new Material().setKd(0).setKs(0).setnShininess(0).setkT(1).setkR(0).setDiffusedAndGlossy(24)),
	             new Plane( new Point3D(-1500, 1500, 0),new Vector(0,1,0)).setEmission(new Color(60,60,60)).setMaterial(new Material().setkR(1)));



	     scene.lights.add
	     (
	       new SpotLight(new Color(100, 100, 50),  new Point3D(50, 200, -150), new Vector(-1, -2, -3) ).setKc(0).setKl(0.00001).setKq(0.000005));
	
	      
	     ImageWriter imageWriter = new ImageWriter("our test",  1000, 1000);
	    Render render = new Render()
	  		  .setImageWriter(imageWriter)
	  		  .setCamera(camera)
	     		  .setRayTracer(new RayTracerBasic(scene));

	     render.renderImage();
	     render.writeToImage();

	}
}