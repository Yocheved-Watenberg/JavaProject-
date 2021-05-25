package geometries;

import java.util.List;



import java.util.LinkedList;
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
	 * function findGeoIntersections to find the intersections of all the geometries by a same ray 
	 * 
	 * @return list of GeoPoints 
	 */
	@Override
	public List<GeoPoint> findGeoIntersections(Ray ray) {
		LinkedList<GeoPoint> intersections = new LinkedList<GeoPoint>();
		for (Intersectable i : intersectable) {
			if (i.findGeoIntersections(ray) != null)
				for (GeoPoint p : i.findGeoIntersections(ray))
					intersections.add(p);
		}
		if (intersections.isEmpty())
			return null;
		return intersections;
	}
	
		
		
	

}
