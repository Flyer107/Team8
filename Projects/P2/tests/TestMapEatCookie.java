import junit.framework.*;
import java.awt.Color;
import java.io.*;

import javax.swing.JComponent;

public class TestMapEatCookie extends TestCase {

  public void testMapEatCookie() {
    Map testMap = new Map(3);
    Location testLoc = new Location(1, 1);
    JComponent testCoookie = new CookieComponent(1, 1, 20);
    testMap.add("tok_x1_y1", testLoc, testCoookie, Map.Type.COOKIE);

    //Eating a cookie returns the correct component
    JComponent returnedCookie = testMap.eatCookie("tok_x1_y1");
    assertEquals(testCoookie, returnedCookie);

    //Cookie is no longer at its location
    assertTrue(!testMap.getLoc(testLoc).contains(Map.Type.COOKIE));

    //Player is awarded a point
    assertEquals(testMap.getCookies(), 1);

    //Attempting to eat a nonexistent cookie returns null
    returnedCookie = testMap.eatCookie("tok_x2_y2");
    assertEquals(returnedCookie, null);

    System.out.println("All tests passed!");

  }
}
