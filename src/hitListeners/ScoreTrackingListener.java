package hitListeners;

import interfaces.HitListener;
import setting.Counter;
import sprites.Ball;
import sprites.Block;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore; //the counter of the score

    /**ScoreTrackingListener constructor.
     * @param scoreCounter - the counter of the score of the game.*/
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }


    /**hitEvent function will increase the score in 5 pointes .
     * @param beingHit - the block in the hit.
     * @param hitter - will be the ball in the hit*/
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
