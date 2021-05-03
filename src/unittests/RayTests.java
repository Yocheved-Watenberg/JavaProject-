/**
 * 
 */
package unittests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * @author Avigail Amar and Yocheved Wattenberg 
 *
 */
public class RayTests {

	/**
	 * Test method for {@link primitives.Ray#findClosestPoint(java.util.List)}.
	 */
	@Test
	public void testFindClosestPoint() {
		
		Ray myRay = new Ray(new Point3D(0,0,1), new Vector(0,1,0));
		
		// ============ Equivalence Partitions Tests ==============

        // TC01: A point in the middle of the list is closest to the beginning of the ray
		assertEquals("bad closest point", new Point3D(0, 1, 1),
				myRay.findClosestPoint(List.of(new Point3D(0,0,4),new Point3D(0,1,1),new Point3D(4,0,0))));


        // =============== Boundary Values Tests ==================

        // TC02: Empty list 
		assertNull("in an empty list, method should return null value", myRay.findClosestPoint(new LinkedList<Point3D>()));
		

        // TC03: The first point is closest to the beginning of the ray
		assertEquals("bad closest point when the closest point is the first point of the list", new Point3D(0, 1, 1),
				myRay.findClosestPoint(List.of(new Point3D(0,1,1),new Point3D(4,0,0),new Point3D(0,0,4))));


        // TC04: The last point is closest to the beginning of the ray
		assertEquals("bad closest point when the closest point is the last point of the list", new Point3D(0, 1, 1),
				myRay.findClosestPoint(List.of(new Point3D(0,0,4),new Point3D(4,0,0),new Point3D(0,1,1))));


    }

}
