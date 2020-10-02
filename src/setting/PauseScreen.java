package setting;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**The PauseScreen constructor init the PauseScreen to the game.
     * @param k - the KeyboardSensor*/
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**The doOneFrame function draw the PauseScreen to the game.
     * @param d - the DrawSurface*/
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    /**The shouldStop function .
     * @return true/false stop field in the class.*/
    public boolean shouldStop() {
        return this.stop;
    }
}
