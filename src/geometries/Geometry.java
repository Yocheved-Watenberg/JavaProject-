package geometries;

import primitives.Point3D;

public interface Geometry {
	public abstract primitives.Vector getNormal(Point3D pnt);
}
