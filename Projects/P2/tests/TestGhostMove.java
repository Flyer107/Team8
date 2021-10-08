import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostMove extends TestCase {

	public void testGhostMove() throws FileNotFoundException{
	    // Test for moved location
	    Map m = new Map(3);
	    Location initLoc = new Location(1,1);
	    Ghost fuyu = new Ghost("fuyu", initLoc, m);
	    m.add("fuyu", initLoc, new GhostComponent(1, 1, 1), Map.Type.GHOST);
	    ArrayList<Location> validMoves = fuyu.get_valid_moves();
	    assertTrue(fuyu.move());
	    assertTrue(validMoves.contains(fuyu.myLoc));
	}
}
