package primitives;

/**
 * Class Point3D is the class representing a point in 3D, with 3 coordinates
 * 
 */

public class Point3D {
	final Coordinate x;
	final Coordinate y;
	final Coordinate z;

	/**
	 * Zero is a static const point3D with the values (0,0,0)
	 * 
	 */
	public final static Point3D ZERO = new Point3D(0, 0, 0);

	/**
	 * Point3D constructor receiving 3 coordinates values
	 * 
	 * @param x coordinate value x
	 * @param y coordinate value y
	 * @param z coordinate value z
	 */
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Point3D constructor receiving 3 double values
	 * 
	 * @param x1 value for x
	 * @param x2 value for y
	 * @param x3 value for z
	 */
	public Point3D(double x1, double x2, double x3) {
		Coordinate v = new Coordinate(x1);
		Coordinate w = new Coordinate(x2);
		Coordinate u = new Coordinate(x3);
		x = v;
		y = w;
		z = u;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		if (z == null) {
			if (other.z != null)
				return false;
		} else if (!z.equals(other.z))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point3D [ Coordinates:x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	/**
	 * function substract to substract the point from the param do : (other - this)
	 * 
	 * @param other
	 * @return a new vector after substraction
	 */
	public Vector substract(Point3D other) {
		Point3D myPoint = new Point3D(other.x.coord - x.coord, other.y.coord - y.coord, other.z.coord - z.coord);
		return new Vector(myPoint);
	}

	/**
	 * function add to add the @param other to the point3D
	 * 
	 * @return a new point after adding the vector to the old point
	 */
	public Point3D add(Vector other) {
		return new Point3D(x.coord + other.head.x.coord, y.coord + other.head.y.coord, z.coord + other.head.z.coord);
	}

	/**
	 * function to calculate the distance squared between two points
	 * 
	 * @param the second point
	 * @return the distance squared
	 */
	public double distanceSquared(Point3D other) {
		return ((other.x.coord - x.coord) * (other.x.coord - x.coord)
				+ (other.y.coord - y.coord) * (other.y.coord - y.coord)
				+ (other.z.coord - z.coord) * (other.z.coord - z.coord));
	}

	/**
	 * function to calculate the distance between two points
	 * 
	 * @param the second point
	 * @return the distance
	 */
	public double distance(Point3D other) {
		return Math.sqrt(distanceSquared(other));
	}
}
