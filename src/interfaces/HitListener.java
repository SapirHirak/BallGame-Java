package interfaces;
import sprites.Ball;
import sprites.Block;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public interface HitListener {
    /** This method is called whenever the beingHit object is hit.
     * @param hitter - the Ball that's doing the hitting.
     * @param beingHit the block in the hitting**/
    void hitEvent(Block beingHit, Ball hitter);
}