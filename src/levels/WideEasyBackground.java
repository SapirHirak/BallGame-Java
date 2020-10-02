package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;
import setting.GameLevel;
import sprites.Block;

import java.awt.Color;
import java.util.List;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class WideEasyBackground implements Sprite {
    private List<Block> blocks;; //the block in the level

    /**The WideEasyBackground constructor init the WideEasyBackground to the game.
     * @param blocks the block in the level.*/
    public WideEasyBackground(List<Block> blocks) {
        this.blocks = blocks;
    }

    /** draw the sprite to the screen.
     * @param d drawface*/
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(255, 255, 102));
        int xPoint = 20;
        for (int i = 0; i < 150; i++) {
            d.drawLine(120, 120, xPoint, (int) this.blocks.get(1).getCollisionRectangle().getUpperLeft().getY());
            xPoint = xPoint + 5;
        }

        d.setColor(new Color(255, 250, 205)); //the big circle of the sun
        d.drawCircle(120, 120, 70);
        d.fillCircle(120, 120, 70);

        d.setColor(new Color(255, 255, 102));
        d.drawCircle(120, 120, 60);
        d.fillCircle(120, 120, 60);

        d.setColor(new Color(255, 255, 0));
        d.drawCircle(120, 120, 50);
        d.fillCircle(120, 120, 50);
    }

    /** notify the sprite that time has passed.*/
    public void timePassed() {

    }

    /**add to the game.
     * @param g the game*/
    public void addToGame(GameLevel g) {

    }

}
