package setting;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import interfaces.Animation;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class AnimationRunner {
    private GUI gui; // the gui of the game
    private int framesPerSecond; //the frame per second

    /**The AnimationRunner constructor init the AnimationRunner to the game.
     * @param gui - the gui in the game*/
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = 40;
    }
    /**The run function draw the PauseScreen to the game.
     * @param animation - the DrawSurface*/
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper(); //sleeper to show the animation
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface(); // will be the drawFace of the game
            animation.doOneFrame(d);
            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
            if (animation.shouldStop()) {
                break;
            }
            gui.show(d);
        }

    }
    }
