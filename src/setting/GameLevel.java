package setting;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import hitListeners.BallRemover;
import hitListeners.BlockRemover;
import hitListeners.PrintingHitListener;
import hitListeners.ScoreTrackingListener;
import interfaces.Animation;
import interfaces.Collidable;
import interfaces.LevelInformation;
import interfaces.Sprite;
import sprites.Ball;
import sprites.Block;
import sprites.Paddle;
import sprites.ScoreIndicator;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class GameLevel implements Animation {
    private SpriteCollection sprites; //will be the sprites collection
    private GameEnvironment environment; //will be the game environment
    private Counter counterBlock; //will be the counter of the blocks
    private Counter counterBalls; //will be the counter of the balls
    private Counter counterScore; //will be the counter of the score
    private GUI gui; //the current gui
    private AnimationRunner runner; //the animation runner
    private boolean running; //true/false if the animation is running
    private LevelInformation levelInformation; //the level: 1,2,3,4
    private List<Ball> balls; //the list of the balls in the game
    private KeyboardSensor keyboardSensor; //the keyboard sensor
    private AnimationRunner animationRunner;

    /**The shouldStop function.
     * @return true/false if the animation is running*/
    public boolean shouldStop() {
        return !this.running;
    }

    /**The doOneFrame function will run the animation.
     * @param d - the drawface*/
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(200, 200, 250));
        d.fillRectangle(0, 0, gui.getDrawSurface().getWidth(), gui.getDrawSurface().getHeight());
        this.sprites.drawAllOn(d);

        if (this.counterBlock.getValue() == 0 || this.counterBalls.getValue() == 0) {
            this.running = false;
        }
        //the pause animation
        if (this.gui.getKeyboardSensor().isPressed("p")) {
            PauseScreen pause = new PauseScreen(this.keyboardSensor);
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY, pause));
        }
        this.sprites.notifyAllTimePassed();
        this.sprites.notifyAllTimePassed();
    }


    /**The setting.Game function is a constructor.in addition, we init the Gui.
     *@param level the current level
     *@param  keyboardSensor - our keyboard
     * @param  animationRunner - will be the current animation
     * @param gui - will be our gui
     * @param score - will be the current score*/
    public GameLevel(LevelInformation level, KeyboardSensor keyboardSensor, AnimationRunner animationRunner, GUI gui,
                     Counter score) {
        this.gui = gui;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.counterBlock = new Counter(0);
        this.counterBalls = new Counter(0);
        this.counterScore = score;
        this.runner = new AnimationRunner(this.gui);
        this.running = true;
        this.levelInformation = level;
        this.balls = new LinkedList<>();
        this.keyboardSensor = keyboardSensor;
        this.animationRunner = animationRunner;
    }
    /**The getGui function get this Gui.
     * @return this Gui*/
    public GUI getGui() {
        return this.gui;
    }
    /**The addCollidable function add this interfaces.Collidable.
     * @param  c - the collidable we need to add*/
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }
    /**The addSprite function add this interfaces.Sprite.
     * @param  s - the sprite we need to add*/
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }
    /**The getSprites function get this Sprites collection.
     * @return this Sprites*/
    public SpriteCollection getSprites() {
        return this.sprites;
    }
    /**The getEnvironment function get this Environment.
     * @return this Environment*/
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**The geCounterBlock function get this CounterBlock.
     * @return this CounterBlock*/
    public Counter getCounterBlock() {
        return this.counterBlock;
    }

    /**The getCounterBalls function get this getCounterBalls.
     * @return this CounterBalls*/
    public Counter getCounterBalls() {
        return this.counterBalls;
    }

    /**The getCounterScore function get this Environment.
     * @return this score counter*/
    public Counter getCounterScore() {
        return this.counterScore;
    }

    /**The getRemaningBlocks function get the remaning blocks.
     * @return this Environment*/
    public int getRemaningBlocks() {
        return this.counterBlock.getValue();
    }

    /**The getRemaningBalls function get this the remaning balls.
     * @return this balls*/
    public int getRemaningBalls() {
        return this.counterBalls.getValue();
    }

    /**The initialize function Initialize a new game: create the Blocks and sprites.Ball (and sprites.Paddle)
     * and add them to the game.*/
    public void initialize() {
        //init the frame blocks:
        Block blockUp = new Block(new Rectangle(new Point(20, 20), 800, 20), Color.gray);
        //if the ball hit the death block it will disappear
        Block blockLeft = new Block(new Rectangle(new Point(0, 20), 20, 580), Color.gray);
        Block blockRight = new Block(new Rectangle(new Point(780, 20), 20, 600), Color.gray);

        //add all the frame to the game
        blockUp.addToGame(this);
        blockLeft.addToGame(this);
        blockRight.addToGame(this);

        this.sprites.addSprite(this.levelInformation.getBackground());


        Paddle paddle = new Paddle(new Rectangle(new Point(50, 550), this.levelInformation.paddleWidth(), 30),
                this.gui.getKeyboardSensor(), this.gui.getDrawSurface().getWidth(),
                blockLeft.getCollisionRectangle().getWidth());
        paddle.addToGame(this);


        //add balls to the game
        int xBall =  this.gui.getDrawSurface().getWidth() / 2;
        int yBall =  this.gui.getDrawSurface().getHeight() / 2 + 50;
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball1;
            if (i % 2 == 0) {
                ball1 = new Ball(xBall + i * 20, yBall + i * 20, 3, Color.magenta);
            } else {
                ball1 = new Ball(xBall - i * 20, yBall + i * 20, 3, Color.magenta);

            }
            ball1.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            this.balls.add(ball1);
            ball1.setGame(this.environment);
            this.counterBalls.increase(1);
            ball1.addToGame(this);
        }

        //score:
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.counterScore, this.levelInformation.levelName());
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(counterScore);
        scoreIndicator.addToGame(this);

        //Ball remover and death block
        BallRemover ballRemover = new BallRemover(this, this.counterBalls);
        Block deathBlock = new Block(new Rectangle(new Point(0, 600), 800, 20), Color.gray);
        deathBlock.addHitListener(ballRemover);
        deathBlock.addToGame(this);

        //now we call our listeners.
        PrintingHitListener printingHitListener = new PrintingHitListener();
        BlockRemover remover = new BlockRemover(this, counterBlock);
        for (int i = 0; i < this.levelInformation.blocks().size(); i++) {
            this.levelInformation.blocks().get(i).addToGame(this);
            this.levelInformation.blocks().get(i).addHitListener(printingHitListener);
            this.levelInformation.blocks().get(i).addHitListener(remover);
            this.levelInformation.blocks().get(i).addHitListener(scoreTrackingListener);
            this.counterBlock.increase(1);
        }

    }

    /**The run function Run the game -- start the animation loop. our runner run the current animation .*/
    public void run() {
        this.runner.run(new CountdownAnimation(3.0, 3, this.sprites)); //countdown before turn starts.
        this.running = true;
        this.runner.run(this);
    }

    /**The removeCollidable function will remove the collidable c from the array of the colliadbles.
     * @param c - the colliadble that will remove.*/
    public void removeCollidable(Collidable c) {
     this.environment.getCollidables().remove(c);
    }

    /**The removeSprite function will remove the sprite s from the array of the sprites.
     * @param s - the colliadble that will remove.*/
    public void removeSprite(Sprite s) {
        this.getSprites().getCollection().remove(s);
    }
}