import junit.framework.*;
import java.awt.Color;
import java.io.*;

public class TestAttack extends TestCase {

	public void testAttack() throws FileNotFoundException{
		int x = 2;
		int y = 2;
		MainFrame frame = new MainFrame();
		Ghost ghost = frame.addGhost(new Location(x, y), "test", Color.red);
		PacMan pacman = frame.addPacMan(new Location(x - 1, y - 1));
		Map map = frame.getMap();

		int change_x = -1, change_y = -1;
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

		if (ghost.is_pacman_in_range()) {
			ghost.attack();
			assertTrue(map.isGameOver());
			assertTrue(ghost.myMap.isGameOver());
			assertEquals(pacman.myLoc.x, ghost.myLoc.x);
			assertEquals(pacman.myLoc.y, ghost.myLoc.y);
		} else {
			assertTrue(false);
		}
	}
}
