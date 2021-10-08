import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestPacManInRange extends TestCase {

	// Pacman is in range
	public void testPacManInRange() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 12)); //Creates PacMan at location x, y

		assertTrue(ghost.is_pacman_in_range() == true);
	}

	// Pacman is in not range
	public void testPacManInRange1() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 12)); //Creates PacMan at location x, y

		assertTrue(ghost.is_pacman_in_range() == false);
	}

	// Pacman is diagonally one unit away
	public void testPacManInRange2() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(7, 10)); //Creates PacMan at location x, y

		assertTrue(ghost.is_pacman_in_range() == false);
	}

	// There is a wall in where pacman is located at
	public void testPacManInRange3() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(8, 12)); //Creates PacMan at location x, y

		// System.out.println(frame.getMap().getLoc(new Location (8,12)));
		assertTrue(ghost.is_pacman_in_range() == false);
	}
	
}