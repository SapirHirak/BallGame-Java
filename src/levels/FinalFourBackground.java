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
public class FinalFourBackground implements Sprite {
    private List<Block> blocks;; //the block in the level

    /**The DirectHitBackground constructor init the DirectHitBackground to the game.
     * @param blocks the block in the level.*/
    public FinalFourBackground(List<Block> blocks) {
        this.blocks = blocks;
    }

    /** draw the sprite to the screen.
     * @param d drawface*/
    public void drawOn(DrawSurface d) {
        //the background
        d.setColor(new Color(120, 157, 206));
        d.fillRectangle(20, 40, 760, 760);

        //first Cloud
        d.setColor(new Color(240, 240, 240));
        int xstartPoint = 540;
        int xendPoint = 450;
        for (int i = 0; i < 15; i++) {
            d.drawLine(xstartPoint, 500, xendPoint, 800);
            xstartPoint = xstartPoint + 7;
            xendPoint = xendPoint + 7;
        }
        d.setColor(new Color(165, 170, 173));
        d.fillCircle(550, 470, 21);
        d.fillCircle(550, 510, 31);
        d.setColor(new Color(157, 157, 175));
        d.fillCircle(580, 490, 30);
       ;
        d.setColor(new Color(147, 147, 161));
        d.fillCircle(600, 510, 26);
        d.fillCircle(620, 500, 30);

        //first Cloud
        d.setColor(new Color(240, 240, 240));
         xstartPoint = 240;
        xendPoint = 150;
        for (int i = 0; i < 15; i++) {
            d.drawLine(xstartPoint, 300, xendPoint, 800);
            xstartPoint = xstartPoint + 7;
            xendPoint = xendPoint + 7;
        }
        d.setColor(new Color(165, 170, 173));
        d.fillCircle(250, 270, 21);
        d.fillCircle(250, 310, 31);
        d.setColor(new Color(157, 157, 175));
        d.fillCircle(280, 290, 30);
        ;
        d.setColor(new Color(147, 147, 161));
        d.fillCircle(300, 310, 26);
        d.fillCircle(320, 300, 30);
    }

    /** notify the sprite that time has passed.*/
    public void timePassed() {

    }

    /**add to the game.
     * @param g the game*/
    public void addToGame(GameLevel g) {

    }
}
