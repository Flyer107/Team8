import java.util.HashSet;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.Random;

public class PacMan{
	String myName;
	Location myLoc;
	Map myMap;
	Location shift;
	Random rand;


	public PacMan(String name, Location loc, Map map) {
		this.myLoc = loc;
		this.myName = name;
		this.myMap = map;
	}

	public ArrayList<Location> get_valid_moves() {
		return null;
	}

	public boolean move() {
		ArrayList<Location> moves = get_valid_moves();
		if(moves.size() > 0) {
			int randIndex = rand.nextInt(moves.size());
			this.myLoc = moves.get(randIndex);
			return true;
		} else {
			return false;
		}
	}

	public boolean is_ghost_in_range() {
		return false;
	}

	public JComponent consume() {
 		return null;
	}
}
