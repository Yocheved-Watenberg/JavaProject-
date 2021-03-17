package primitives;

public class Vector {
	Point3D head;

	public Vector(Point3D head) {
		if (head.equals(new Point3D(0, 0, 0)))
			throw new IllegalArgumentException("The vector can't be vector 0");
		this.head = head;
	}

	public Vector(double x, double y, double z) {
		if (new Point3D(x, y, z).equals(new Point3D(0, 0, 0)))
			if (x == y && y == z && z == 0)
				throw new IllegalArgumentException("The vector can't be vector 0");
		head = new Point3D(x, y, z);
	}

	public Point3D getHead() {
		return head;
	}

	public void setHead(Point3D head) {
		this.head = head;
	}

	/**
	 * equals of Vector
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Vector))
			return false;
		Vector other = (Vector) obj;
		return this.head.equals(other.head);
	}

	/**
	 * toString of Vector
	 */
	@Override
	public String toString() {
		return "Vector [Coordinates of head: x=" + head.x.coord + ", y=" + head.y.coord + ", z=" + head.z.coord + "]";
	}

	public Vector add(Vector Other) {
		return new Vector(new Point3D(head.x.coord + Other.head.x.coord, head.y.coord + Other.head.y.coord,
				head.z.coord + Other.head.z.coord));
	}

	public Vector substract(Vector Other) {
		return new Vector(new Point3D(head.x.coord - Other.head.x.coord, head.y.coord - Other.head.y.coord,
				head.z.coord - Other.head.z.coord));
	}

	public Vector scale(double number) {
		return new Vector(new Point3D(head.x.coord * number, head.y.coord * number, head.z.coord * number));
	}

	public double lengthSquared() {
		return head.x.coord * head.x.coord + head.y.coord * head.y.coord + head.z.coord * head.z.coord;
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	public Vector crossProduct(Vector Other) {
		return new Vector(new Point3D(head.y.coord * Other.head.z.coord - head.z.coord * Other.head.y.coord,
				head.z.coord * Other.head.x.coord - head.x.coord * Other.head.z.coord,
				head.x.coord * Other.head.y.coord - head.y.coord * Other.head.x.coord));
	}

	public double dotProduct(Vector Other) {
		return head.x.coord * Other.head.x.coord + head.y.coord * Other.head.y.coord
				+ head.z.coord * Other.head.z.coord;
	}

	public Vector normalize() {
		Coordinate myx = new Coordinate(this.getHead().x.coord / this.length());
		Coordinate myy = new Coordinate(this.getHead().y.coord / this.length());
		Coordinate myz = new Coordinate(this.getHead().z.coord / this.length());
		Point3D myp = new Point3D(myx, myy, myz);
		this.setHead(myp);
		return this;
	}

	public Vector normalized() {
		Vector norme = normalize();
		return norme;
	}
}