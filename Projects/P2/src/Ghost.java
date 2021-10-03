import java.util.HashSet;
import java.util.ArrayList;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;

	public Ghost(String name, Location loc, Map map) {
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

	public boolean is_pacman_in_range() { 
		Location pacman_top_left = myLoc.shift(-1, 1);
	    Location pacman_top = myLoc.shift(0, 1);
		Location pacman_top_right = myLoc.shift(1, 1);
		Location pacman_left = myLoc.shift(-1, 0);
		Location pacman_right = myLoc.shift(1, 0);
		Location pacman_down_left = myLoc.shift(-1, -1);
		Location pacman_down = myLoc.shift(0, -1);
		Location pacman_down_right = myLoc.shift(1, -1);

		ArrayList<Location> possible_locations = new ArrayList<Location>(8);
		possible_locations.add(pacman_top_left);
		possible_locations.add(pacman_top);
		possible_locations.add(pacman_top_right);
		possible_locations.add(pacman_left);
		possible_locations.add(pacman_right);
		possible_locations.add(pacman_down_left);
		possible_locations.add(pacman_down);
		possible_locations.add(pacman_down_right);
		
		
		HashSet<Map.Type> hash = new HashSet<Map.Type>();
		hash.add(Map.Type.PACMAN);

		for (int i = 0; i < possible_locations.size(); i++) {
			if (this.myMap.getLoc(possible_locations.get(i)).equals(hash)) {
				return true;
			}
		}

		return false;
	}

	public boolean attack() {
		return false;
	}
}
