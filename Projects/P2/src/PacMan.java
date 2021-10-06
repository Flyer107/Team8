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
 			return this.myMap.eatCookie(this.myName);
 		} else {
 			return null;
 		}
	}
}
