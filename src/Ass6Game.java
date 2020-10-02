import levels.GameLevel1;
import levels.GameLevel2;
import levels.GameLevel3;
import levels.GameLevel4;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import interfaces.LevelInformation;
import setting.AnimationRunner;
import setting.GameFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Ass6Game {
    /** the main function will start the game.
     * @param args */
    public static void main(String[] args) {
        GUI gui = new GUI("title", 800, 600); //the gui we will work on
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        AnimationRunner animationRunner = new AnimationRunner(gui);
        List<LevelInformation> levels = new ArrayList<>();
        int counterLevel = 0; //wiill count the levels in the args.
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1") || args[i].equals("2") || args[i].equals("3") || args[i].equals("4")) {
                counterLevel++;
            }
        }
        //if there is no arguments
        if (counterLevel == 0) {
            levels.add(new GameLevel1());
            levels.add(new GameLevel2());
            levels.add(new GameLevel3());
            levels.add(new GameLevel4());
        } else {
            //if there is arguments
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("1")) {
                    levels.add(new GameLevel1());
                }
                if (args[i].equals("2")) {
                    levels.add(new GameLevel2());
                }
                if (args[i].equals("3")) {
                    levels.add(new GameLevel3());
                }
                if (args[i].equals("4")) {
                    levels.add(new GameLevel4());
                }
            }
        }
        //init the gameFlow and run the levels in the levels list
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor, gui);
        gameFlow.runLevels(levels);
        gui.close();
    }
}
