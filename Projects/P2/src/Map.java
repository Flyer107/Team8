import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JComponent;

public class Map{

	public enum Type {
		EMPTY,
		PACMAN,
		GHOST,
		WALL,
		COOKIE		
	}
	
	private HashMap<Location, HashSet<Type>> field;
	private boolean gameOver;
	private int dim;

	private HashMap<String, Location> locations;
	private HashMap<String, JComponent> components; 
	private HashSet<Type> emptySet;
	private HashSet<Type> wallSet; 

	private int cookies = 0;

	public Map(int dim){
		gameOver = false;
		locations = new HashMap<String, Location>();
		components = new HashMap<String, JComponent>();
		field = new HashMap<Location, HashSet<Type>>();

		emptySet = new HashSet<Type>();
		wallSet = new HashSet<Type>();
		emptySet.add(Type.EMPTY);
		wallSet.add(Type.WALL);
		this.dim = dim;
	}


	public void add(String name, Location loc, JComponent comp, Type type) {
		locations.put(name, loc);
		components.put(name, comp);
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>());
		field.get(loc).add(type);
	}

	public int getCookies() {
		return cookies;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
		
	public boolean move(String name, Location loc, Type type) {
		//update locations, components, and field
		//use the setLocation method for the component to move it to the new location
		if(locations.containsKey(name) && components.containsKey(name)) {
			field.get(locations.get(name)).remove(type); // Remove the type of old location
		if (field.get(locations.get(name)).isEmpty()) field.get(locations.get(name)).add(Type.EMPTY); // If old location is empty, add EMPTY to hashset
		locations.replace(name, loc); // Update locations
		components.get(name).setLocation(loc.x, loc.y); // update components
		if (!field.containsKey(loc)) field.put(loc, new HashSet<Type>()); // copied from add function
		if (field.get(loc).contains(Type.EMPTY)) field.get(loc).remove(Type.EMPTY); // If it was empty before, remove EMPTY in Hashset
		field.get(loc).add(type); // copied from add function
			return true;
		} else {
			return false;
		}
	}
	
	public HashSet<Type> getLoc(Location loc) {
		//wallSet and emptySet will help you write this method

		if (field.get(loc) != null) {
			
			if (field.get(loc).contains(Type.PACMAN) && field.get(loc).contains(Type.GHOST)) {
				return null;
			} else if (field.containsKey(Type.WALL)) {
				return wallSet;
			} else {
				return field.get(loc);
			}

		}

		return emptySet;
	}

	public boolean attack(String Name) {
		
		this.gameOver = true;
	   return true;
   }
	
	public JComponent eatCookie(String name) {
		//update locations, components, field, and cookies
		//the id for a cookie at (10, 1) is tok_x10_y1
		JComponent cookie = null;
		Location cookie_loc = this.locations.remove(name);

		if(cookie_loc != null){
			cookie = this.components.remove(name);
			this.field.get(cookie_loc).remove(Map.Type.COOKIE);
			this.cookies++;
		}

    return cookie;
	}
}
