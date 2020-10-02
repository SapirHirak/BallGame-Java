package sprites;

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import interfaces.Collidable;
import interfaces.Sprite;
import setting.GameLevel;
import setting.GameEnvironment;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Ball implements Sprite {
    private Velocity v; // will be the geometry.Velocity of the ball
    private Point center; //will be the center of the ball
    private int r; // will be the radius of the ball
    private java.awt.Color color; //color of the ball
    private int bottomFrame = -1; //will be the bottom frame
    private int topFrame = 0; //will be the top frame
    private int rightFrame = -1; //will be the right frame
    private int leftFrame = 0; //will be the left frame
    private GameEnvironment environment; //will be the game enviroment
    private static int idCount = 1;
    private int id;
    /**sprites.Ball setGame set the game .
     * @param theEnvironment - the enviroment we want to add.*/
    public void setGame(GameEnvironment theEnvironment) {
        this.environment = theEnvironment;
    }

    /**sprites.Ball constructor gets 3 args .
     * @param center - get 3 nunbers.
     * @param r - radius
     * @param color - the color of the ball */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center; //the center of the ball
        this.r = r; //the radius of the ball
        this.color = color; //the color of the ball
        this.v = new Velocity(0, 0); //the velocity of the ball

    }
    /**sprites.Ball constructor gets 4 args .
     * @param x - et 3 nunbers.
     * @param  y - yPoint of the center
     * @param r - radius
     * @param color - color of the ball*/
    public Ball(int x, int y, int r, java.awt.Color color) {
        Point centerBall = new Point(x, y);
        this.center = centerBall;
        this.r = r;
        this.color = color;
        this.v = new Velocity(0, 0);
        this.id = this.idCount++;
    }

    /**The getX function return this x value of this center.
     * @return this x*/
    public int getX() {
        return (int) this.center.getX();
    }
    /**The getY function return this y value of this center.
     * @return this x*/
    public int getY() {
        return (int) this.center.getY();
    }
    /**The getX function return this x value of this center.
     * @return this x*/
    public int getSize() {
        return this.r;
    }
    /**The getX function return this x value of this center.
     * @return this x*/
    public java.awt.Color getColor() {
        return this.color;
    }

    // draw the ball on the given DrawSurface
    /**The drawOn function getssurface and draw the circle .if the size of the frame in the ball is not initialize, we
     * update the ball's size to be the hole surface and draw the ball on the given DrawSurface, otherwise we have
     * already the currect surface from setFrame and we dont need to change it again.
     * @param surface - the suface we need to draw on.*/
    public void drawOn(DrawSurface surface) {
        if (this.bottomFrame == -1 && this.rightFrame == -1) {
            this.bottomFrame = surface.getHeight();
            this.rightFrame = surface.getWidth();
        }
        surface.drawCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), r);
    }

    /**The setVelocity function change the velocity .
     * @param newV - the new velocity.*/
    public void setVelocity(Velocity newV) {
        this.v.setDx(newV.getDx());
        this.v.setDy(newV.getDy());
    }
    /**The setVelocity function change the velocity .
     * @param dx - the new dx.
     * @param dy - the new dy*/
    public void setVelocity(double dx, double dy) {
        this.v.setDx(dx);
        this.v.setDy(dy);
    }
    /**The getVelocity function get this velocity.
     * @return velocity*/
    public Velocity getVelocity() {
        return this.v;
    }
    /**The setFrame function set the frame .
     * @param newBottomFrame - bottom frame
     * @param newRightFrame  - the right frame
     * @param newLeftFrame - will be the left frame
     * @param newTopFrame - top frame.*/
    public void setFrame(int newBottomFrame, int newRightFrame, int newLeftFrame, int newTopFrame) {
        this.bottomFrame = newBottomFrame;
        this.rightFrame = newRightFrame;
        this.topFrame = newTopFrame;
        this.leftFrame = newLeftFrame;
    }
    /**The moveOneStep checks if the next move is ok , if he is ok we do the move,otherwise its change direction
     * first.*/
    public void moveOneStep() {
        Point endTrajectory = new Point(this.center.getX(), this.center.getY());
        endTrajectory.setX(endTrajectory.getX() + this.v.getDx());
        endTrajectory.setY(endTrajectory.getY() + this.v.getDy());

        Line trajectory = new Line(this.center, endTrajectory);
        //if there is no blocks we move the ball to the end of the trajectory
        if (this.environment.getClosestCollision(trajectory) == null) {
            this.center = endTrajectory;
        } else {
            Collidable collidableObject = this.environment.getClosestCollision(trajectory).collisionObject();
            Rectangle objectRectangle = collidableObject.getCollisionRectangle();
            Point collidablePoint = this.environment.getClosestCollision(trajectory).collisionPoint();
            //if the ball hit the upper or left line
            if (collidablePoint.getX() == objectRectangle.getLeftLine().getStart().getX()
                    || collidablePoint.getY() ==  objectRectangle.getUpperLine().getStart().getY()) {
                this.center.setX(collidablePoint.getX() - 2);
                this.center.setY(collidablePoint.getY() - 2);
            //if the ball hit the right or down line
            } else if (collidablePoint.getX() == objectRectangle.getDownLine().getStart().getX()
                    || collidablePoint.getY() == objectRectangle.getDownLine().getStart().getY()
                    || collidablePoint.getX() == objectRectangle.getRightLine().getStart().getX()
                    || collidablePoint.getY() == objectRectangle.getRightLine().getStart().getY()) {
                this.center.setX(2 + collidablePoint.getX());
                this.center.setY(2 + collidablePoint.getY());
            }

          //  System.out.println(this.id + " " + collidablePoint);
        //    System.out.println(this.id + " " + this.v);
            this.setVelocity(collidableObject.hit(this, collidablePoint, this.v));
        }
    }
    /**The timePassed notify the sprite that time has passed , and call to moveonestep.*/
    public void timePassed() {
        moveOneStep();
    }
    /**The addToGame definite the environment to the game environment.
     * @param g - the game.*/
    public void addToGame(GameLevel g) {
        this.environment = g.getEnvironment();
        g.addSprite(this);
    }

    /**The removeFromGame function will remove this ball from the array of the sprites.
     * @param g -  the game we want to remove from it.*/
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.getCounterBalls().decrease(1);
    }
}