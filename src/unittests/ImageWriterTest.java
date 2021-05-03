/**
 * 
 */
package unittests;

import org.junit.Test;

import primitives.Color;
import renderer.ImageWriter;

/**
 * @author Avigail Amar & Yocheved Watenberg 
 *
 */
public class ImageWriterTest {

	/**
	 * Test method for {@link renderer.ImageWriter#ImageWriter(java.lang.String, int, int)}.
	 */
	@Test
	public void testImageWriter() {
		ImageWriter image = new ImageWriter("firstImage", 800,500 );  //create a new image 800 x 500 pixels
		for (int i=0; i<800; i++)
			for (int j=0; j<500; j++)
				if ((i%50==0)||(j%50==0))
					image.writePixel(i,j,new Color(255,255,255));	 //color the grid in white
				else
					image.writePixel(i,j,new Color(0,255,255));		//color the background in turquoise 
		image.writeToImage(); 										//create the image 
		}
	

}


