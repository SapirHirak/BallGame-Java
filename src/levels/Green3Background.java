package levels;

import biuoop.DrawSurface;
import interfaces.Sprite;
import setting.GameLevel;
import sprites.Block;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Green3Background implements Sprite {
    private java.util.List<Block> blocks;; //the block in the level

    /**The Green3Background constructor init the Green3Background to the game.
     * @param blocks the block in the level.*/
    public Green3Background(List<Block> blocks) {
        this.blocks = blocks;
    }

    /** draw the sprite to the screen.
     * @param d drawface*/
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(1, 1, 1));
        d.fillRectangle(100, 350, 210, 300); //200 on 300
        d.setColor(new Color(179, 116, 191));

        Point rectanglePoint = new Point(110, 370); //first point to the first block
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle((int) rectanglePoint.getX(), (int) rectanglePoint.getY(), 30, 40);
                rectanglePoint = new Point((int) rectanglePoint.getX() + 40, (int) rectanglePoint.getY());
            }
            rectanglePoint = new Point(110, (int) rectanglePoint.getY() + 50);
        }

        d.setColor(Color.gray);
        d.fillRectangle(180, 300, 50, 50);

        d.setColor(new Color(203, 176, 176));
        d.fillRectangle(200, 100, 10, 200);

        //the light on the buildind:
        d.setColor(new Color(219, 149, 122));
        d.fillCircle(204, 90, 12);

        d.setColor(new Color(226, 67, 41));
        d.fillCircle(204, 90, 8);

        d.setColor(new Color(255, 255, 255));
        d.fillCircle(204, 90, 4);
    }

    /** notify the sprite that time has passed.*/
    public void timePassed() {

    }

    /**add to the game.
     * @param g the game*/
    public void addToGame(GameLevel g) {

    }


}
