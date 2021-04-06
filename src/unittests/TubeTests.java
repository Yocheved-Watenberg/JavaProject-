/**
 *
 */
package unittests;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Avigail Amar & Yocheved Wattenberg
 *
 */
public class TubeTests {

/**
* Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
*/
@Test
public void testGetNormal()

{   // =============== Boundary Values Tests ==================
 
Ray myAxisRay=new Ray(new Point3D(0,0,0),new Vector(new Point3D(0,1,0)));
Tube myTube=new Tube(myAxisRay,1);
Point3D test=new Point3D(1,0,0);
Vector result=myTube.getNormal(test);
Vector expected=new Vector(Point3D(1,0,0));
assertEquals("The method GetNormal for a tube doesn't work",expected,result);
// =============== Equivalence Partitioning Tests==================
Ray myAxisRay=new Ray(new Point3D(0,0,0),new Vector(new Point3D(0,1,0)));
Tube myTube=new Tube(myAxisRay,1);
Point3D test=new Point3D(1,1,0);
Vector result=myTube.getNormal(test);
Vector expected=new Vector(Point3D(1,0,0));
assertEquals("The method GetNormal for a tube doesn't work",expected,result);
}

}


