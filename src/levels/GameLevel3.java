package levels;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Block;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class GameLevel3 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;

    /**The GameLevel3 constructor init the number Ofthe third background in the game..*/
    public GameLevel3() {
        this.numberOfBalls = numberOfBalls();
        this.initialBallVelocities = initialBallVelocities();
        this.paddleSpeed = paddleSpeed();
        this.paddleWidth = paddleWidth();
        this.levelName = levelName();
        this.background = getBackground();
        this.blocks = initblocks();
    }

    /**The numberOfBalls function return the number OfB alls in the game.
     * @return 1.*/
    public List<Block> getBlocks() {
        return this.blocks;
    }

    /**The initialBallVelocities function initial velocity of each ball.
     * @return list of velocities.*/
    public List<Velocity> initialBallVelocities() {
        LinkedList velocitys = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            Velocity ball1Velocity = new Velocity(3, -3);
            velocitys.add(ball1Velocity);
        }
        return velocitys;
    }
    /**The paddleSpeed function return the Speed of paddle in the game.
     * @return 7.*/
    public int paddleSpeed() {
        return 7;
    }
    /**The paddleWidth function return the Width of paddle in the game.
     * @return 7.*/
    public int paddleWidth() {
        return 120;
    }
    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    public String levelName() {
        return "Green 3 !";
    }

    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    public Sprite getBackground() {
        Sprite backgroundThis = new Green3Background(this.blocks);
        return backgroundThis;
    }

    /**The initBlocks function init The Blocks in this level, each block contains its size, color and location.
     * @return the blocks.*/
    public List<Block> initblocks() {
        LinkedList blockss = new LinkedList<>();

        //we will built all the blocks
        Point blockPoint = new Point(725.0, 100.0); //the location of the first block
        Color[]colors = new Color[5]; //an aray of colors to the 5 lines of blocks
        colors[0] = Color.GRAY;
        colors[1] = new Color(200,  5, 100);
        colors[2] = new Color(250, 50, 100);
        colors[3] = Color.magenta;
        colors[4] = new Color(150, 150, 250);

        for (int j = 0; j < 5; j++) {
            for (int i = j; i < 9; i++) {
                Block block = new Block(new Rectangle(new Point(blockPoint.getX(), blockPoint.getY()), 55,
                        30), colors[j]);
                //add all the listeners in the exercise.
                blockPoint.setX(blockPoint.getX() - 55);
                blockss.add(block);
            }
            blockPoint.setX(725.0);
            blockPoint.setY(blockPoint.getY() + 30);
        }
        return blockss;
    }

    /**The initBlocks function init The Blocks in this level, each block contains its size, color and location.
     * @return the blocks.*/
    public List<Block> blocks() {
       return this.blocks;
    }
    /**The numberOfBlocksToRemove function return Number of blocks that should be removed before the level is
     * considered to be "cleared".
     * @return string.*/
    public int numberOfBlocksToRemove() {
       return this.blocks.size();
    }
    /**The numberOfBalls function return the number OfB alls in the game.
     * @return 1.*/
    public int numberOfBalls() {
        return 2;
    }
}
