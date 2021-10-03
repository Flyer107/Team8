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
      for (int y = 1; y < 2; y++) {
        Location loc = this.myLoc.shift(x, y);
        if (!this.myMap.getLoc(loc).contains(Map.Type.WALL)) {
          validMoves.add(loc);
        }
      }
    }

    return validMoves;
	}

	public boolean move() {
		return false;
	}

	public boolean is_pacman_in_range() { 
		return false;
	}

	public boolean attack() {
		return false;
	}
}
