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
public class GameLevel4 implements LevelInformation {
    private int numberOfBalls; //the number of the balls
    private List<Velocity> initialBallVelocities; //the list of the velocites
    private int paddleSpeed; //the paddle speed
    private int paddleWidth; //the paddle width
    private String levelName; //the level name
    private Sprite background; //the background of the level
    private List<Block> blocks; //the list of the blocks

    /**The GameLevel4 constructor init the number Ofthe third background in the game..*/
    public GameLevel4() {
        this.numberOfBalls = numberOfBalls();
        this.initialBallVelocities = initialBallVelocities();
        this.paddleSpeed = paddleSpeed();
        this.paddleWidth = paddleWidth();
        this.levelName = levelName();
        this.background = getBackground();
        this.blocks = initBlocks();
    }
    /**The getBlocks function will get the Blocks .
     * @return list of Blocks.*/
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
        return "Final Four !";
    }
    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    public Sprite getBackground() {
        Sprite backgroundThis = new FinalFourBackground(this.blocks);
        return backgroundThis;
    }

    /**The initBlocks function init The Blocks in this level, each block contains its size, color and location.
     * @return the blocks.*/
    public List<Block> initBlocks() {
        LinkedList blockss = new LinkedList<>();

        Color[]colors = new Color[7]; //an aray of colors to the 5 lines of blocks
        colors[0] = new Color(191, 20, 67);
        colors[1] = new Color(190, 150, 70);
        colors[2] = new Color(226, 222, 86);
        colors[3] = new Color(25, 208, 107);
        colors[4] = new Color(32, 177, 203);
        colors[5] = new Color(118, 32, 203);
        colors[6] = new Color(182, 27, 180);

        Point pointBlock = new Point(20, 120);
        Block block = new Block(new Rectangle(pointBlock, 40, 20), colors[0]);
        Rectangle r = block.getCollisionRectangle();
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 19; i++) {
                block = new Block(new Rectangle(pointBlock, 40, 20), colors[j]);
                blockss.add(block);
                r = block.getCollisionRectangle();
                pointBlock = new Point(r.getUpperLeft().getX() + r.getWidth(), r.getUpperLeft().getY());
            }
            pointBlock = new Point(20, r.getUpperLeft().getY() + r.getHeight());
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
    /**The numberOfBalls function return The Balls in this level.
     * @return the blocks.*/
    public int numberOfBalls() {
        return 3;
    }
}
