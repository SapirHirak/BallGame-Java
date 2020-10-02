package setting;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;
import sprites.Ball;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class GameEnvironment {
    private ArrayList<Collidable> collidables; // Create an ArrayList object

    /**The setting.GameEnvironment constructor.*/
    public GameEnvironment() {
        this.collidables = new ArrayList<Collidable>();
    }
    /**The addCollidable function add the given collidable to the environment.
     * @param c - given collidable*/
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**The getCollidables function return this y value of this center.
     * @return array of Collidables*/
    public ArrayList<Collidable> getCollidables() {
        return this.collidables;
    }

    /**The getClosestCollision function return information about the collection point , otherwise return null.
     * @param trajectory - the line
     * @return If this object will not collide with any of the collidables in this collection, return null. Else,
     * return the information about the closest collision that is going to occur.*/
    public CollisionInfo getClosestCollision(Line trajectory) {
        ArrayList<CollisionInfo> collidablePoints = new ArrayList<CollisionInfo>(); //ArrayList of the collisions
        Rectangle r; //will be the rectangles of the collidables

        for (Collidable c : collidables) {
            r = c.getCollisionRectangle();
            if (trajectory.closestIntersectionToStartOfLine(r) != null) {
                CollisionInfo newC = new CollisionInfo(trajectory.closestIntersectionToStartOfLine(r), c);
                collidablePoints.add(newC);
            }
        }
        //if there is no collidablePoints
        if (collidablePoints.size() == 0) {
            return null;
        }
        //else - find the closest point
        CollisionInfo closest = collidablePoints.get(0);
        for (CollisionInfo c : collidablePoints) {
            if (trajectory.getStart().distance(c.getCollisionPoint())
                    < trajectory.getStart().distance(closest.getCollisionPoint())) {
                closest = c;
            }
        }
        return  closest;
    }

    /**the main function create the game.
     * @param args .*/
    public static void main(String[] args) {
        GUI gui = new GUI("title", 800, 800); //the gui we will work on
        Ball ball = new Ball(30, 20, 10, Color.magenta);
        ball.setVelocity(10, 20);
        Random rand = new Random();
        Block[] blocks = new Block[14];
        GameEnvironment environment = new GameEnvironment();
        for (int i = 0; i < 10; i++) { //10 little blocks
            Block block1 = new Block(new Rectangle(new Point((double) rand.nextInt(700),
                    (double) rand.nextInt(700)), 30, 60), Color.RED);
            blocks[i] = block1;
            environment.addCollidable(blocks[i]);
        }
        //2 big blocks
        Block blockUp = new Block(new Rectangle(new Point(0, 0), 800, 6), Color.RED);
        Block blockDown = new Block(new Rectangle(new Point(0, 490), 800, 30), Color.RED);
        Block blockLeft = new Block(new Rectangle(new Point(0, 0), 30, 800), Color.RED);
        Block blockRight = new Block(new Rectangle(new Point(730, 0), 30, 800), Color.RED);

        blocks[10] = blockUp;
        blocks[11] = blockDown;
        blocks[12] = blockLeft;

        blocks[13] = blockRight;

        environment.addCollidable(blocks[10]);
        environment.addCollidable(blocks[11]);
        environment.addCollidable(blocks[12]);
        environment.addCollidable(blocks[13]);

        ball.setGame(environment);
        drawAnimation(blocks, environment, gui, ball);
    }
    /**TThe drawAnimation function gets 4 params and draw an animation of the ball.
     * @param  blocks - array of blocks
     * @param gui - the gui.
     * @param environment - the envairoment of the game
     * @param ball - the ball of the game*/
    private static void drawAnimation(Block[] blocks, GameEnvironment environment, GUI gui, Ball ball) {
        Sleeper sleeper = new Sleeper(); //sleeper to show the animation

        while (true) {
            DrawSurface d = gui.getDrawSurface();
            ball.moveOneStep();

            ball.drawOn(d);
            for (int i = 0; i < blocks.length; i++) {
               blocks[i].drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }

}