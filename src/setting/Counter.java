package setting;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Counter {
    private int value; //will be the value of the counter.

    /**Counter constructor.
     * @param number - the number of the value.*/
    public Counter(int number) {
        this.value = number;
    }

    /**increase function  add number to current count.
     * @param number - the number we add.*/
   public void increase(int number) {
       this.value = this.value + number;
   }

    /**increase function  subtract number from current count.
     * @param number - the number we add.*/
   public void decrease(int number) {
        this.value = this.value - number;
   }

    /** get current count.
     * @return the number of the value.*/
   public int getValue() {
        return this.value;
   }
    /** will setValue.
     * @param  val the number of the value.*/
   public void setValue(int val) {
       this.value = val;
   }
}