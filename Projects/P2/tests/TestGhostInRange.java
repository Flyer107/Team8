import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestGhostInRange extends TestCase {

	// Ghost is in range
	public void testGhostInRange() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 12)); //Creates PacMan at location x, y

		assertTrue(pacman.is_ghost_in_range() == true);
	}

	// Ghost is diagonally one unit away
	public void testGhostInRange2() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(10, 12)); //Creates PacMan at location x, y

		assertTrue(pacman.is_ghost_in_range() == true);
	}

	// When ghost is not with in range
	public void testGhostInRange3() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(10, 13)); //Creates PacMan at location x, y

		assertTrue(pacman.is_ghost_in_range() == false);
	}

	// When ghost is in range but there is a wall there already
	public void testGhostInRange4() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(1, 1), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(0, 0)); //Creates PacMan at location x, y

		assertTrue(pacman.is_ghost_in_range() == false);
	}
}

