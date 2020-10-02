package setting;
import biuoop.DrawSurface;
import biuoop.Sleeper;
import interfaces.Animation;

import java.awt.Color;

// The CountdownAnimation will display the given gameScreen,
// for numOfSeconds seconds, and on top of them it will show
// a countdown from countFrom back to 1, where each number will
// appear on the screen for (numOfSeconds / countFrom) seconds, before
// it is replaced with the next one.
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class CountdownAnimation implements Animation {
    private double numOfSeconds; //the number of seconds
    private int countFrom; //the number we count from
    private SpriteCollection sprites; //the collection of sprites
    private Sleeper sleeper; //the sleeper for this class

    /**Counter constructor.
     * @param numOfSeconds - the number of the value.
     * @param countFrom the number we count from
     * @param gameScreen - the sprites collection*/
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.sleeper = new Sleeper();
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.sprites = gameScreen;
    }

    /**The doOneFrame function draw the PauseScreen to the game.
     * @param d - the DrawSurface*/
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.BLACK);
        this.sprites.drawAllOn(d);
        d.setColor(Color.BLACK);

        d.drawText(70, 15, "Start in:" + this.countFrom + " seconds", 20);
        long mili = (long) (1000 * this.numOfSeconds);

        if (countFrom != 3) {
            this.sleeper.sleepFor(mili);
        }
        if (countFrom < 0) {
            shouldStop();
        }
        this.countFrom--;
        this.numOfSeconds--;
    }

    /**The shouldStop function .
     * @return true/false stop field in the class.*/
    public boolean shouldStop() {
        if (numOfSeconds == -1) {
            return true;
        }
       return false;
    }
}