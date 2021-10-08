import java.awt.Color;
import java.io.FileNotFoundException;

import junit.framework.*;


public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 12)); //Creates PacMan at location x, y
		Map map = frame.getMap();
		
		if (ghost.is_pacman_in_range()) {
			map.attack("test");
			assertTrue(map.isGameOver());
		} else {
			assertTrue(false);
		}
	}
}
