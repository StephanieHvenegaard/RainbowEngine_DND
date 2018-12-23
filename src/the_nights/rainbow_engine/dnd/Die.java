/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.dnd;

/**
 *
 * @author Stephanie
 */
public class Die {
    int iSides;
    public Die(int sides)
    {
        this.iSides = sides;
    }
    public int Roll()
    {
        return (int)(1+ (Math.random() * iSides+1));
    }
    
}
