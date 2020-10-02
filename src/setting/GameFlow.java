package setting;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;

import java.util.List;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class GameFlow {
    private AnimationRunner ar; //the animation runner
    private KeyboardSensor ks; //the ketboard
    private GUI gui; //the gui in the game
    private Counter score; //the current score

    /**The KeyPressStoppableAnimation constructor init the KeyPressStoppableAnimation.
     * @param ar - the AnimationRunner
     * @param ks - the KeyboardSensor
     * @param gui the gui*/
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.ar = ar;
        this.ks = ks;
        this.gui = gui;
        this.score = new Counter(0);
    }

    /**The runLevels function will run the levels in the game.
     * @param levels - the list of the levels*/
    public void runLevels(List<LevelInformation> levels) {
        WinScreen win = new WinScreen(this.score, this.ks);
        LooseScreen loose = new LooseScreen(this.score, this.ks);

        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.ks, this.ar, this.gui, this.score);
            level.initialize();
            while (level.getRemaningBalls() > 0 && level.getRemaningBlocks() > 0) {
                /*
                AnimationRunner runner = ar;
                Animation a1 = new WinScreen(this.score, this.ks);
                Animation a2 = new PauseScreen(this.ks); // also an Animation
                Animation a1k = new KeyPressStoppableAnimation(ks, "m", a1);
                Animation a2k = new KeyPressStoppableAnimation(ks, "m", a2);
                runner.run(a1k);
                runner.run(a2k);
                 */
                level.run();
            }
            if (level.getRemaningBalls() == 0) {
                this.ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY, loose));
              //  this.gui.close();
                return;
            }
            this.score.setValue(level.getCounterScore().getValue());
        }
        this.ar.run(new KeyPressStoppableAnimation(this.ks, KeyboardSensor.SPACE_KEY, win));
    }

}