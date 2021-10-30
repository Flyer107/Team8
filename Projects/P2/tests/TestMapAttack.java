import java.awt.Color;
import java.io.FileNotFoundException;

import junit.framework.*;


public class TestMapAttack extends TestCase {

	public void testMapAttack() throws FileNotFoundException{	
		Map m = new Map(15);

		//Creating Players
		Location ghost_loc = new Location(9, 11);
		Location pac_loc = new Location(9, 12);
		Ghost ghost = new Ghost("ghost", ghost_loc, m);
		m.add("ghost", ghost_loc, new GhostComponent(9, 11, 1), Map.Type.GHOST);
		PacMan pacman = new PacMan("pacman", pac_loc, m);
		m.add("pacman", pac_loc, new PacManComponent(9, 12, 1), Map.Type.PACMAN);
		
		if (ghost.is_pacman_in_range()) {
			m.attack("ghost");
			assertTrue(m.isGameOver());
		} else {
			assertTrue(false);
		}
	}
}
