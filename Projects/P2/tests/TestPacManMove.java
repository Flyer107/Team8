import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
	    // Test for no moves
	    Map noSpace = new Map(1);
	    Location loc = new Location(0,0);
	    PacMan pakupaku = new PacMan("pakupaku", loc, noSpace);
	    assertFalse(pakupaku.move());

	    // Test for moved location
	    Map m = new Map(3);
	    Location initLoc = new Location(1,1);
	    PacMan paku = new PacMan("paku", initLoc, m);
	    ArrayList<Location> validMoves = paku.get_valid_moves();
	    assertTrue(paku.move());
	    assertTrue(validMoves.contains(paku.myLoc));
	}
}
