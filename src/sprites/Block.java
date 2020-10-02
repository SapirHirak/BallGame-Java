package sprites;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.Sprite;
import interfaces.HitNotifier;
import setting.GameLevel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Block implements Collidable, Sprite, HitNotifier  {
    private List<HitListener> hitListeners; // will be the list of the listeners
    private Rectangle block; //will be the rectangle of the block
    private Color color;

    /**sprites.Block constructor.
     * @param r - the rectangle of the class*/
    public Block(Rectangle r, Color color) {
        this.hitListeners = new ArrayList<HitListener>();
        this.block = r;
        this.color = color;
    }
    /**The getCollisionRectangle function  Return the "collision shape" of the object.
     * @return rectangle*/
    public Rectangle getCollisionRectangle() {
        return this.block;
    }
    /**The getHitListeners function  Return the list of listeners.
     * @return list of listeners*/
    public List<HitListener> getHitListeners() {
        return this.hitListeners;
    }

    /**The hit function  Notify the object that we collided with it at collisionPoint with a given velocity.
     // The return is the
     * @param collisionPoint - the point of the collision
     * @param currentVelocity - the velocity before the change
     * @param hitter - the ball object
     * @return new velocity expected after the hit (based on the force the object inflicted on us)*/
    public  Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        Velocity newVelocity = currentVelocity; //first we will define the new velocity to be the current velocity
        Point downLeftPoint = block.getDownLeftPoint();
        Point upperRightPoint = block.getUpperRightPoint();
      if (collisionPoint.getX() >= upperRightPoint.getX() || collisionPoint.getX()
              <= this.block.getUpperLeft().getX()) {
          newVelocity.setDx(-1 * newVelocity.getDx());
        } else if (collisionPoint.getY() >= downLeftPoint.getY() || collisionPoint.getY() <= upperRightPoint.getY()) {
            newVelocity.setDy(-1 * newVelocity.getDy());
        }
        this.notifyHit(hitter);
        return newVelocity;
    }
    //
    /**The drawOn function draw the sprite to the screen.
     * @param d - the DrawSurface we will draw on*/
    public void drawOn(DrawSurface d) {

        d.setColor(this.color);
        d.fillRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());

        d.setColor(Color.black);
        d.drawRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
    }
    /**The timePassed notify the sprite that time has passed.*/
    public void timePassed() {

    }
    /**The addToGame function will add the object to the array of the colliadbles and sprites notify the sprites.
     * @param g -  the game we want to add to*/
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /**The toString function return information of this block.
     * @return string*/
        @Override
    public String toString() {
        return "sprites.Block{" + "block=" + block.toString() + '}';
    }

    /**The removeFromGame function will remove this block from the array of the colliadbles and sprites.
     * @param gameLevel -  the game we want to remove from it.*/
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }

    @Override
    /**The addHitListener function will add listener to the array of the listeners.
     * @param hl -  the listener we want to add.*/
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    /**The removeHitListener function will remove listener to the array of the listeners.
     * @param hl -  the listener we want to add.*/
    public void removeHitListener(HitListener hl) {
            this.hitListeners.remove(hl);
    }

    /**The notifyHit function will notify all listeners about a hit event.
     * @param hitter -  the ball that made the hit.*/
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
