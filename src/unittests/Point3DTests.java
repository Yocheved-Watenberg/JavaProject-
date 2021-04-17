/**
 *
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

import primitives.Point3D;
import primitives.Vector;

/**
 * @author Avigail Amar & Yocheved Wattenberg
 *
 */
public class Point3DTests {

	/**
	 * Test method for {@link primitives.Point3D#substract(primitives.Point3D)}.
	 */
	@Test
	public void testSubstract() {// ============ Equivalence Partitions Tests ==============
//TA01: checks if the function substract works properly.
		Point3D p1 = new Point3D(1, 2, 3);
		Vector vecSubResult = new Vector(1, 1, 1);
		Vector vecSub = p1.substract(new Point3D(2, 3, 4));
		assertTrue(" Point - Point does not work correctly\"", vecSubResult.equals(vecSub));
	}

	/**
	 * Test method for {@link primitives.Point3D#add(primitives.Vector)}.
	 */
	@Test
	public void testAdd() {
//============ Equivalence Partitions Tests ==============
//TA02: checks if the function add works properly.
		Point3D p1 = new Point3D(1, 2, 3);
		Point3D vecAdd = p1.add(new Vector(-1, -2, -3));
		assertTrue(" Point - Point does not work correctly\"", vecAdd.equals(Point3D.ZERO));

	}

	/**
	 * Test method for
	 * {@link primitives.Point3D#distanceSquared(primitives.Point3D)}.
	 */
	@Test
	public void testDistanceSquared() {// ============ Equivalence Partitions Tests ==============
//TA03: checks if the function testDistanceSquared works properly.

		Point3D p1 = new Point3D(1, 1, 1);
		Point3D p2 = new Point3D(2, 2, 2);
		assertEquals("DistanceSquared doesn't work properly", p1.distanceSquared(p2), 3, 0.00001);

	}

	/**
	 * Test method for {@link primitives.Point3D#distance(primitives.Point3D)}.
	 */
	@Test
	public void testDistance() {// ============ Equivalence Partitions Tests ==============
//TA04: checks if the function testDistance works properly.

		Point3D p1 = new Point3D(0, 0, 2);
		Point3D p2 = new Point3D(0, 0, 4);
		assertEquals("Distance doesn't work properly", p1.distance(p2), 2, 0.00001);
	}

}
