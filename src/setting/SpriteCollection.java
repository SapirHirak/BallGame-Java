package setting;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
/**@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class SpriteCollection {
    private ArrayList<Sprite> collection; //interfaces.Sprite ArrayList

    /**The sprites.Paddle function is a constructor - init the sprite collection.*/
    public SpriteCollection() {
        this.collection = new ArrayList<Sprite>();
    }
    /**The getCollection function get this collection.
     * @return this collection*/
    public ArrayList<Sprite> getCollection() {
        return this.collection;
    }

    /**The addSprite function add the sprite to the game.
     * @param s - the sprite*/
    public void addSprite(Sprite s) {
        collection.add(s);
    }

    /**The notifyAllTimePassed function call timePassed() on all sprites.*/
    public void notifyAllTimePassed() {
        for (int i = 0; i < collection.size(); i++) {
            collection.get(i).timePassed();
        }
    }

    /**The drawAllOn function call drawOn(d) on all sprites.
     * @param d - the surface*/
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < collection.size(); i++) {
            collection.get(i).drawOn(d);
        }
    }
}