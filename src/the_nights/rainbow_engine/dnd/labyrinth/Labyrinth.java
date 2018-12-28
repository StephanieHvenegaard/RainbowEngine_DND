/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.dnd.labyrinth;

import the_nights.rainbow_engine.core.interfaces.IRender;
import the_nights.rainbow_engine.core.interfaces.IScreenBuffer;

/**
 *
 * @author Stephanie
 */
public class Labyrinth{
    private int size;
    private Room[][] maze;
    private boolean isLoop = false;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Room[][] getMaze() {
        return maze;
    }

    public void setMaze(Room[][] maze) {
        this.maze = maze;
    }

    public boolean isIsLoop() {
        return isLoop;
    }

    public void setIsLoop(boolean isLoop) {
        this.isLoop = isLoop;
    }    
}
