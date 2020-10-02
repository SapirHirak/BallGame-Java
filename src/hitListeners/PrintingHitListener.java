package hitListeners;
import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class PrintingHitListener implements HitListener {
    /**will print a massage.
     * @param  beingHit the block
     * @param hitter the ball.**/
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}