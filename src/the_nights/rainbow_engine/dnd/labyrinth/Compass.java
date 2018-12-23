/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.dnd.labyrinth;

/**
 *
 * @author Stephanie
 */
public enum Compass {
    N("north", 0, -1), S("south", 0, 1), E("east", 1, 0), W("west", -1, 0);
    public final String direction; //representation of direction. 
    public final int dx;  // Direction in the array out of the x axis 
    public final int dy;  // Direction in the array out of the y axis
    public Compass opposite;  // deklares the opposite direction for ref. 
    public Compass left;
    public Compass right;
    // use the static initializer to resolve forward references
    static {
        N.opposite = S;
        S.opposite = N;
        E.opposite = W;
        W.opposite = E;
        N.left = W;
        S.left = E;
        E.left = N;
        W.left = S;
        N.right = E;
        S.right = W;
        E.right = S;
        W.right = N;
    }
    private Compass(String dir, int dx, int dy) {
        this.direction = dir;
        this.dx = dx;
        this.dy = dy;
    }
};

