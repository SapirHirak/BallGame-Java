package setting;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfaces.Animation;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor; //the keyboard
    private String key; //the string of the kry
    private Animation animation; //the animation field
    private boolean stop; //the boolean stop fiels
    private boolean alreadyPressed; //the boolean press field

    /**The KeyPressStoppableAnimation constructor init the KeyPressStoppableAnimation.
     * @param sensor - the ketboard
     * @param key - the Key that pressed
     * @param animation the animation*/
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor; //the keyBoard
        this.key = key; //the key we press
        this.animation = animation; //the anumation that run
        this.stop = false;
        this.alreadyPressed = true;
    }

    @Override
    /**The doOneFrame function draw the PauseScreen to the game.
     * @param d - the DrawSurface*/
    public void doOneFrame(DrawSurface d) {
        if (this.sensor.isPressed(key) && !this.isAlreadyPressed()) {
            this.stop = true;
        } else {
            this.alreadyPressed = false;
        }
        this.animation.doOneFrame(d);
    }
    /**The isAlreadyPressed function .
     * @return true/false isAlreadyPressed field in the class.*/
    private boolean isAlreadyPressed() {
        return this.alreadyPressed;
    }

    @Override
    /**The shouldStop function .
     * @return true/false stop field in the class.*/
    public boolean shouldStop() {
        return this.stop;
    }
}
