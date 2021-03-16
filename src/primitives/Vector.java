package primitives;

public class Vector {
	Point3D head;

	public Vector(Point3D head) {
		if (head.getX() == head.getY() && head.getY() == head.getZ() && head.getZ() == 0)
			throw new RuntimeException("The vector can't be null");
		this.head = head;
	}

	public Vector(double x, double y, double z) {
		if (x == y && y == z && z == 0)
			throw new RuntimeException("The vector can't be null");
		head = new Point3D(x, y, z);
	}

	public Vector(Coordinate x, Coordinate y, Coordinate z) {
		if (x.coord == y.coord && y.coord == z.coord && z.coord == 0)
			throw new RuntimeException("The vector can't be null");
		this.head = new Point3D(x, y, z);
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
		return "Vector [Coordinates of head: x=" + head.getX() + ", y=" + head.getY() + ", z=" + head.getZ() + "]";
	}

	public void add(Vector vector) {
		this._head.add(vector);
	}

	public void Substrct(Vector vector) {
		this._head.Substrct(vector);
	}

	public void scale(double scalingFacor) {
		Coordinate myx = new Coordinate(scalingFacor * this.get_head().getX().get());
		Coordinate myy = new Coordinate(scalingFacor * this.get_head().getY().get());
		Coordinate myz = new Coordinate(scalingFacor * this.get_head().getZ().get());
		Point3D myp = new Point3D(myx, myy, myz);
		this.set_head(myp);
	}

	public void normalize() {
		Coordinate myx = new Coordinate(this.get_head().getX().get() / this.length());
		Coordinate myy = new Coordinate(this.get_head().getY().get() / this.length());
		Coordinate myz = new Coordinate(this.get_head().getZ().get() / this.length());
		Point3D myp = new Point3D(myx, myy, myz);
		this.set_head(myp);
	}

	public Vector crossProduct(Vector vector) {
		Coordinate myx = new Coordinate((this.get_head().getY().get() * vector.get_head().getZ().get())
				- (this.get_head().getZ().get() * vector.get_head().getY().get()));
		Coordinate myy = new Coordinate((this.get_head().getZ().get() * vector.get_head().getX().get())
				- (this.get_head().getX().get() * vector.get_head().getZ().get()));
		Coordinate myz = new Coordinate((this.get_head().getX().get() * vector.get_head().getY().get())
				- (this.get_head().getY().get() * vector.get_head().getX().get()));
		Point3D myp = new Point3D(myx, myy, myz);
		return new Vector(myp);
	}

	public double dotProduct(Vector vector) {
		double myx = this.get_head().getX().get() * vector.get_head().getX().get();
		double myy = this.get_head().getY().get() * vector.get_head().getY().get();
		double myz = this.get_head().getZ().get() * vector.get_head().getZ().get();
		return myx + myy + myz;

	}

}