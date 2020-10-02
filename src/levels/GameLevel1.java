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
public class GameLevel1 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;

    /**The GameLevel3 constructor init the number Ofthe third background in the game..*/
    public GameLevel1() {
        this.numberOfBalls = numberOfBalls();
        this.initialBallVelocities = initialBallVelocities();
        this.paddleSpeed = paddleSpeed();
        this.paddleWidth = paddleWidth();
        this.levelName = levelName();

        this.blocks = initBlocks();
        this.background = new DirectHitBackground(this.blocks.get(0));
    }

    /**The numberOfBalls function return the number OfB alls in the game.
     * @return 1.*/
    public int numberOfBalls() {
        return 1;
    }

    /**The initialBallVelocities function initial velocity of each ball.
     * @return list of velocities.*/
    public List<Velocity> initialBallVelocities() {
        Velocity ball1Velocity = new Velocity(0, -3);
        LinkedList velocitys = new LinkedList<>();
        velocitys.add(ball1Velocity);
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
        return "Direct Hit !";
    }
    // Returns a sprite with the background of the level

    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    public Sprite getBackground() {
        return this.background;
    }

    /**The initBlocks function init The Blocks in this level, each block contains its size, color and location.
     * @return the blocks.*/
    public List<Block> initBlocks() {
        LinkedList blockss = new LinkedList<>();
        Block block = new Block(new Rectangle(new Point(380, 180), 40, 40), new Color(194, 26, 69));
        blockss.add(block);
        return blockss;
    }
    /**The Blocks function return The Blocks in this level, each block contains its size, color and location.
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
}
