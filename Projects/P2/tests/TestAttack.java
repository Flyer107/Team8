import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 12)); //Creates PacMan at location x, y
		Map map = frame.getMap();

		if (ghost.is_pacman_in_range()) {
			ghost.attack();
			assertTrue(map.isGameOver());
			assertTrue(ghost.myMap.isGameOver());
		} else {
			assertTrue(false);
		}
	}
	
	public void testAttackFails() throws FileNotFoundException{
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 15)); //Creates PacMan at location x, y
		Map map = frame.getMap();

		ghost.attack();
		assertFalse(map.isGameOver());
		assertFalse(ghost.myMap.isGameOver());
	}
}
