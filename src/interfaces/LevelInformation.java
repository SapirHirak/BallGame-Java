package interfaces;

import geometry.Velocity;
import sprites.Block;

import java.util.List;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public interface LevelInformation {
    /**The numberOfBalls function return the number OfB alls in the game.
     * @return 1.*/
    int numberOfBalls();
    /**The initialBallVelocities function initial velocity of each ball.
     * @return list of velocities.*/
    List<Velocity> initialBallVelocities();
    /**The paddleSpeed function return the Speed of paddle in the game.
     * @return 7.*/
    int paddleSpeed();
    /**The paddleWidth function return the Width of paddle in the game.
     * @return 7.*/
    int paddleWidth();
    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    String levelName();
    /**The levelName function return the name of level in the game ,and will be displayed at the top of the screen.
     * @return string.*/
    Sprite getBackground();
    /**The Blocks function return The Blocks in this level, each block contains its size, color and location.
     * @return the blocks.*/
    List<Block> blocks();
    /**The numberOfBlocksToRemove function return Number of blocks that should be removed before the level is
     * considered to be "cleared".
     * @return string.*/
    int numberOfBlocksToRemove();
}
