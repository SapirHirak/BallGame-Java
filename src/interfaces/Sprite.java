package interfaces;
import biuoop.DrawSurface;
import setting.GameLevel;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public interface Sprite {
    /** draw the sprite to the screen.
     * @param d drawface*/
    void drawOn(DrawSurface d);

    /** notify the sprite that time has passed.*/
    void timePassed();

    /**add to the game.
     * @param g the game*/
    void addToGame(GameLevel g);
}