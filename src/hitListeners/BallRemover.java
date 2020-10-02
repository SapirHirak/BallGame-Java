package hitListeners;
import interfaces.HitListener;
import setting.Counter;
import setting.GameLevel;
import sprites.Ball;
import sprites.Block;

// a BlockRemover is in charge of .
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class BallRemover implements HitListener {
    private GameLevel gameLevel; //will be our game
    private Counter remainingBalls; //will be the counter of the balls

    /**BallRemover constructor.
     * @param gameLevel - the current game.
     * @param removedBalls - the counter of the balls.*/
    public BallRemover(GameLevel gameLevel, Counter removedBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBalls;
    }

    /**hitEvent function will remove ball from the game, as well as keeping count
     // of the number of balls that remain.
     * @param beingHit - the block we will remove.
     * @param hitter - the ball in the hit.*/
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.getHitListeners().remove(hitter);
        hitter.removeFromGame(this.gameLevel);
    }
}