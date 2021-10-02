import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift; 

	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;	
	}

	public boolean move() {
		return false;
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
			if (this.myMap.getLoc(possible_locations.get(i)).equals(hash)) {
				return true;
			}
		}

		return false;
	}

	public JComponent consume() { 
 		return null;
	}
}
