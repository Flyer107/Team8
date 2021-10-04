import junit.framework.*;
import java.awt.Color;
import java.io.*;
import java.util.ArrayList;

public class TestGhostValidMoves extends TestCase {

  public void testGhostValidMoves() throws FileNotFoundException {
    // Each test creates a 3x3 sandbox for testing valid moves
    Map testMap = new Map(3);
    ArrayList<Location> validMoves = new ArrayList<Location>();

    // Place pacman at the bottom right corner of the map
    Location pacManLoc = new Location(2, 2);
    PacMan testPacMan = new PacMan("test", pacManLoc, testMap);

    //Place ghsot at the center of the map
    Location ghostLoc = new Location(1, 1);
    Ghost testGhost = new Ghost("test", ghostLoc, testMap);

    // Fills the top row with walls and the left column with ghosts
    // Right column and bottom row are filled with cookies with Pacman in the bottom right corner
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        Location loc = new Location(row, col);
        if (loc.x == 0) {
          WallComponent wall = new WallComponent(loc.x, loc.y, 20);
          testMap.add("wall", loc, wall, Map.Type.WALL);
        } else if (loc.y == 0) {
          GhostComponent ghost = new GhostComponent(loc.x, loc.y, Color.red, 20);
          testMap.add("ghost", loc, ghost, Map.Type.GHOST);
        } else {
          CookieComponent tok = new CookieComponent(loc.x, loc.y, 20);
          myMap.add("tok_x" + row + "_y" + col, loc, tok, Map.Type.COOKIE);
        }
      }
    }

    // Ghosts can move through everything except walls
    validMoves = testGhost.get_valid_moves();
    validMoves.forEach((location) -> assertTrue(location.x != 0));
    assertTrue(validMoves.size() == 5);

    // Test for no moves if ghost is surrounded
    testMap = new Map(3);
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        Location loc = new Location(row, col);
        if (loc.x == loc.y && loc.x == 1) {
          // Place pacman at the center of the map
          testGhost = new Ghost("test", loc, testMap);
        } else {
          // Surround pacman with walls
          WallComponent wall = new WallComponent(loc.x, loc.y, 20);
          testMap.add("wall", loc, wall, Map.Type.WALL);
        }
      }
    }

    // No valid moves if pacman is surrounded
    validMoves = testGhost.get_valid_moves();
    assertTrue(validMoves.isEmpty());
  }
}
