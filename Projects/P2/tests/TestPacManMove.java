import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestPacManMove extends TestCase {

	public void testPacManMove() throws FileNotFoundException{
	    // Test for moved location
	    Map m = new Map(3);
	    Location initLoc = new Location(1,1);
	    PacMan paku = new PacMan("paku", initLoc, m);
	    m.add("paku", initLoc, new PacManComponent(1, 1, 1), Map.Type.PACMAN);
	    ArrayList<Location> validMoves = paku.get_valid_moves();
	    assertTrue(paku.move());
	    assertTrue(validMoves.contains(paku.myLoc));
	}
}
