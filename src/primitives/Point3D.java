package primitives;
 

public class Point3D {
	private Coordinate x;
	private Coordinate y;
	private Coordinate z;
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Point3D(double x1,double x2,double x3) {
		super();
		Coordinate v=new Coordinate(x1);
		Coordinate w=new Coordinate(x2);
		Coordinate u=new Coordinate(x3);
		x=v;
		y=w;
		z=u;

	}
	
	 /**
     * Equals
     * 
     * a changer?
     */
	
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
	public double getX() {
		return x.coord;
	}
	public void setX(Coordinate x) {
		this.x = x;
	}
	public double getY() {
		return y.coord;
	}
	public void setY(Coordinate y) {
		this.y = y;
	}
	public double getZ() {
		return z.coord;
	}
	public void setZ(Coordinate z) {
		this.z = z;
	}
	@Override
	public String toString() {
		return "Point3D [ Coordinates:x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	public Vector substract (Point3D other) 
	{
		Point3D myPoint= new Point3D(other.getX()-getX(),other.getY()-getY(),other.getZ()-getZ());
		return new Vector(myPoint) ;
	}
	public Point3D add(Vector other) 
	{
		return new Point3D(getX()+other.head.getX(),getY()+other.head.getY(),getZ()+other.head.getZ());
	 }
	public double distanceSquared(Point3D other) 
	{
		return ((other.getX()-getX())*(other.getX()-getX())+(other.getY()-getY())*(other.getY()-getY())+(other.getZ()-getZ())*(other.getZ()-getZ()));
	}
	public double distance(Point3D other) 
	{
		return Math.sqrt(distanceSquared(other));
	}
	


}
