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
    ArrayList<Location> validMoves = new ArrayList<Location>();

    for (int x = -1; x < 2; x++) {
      for (int y = -1; y < 2; y++) {
        Location loc = this.myLoc.shift(x, y);
        if (!this.myMap.getLoc(loc).contains(Map.Type.WALL)) {
          validMoves.add(loc);
        }
      }
    }

    return validMoves;
	}

	public boolean move() {
	    ArrayList<Location> moves = this.get_valid_moves();
	    if(moves.size() > 0) {
		int randIndex = rand.nextInt(moves.size());
		this.myLoc = moves.get(randIndex);
		return this.myMap.move(this.myName, moves.get(randIndex), Map.Type.GHOST); 
	    } else {
		return false;
	    }
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
		if (this.is_pacman_in_range() == true) {
			return this.myMap.attack(this.myName);
		} else {
			return false;
		}
	}
}
