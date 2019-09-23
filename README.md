Toy Robot uses 5 * 5 Grid to move around.

An ArrayList is used to capture the cordinates in a pattern,before setting them(cordinates) as array elements in the 2 dimentional array.
The array indexes are then mapped to these cordinates with the help of a hashmap used for lookups. o(1) complexity.

It responds to following commands.
place/move/report/left/right/exit.


Sample Commands.
----------------

place 0,0,NORTH
move
report
place 0, 0, NORTH
left
report
place 1,2,EAST
exit


Sample Output.
--------------

Welcome to Toy Robot!
Command :place 5,0, NORTH
Command :report
Output =0,0,UNKNOWN
Command :place a,b,NORTH
Command :report
Output =0,0,UNKNOWN
Command :place -1,500000,NORTH
Command :report
Output =0,0,UNKNOWN
Command :place 0,0,NORTH
Command :report
Output =0,0,NORTH
Command :move
Command :report
Output =0,1,NORTH
Command :place 0,0,NORTH
Command :left
Command :report
Output =0,0,WEST
Command :place 1,2,EAST
Command :move
Command :move
Command :left
Command :move
Command :report
Output =3,3,NORTH
Command :exit