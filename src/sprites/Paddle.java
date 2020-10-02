package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import setting.GameLevel;

import java.awt.Color;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard; // the keyboard of the game
    private Rectangle  collisionRectangle; //the rectangle of the paddle
    private double drawSurfaceWidth; //the width of the drawface
    private double frameWidth; //the width of the frame

    /**The sprites.Paddle function is a constructor.
     * @param drawSurfaceWidth - the width of the drawface
     * @param frameWidth - will be the width of the frame
     * @param keybord the keyborad
     * @param rectangle - the rectangle of the paddle*/
    public Paddle(Rectangle rectangle, biuoop.KeyboardSensor keybord, double drawSurfaceWidth, double frameWidth) {
        this.drawSurfaceWidth = drawSurfaceWidth;
        this.frameWidth = frameWidth;
        this.collisionRectangle = rectangle;
        this.keyboard = keybord;
    }
    /** The moveLeft function move the paddle left.*/
    public void moveLeft() {
        Point upperLeftThis = this.collisionRectangle.getUpperLeft();
        if (upperLeftThis.getX() > frameWidth) {
            this.collisionRectangle.getUpperLeft().setX(upperLeftThis.getX() - 10);
            this.collisionRectangle.setRectangle();
        }
    }
    /**The moveRight function move the paddle right.*/
    public void moveRight() {
        Point upperLeftThis = this.collisionRectangle.getUpperLeft();
        //the paddle will n0t move if it get out of the frame.
        if (upperLeftThis.getX() < drawSurfaceWidth - frameWidth - collisionRectangle.getWidth()) {
            //System.out.println("IF: " + upperLeftThis.getX());
            this.collisionRectangle.getUpperLeft().setX(upperLeftThis.getX() + 10);
            this.collisionRectangle.setRectangle();

        }
    }

    /**The getEnd function return the end of the line.*/
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
    }
    /**The getEnd function return the end of the line.
     * @param d - the drawface*/
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        Point upperLeft = this.collisionRectangle.getUpperLeft();
        d.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.collisionRectangle.getHeight());
        d.setColor(Color.PINK);
        d.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.collisionRectangle.getHeight());
    }

    // interfaces.Collidable
    /**The getEnd function return the end of the line.
     * @return this End point*/
    public Rectangle getCollisionRectangle() {
        return this.collisionRectangle;
    }

    /**The hit function change the velocity depends on the location it hit the paddle.
     * @param collisionPoint - the point of the collision
     * @param currentVelocity - the velocity before the change
     * @param hitter - the ball.
     * @return new velocity expected after the hit*/
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity; //first we define the new velocity to be the current velocity
        double rectangleWidth = this.collisionRectangle.getWidth(); //the width of the paddle
        Point upperLeft = this.collisionRectangle.getUpperLeft();
        //if the ball hit on the sides of the paddle
            if (collisionPoint.getY() > upperLeft.getY() && (collisionPoint.getX() == upperLeft.getX()
                    || collisionPoint.getX() == upperLeft.getX() + rectangleWidth)) {
                newVelocity.setDx(-1 * newVelocity.getDx());
                //there is 5 different locations on the top of the paddle
            } else if (collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() <= (rectangleWidth / 5)
            && collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() >= 0) {
                newVelocity = Velocity.fromAngleAndSpeed(330, 4);

            } else if (collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() <= 2 * (rectangleWidth / 5)
                    && collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() >= 0) {
                newVelocity = Velocity.fromAngleAndSpeed(300, 4);
            } else if (collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() <= 3 * (rectangleWidth / 5)
                    && collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() >= 0) {
                newVelocity.setDy(-1 * newVelocity.getDy());
            } else if (collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() <= 4 * (rectangleWidth / 5)
                    && collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() >= 0) {
                newVelocity = Velocity.fromAngleAndSpeed(30, 4);

            } else if (collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() <= rectangleWidth
                    && collisionPoint.getX() - this.collisionRectangle.getUpperLeft().getX() >= 0) {
                newVelocity = Velocity.fromAngleAndSpeed(60, 4);
            }
        //}

        return newVelocity;
    }

    /**The addToGame function add the paddle to the game.
     * @param g - the game*/
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    @Override
    /**The toString function print a string with the information of this paddle.
     * @return string*/
    public String toString() {
        return "sprites.Paddle{" + "keyboard=" + keyboard + ", collisionRectangle=" + collisionRectangle + '}';
    }
}

