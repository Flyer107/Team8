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

### get_valid_moves
- **Type**: `() -> ArrayList<Location>`

- **Description**: Checks PacMan's surroundings to see which Locations are available to move to. Pacman cannot move to Locations that are occupied by Walls or Ghosts.

### consume()
- **Type**: `() -> JComponent

- **Description**: Checks to see if there is a cookie at Pacman's location. If there is, it makes Pacman eat the cookie, and returns the cookie component that was eaten. If there is no cookie, it returns null.

## Ghost

### move()
- **Type**: `() -> Bool`

- **Description**:  Given current location, find a possible location for Ghost to move
using get_valid_moves method. This updates the location of Ghost and also calls
Map.move(). Returns true if able and false if not.

### is_pacman_in_range()
- **Type**: `() -> Bool`

- **Description**: Check the ghost's surrounding to see if PacMan is in attack range.

### get_valid_moves()
- **Type**: `() -> ArrayList<Location>`

- **Description**: Checks Ghost's surroundings to see which Locations are available to move to. Ghost cannot move to Locations that are occupied by Walls, but can move through other Ghosts or Pacman.

### Attack()
- **Type**: `() -> Bool`

- **Description**: Checks to see if Pacman is in range of the ghost. If it is, the function calls map's attack function and returns it's output. If not, it returns false.

## Map

### move()
- **Type**: `(String name, Location loc, Type type) -> Bool`

- **Description**: Method takes name, location, and type and put the object in the given
location. Returns true if able and false if not. 

### getLoc(Location loc)
- **Type**: `(Location) -> HashSet<Type>`

- **Description**: Given a location argument, it returns what is currently at the location (Empty, Pacman, Cookie, Ghost, Wall).

### attack(String Name)
- **Type**: `(String) -> Bool`

- **Description**: Designates the end of the game by setting the map's isGameOver value to true. It then returns true.


### eatCookie(String name)
- **Type**: `(String) -> JComponent`

- **Description**: Registers a cookie eaten by Pacman. Removes the cookie specified by "name" from the components and field HashMaps and increments the Map's cookie counter.

# Tests

## Pacman

### TestPacManMove
- **Description**: This tests if the move() function returns true if there is a valid move. It also
checks if the move itself was a valid move.

### TestGhostInRange
- **Description**: The test returns true if ghost is 1 attack radius away from PacMan, else it returns false.

### TestPacManGetValidMoves
- **Description**: The first test places Pacman in a small 3x3 game board and fills the top row with walls and the left column with ghosts. The second test returns true if Pacman has 3 available moves and can only move to locations (1,2) (2,1) and (2,2). The second test surrounds Pacman with walls and returns true if he has no available moves.

### TestConsume
- **Description**: Test creates pacman and cookie objects and calls the consume function to make the pacman eat the cookie. The test then checks if the cookie returned matched the cookie inputted, and whether the cookie was successfully removed from the map.

## Ghost

### TestGhostMove
- **Description**: This tests if the move() function returns true if there is a valid move. It also
checks if the move itself was a valid move. 

### TestPacManInRange
- **Description**: The tests returns true if PacMan is 1 attack radius away from ghost, else it returns false.

### TestAttack
- **Description**: The first test creates pacman and ghost objects next to each other. The ghost then calls the attack function. The test passes if the map object confirms the game is over, both from the map object itself, and from the ghost's map reference. The second test creates a pacman and ghost object with some distance between them. The test passes if the attack function returns false.

### TestGhostGetValidMoves
- **Description**: The first test places Ghost in a small 3x3 game board and fills the top row with walls and the left column with ghosts. The second test returns true if Pacman has 5 available moves and can only move to locations (1, 0) (2, 0) (1,2) (2,1) and (2,2). The second test surrounds Ghost with walls and returns true if he has no available moves.

## Map

### TestMapMove
- **Description**: This tests if the destination location has the given type if returned
true, and that the initial location no longer has the given type. It also tests that
an object that does not exist does not move and returns false. 

### TestMapGetLoc
- **Description**: Tests if the correct object is being returned for a specific location.

### TestMapAttack
- **Description**: Test creates a pacman and ghost object next to each other, and calls the map's attack function. The test passes if the isGameOver value changes to true.

### TesMapEatCookie
- **Description**: Tests if a cookie is successfully registered as eaten when consumed by Pacman. Test passes if:

- 1. the returned cookie matches the cookie whose name is passed in as the parameter
- 2. the cookie eaten is no longer contained in its former location
- 3. the player point total has increased by 1
- 4. attempting to eat a nonexistent cookie returns null
