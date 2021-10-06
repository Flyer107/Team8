import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestMapMove extends TestCase {

	public void testMapMove() {
	    // Initializations
	    Map m = new Map(2);
	    Location initLoc = new Location(0, 0);
	    Location destLoc = new Location(0, 1);
	    String name = "P1";
	    PacManComponent pakupaku = new PacManComponent(0, 0, 1);
	    m.add(name, initLoc, pakupaku, Map.Type.PACMAN);

	    assertTrue(m.move(name, destLoc, Map.Type.PACMAN));
	    assertTrue(m.getLoc(initLoc).contains(Map.Type.EMPTY));
	    assertTrue(!m.getLoc(destLoc).contains(Map.Type.EMPTY)); 
	    assertTrue(m.getLoc(destLoc).contains(Map.Type.PACMAN));

	    assertFalse(m.move("ioehoihs", destLoc, Map.Type.GHOST));
	}
}
