import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift;
  private Random rand;

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
		this.rand = new Random();
	}

	public ArrayList<Location> get_valid_moves() {
		ArrayList<Location> validMoves = new ArrayList<Location>();

    for (int x = -1; x < 2; x++) {
      for (int y = -1; y < 2; y++) {
        Location loc = this.myLoc.shift(x, y);
        if (!loc.equals(this.myLoc) && !this.myMap.getLoc(loc).contains(Map.Type.WALL) && !this.myMap.getLoc(loc).contains(Map.Type.GHOST)) {
          validMoves.add(loc);
        }
      }
    }

    return validMoves;
	}

	public boolean move() {
    
		ArrayList<Location> moves = this.get_valid_moves();
		if(moves.size() < 0) {
			int randIndex = rand.nextInt(moves.size());
			this.myLoc = moves.get(randIndex);
			return this.myMap.move(this.myName, moves.get(randIndex), Map.Type.PACMAN);
		} else {
			return false;
		}
	}

	public boolean is_ghost_in_range() { 
		Location ghost_top_left = myLoc.shift(-1, 1);
	  Location ghost_top = myLoc.shift(0, 1);
		Location ghost_top_right = myLoc.shift(1, 1);
		Location ghost_left = myLoc.shift(-1, 0);
		Location ghost_right = myLoc.shift(1, 0);
		Location ghost_down_left = myLoc.shift(-1, -1);
		Location ghost_down = myLoc.shift(0, -1);
		Location ghost_down_right = myLoc.shift(1, -1);

		ArrayList<Location> possible_locations = new ArrayList<Location>(8);
		possible_locations.add(ghost_top_left);
		possible_locations.add(ghost_top);
		possible_locations.add(ghost_top_right);
		possible_locations.add(ghost_left);
		possible_locations.add(ghost_right);
		possible_locations.add(ghost_down_left);
		possible_locations.add(ghost_down);
		possible_locations.add(ghost_down_right);
		
		HashSet<Map.Type> hash = new HashSet<Map.Type>();
		hash.add(Map.Type.GHOST);
		
		for (int i = 0; i < possible_locations.size(); i++) {
			if (!this.myMap.getLoc(possible_locations.get(i)).equals(hash)) {
				return true;
			}
		}
    
    return false;
  }

	/*
	 * This method checks to see if there is a 'power-cookie' 
	 * located in Pacman's current coordinate. If there is, 
	 * this method calls the eatCookie method from the Map Class, 
	 * and returns the cookie component if the cookie a consumed, 
	 * and null otherwise.
	 */
	public JComponent consume() { 
 		if (this.myMap.getLoc(this.myLoc).contains(Map.Type.COOKIE)) {
 			Location loc = this.myLoc;
 			String cookie_id = "tok_x" + loc.x + "_x" + loc.y;
 			return this.myMap.eatCookie(cookie_id);
 		} else {
 			return null;
 		}
	}
}
