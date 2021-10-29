import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		Map m = new Map(15);
		assertFalse(m.isGameOver());

		//Creating Players
		Location ghost_loc = new Location(9, 11);
		Location pac_loc = new Location(9, 12);
		Ghost ghost = new Ghost("ghost", ghost_loc, m);
		m.add("ghost", ghost_loc, new GhostComponent(9, 11, 1), Map.Type.GHOST);
		PacMan pacman = new PacMan("pacman", pac_loc, m);
		m.add("pacman", pac_loc, new PacManComponent(9, 12, 1), Map.Type.PACMAN);

		if (ghost.is_pacman_in_range()) {
			ghost.attack();
			assertTrue(m.isGameOver());
			assertTrue(ghost.myMap.isGameOver());
		} else {
			assertTrue(false);
		}
	}
	
	public void testAttackFails() throws FileNotFoundException{
		Map m = new Map(15);
		assertFalse(m.isGameOver());

		//Creating Players
		Location ghost_loc = new Location(9, 11);
		Location pac_loc = new Location(9, 13);
		Ghost ghost = new Ghost("ghost", ghost_loc, m);
		m.add("ghost", ghost_loc, new GhostComponent(9, 11, 1), Map.Type.GHOST);
		PacMan pacman = new PacMan("pacman", pac_loc, m);
		m.add("pacman", pac_loc, new PacManComponent(9, 13, 1), Map.Type.PACMAN);

		ghost.attack();
		assertFalse(m.isGameOver());
		assertFalse(ghost.myMap.isGameOver());
	}
}
