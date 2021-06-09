
package renderer;

import java.util.MissingResourceException;

import elements.Camera;
import primitives.Color;


public class Render {

	/**
	 * Class render to create the color matrix of the image from the scene
	 *
	 */
	ImageWriter imageWriter;
	Camera camera;
	RayTracerBase rayTracerBase;

	/**
	 * @param imageWriter the imageWriter to set
	 * @return the object itself for threading
	 */
	public Render setImageWriter(ImageWriter imageWriter) {
		this.imageWriter = imageWriter;
		return this;
	}

	/**
	 * @param camera the camera to set
	 * @return the object itself for threading
	 */
	public Render setCamera(Camera camera) {
		this.camera = camera;
		return this;
	}
	/**
	 * @param rayTracerBase the rayTracerBase to set
	 * @return the object itself for threading
	 */
	public Render setRayTracerBase(RayTracerBase rayTracerBase) {
		this.rayTracerBase = rayTracerBase;
		return this;
	}
	
	
	
	@Override
	public String toString() {
		return "Render [imageWriter=" + imageWriter + ", camera=" + camera + ", rayTracerBase="
				+ rayTracerBase + "]";
	}
	
	/**
	 * this function check that there are all the fields
	 * and then fill the matrix of color 
	 * 
	 */
	public void renderImage() {
		try {
		if (imageWriter==null) 
			throw new MissingResourceException("there is no imageWriter for the render", this.toString(), imageWriter.toString());
		if (camera==null) 
			throw new MissingResourceException("there is no camera for the render", this.toString(), camera.toString());
		if (rayTracerBase==null) 
			throw new MissingResourceException("there is no rayTraceBase for the render", this.toString(), rayTracerBase.toString());
		}
		catch (MissingResourceException e){
			throw new UnsupportedOperationException();
		}
		Color pixelColor; 
		for (int i=0; i<imageWriter.getNx(); i++) {
			for (int j=0; j<imageWriter.getNy(); j++) {
				pixelColor = rayTracerBase.traceRay(camera.constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(),i,j));
				imageWriter.writePixel(i,j,pixelColor);	 //color the pixel 
			}		
		}
	}
	
	
	
	
	/**
	 * this function check that there are all the fields
	 * and then fill the matrix of color 
	 * mini project 1 : the same function than renderImage for beam of rays
	 * 
	 */
	public void renderImageBeamOfRayReflected() {
		try {
		if (imageWriter==null) 
			throw new MissingResourceException("there is no imageWriter for the render", this.toString(), imageWriter.toString());
		if (camera==null) 
			throw new MissingResourceException("there is no camera for the render", this.toString(), camera.toString());
		if (rayTracerBase==null) 
			throw new MissingResourceException("there is no rayTraceBase for the render", this.toString(), rayTracerBase.toString());
		}
		catch (MissingResourceException e){
			throw new UnsupportedOperationException();
		}
		Color pixelColor; 
		for (int i=0; i<imageWriter.getNx(); i++) {
			for (int j=0; j<imageWriter.getNy(); j++) {
				pixelColor = rayTracerBase.traceBeamOfRayReflected(camera.constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(),i,j));
				imageWriter.writePixel(i,j,pixelColor);	 //color the pixel 
			}		
		}
	}
	
	

	
	/**
	 * this function check that there are all the fields
	 * and then fill the matrix of color 
	 * mini project 1 : the same function than renderImage for beam of rays
	 * 
	 */
	public void renderImageBeamOfRayRefracted() {
		try {
		if (imageWriter==null) 
			throw new MissingResourceException("there is no imageWriter for the render", this.toString(), imageWriter.toString());
		if (camera==null) 
			throw new MissingResourceException("there is no camera for the render", this.toString(), camera.toString());
		if (rayTracerBase==null) 
			throw new MissingResourceException("there is no rayTraceBase for the render", this.toString(), rayTracerBase.toString());
		}
		catch (MissingResourceException e){
			throw new UnsupportedOperationException();
		}
		Color pixelColor; 
		for (int i=0; i<imageWriter.getNx(); i++) {
			for (int j=0; j<imageWriter.getNy(); j++) {
				//if (i==100 && j==100) 
				//{System.out.println("here");}
				pixelColor = rayTracerBase.traceBeamOfRayRefracted(camera.constructRayThroughPixel(imageWriter.getNx(), imageWriter.getNy(),i,j));
				imageWriter.writePixel(i,j,pixelColor);	 //color the pixel 
			}		
		}
	}
	 
	
	
	/**
	 * function to color a grid 
	 * @param interval
	 * @param color
	 */
	public void printGrid(int interval, Color color) {
		if (imageWriter==null) 
			throw new MissingResourceException("there is no imageWriter for the render", this.toString(), imageWriter.toString());
		for (int i=0; i<imageWriter.getNx(); i++)
			for (int j=0; j<imageWriter.getNy(); j++)
				if ((i%interval==0)||(j%interval==0))
					imageWriter.writePixel(i,j,color);	 //color the grid 
	}
	
	/**
	 * if there is no error, write the matrix of color to the image 
	 * 
	 */
	public void writeToImage(){
		if (imageWriter==null) 
			throw new MissingResourceException("there is no imageWriter for the render", this.toString(), imageWriter.toString());
		imageWriter.writeToImage();						 //create the image 
	}

}
