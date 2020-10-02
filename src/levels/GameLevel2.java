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
public class GameLevel2 implements LevelInformation {
    private int numberOfBalls;
    private List<Velocity> initialBallVelocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite background;
    private List<Block> blocks;

    /**The GameLevel3 constructor init the number Ofthe third background in the game..*/
    public GameLevel2() {
        this.numberOfBalls = numberOfBalls();
        this.initialBallVelocities = initialBallVelocities();
        this.paddleSpeed = paddleSpeed();
        this.paddleWidth = paddleWidth();
        this.levelName = levelName();
        this.background = getBackground();
        this.blocks = initBlocks();

    }

    /**The numberOfBalls function return the number OfB alls in the game.
     * @return 1.*/
    public int numberOfBalls() {
        return 10;
    }
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    /**The initialBallVelocities function initial velocity of each ball.
     * @return list of velocities.*/
    public List<Velocity> initialBallVelocities() {
        LinkedList velocitys = new LinkedList<>();
        for (int i = 1; i < 11; i++) {
            Velocity ball1Velocity = new Velocity(i, -3);
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
        return 700;
    }

    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    public String levelName() {
        return "Wide Easy !";
    }

    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    public Sprite getBackground() {
        Sprite backgroundThis = new WideEasyBackground(this.blocks);
        return backgroundThis;
    }

    /**The initBlocks function init The Blocks in this level, each block contains its size, color and location.
     * @return the blocks.*/
    public List<Block> initBlocks() {
        LinkedList blockss = new LinkedList<>();
        Point pointBlock = new Point(20, 250);

        for (int i = 0; i < 15; i++) {
            Color color = new Color(1, 1, 1);
            if (i >= 0 && i <= 1) {
                color = new Color(191, 20, 67);
            }
            if (i >= 2 && i <= 3) {
                color = new Color(190, 150, 70);
            } else if (i >= 4 && i <= 5) {
                color = new Color(226, 222, 86);
            } else if (i >= 6 && i <= 8) {
                color = new Color(25, 208, 107);
            } else if (i >= 9 && i <= 10) {
                color = new Color(32, 177, 203);
            } else if (i >= 11 && i <= 12) {
                color = new Color(118, 32, 203);
            } else if (i >= 13 && i <= 14) {
                color = new Color(182, 27, 180);
            }
            Block block = new Block(new Rectangle(pointBlock, 51, 30), color);
            blockss.add(block);
            Rectangle r = block.getCollisionRectangle();
            pointBlock = new Point(r.getUpperLeft().getX() + r.getWidth(), r.getUpperLeft().getY());
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
}
