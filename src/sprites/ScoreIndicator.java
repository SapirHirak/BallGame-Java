package sprites;
import biuoop.DrawSurface;
import interfaces.Sprite;
import setting.Counter;
import setting.GameLevel;
import java.awt.Color;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class ScoreIndicator implements Sprite {
    private Counter scoreCounter; //the counter of the score
    private String nameLevel;

    /**ScoreIndicator constructor.
     * @param counter - the counter of the score.*/
    public ScoreIndicator(Counter counter, String nameLevel) {
        this.nameLevel = nameLevel;
        this.scoreCounter = counter;
    }

    /** draw the score sprite to the screen.
     * @param d drawface*/
   public void drawOn(DrawSurface d) {
       d.setColor(Color.BLACK);
       d.drawRectangle(0, 0, 800, 20);
       d.setColor(Color.PINK);
       d.fillRectangle(0, 0, 800, 20);
       String currentScore = "Score is: " + this.scoreCounter.getValue();
       d.setColor(Color.BLACK);
       d.drawText(250, 15, currentScore, 15);
       d.drawText(650, 15, this.nameLevel, 15);
    }

    /** notify the sprite that time has passed.*/
   public void timePassed() { }

    /**add to the game - add to the sprites list.
     * @param g - the game*/
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }


}
