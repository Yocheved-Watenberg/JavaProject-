package primitives;

public class Point3D {
	final Coordinate x;
	final Coordinate y;
	final Coordinate z;
	public final static Point3D ZERO = new Point3D(0, 0, 0);

	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

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

	public Vector substract(Point3D other) {
		Point3D myPoint = new Point3D(x.coord - other.x.coord, y.coord - other.y.coord, z.coord - other.z.coord);
		return new Vector(myPoint);
	}

	public Point3D add(Vector other) {
		return new Point3D(x.coord + other.head.x.coord, y.coord + other.head.y.coord, z.coord + other.head.z.coord);
	}

	public double distanceSquared(Point3D other) {
		return ((other.x.coord - x.coord) * (other.x.coord - x.coord)
				+ (other.y.coord - y.coord) * (other.y.coord - y.coord)
				+ (other.z.coord - z.coord) * (other.z.coord - z.coord));
	}

	public double distance(Point3D other) {
		return Math.sqrt(distanceSquared(other));
	}
}
