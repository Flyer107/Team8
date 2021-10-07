import junit.framework.*;
import java.awt.Color;
import java.io.*;
import javax.swing.JComponent;

public class TestConsume extends TestCase {

	public void testConsume() throws FileNotFoundException {
		int x = 1, y = 1;
		MainFrame frame = new MainFrame();
		PacMan pacman = frame.addPacMan(new Location(x, y));
		Map map = frame.getMap();
		CookieComponent test = new CookieComponent(x,y,20);
		map.add("power-cookie", new Location(x, y), test, Map.Type.COOKIE);
	
		JComponent consumed = pacman.consume();
		assertEquals(consumed, test);
		assertFalse(map.getLoc(pacman.myLoc).contains(Map.Type.COOKIE));
	}
}
