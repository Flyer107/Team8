# Team 8 PacMan

Group Members: Yuexia Huang, Miguel Musngi, Justin Robinson, Lucas Tucker

## PacMan Sample
insert image here

## How To Run
'Code Block here'

# Functions
## PacMan

### move()
Type: () -> Bool
Description: Given current location, find a possible location for PacMan to move
using get_valid_moves method. This updates the location of PacMan and also calls
Map.move(). Returns true if able and false if not.

### Function here

### Function here

### Function here

## Ghost

### move()
Type: () -> Bool
Description: Given current location, find a possible location for Ghost to move
using get_valid_moves method. This updates the location of Ghost and also calls
Map.move(). Returns true if able and false if not.

### Function here

### Function here

### Function here

## Map

### move()
Type: (String name, Location loc, Type type) -> Bool
Description: Method takes name, location, and type and put the object in the given
location. Returns true if able and false if not. 

### Function here

### Function here

### Function here

# Tests

## Pacman

### TestPacManMove
Description: This tests if the move() function returns false if there are no valid
moves, and true if there is a valid move. It also checks if the move itself was
a valid move.

### Test here

### Test here

### Test here

## Ghost

### TestGhostMove
Description: This tests if the move() function returns false if there are no valid
moves, and true if there is a valid move. It also checks if the move itself was
a valid move. 

### Test here

### Test here

### Test here

## Map

### TestMapMove
Description: This tests if the destination location has the given type if returned
true, and that the initial location no longer has the given type. It also tests that
an object that does not exist does not move and returns false. 

### Test here

### Test here

### Test here
