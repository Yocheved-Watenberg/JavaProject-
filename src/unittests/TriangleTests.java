package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import geometries.*;
import primitives.*;

public class TriangleTests {

	@Test
	public void testGetNormal() {

		Point3D p1 = new Point3D(1, 1, 1);
		Point3D p2 = new Point3D(2, 3, 1);
		Point3D p3 = new Point3D(3, 0, 1);
		Triangle triangle = new Triangle(p1, p2, p3);
		Vector result = triangle.getNormal(p1);
		Vector expected = new Vector(new Point3D(0,0,-1));
		assertEquals("The method GetNormal for a triangle doesn't work", expected, result);
	}

}
