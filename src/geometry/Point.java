package geometry;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Point {
    private double x; //xPoint
    private double y; //yPoint

    /**The geometry.Point function is a constructor.
     * @param x - xPoint
     * @param y - yPoint*/
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**The distance function will return the distance of this point to the other point.
     * @param other - other point to calculate with this point
     * @return */
    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**The equals function will return true is the points are equal, false otherwise.
     * @param other - other point to compare with this point
     * @return true if equals,false otherwise*/
    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }

    /**The getX function return this x value of this geometry.Point.
     * @return this x*/
    public double getX() {
        return this.x;
    }
    /**The getX function return this x value of this geometry.Point.
     * @return this y*/
    public double getY() {
        return this.y;
    }
    /**The setX function change this x value of this geometry.Point.
     * @param newx */
    public void setX(double newx) {
        this.x = newx;
    }
    /**The setY function change this y value of this geometry.Point.
     * @param newy */
    public void setY(double newy) {
        this.y = newy;
    }

    @Override
    /**The toString function print a string with the information of this point.
     * @return string*/
    public String toString() {
        return "geometry.Point{" + "x=" + x + ", y=" + y + '}';
    }
}
