package geometries;

import java.util.List;

import java.util.LinkedList;

import primitives.Point3D;
import primitives.Ray;


/**
 * Geometries class implements Intersectable (have the function findIntersections)
 * List of Intersectables 
 * @author Avigail Amar and Yocheved Wattenberg
 */
public class Geometries implements Intersectable {

	private List<Intersectable> intersectable;

	/**
	 * Geometries empty constructor 
	 * Create an empty list of intersectables geometries
	 */
	public Geometries() {
		intersectable = new LinkedList<Intersectable>();   
		//We used linked list to save time in adding and deleting data
	}

	/**
	 * Geometries constructor
	 * Create a list of intersectables geometries with the @param
	 * @param List of intersectables geometries 
	 */
	public Geometries(Intersectable... geometries) {
		intersectable = List.of(geometries);
	}

	/**
	 * Function add to add a list of intersectables geometries to the list
	 * 
	 * @param geometries : list to add 
	 */
	public void add(Intersectable... geometries) {
		for (Intersectable i:geometries)
		intersectable.add(i);
	}

	/**
	 * function findIntersections to find the intersections of all the geometries by a same ray 
	 * 
	 * @return list of intersection points
	 */
	@Override
	public List<Point3D> findIntersections(Ray ray) {
		LinkedList<Point3D> intersections = new LinkedList<Point3D>();
		for (Intersectable i : intersectable) {
			if (i.findIntersections(ray) != null)
				for (Point3D p : i.findIntersections(ray))
					intersections.add(p);
		}
		if (intersections.isEmpty())
			return null;
		return intersections;

	}

}
