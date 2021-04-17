/**
 *
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import geometries.*;
import primitives.*;

/**
 * @author Avigail Amar & Yocheved Wattenberg
 *
 */
public class PlaneTests {
	/**
	 * Test method for
	 * {@link geometries.Plane#Plane(primitives.Point3D, primitives.Point3D, primitives.Point3D)}.
	 */
	@Test
	public void testConstructor() {
		// =============== Boundary Values Tests ==================
		// TC1: Last point = first point	  
		assertThrows("Constructed a plane and the last point is the same than the first one", IllegalArgumentException.class, ()->new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 0, 1)));
		// TC2: Colocated points 
		assertThrows("Constructed a plane with collocated points", IllegalArgumentException.class, ()->new Plane(new Point3D(0, 0, 1), new Point3D(0, 1, 0), new Point3D(0, 1, 0)));		
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
// =============== Equivalence Partitions Tests ==================
		Point3D p1 = new Point3D(1,1,1);
		Point3D p2 = new Point3D(2, 3, 1);
		Point3D p3 = new Point3D(3, 0, 1);
		Plane plane = new Plane(p1, p2, p3);
		Vector result = plane.getNormal(p1);
		Vector expected = new Vector(new Point3D(0,0,-1));
		assertEquals("The method GetNormal for a Plane doesn't work", expected, result);
	}

}
