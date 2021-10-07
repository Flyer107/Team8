import junit.framework.*;
import java.awt.Color;
import java.io.*;


public class TestMapGetLoc extends TestCase{
	
	// Type ghost
	public void testMapGetLoc() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		
		assertTrue(frame.getMap().getLoc(new Location(9,11)).contains(Map.Type.GHOST));
	}

	// Ghost placed where wall is
	public void testMapGetLoc1() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		frame.initPlayers(); //Creates all of the players
		
		assertTrue(frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.PACMAN));
	}

	// Pacman and ghost in the same location
	public void testMapGetLoc2() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 11)); //Creates PacMan at location x, y

		assertTrue(frame.getMap().getLoc(new Location(9,11)) == null);
	}

	// Type Pacman
	public void testMapGetLoc3() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		frame.initPlayers(); //Creates all of the players
		
		assertTrue(frame.getMap().getLoc(new Location(1,1)).contains(Map.Type.PACMAN));
	}

	// Type Wall
	public void testMapGetLoc4() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		frame.initPlayers(); //Creates all of the players
		
		assertTrue(frame.getMap().getLoc(new Location(0,0)).contains(Map.Type.WALL));
	}

	// Type Cookie
	public void testMapGetLoc5() throws FileNotFoundException{
		//Creating A Map
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		frame.initPlayers(); //Creates all of the players
		
		assertTrue(frame.getMap().getLoc(new Location(2,1)).contains(Map.Type.COOKIE));
	}
}
