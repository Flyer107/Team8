import junit.framework.*;
import java.awt.Color;
import java.io.*;
import javax.swing.JComponent;


public class TestRunning {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		int x = 2;
		int y = 2;
		NoFrame frame = new NoFrame();
		Ghost ghost = frame.addGhost(new Location(x, y), "test", Color.red);
		PacMan pacman = frame.addPacMan(new Location(x - 1, y - 1));
		Map map = frame.getMap();
		
		int change_x = -1, change_y = -1;
		
		System.out.println(ghost.is_pacman_in_range());
		while (!ghost.is_pacman_in_range() && change_y <= 1) {
			map.move("pacman", new Location(x + change_x, y + change_y), Map.Type.PACMAN);
			
			if (change_x >= 1) {
				change_y++;
				change_x = -1;
			} else {
				change_x++;
			}
			
			if (change_x == 0 && change_y == 0) {
				change_x++;
			}
		}
		
		System.out.println(pacman.myLoc.x);
		System.out.println(pacman.myLoc.y);
		System.out.println(ghost.is_pacman_in_range());
		
		
		
		NoFrame frame = new NoFrame(); //Creates A New Map With Walls and Tokens w/o a Display

		//Creating Players
		Ghost ghost = frame.addGhost(new Location(9, 11), "name", Color.red); //Creates a red ghost named "name" at location x,y
		PacMan pacman = frame.addPacMan(new Location(9, 12)); //Creates PacMan at location x, y
		Map map = frame.getMap();
		
		
		
		
		System.out.println("Pacman x: " + pacman.myLoc.x + ", Ghost x: " + ghost.myLoc.x);
		System.out.println("Pacman y: " + pacman.myLoc.y + ", Ghost y: " + ghost.myLoc.y);
		
		*/
		
		Map map = new Map(2);
	    Location ghostLoc = new Location(0, 1);
	    Location pacLoc = new Location(0, 0);
	    PacManComponent pakupaku = new PacManComponent(0, 0, 1);
	    PacMan pacman = new PacMan("pacman", pacLoc, map);
	    map.add("pacman", pacLoc, pakupaku, Map.Type.PACMAN);
	    Ghost ghost = new Ghost("ghost", ghostLoc, map);
	    map.add("ghost", ghostLoc, new GhostComponent(0, 1, 1), Map.Type.GHOST);
		
		if (ghost.is_pacman_in_range()) {
			map.attack("ghost");
			System.out.println("Is game over: " + map.isGameOver());
			System.out.println("Pacman x: " + pacman.myLoc.x + ", Ghost x: " + ghost.myLoc.x);
			System.out.println("Pacman y: " + pacman.myLoc.y + ", Ghost y: " + ghost.myLoc.y);
		} else {
			System.out.println("Pacman not in range");
		}
	}

}
