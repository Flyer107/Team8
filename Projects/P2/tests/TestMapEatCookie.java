import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapEatCookie {

  public void testMapEatCookie() {
    Map testMap = new Map();
    Location testLoc = new Location(1, 1);
    CookieComponent testCoookie = new CookieComponent(1, 1, 20);
    testMap.add("tok_x1_y1", testLoc, testCoookie, Map.Type.COOKIE);

    //Eating a cookie returns the correct component
    CookieComponent returnedCookie = testMap.eatCookie("tok_x1_y1");
    assertEqual(testCoookie, returnedCookie);

    //Cookie is no longer at its location
    assertTrue(!testMap.getLoc(testLoc).contains(Map.Type.COOKIE));

    //Player is awarded a point
    assertEqual(testMap.getCookies(), 1);

    //Attempting to eat a nonexistent cookie returns null
    returnedCookie = testMap.eatCookie("tok_x2_y2");
    assertEqual(returnedCookie, null);
  }
}
