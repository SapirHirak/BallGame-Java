package setting;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class WinScreen implements Animation {
    private KeyboardSensor keyboard; //the ketboard on the game
    private boolean stop; //boolean var to stop the animation
    private Counter score; //the current score

    /**The WinScreen constructor init the WinScreen to the game.
     * @param currentScore - the Counter
     * @param k - the KeyboardSensor*/
    public WinScreen(Counter currentScore, KeyboardSensor k) {
        this.score = currentScore;
        this.keyboard = k;
        this.stop = false;
    }
    /**The doOneFrame function draw the PauseScreen to the game.
     * @param d - the DrawSurface*/
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win ! Your Score is " + this.score.getValue(), 32);
    }
    /**The shouldStop function .
     * @return true/false stop field in the class.*/
    public boolean shouldStop() {
        return this.stop;
    }
}
