package unittests;

import static org.junit.Assert.*;
import org.junit.Test;
import geometries.*;
import primitives.*;
import elements.Camera;

public class IntegrationTests {

	/**
	 * Test method for {@link elements.Camera} intersections with a sphere
	 */
	@Test
	public void SphereTests() {
		Camera camera1 = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
				.setViewPlaneSize(3, 3);
		Camera camera2 = new Camera(new Point3D(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
				.setViewPlaneSize(3, 3);
		// TC01: sphere after the camera 2 intersections
		assertEquals("Mistake in the calcul of intersections points with a sphere", 2,
				camera1.numbersIntersections(new Geometries(new Sphere(new Point3D(0, 0, -3), 1))));
		// TC02: view plane in the sphere 18 intersections
		assertEquals("Mistake in the calcul of intersections points when the wiew plane is in the sphere", 18,
				camera2.numbersIntersections(new Geometries(new Sphere(new Point3D(0, 0, -2.5), 2.5))));
		// TC03: view plane in the sphere 10 intersections
		assertEquals("Mistake in the calcul of intersections points when the wiew plane is in the sphere ", 10,
				camera2.numbersIntersections(new Geometries(new Sphere(new Point3D(0, 0, -2), 2))));
		// TC04: camera in the sphere 9 intersections
		assertEquals("Mistake in the calcul of intersections points when the camera is in the sphere", 9,
				camera1.numbersIntersections(new Geometries(new Sphere(new Point3D(0, 0, 0), 4))));
		// TC05: sphere behind the camera, no intersections
		assertEquals("Mistake in the calcul of intersections points with a sphere behind the camera ", 0,
				camera1.numbersIntersections(new Geometries(new Sphere(new Point3D(0, 0, 1), 0.5))));
	}

	/**
	 * Test method for {@link elements.Camera} intersections with a plane
	 */
	@Test
	public void PlaneTests() {
		Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
				.setViewPlaneSize(3, 3);
		// TC06: plane parallel to the view plane 9 intersections
		assertEquals("Mistake in the calcul of intersections points with a plane parallel to the view plane ", 9,
				camera.numbersIntersections(new Geometries(new Plane(new Point3D(0, 0, -3), new Vector(0, 0, 1)))));
		// TC07: plane 9 intersections
		assertEquals("Mistake in the calcul of intersections points with a plane", 9,
				camera.numbersIntersections(new Geometries(new Plane(new Point3D(0, 0, -1), new Vector(0, -0.5, 1)))));
		// TC08: plane 6 intersections
		assertEquals("Mistake in the calcul of intersections points with a plane", 6,
				camera.numbersIntersections(new Geometries(new Plane(new Point3D(0, 0, -5), new Vector(0, -2, 1)))));
	}

	/**
	 * Test method for {@link elements.Camera} intersections with a triangle
	 */
	@Test
	public void TriangleTests() {
		Camera camera = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, 1, 0)).setDistance(1)
				.setViewPlaneSize(3, 3);
		// TC09: triangle 1 intersection
		assertEquals("Mistake in the calcul of intersections points with a small triangle ", 1,
				camera.numbersIntersections(new Geometries(
						new Triangle(new Point3D(0, 1, -2), new Point3D(1, -1, -2), new Point3D(-1, -1, -2)))));
		// TC10: triangle 2 intersections
		assertEquals("Mistake in the calcul of intersections points with a big triangle ", 2,
				camera.numbersIntersections(new Geometries(
						new Triangle(new Point3D(0, 20, -2), new Point3D(1, -1, -2), new Point3D(-1, -1, -2)))));
	}

}
