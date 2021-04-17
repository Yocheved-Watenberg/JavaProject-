/**
 *
 */
package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import primitives.Vector;
import primitives.Util;

/**
 * @author Avigail Amar and Yocheved Watenberg
 *
 */
public class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#add(primitives.Vector)}. ou mettre
	 * try { // test zero vector new Vector(0, 0, 0); out.println("ERROR: zero
	 * vector does not throw an exception"); } catch (Exception e) { }
	 */
	@Test
	public void testAdd() {
//============ Equivalence Partitions Tests ==============
//TA01: checks if the function add works properly.
		Vector v1 = new Vector(1, 2, 3);
		Vector vecAdd = v1.add(new Vector(1, 2, 3));
		Vector verify = new Vector(2, 4, 6);
		assertTrue("The method Add doesn't work properly", verify.equals(vecAdd));
	}

	/**
	 * Test method for {@link primitives.Vector#substract(primitives.Vector)}.
	 */
	@Test
	public void testSubstract() {
//============ Equivalence Partitions Tests ==============
//TA02: checks if the function substract works properly.
		Vector v1 = new Vector(2, 3, 4);
		Vector vecSub = v1.substract(new Vector(1, 2, 3));
		Vector verify = new Vector(1, 1, 1);
		assertTrue("The method Add doesn't work properly", verify.equals(vecSub));
	}

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	public void testScale() {
//============ Equivalence Partitions Tests ==============
//TA03: checks if the function Scale returns a vector with coordinates equal to the scalar*last coordinates .
		Vector v1 = new Vector(2, 3, 4);
		Vector vecScale = v1.scale(2);
		Vector verify = new Vector(4, 6, 8);
		assertTrue("The method Add doesn't work properly", verify.equals(vecScale));
	}

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() {
//============ Equivalence Partitions Tests ==============
//TA04: checks if the function lengthSquared returns the length of the vector squared .
		Vector v1 = new Vector(1, 2, 3);
		assertTrue("lengthSquared() wrong value", Util.isZero(v1.lengthSquared() - 14));
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() {
//============ Equivalence Partitions Tests ==============
//TA05: checks if the function length returns the length of the vector .
		Vector v1 = new Vector(0, 3, 4);
		assertTrue("length() wrong value", Util.isZero(v1.length() - 5));
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	public void testCrossProduct() {
		Vector v1 = new Vector(1, 2, 3);

		// ============ Equivalence Partitions Tests ==============
		Vector v2 = new Vector(0, 3, -2);
		Vector vr = v1.crossProduct(v2);

		// TC01: Test that length of cross-product is proper (orthogonal vectors taken
		// for simplicity)
		assertEquals("crossProduct() wrong result length", v1.length() * v2.length(), vr.length(), 0.00001);

		// TC02: Test cross-product result orthogonality to its operands
		assertTrue("crossProduct() result is not orthogonal to 1st operand", Util.isZero(vr.dotProduct(v1)));
		assertTrue("crossProduct() result is not orthogonal to 2nd operand", Util.isZero(vr.dotProduct(v2)));

		// =============== Boundary Values Tests ==================
		// TC11: test zero vector from cross-productof co-lined vectors
		Vector v3 = new Vector(-2, -4, -6);
		assertThrows("crossProduct() for parallel vectors does not throw an exception", IllegalArgumentException.class,
				() -> v1.crossProduct(v3));

	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() {
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(-2, -4, -6);
		Vector v3 = new Vector(0, 3, -2);

//============ Equivalence Partitions Tests ==============
//TA05: checks that the  DotProduct of orthogonal vectors is not zero
		assertTrue("dotProduct() for orthogonal vectors is not zero", Util.isZero(v1.dotProduct(v3)));
		// ============ Equivalence Partitions Tests ==============
		// TA06: checks that the DotProduct returns the good value
		assertTrue("dotProduct() wrong value", Util.isZero(v1.dotProduct(v2) + 28));
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() {
		Vector v = new Vector(1, 2, 3);
		Vector vCopy = new Vector(v.getHead());
		Vector vCopyNormalize = vCopy.normalize();
//============ Equivalence Partitions Tests ==============
//TA07: checks that the  function Normalize doesn't create a new vector
		assertTrue("  normalize() function creates a new vector", vCopyNormalize == vCopy);
//============ Equivalence Partitions Tests ==============
//TA08: checks that the  function Normalize returns an unit vector
		assertTrue("normalize() result is not a unit vector", Util.isZero(vCopyNormalize.length() - 1));
	}

	/**
	 * Test method for {@link primitives.Vector#normalized()}.
	 */
	@Test
	public void testNormalized() {

		Vector v = new Vector(1, 2, 3);
		Vector u = v.normalized();
//============ Equivalence Partitions Tests ==============
//TA06: checks that the  function Normalize creates a new vector
		assertFalse("normalizated() function does not create a new vector", u == v);
	}

}

