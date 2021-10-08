# Team 8 PacMan

Group Members: Yuexia Huang, Miguel Musngi, Justin Robinson, Lucas Tucker

## PacMan Sample
<img width="599" alt="6b3aa2c2029c4c37a713f358a870083f" src="https://user-images.githubusercontent.com/60447054/136598205-bfa32397-a3cf-407a-a48c-caea65cbad26.png">


## How To Run
```bash
javac -cp "src/" src/*.java
java -cp "src/" StartMenu
```

# Functions
## PacMan

### move()
- **Type**: `() -> Bool`

- **Description**: Given current location, find a possible location for PacMan to move
using get_valid_moves method. This updates the location of PacMan and also calls
Map.move(). Returns true if able and false if not.

### is_ghost_in_range()
- **Type**: `() -> Bool`

- **Description**: Check PacMan's surrounding to see if any Ghosts are in attack range. 

### Function here

### Function here

## Ghost

### move()
- **Type**: `() -> Bool`

- **Description**:  Given current location, find a possible location for Ghost to move
using get_valid_moves method. This updates the location of Ghost and also calls
Map.move(). Returns true if able and false if not.

### is_pacman_in_range()
- **Type**: `() -> Bool`

- **Description**: Check the ghost's surrounding to see if PacMan is in attack range.

### Function here

### Function here

## Map

### move()
- **Type**: `(String name, Location loc, Type type) -> Bool`

- **Description**: Method takes name, location, and type and put the object in the given
location. Returns true if able and false if not. 

### getLoc(Location loc)
- **Type**: `(Location loc) -> HashSet<Type>`

- **Description**: Given a location argument, it returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall).

### Function here

### Function here

# Tests

## Pacman

### TestPacManMove
- **Description**: This tests if the move() function returns true if there is a valid move. It also
checks if the move itself was a valid move.

### TestGhostInRange
- **Description**: The test returns true if ghost is 1 attack radius away from PacMan, else it returns false.

### Test here

### Test here

## Ghost

### TestGhostMove
- **Description**: This tests if the move() function returns true if there is a valid move. It also
checks if the move itself was a valid move. 

### TestPacManInRange
- **Description**: The tests returns true if PacMan is 1 attack radius away from ghost, else it returns false.

### Test here

### Test here

## Map

### TestMapMove
- **Description**: This tests if the destination location has the given type if returned
true, and that the initial location no longer has the given type. It also tests that
an object that does not exist does not move and returns false. 

### TestMapGetLoc
- **Description**: Tests if the correct object is being returned for a specific location.

### Test here

### Test here
