package primitives;

public class Ray {
	Point3D p0;
	Vector dir;

	/**
	 * Ray constructor receiving the point of beginning and a director vector
	 * 
	 * @param p0  the point of the beginning of the ray
	 * @param dir the director vector
	 */
	public Ray(Point3D p0, Vector dir) {
		dir.normalize();
		this.p0 = p0;
		this.dir = dir;
	}

	/**
	 * function get
	 * 
	 * @return p0 the point of the beginning of the ray
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * function get
	 * 
	 * @return dir the director vector of the ray
	 */
	public Vector getDir() {
		return dir;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (p0 == null) {
			if (other.p0 != null)
				return false;
		} else if (!p0.equals(other.p0))
			return false;
		if (dir == null) {
			if (other.dir != null)
				return false;
		} else if (!dir.equals(other.dir))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ray [p0=" + p0 + ", direction=" + dir + "]";
	}

}