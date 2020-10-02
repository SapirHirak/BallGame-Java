package setting;

import geometry.Point;
import interfaces.Collidable;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class CollisionInfo {
    private Point collisionPoint;  //the point at which the collision occurs.
     private Collidable collisionObject; //the point at which the collision occurs

    /**CollisionInfo constructor.
     * @param p - the point at which the collision occurs.
     * @param collisionObject - the point at which the collision occurs.*/
    public CollisionInfo(Point p, Collidable collisionObject) {
        this.collisionPoint = p; //will be the collision point of the collision
        this.collisionObject = collisionObject; //will be the collision object of the collision
    }
    /**The getCollisionPoint function get this collisionPoint.
     * @return collisionPoint*/
    public Point getCollisionPoint() {
        return this.collisionPoint;
    }

    /**the point at which the collision occurs.
     * @return  r - the rectangle of the class*/
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**the collidable object involved in the collision.
     * @return  r - the rectangle of the class*/
    public Collidable collisionObject() {
        return this.collisionObject;
    }

    /**The toString function return information of this rectangle.
     * @return string*/
    @Override
    public String toString() {
        return "setting.CollisionInfo{" + "collisionPoint=" + collisionPoint + ", collisionObject=" + collisionObject
                + '}';
    }
}