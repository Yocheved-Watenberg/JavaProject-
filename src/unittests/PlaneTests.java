package unittests;

import static org.junit.Assert.*;

import java.util.List;

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
		assertThrows("Constructed a plane and the last point is the same than the first one",
				IllegalArgumentException.class,
				() -> new Plane(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 0, 1)));
		// TC2: Colocated points
		assertThrows("Constructed a plane with collocated points", IllegalArgumentException.class,
				() -> new Plane(new Point3D(0, 0, 1), new Point3D(0, 1, 0), new Point3D(0, 1, 0)));
	}

	/**
	 * Test method for {@link geometries.Plane#getNormal(primitives.Point3D)}.
	 */
	@Test
	public void testGetNormal() {
		// =============== Equivalence Partitions Tests ==================
		Point3D p1 = new Point3D(1, 1, 1);
		Point3D p2 = new Point3D(2, 3, 1);
		Point3D p3 = new Point3D(3, 0, 1);
		Plane plane = new Plane(p1, p2, p3);
		Vector result = plane.getNormal(p1);
		Vector expected = new Vector(new Point3D(0, 0, -1));
		assertEquals("The method GetNormal for a Plane doesn't work", expected, result);
	}
	

	/**
	 * Test method for {@link geometries.Plane#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections()
	{
		Plane plane=new Plane(new Point3D(1,0,0),new Vector(0,1,0));   //plane xz
		// ============ Equivalence Partitions Tests ==============
		// TC01:Ray's line intersects the plane
		assertEquals("Ray's line intersects the plane",List.of(new Point3D (0,0,3)),
            plane.findIntersections(new Ray(new Point3D(0,-3,0), new Vector(0,1,1))));
		// TC02:Ray's line doesn't intersect the plane
		  assertNull("Ray's line doesn't intersect the plane",
	                plane.findIntersections(new Ray(new Point3D(5, 5, 0), new Vector(1,1,1))));  
		  
		  
	        // =============== Boundary Values Tests ==================
        // TC03: Ray's line is parallel to the plane and is included in it
        assertNull("Ray's line parallel and included in the plane",
               plane.findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(1,0,0))));
        // TC04: Ray's line is  parallel to the plane and isn't included in it
        assertNull("Ray's line parallel and isn't included in the plane",
               plane.findIntersections(new Ray(new Point3D(0,1,0), new Vector(1,0,0))));
        // TC05: Ray's line is  orthogonal to the plane and starts before the plane
        assertEquals("Ray's line orthogonal and starts before in the plane",List.of(new Point3D(0,0,1)),
        		plane.findIntersections(new Ray(new Point3D(0,-2,1), new Vector(0,1,0))));
        // TC06: Ray's line is  orthogonal to the plane and starts in it
        assertNull("Ray's line orthogonal and starts in the plane",
                plane.findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(0,1,0))));
        //TC07: Ray's line is orthogonal to the plane and  and starts after it
        assertNull("Ray's line orthogonal and starts after the plane",
        		plane.findIntersections(new Ray(new Point3D(0,2,1), new Vector(0,1,0))));
       //TC08: Ray's line is neither orthogonal nor parallel to and begins at the plane
        assertNull("Ray's line is neither orthogonal nor parallel to and begins at the plane",
                plane.findIntersections(new Ray(new Point3D(2, 0, 0), new Vector(1,1,0))));
        //TC09: Ray's line is neither orthogonal nor parallel to and begins at point3d of the plane
        assertNull("Ray's line is neither orthogonal nor parallel to and begins at point3d of the plane",
                plane.findIntersections(new Ray(new Point3D(1, 0, 0), new Vector(1,1,0))));		
	}


}
