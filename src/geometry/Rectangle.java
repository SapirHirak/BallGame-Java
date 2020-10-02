package geometry;
import java.util.ArrayList;
import java.util.List;
/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Rectangle {
    private Point upperLeft; //upper Left point
    private double width; //the width of the rectangle
    private double height; //the height of the rectangle
    private Line leftLine; //the left line of the rectangle
    private Line rightLine; //the right line of the rectangle
    private Line upperLine; //the upper line of the rectangle
    private Line downLine; //the down line of the rectangle
    private Point downLeftPoint; //down Left point of the rectangle
    private Point upperRightPoint; //upper right point
    private Point downRightPoint; //down right point

    /**The function Create a new rectangle with location and width/height, and calculate all the lines ans points.
     * @param  upperLeft point
     * @param width of the rectangle
     * @param  height of the rectangle*/
    public Rectangle(Point upperLeft, double width, double height) {
        this.downLeftPoint = new Point(upperLeft.getX(), upperLeft.getY() + height);
        this.upperRightPoint = new Point(upperLeft.getX() + width, upperLeft.getY());
        this.downRightPoint = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        this.leftLine = new Line(upperLeft, downLeftPoint);
        this.rightLine = new Line(upperRightPoint, downRightPoint);
        this.upperLine = new Line(upperLeft, upperRightPoint);
        this.downLine = new Line(downLeftPoint, downRightPoint);

        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**The getWidth function return this Width.
     * @return this Width*/
    public double getWidth() {
        return this.width;
    }
    /**The getHeight function return this Height.
     * @return this Height*/
    public double getHeight() {
        return this.height;
    }

    //
    /**The getUpperLeft function Returns the upper-left point of the rectangle.
     * @return this UpperLeft*/
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**The getDownLeftPoint function return this DownLeftPoint.
     * @return this downLeftPoint*/
    public Point getDownLeftPoint() {
        return this.downLeftPoint;
    }
    /**The getUpperRightPoint function return this UpperRightPoint.
     * @return this UpperRightPoint*/
    public Point getUpperRightPoint() {
        return this.upperRightPoint;
    }
    /**The getDownRightPoint function return this DownRightPoint.
     * @return this DownRightPoint*/
    public Point getDownRightPoint() {
        return this.downRightPoint;
    }
    /**The setUpperLeft function change this UpperLeft point.
     * @param newUpperLeft - the change*/
    public void setUpperLeft(Point newUpperLeft) {
        this.upperLeft = newUpperLeft;
    }
    /**The setRectangle function change all the rectangle.*/
    public void setRectangle() {
        this.downLeftPoint = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        this.upperRightPoint = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        this.downRightPoint = new Point(this.upperLeft.getX() + width, this.upperLeft.getY() + height);
        this.leftLine = new Line(this.upperLeft, downLeftPoint);
        this.rightLine = new Line(upperRightPoint, downRightPoint);
        this.upperLine = new Line(this.upperLeft, upperRightPoint);
        this.downLine = new Line(downLeftPoint, downRightPoint);
    }


    /**The getDownLeftPoint function return this DownLeftPoint.
     * @return this downLeftPoint*/
    public Line getLeftLine() {
        return this.leftLine;
    }
    /**The getDownLeftPoint function return this DownLeftPoint.
     * @return this downLeftPoint*/
    public Line getDownLine() {
        return this.downLine;
    }
    /**The getDownLeftPoint function return this DownLeftPoint.
     * @return this downLeftPoint*/
    public Line getRightLine() {
        return this.rightLine;
    }
    /**The getDownLeftPoint function return this DownLeftPoint.
     * @return this downLeftPoint*/
    public Line getUpperLine() {
        return this.upperLine;
    }

    /**The intersectionPoints function will calculate Return a (possibly empty) List of intersection points with the
     *  specified line.
     * @param line - the line we check on
     * @return List of Points */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<>();

        if (this.leftLine.isIntersecting(line)) {
            points.add(this.leftLine.intersectionWith(line));
        } else if (this.downLine.isIntersecting(line)) {
            points.add(this.downLine.intersectionWith(line));
        } else if (this.rightLine.isIntersecting(line)) {
            points.add(this.rightLine.intersectionWith(line));
        } else if (this.upperLine.isIntersecting(line)) {
            points.add(this.upperLine.intersectionWith(line));
        }
        return points;
    }
    /**The isIntersection function return if the line and the rectangle are Intersection.
     * @param line for checking
     * @return true if the lines isIntersection, else otherwise*/
    public boolean isIntersection(Line line) {
        if (intersectionPoints(line).isEmpty()) {
            return false;
        }
        return true;
    }


    /**The toString function return information of this rectangle.
     * @return string*/
    @Override
    public String toString() {
        return "geometry.Rectangle{" + "upperLeft=" + upperLeft.toString() + ", width=" + width + ", height=" + height
                + '}';
    }
}