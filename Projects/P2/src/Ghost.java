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
		return null;
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
		return false;
	}
}
