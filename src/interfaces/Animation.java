package interfaces;
import biuoop.DrawSurface;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public interface Animation {
    /**The doOneFrame function draw the Animation to the game.
     * @param d - the DrawSurface*/
    void doOneFrame(DrawSurface d);
    /**The PauseScreen constructor init the PauseScreen to the game.
     * @return the stop field in the class.*/
    boolean shouldStop();
}