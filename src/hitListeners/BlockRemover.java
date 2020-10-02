package hitListeners;

import interfaces.HitListener;
import setting.Counter;
import setting.GameLevel;
import sprites.Ball;
import sprites.Block;


/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class BlockRemover implements HitListener {
    private GameLevel gameLevel; //the current game
    private Counter remainingBlocks; //the counter of the blocks

    /**BlockRemover constructor.
     * @param gameLevel - the current game.
     * @param removedBlocks - counter of the blocks.*/
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**hitEvent function will call a function that will remove the block.
     * @param beingHit - the block we need to remove.
     * @param hitter - the the ball that hit the block .*/
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(this.gameLevel);
        this.gameLevel.getCounterBlock().decrease(1);
        //if we removed all the blocks - get more 100 points
        if (this.remainingBlocks.getValue() == 0) {
            gameLevel.getCounterScore().increase(100);
        }
    }
}