import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
	    Map noSpace = new Map(1);
	    Location loc = new Location(0,0);
	    Ghost fuyufuyu = new Ghost("fuyufuyu", loc, noSpace);
	    assertFalse(fuyufuyu.move());

	    // Test for moved location
	    Map m = new Map(3);
	    Location initLoc = new Location(1,1);
	    Ghost fuyu = new Ghost("fuyu", initLoc, m);
	    ArrayList<Location> validMoves = fuyu.get_valid_moves();
	    assertTrue(fuyu.move());
	    assertTrue(validMoves.contains(fuyu.myLoc));
	}
}
