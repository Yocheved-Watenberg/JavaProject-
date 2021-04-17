/**
 *
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.Sphere;
import primitives.Point3D;
import primitives.Vector;

/**
 * @author Avigail Amar & Yocheved Wattenberg
 *
 */
public class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point3D)}.
	 * 
	 */
	@Test
	public void testGetNormal() {

		Point3D center = new Point3D(2, 1, 2);
		double radius = 3;
		Sphere sphere = new Sphere(center, radius);
		Vector result = sphere.getNormal(new Point3D(5, 3, 7));
		Vector expected = new Vector(new Point3D(3, 2, 5));
		assertEquals("The method GetNormal for a Sphere doesn't work", expected, result);
	}

}
