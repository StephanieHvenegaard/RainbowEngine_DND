/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.dnd.labyrinth;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Stephanie
 */
public class Generator {
    private int size;
    private Room[][] maze;
    private boolean isLoop = false;
    
    private void startMazeGeneration() {
        maze[0][0].setIsExit(true);
        Compass dir = Compass.S;
        // Add Exit to Current Room
        int nextX = dir.dx;      // gets X for the next Room 
        int nextY = dir.dy;      // gets Y for the nex Room
        maze[0][0].setExit(dir.direction, maze[nextX][nextY]);
        // Add oppesite exit to next Room to bind them together
        maze[nextX][nextY].setExit(dir.opposite.direction, maze[0][0]);
        // goes to next Cell and start the proces over again untill all rooms is full.
        generateRoom(nextX, nextY);
    }

    private void generateRoom(int currentX, int currentY) {        
        Compass[] dirs = Compass.values(); // gets all 4 enums for direction
        Collections.shuffle(Arrays.asList(dirs)); // mixes them up to get a reandom direction.
        for (Compass compass : dirs) // loops through each posible direction
        {
            int nextX = currentX + compass.dx;      // gets X for the next Room 
            int nextY = currentY + compass.dy;      // gets Y for the nex Room
            if (nextX == 0 && nextY == 0) {
                continue; //checks if Spawn room if true skip.
            }
            if (isInsideMaze(nextX, this.size) // checks if x is indside maze.
                    && isInsideMaze(nextY, this.size)) // checks if y is indside maze.
            {
                // checks if room has no exits 
                if (!maze[nextX][nextY].hasAnyExits()) {
                    // Add Exit to Current Room
                    maze[currentX][currentY].setExit(compass.direction, maze[nextX][nextY]);
                    // Add oppesite exit to next Room to bind them together
                    maze[nextX][nextY].setExit(compass.opposite.direction, maze[currentX][currentY]);
                    // goes to next Cell and start the proces over again untill all rooms is full.
                    generateRoom(nextX, nextY);
                } else {
                    // we have reached a room with an exit, checks if we should punch a hole 
                    // before backtracking to make sure the map is a loop
                    if (!maze[nextX][nextY].hasExit(compass.opposite.direction) // is there allready a exit to this room
                            && (!isLoop || ((int) (Math.random() * 20) == 5))) // force or random
                    {
                        // Add Exit to Current Room
                        maze[currentX][currentY].setExit(compass.direction, maze[nextX][nextY]);
                        // Add oppesite exit to next Room to bind them together
                        maze[nextX][nextY].setExit(compass.opposite.direction, maze[currentX][currentY]);
                        // the maze is now a loop
                        isLoop = true;   // no need to force no more                     
                    }
                }
            }
        }
    }
    /*
     * Checks if the next room is inside the maze.
     */
    private boolean isInsideMaze(int v, int upper) {
        return (v >= 0) && (v < upper);
    }
}
