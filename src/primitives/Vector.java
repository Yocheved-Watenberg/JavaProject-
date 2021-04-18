package primitives;

public class Vector {
	Point3D head;

	/**
	 * Vector constructor receiving the head of the vector
	 * 
	 * @param head a point for the head of the vector (the direction)
	 */
	public Vector(Point3D head) {
		if (head.equals(new Point3D(0, 0, 0)))
			throw new IllegalArgumentException("The vector can't be vector 0");
		this.head = head;
	}

	/**
	 * Vector constructor receiving 3 values for the head of the vector
	 * 
	 * @param x : the x of point for the head of the vector
	 * @param y : the y of point for the head of the vector
	 * @param z : the z of point for the head of the vector
	 */
	public Vector(double x, double y, double z) {
		if (new Point3D(x, y, z).equals(new Point3D(0, 0, 0)))
			if (x == y && y == z && z == 0)
				throw new IllegalArgumentException("The vector can't be vector 0");
		head = new Point3D(x, y, z);
	}

	/**
	 * function get
	 * 
	 * @return head: a point for the head of the vector (the direction)
	 */
	public Point3D getHead() {
		return head;
	}

	/**
	 * function set
	 * 
	 * @param head: a point for the head of the vector (the direction)
	 */
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

	/**
	 * function add 2 vectors
	 * 
	 * @param Other : the vector to add to a first vector
	 * @return new Vector of the addition of two vectors
	 */
	public Vector add(Vector Other) {
		return new Vector(new Point3D(head.x.coord + Other.head.x.coord, head.y.coord + Other.head.y.coord,
				head.z.coord + Other.head.z.coord));
	}

	/**
	 * function subtract 2 vectors
	 * 
	 * @param Other : the vector to subtract of a first vector
	 * @return new Vector of the subtraction of (this - other)
	 */
	public Vector substract(Vector Other) {
		return new Vector(new Point3D(head.x.coord - Other.head.x.coord, head.y.coord - Other.head.y.coord,
				head.z.coord - Other.head.z.coord));
	}

	/**
	 * function to multiply a vector by a number
	 * 
	 * @param number : the number to multiply the vector
	 * @return new Vector after multiplication
	 */
	public Vector scale(double number) {
		return new Vector(new Point3D(head.x.coord * number, head.y.coord * number, head.z.coord * number));
	}

	/**
	 * function length squared of a vector
	 * 
	 * @return length squared of a vector
	 */
	public double lengthSquared() {
		return head.x.coord * head.x.coord + head.y.coord * head.y.coord + head.z.coord * head.z.coord;
	}

	/**
	 * function length of a vector
	 * 
	 * @return length of a vector
	 */
	public double length() {
		return Math.sqrt(lengthSquared());
	}

	/**
	 * function cross product of 2 vectors
	 * 
	 * @param the second vector
	 * @return cross product of the 2 vectors ( a vector )
	 */
	public Vector crossProduct(Vector Other) {
		return new Vector(new Point3D(head.y.coord * Other.head.z.coord - head.z.coord * Other.head.y.coord,
				head.z.coord * Other.head.x.coord - head.x.coord * Other.head.z.coord,
				head.x.coord * Other.head.y.coord - head.y.coord * Other.head.x.coord));
	}

	/**
	 * function dot product of 2 vectors
	 * 
	 * @param the second vector
	 * @return dot product of the 2 vectors ( a double )
	 */
	public double dotProduct(Vector Other) {
		return head.x.coord * Other.head.x.coord + head.y.coord * Other.head.y.coord
				+ head.z.coord * Other.head.z.coord;
	}

	/**
	 * function normalize : the vector measures 1
	 * 
	 * @return the vector itself after normalization
	 */
	public Vector normalize() {
		Coordinate myx = new Coordinate(this.getHead().x.coord / this.length());
		Coordinate myy = new Coordinate(this.getHead().y.coord / this.length());
		Coordinate myz = new Coordinate(this.getHead().z.coord / this.length());
		Point3D myp = new Point3D(myx, myy, myz);
		this.setHead(myp);
		return this;
	}

	/**
	 * function normalized : the vector measures 1 now
	 * 
	 * @return the old vector before normalization
	 */
	public Vector normalized() {
		Vector norme = new Vector(this.head);
		norme.normalize();
		return norme;
	}
}