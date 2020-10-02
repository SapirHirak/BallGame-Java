package interfaces;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public interface HitNotifier {
    /**The addHitListener function will hl as a listener to hit events.
     * @param hl -  the listener we want to add.*/
    void addHitListener(HitListener hl);

    /**The removeHitListener function will remove hl from the list of listeners to hit events..
     * @param hl -  the listener we want to remove.*/
    void removeHitListener(HitListener hl);
}

