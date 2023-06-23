/**
 * On Mac/Linux:
 * javac -cp .:junit-cs211.jar *.java         # compile everything
 * java -cp .:junit-cs211.jar E3Tester        # run tester
 * <p>
 * On windows replace colons with semicolons: (: with ;)
 * javac -cp .;junit-cs211.jar *.java         # compile everything
 * java -cp .;junit-cs211.jar E3Tester        # run tester
 */

 import static org.junit.Assert.*;
 import org.junit.Test;
 
 public class E3Tester {
	 public static void main(String args[]) {
		 org.junit.runner.JUnitCore.main("E3Tester");
	 }
 
	 /**
		 This is a helper method, not an actual test
 
		 Notice that:
		 - the @Test annotation is missing
		 - the visibility is private
	 */
	 private boolean someHelp(String someParameter) {
		 return true;
	 }
 
	 // /**
	 //     This is an empty test; it's always a pass
	 //     Not a useful test!
	 // */
	 // @Test
	 // public void test_Point_01() {
	 // }
 
	 // /**
	 //     This test always fails
	 //     Not a useful test either!
	 // */
	 // @Test
	 // public void test_Point_02() {
	 //     fail();
	 // }
 
 
	 /**
	  * check Point.constructor
	 */
	 @Test
	 public void test_Point_03()
	 {
		 try {
			 Point point = new Point(1,2,3);
		 }
		 catch (Exception e) {fail();}
	 }
 
	  /**
	  * check if exception is thrown for negative x value 
	  */
	  @Test(expected = ArithmeticException.class)
	  public void test_Point_04() 
	  {
		Point point = new Point(-1, 1, 1);
	  }

	 /**
	  * check if exception is thrown for negative y value 
	  */
	  @Test(expected = ArithmeticException.class)
	  public void test_Point_05() 
	  {
		Point point = new Point(1, -1, 1);
	  }

	 /**
	  * check if exception is thrown for negative z value 
	  */
	  @Test(expected = ArithmeticException.class)
	  public void test_Point_06() 
	  {
		Point point = new Point(1, 1, -1);
	  }

	 /**
	  * check negative x value error message
	  */
	 @Test
	 public void test_Point_07() 
	 {
		 try {
			 Point point = new Point(-1, 1, 1);
		 }
		 catch (ArithmeticException ae) {assertEquals("Invalid value -1.0 for coordinate x", ae.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check negative y value error message
	  */
	 @Test
	 public void test_Point_08()
	 {
		 try {
			 Point point = new Point(1, -1, 1);
		 }
		 catch (ArithmeticException ae) {assertEquals("Invalid value -1.0 for coordinate y", ae.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check negative z value error message
	  */
	 @Test
	 public void test_Point_09()
	 {
		 try {
			 Point point = new Point(1, 1, -1);
		 }
		 catch (ArithmeticException ae) {assertEquals("Invalid value -1.0 for coordinate z", ae.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.toString : passes
	 */
	 @Test
	 public void test_Point_toString_01()
	 {
		 try {
			 Point point = new Point(1.1,2.2,3.3); //passes
			 assertEquals("{1.1,2.2,3.3}", point.toString());
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.equals : passes
	 */
	 @Test
	 public void test_Point_equals_01()
	 {
		 try {
			 Point p1 = new Point(1.1,2.2,3.3); //passes
			 Point p2 = new Point(1.1,2.2,3.3); //passes
			 assertTrue(p1.equals(p2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.equals : not equal
	 */
	 @Test
	 public void test_Point_equals_02()
	 {
		 try {
			 Point p1 = new Point(1.1,2.2,3.3); //passes
			 Point p2 = new Point(1.0,2.2,3.3); //passes
			 assertFalse(p1.equals(p2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.equals : wrong object
	 */
	 @Test
	 public void test_Point_equals_03()
	 {
		 try {
			 Point p1 = new Point(1.1,2.2,3.3); //passes
			 assertFalse(p1.equals("HAHA"));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.distance : passes
	 */
	 @Test
	 public void test_Point_distance_01()
	 {
		 try {
			 Point p1 = new Point(1.1,2.2,3.3); //passes
			  Point p2 = new Point(1.1,2.2,3.3); //passes
			 assertTrue(0.0 == p1.distance(p2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.distance : passes
	 */
	 @Test
	 public void test_Point_distance_02()
	 {
		 try {
			 //square root of 25 = (9 + 16 + 0) = 5
			 Point p1 = new Point(4,20,1); //passes
			  Point p2 = new Point(1,24,1); //passes
			 assertTrue(5.0 == p2.distance(p1));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check Point.distance : passes
	 */
	 @Test
	 public void test_Point_distance_03()
	 {
		 try {
			 //square root of 81 = (1 + 16 + 64) = 9
			 Point p1 = new Point(2,7,96); //passes
			  Point p2 = new Point(3,3,88); //passes
			 assertTrue(9.0 == p1.distance(p2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face constructor : passes
	  */
	 @Test
	 public void test_Face_01()
	 {
		 try {
			 Point p4 = new Point(1, 2, 3); //passes
			 Point p5 = new Point(3, 1, 2); //passes
			 Point p6 = new Point(2, 3, 1); //passes
			 Face f2 = new Face(p4, p5, p6); //passes
		 }
		 catch (Exception e) {fail();}
 
	 }
 
	 /**
	  * check if face exception thrown for face constructor with zero area
	  */
	  @Test(expected = FaceException.class)
	  public void test_Face_02()
	  {
		Point p1 = new Point(1, 1, 1); //passes
		Point p2 = new Point(1, 1, 1); //passes
		Point p3 = new Point(1, 1, 1); //passes
		Face f1 = new Face(p1, p2, p3);
	  }

	 /**
	  * check if face exception thrown face constructor where points not equidistant
	  */
	  @Test(expected = FaceException.class)
	  public void test_Face_03()
	  {
		Point p7 = new Point(1, 2, 2); //passes
		Point p8 = new Point(3, 1, 2); //passes
		Point p9 = new Point(2, 3, 1); //passes
		Face f3 = new Face(p7, p8, p9);
	  }

	 /**
	  * check face constructor : zero area error message
	  */
	 @Test
	 public void test_Face_04()
	 {
		 try {
			 Point p1 = new Point(0, 0, 0); //passes
			 Point p2 = new Point(0, 0, 0); //passes
			 Point p3 = new Point(0, 0, 0); //passes
			 Face f1 = new Face(p1, p2, p3);
		 }
		 catch (FaceException fe) {assertEquals("A face can't have a zero area", fe.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face constructor : not equidistant error message
	  */
	 @Test
	 public void test_Face_05()
	 {
		 try {
			 Point p7 = new Point(1, 2, 2); //passes
			 Point p8 = new Point(3, 1, 2); //passes
			 Point p9 = new Point(2, 3, 1); //passes
			 Face f3 = new Face(p7, p8, p9);
		 }
		 catch (FaceException fe) {assertEquals("Points must be equidistant", fe.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face toString : passes
	  */
	 @Test
	 public void test_Face_toString_01()
	 {
		 try {
			 Point p4 = new Point(1, 2, 3); //passes
			 Point p5 = new Point(3, 1, 2); //passes
			 Point p6 = new Point(2, 3, 1); //passes
			 Face f2 = new Face(p4, p5, p6); //passes
			 assertEquals("[{1.0,2.0,3.0}-{3.0,1.0,2.0}-{2.0,3.0,1.0}]", f2.toString());
		 }
		 catch (Exception e) {fail();}
 
	 }
 
	 /**
	  * check face equals : true
	  */
	 @Test
	 public void test_Face_equals_01()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Face f1 = new Face(p1, p2, p3);
			 Point p4 = new Point(2, 2, 2); //passes
			 Point p5 = new Point(2, 0, 0); //passes
			 Point p6 = new Point(0, 2, 0); //passes
			 Face f2 = new Face(p6, p5, p4);
			 assertTrue(f1.equals(f2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face equals : false 
	  */
	 @Test
	 public void test_Face_equals_02()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Face f1 = new Face(p1, p2, p3);
			 Point p4 = new Point(2, 2, 2); //passes
			 Point p5 = new Point(2, 0, 0); //passes
			 Point p6 = new Point(0, 2, 0); //passes
			 Face f2 = new Face(p6, p5, p4);
			 assertFalse(f1.equals(f2));
		 }
		 catch (Exception e) {fail();}
 
	 }
 
	 /**
	  * check face equals : false b/c wrong object
	  */
	 @Test
	 public void test_Face_equals_03()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Face f1 = new Face(p1, p2, p3);
			 assertFalse(f1.equals("LOL"));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face edge :
	  */
	 @Test
	 public void test_Face_edge_01()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Face f1 = new Face(p1, p2, p3);
			 assertTrue(Math.sqrt(8) == f1.edge());
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face area : 
	  */
	 @Test
	 public void test_Face_area_01()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Face f1 = new Face(p1, p2, p3); //passes
			 assertTrue((Math.sqrt(3) / 4) * Math.pow(p1.distance(p2),2) == f1.area());
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face area :
	  */
	 @Test
	 public void test_Face_area_02()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Face f1 = new Face(p1, p2, p3);
			 assertTrue((Math.sqrt(3) / 4) * Math.pow(p1.distance(p2),2) == f1.area());
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face adjacent : true
	  */
	 @Test
	 public void test_Face_adjacent_01()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Point p4 = new Point(1, 1, 3);
			 Face f1 = new Face(p1, p2, p3);
			 Face f2 = new Face(p2, p3, p4);
			 assertTrue(f1.adjacent(f2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face adjacent : false b/c shares no edge
	  */
	 @Test
	 public void test_Face_adjacent_02()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Face f1 = new Face(p1, p2, p3);
			 Point p4 = new Point(2, 2, 2);
			 Point p5 = new Point(2, 0, 0);
			 Point p6 = new Point(0, 2, 0);
			 Face f2 = new Face(p4, p5, p6);
			 assertFalse(f1.adjacent(f2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check face adjacent : false b/c faces are equal
	  */
	 @Test
	 public void test_Face_adjacent_03()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Face f1 = new Face(p1, p2, p3);
			 Point p5 = new Point(3, 3, 3);
			 Point p6 = new Point(3, 1, 1);
			 Point p4 = new Point(1, 3, 1);
			 Face f2 = new Face(p4, p5, p6);
			 assertFalse(f1.adjacent(f2));
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron constructor with faces : passes
	  */
	 @Test
	 public void test_Tetrahedron_withFaces_01()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Point p4 = new Point(1, 1, 3);
			 Face f1 = new Face(p1, p2, p3);
			 Face f2 = new Face(p2, p3, p4);
			 Face f3 = new Face(p3, p4, p1);
			 Face f4 = new Face(p4, p1, p2);
			 Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
		 }
		 catch (Exception e) {fail();}
	 }

	 /**
	  * check if tetrahedron constructor throws exception for faces not all adjacent
	  */
	  @Test(expected = TetrahedronException.class)
	  public void test_Tetrahedron_withFaces_03() throws TetrahedronException
	  {
		Point p1 = new Point(3, 3, 3);
		Point p2 = new Point(3, 1, 1);
		Point p3 = new Point(1, 3, 1);
		Point p4 = new Point(1, 1, 3);
		Face f1 = new Face(p1, p2, p3);
		Face f2 = new Face(p2, p3, p4);
		Face f3 = new Face(p3, p4, p1);
		Point p5 = new Point(2, 2, 2);
		Point p6 = new Point(2, 0, 0);
		Point p7 = new Point(0, 2, 0);
		Face f4 = new Face(p5, p6, p7);
		Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
	  }
 
	 /**
	  * check tetrahedron constructor error message with faces : fails b/c not all adjacent
	  */
	 @Test
	 public void test_Tetrahedron_withFaces_04()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Point p4 = new Point(1, 1, 3);
			 Face f1 = new Face(p1, p2, p3);
			 Face f2 = new Face(p2, p3, p4);
			 Face f3 = new Face(p3, p4, p1);
			 Point p5 = new Point(2, 2, 2);
			 Point p6 = new Point(2, 0, 0);
			 Point p7 = new Point(0, 2, 0);
			 Face f4 = new Face(p5, p6, p7);
			 Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
		 }
		 catch (TetrahedronException te) {assertEquals("The four faces do not form a tetrahedron", te.getMessage());}
		 catch (Exception e) {fail();}
	 }

	 /**
	  * check if tetrahedron constructor throws exception with duplicate face
	  */
	  @Test(expected = TetrahedronException.class)
	  public void test_Tetrahedron_withFaces_05() throws TetrahedronException
	  {
		Point p1 = new Point(3, 3, 3);
		Point p2 = new Point(3, 1, 1);
		Point p3 = new Point(1, 3, 1);
		Point p4 = new Point(1, 1, 3);
		Face f1 = new Face(p1, p2, p3);
		Face f2 = new Face(p2, p3, p4);
		Face f3 = new Face(p3, p4, p1);

		Face f4 = new Face(p2, p1, p3); //dupe
		Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
	  }
 
	 /**
	  * check tetrahedron constructor error message with faces : fails b/c one face is duplicate
	  */
	 @Test
	 public void test_Tetrahedron_withFaces_06()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Point p4 = new Point(1, 1, 3);
			 Face f1 = new Face(p1, p2, p3);
			 Face f2 = new Face(p2, p3, p4);
			 Face f3 = new Face(p3, p4, p1);
 
			 Face f4 = new Face(p2, p1, p3); //dupe
			 Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
		 }
		 catch (TetrahedronException te) {assertEquals("The four faces do not form a tetrahedron", te.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron constructor with points : passes
	  */
	 @Test
	 public void test_Tetrahedron_withPoints_01()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Point p4 = new Point(0, 0, 2);
			 Tetrahedron t1 = new Tetrahedron(p1, p2, p3, p4);
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron constructor error message with points : fails b/c not all edges are the same length
	  */
	 @Test
	 public void test_Tetrahedron_withPoints_02()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Point p4 = new Point(0, 0, 0);
			 Tetrahedron t1 = new Tetrahedron(p1, p2, p3, p4);
		 }
		 catch (TetrahedronException te) {assertEquals("The four faces do not form a tetrahedron", te.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron constructor error message with points : fails b/c one point is dupe
	  */
	 @Test
	 public void test_Tetrahedron_withPoints_03()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
 
			 Point p4 = new Point(2, 2, 2); //dupe
			 Tetrahedron t1 = new Tetrahedron(p1, p2, p3, p4);
		 }
		 catch (TetrahedronException te) {assertEquals("The four faces do not form a tetrahedron", te.getMessage());}
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron w faces' area : 
	  */
	 @Test
	 public void test_Tetrahedron_FacesArea_01()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Point p4 = new Point(1, 1, 3);
			 Face f1 = new Face(p1, p2, p3);
			 Face f2 = new Face(p2, p3, p4);
			 Face f3 = new Face(p3, p4, p1);
			 Face f4 = new Face(p4, p1, p2);
			 Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
			 assertTrue(f1.area() * 4 == t1.area());
		 }
		 catch (Exception e) {fail();}
	 }
	 
 
	 /**
	  * check tetrahedron w points' area : 
	  */
	 @Test
	 public void test_Tetrahedron_PointsArea_01()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Point p4 = new Point(0, 0, 2);
			 Tetrahedron t1 = new Tetrahedron(p1, p2, p3, p4);
			 assertTrue((Math.sqrt(3) * Math.pow(p1.distance(p2), 2)) == t1.area());
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron w faces' volume : 
	  */
	 @Test
	 public void test_Tetrahedron_FacesVolume_01()
	 {
		 try {
			 Point p1 = new Point(3, 3, 3);
			 Point p2 = new Point(3, 1, 1);
			 Point p3 = new Point(1, 3, 1);
			 Point p4 = new Point(1, 1, 3);
			 Face f1 = new Face(p1, p2, p3);
			 Face f2 = new Face(p2, p3, p4);
			 Face f3 = new Face(p3, p4, p1);
			 Face f4 = new Face(p4, p1, p2);
			 Tetrahedron t1 = new Tetrahedron(f1, f2, f3, f4);
			 assertTrue(Math.pow((p1.distance(p2)), 3) / (6 * Math.sqrt(2)) == t1.volume());
		 }
		 catch (Exception e) {fail();}
	 }
 
	 /**
	  * check tetrahedron w points' volume : 
	  */
	 @Test
	 public void test_Tetrahedron_PointsVolume_01()
	 {
		 try {
			 Point p1 = new Point(2, 2, 2);
			 Point p2 = new Point(2, 0, 0);
			 Point p3 = new Point(0, 2, 0);
			 Point p4 = new Point(0, 0, 2);
			 Tetrahedron t1 = new Tetrahedron(p1, p2, p3, p4);
			 assertTrue(Math.pow((p1.distance(p2)), 3) / (6 * Math.sqrt(2)) == t1.volume());
		 }
		 catch (Exception e) {fail();}
	 }
 }