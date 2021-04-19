package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import geometries.*;
import primitives.*;
import java.util.List;

public class TriangleTests {

	/**
	 * Test method for {@link geometries.Triangle#getNormal(primitives.Point3D)}.
	 * 
	 */
	@Test
	public void testGetNormal() {

		Point3D p1 = new Point3D(1, 1, 1);
		Point3D p2 = new Point3D(2, 3, 1);
		Point3D p3 = new Point3D(3, 0, 1);
		Triangle triangle = new Triangle(p1, p2, p3);
		Vector result = triangle.getNormal(p1);
		Vector expected = new Vector(new Point3D(0, 0, -1));
		assertEquals("The method GetNormal for a triangle doesn't work", expected, result);
	}

	/**
	 * Test method for {@link geometries.Polygon#findIntersections(primitives.Ray)}.
	 */
	@Test
	public void testFindIntersections() 
	{
		Triangle triangle=new Triangle(new Point3D(-1,0,0),new Point3D(1,0,0),new Point3D(0,0,1));
		// ============ Equivalence Partitions Tests ==============
		//TC01: Intersection point inside the triangle
		List<Point3D> result = triangle.findIntersections(new Ray(new Point3D(0, 4, 0.5),new Vector(0,-3,0)));
		assertEquals("Intersection point is inside the triangle",List.of(new Point3D(0,0,0.5)),result);
		
		//TC02: Intersection point is outside against edge
		assertNull("Intersection point is outside against edge",triangle.findIntersections(new Ray(new Point3D(0,-3,0),new Vector(-1,3,0.5))));
		
		//TC03: Intersection point is outside against vertex
		assertNull("Intersection point is outside against vertex",triangle.findIntersections(new Ray(new Point3D(0,-2,0),new Vector(0,1,1))));
				
		// =============== Boundary Values Tests =================
		//TC04: Intersection point on the edge
		assertNull("Intersection point is on the edge",triangle.findIntersections(new Ray(new Point3D(0, 1,0),new Vector(0, -2,0))));
	
		//TC05:Intersection point is in the vertex
		assertNull("Intersection point is in the vertex",triangle.findIntersections(new Ray(new Point3D(0,2,0),new Vector(0,-2,1))));
		
		//TC06:Intersection point is in the continuation of the edge
		assertNull("Intersection point is on the continuity of the edge",triangle.findIntersections(new Ray(new Point3D(0,3,0),new Vector(1,-3,2))));
		
	}

}
