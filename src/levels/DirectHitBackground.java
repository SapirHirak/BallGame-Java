package levels;
import biuoop.DrawSurface;
import interfaces.Sprite;
import setting.GameLevel;
import sprites.Block;

import java.awt.Color;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class DirectHitBackground implements Sprite {
    private Block block; //the block in the level

    /**The DirectHitBackground constructor init the DirectHitBackground to the game.
     * @param block the block in the level.*/
    public DirectHitBackground(Block block) {
        this.block = block;
    }

    /** draw the sprite to the screen.
     * @param d drawface*/
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(20, 40, 760, 760);
        d.setColor(Color.blue);
        int yBlock = (int) this.block.getCollisionRectangle().getUpperLeft().getY();
        int xBlock = (int) this.block.getCollisionRectangle().getUpperLeft().getX();
        int widthBlock =  (int) this.block.getCollisionRectangle().getWidth();
        int heightBlock = (int) this.block.getCollisionRectangle().getHeight();
        //4 lines of the circle
        d.drawLine(xBlock + widthBlock / 2, yBlock - 140, xBlock + widthBlock / 2,  yBlock - 5);
        d.drawLine(xBlock + widthBlock / 2, yBlock + 5, xBlock + widthBlock / 2,  yBlock + 200);
        d.drawLine(xBlock - 5, yBlock + heightBlock / 2, xBlock - 180,  yBlock + heightBlock / 2);
        d.drawLine(xBlock + 5 + widthBlock, yBlock + heightBlock / 2, xBlock + 180 + widthBlock,
                yBlock + heightBlock / 2);

        d.drawCircle(xBlock + widthBlock / 2, yBlock + heightBlock / 2, 80);
        d.drawCircle(xBlock + widthBlock / 2, yBlock + heightBlock / 2, 120);
        d.drawCircle(xBlock + widthBlock / 2, yBlock + heightBlock / 2, 160);
    }

    /** notify the sprite that time has passed.*/
    public void timePassed() {
    }

    /**add to the game.
     * @param g the game*/
    public void addToGame(GameLevel g) {

    }

}
