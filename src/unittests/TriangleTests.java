package unittests;

import static org.junit.Assert.*;

import primitives.Vector;

import org.junit.Test;

import geometries.Triangle;
import primitives.Point3D;

public class TriangleTests {

@Test
public void testGetNormal()
{

Point3D p1=new Point3D(1,1,1);
Point3D p2=new Point3D(2,3,2);
Point3D p3=new Point3D(3,1,2);
Point3D p4=new Point3D(2,3,2);
Triangle triangle=new Triangle(p1,p2,p3);
Vector result=triangle.getNormal(p4);
Vector expected=new Vector(new Point3D(2,1,-4));
assertEquals("The method GetNormal for a triangle doesn't work",expected,result);
}

}


