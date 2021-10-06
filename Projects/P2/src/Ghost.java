import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;

public class Ghost{
	String myName;
	Location myLoc;
	Map myMap;
        Random rand;

	public Ghost(String name, Location loc, Map map) {
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
