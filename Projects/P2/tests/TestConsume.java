import junit.framework.*;
import java.awt.Color;
import java.io.*;
import javax.swing.JComponent;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		int x = 1, y = 1;
		Location pac_loc = new Location(x, y);
		Map m = new Map(15);

		PacMan pacman = new PacMan("pacman", pac_loc, m);
		m.add("pacman", pac_loc, new PacManComponent(x, y, 1), Map.Type.PACMAN);

		CookieComponent test = new CookieComponent(x,y,1);
		m.add("tok_x1_y1", pac_loc, test, Map.Type.COOKIE);
	
		JComponent consumed = pacman.consume();
		assertEquals(consumed, test);
		assertFalse(m.getLoc(pacman.myLoc).contains(Map.Type.COOKIE));
	}
}
