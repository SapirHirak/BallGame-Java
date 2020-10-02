package interfaces;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Ball;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public interface Collidable {
    /** Return the "collision shape" of the object.
     * @return shape*/
    Rectangle getCollisionRectangle();

    /** Notify the object that we collided with it at collisionPoint wite a given velocity.
     * @param collisionPoint - the point of the collision
     * @param currentVelocity - the velocity before change
     * @param  hitter the ball
    * @return is the new velocity expected after the hit (based on the force the object inflicted on us).*/
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
