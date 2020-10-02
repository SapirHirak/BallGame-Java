package geometry;

import java.util.List;

/**
 * *@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Line {
    /**The main function gets strigs and char ,and prints first the strings with the char.
     * and then the strings without the char *
     * @param args - get string and char.*/
    private Point start; //the start point the line
    private Point end; //the end point of the line

    /**The geometry.Line function is a constructor.
     * @param start - start line
     * @param end - end line*/
    public Line(Point start, Point end) {
        if (start.getX() < end.getX()) {
            this.start = start;
            this.end = end;
        } else {
            this.end = start;
            this.start = end;
        }
    }
    /**The geometry.Line function is a constructor.
     * @param x1 - xstart line .
     * @param y1 - yStart line.
     * @param x2 - end line.
     * @param y2 - yEnd line.*/
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**The length function will return the length of this line.
     * @return length */
    public double length() {
        return start.distance(end);
    }

    //
    /**The middle function Returns the middle point of the line.
     * @return point */
    public Point middle() {
        Point middle = new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
        return middle;
    }

    /**The start function return the start geometry.Point of this line.
     * @return point */
    public Point start() {
        return this.start;
    }

    /**The end function return the end geometry.Point of this line.
     * @return end point*/
    public Point end() {
        return this.end;
    }

    /**The isIntersecting function Returns true if the lines intersect, false otherwise.
     * @param other - the line we compare to check if the lines intersect
     * @return true if the lines intersect , false otherwise*/
    public boolean isIntersecting(Line other) {
        if (intersectionWith(other) != null) {
            return true;
        }
        return false;
    }

    /**The start function Returns true if the lines intersect, false otherwise.
     * @param other - the line we compare to check if the lines intersect
     * @return the intersection point if the lines intersect*/
    public Point intersectionWith(Line other) {
        //edge cases
        if (this.start == other.start && this.end != other.end) {
            return this.start;
        }
        if (this.start == other.end && this.end != other.start) {
            return this.start;
        }
        if (this.end == other.start && this.start != other.end) {
            return this.start;
        }
        if (this.end == other.end && this.start != other.start) {
            return this.start;
        }
        //geometry.Line 1
        double x1 = this.start.getX(); //x start
        double x2 = this.end.getX(); //x end
        double y1 = this.start.getY(); //y start
        double y2 = this.end.getY(); //y end
        double m1 = (y1 - y2) / (x1 - x2); //line1 Incline
        //geometry.Line 2
        double a1 = other.start.getX(); //x start
        double a2 = other.end.getX(); //x end
        double b1 = other.start.getY(); //y start
        double b2 = other.end.getY(); //y end
        double m2 = (b1 - b2) / (a1 - a2); //line 2 Incline
        //both Vertical line
        if (x1 - x2 == 0 && a1 - a2 == 0) {
            return null;
        }
        //if one of them is vertical line
        if (x1 - x2 == 0 && a1 - a2 != 0) {
            double xCut = x1; //the x number of the cut point
            double yCut = b1 + m2 * (xCut - a1); //the y number of the cut point
            Point cut = new Point(xCut, yCut);
            if (xCut >= Math.min(x1, x2) && xCut <= Math.max(x1, x2) && xCut >= Math.min(a1, a2)
                    && xCut <= Math.max(a1, a2) && yCut >= Math.min(y1, y2) && yCut >= Math.min(b1, b2)
                    && yCut <= Math.max(y1, y2) && yCut <= Math.max(b1, b2)) {
                return cut;
            }
            return null;
        }
        //if another is vertical line
        if (x1 - x2 != 0 && a1 - a2 == 0) {
            double xCut = a1; //the x number of the cut point
            double yCut = y1 + m1 * (xCut - x1); //the y number of the cut point
            Point cut = new Point(xCut, yCut);
            if (xCut >= Math.min(x1, x2) && xCut <= Math.max(x1, x2) && xCut >= Math.min(a1, a2)
                    && xCut <= Math.max(a1, a2) && yCut >= Math.min(y1, y2) && yCut >= Math.min(b1, b2)
                    && yCut <= Math.max(y1, y2) && yCut <= Math.max(b1, b2)) {
                return cut;
            }
            return null;
        }
        //if the second line with m = 0
        if (y1 - y2 != 0 && b1 - b2 == 0) {
            double yCut = b1;  //the y number of the cut point
            double xCut = ((b1 - y1) / m1) + x1; //the x number of the cut point
            Point cut = new Point(xCut, yCut);
            if (xCut >= Math.min(x1, x2) && xCut <= Math.max(x1, x2) && xCut >= Math.min(a1, a2)
                    && xCut <= Math.max(a1, a2) && yCut >= Math.min(y1, y2) && yCut >= Math.min(b1, b2)
                    && yCut <= Math.max(y1, y2) && yCut <= Math.max(b1, b2)) {
                return cut;
            }
            return null;
        }
        //if the first line with m = 0
        if (y1 - y2 == 0 && b1 - b2 != 0) {
            double yCut = y1;  //the y number of the cut point
            double xCut = ((y1 - b1) / m2) + a1; //the x number of the cut point
            Point cut = new Point(xCut, yCut);
            if (xCut >= Math.min(x1, x2) && xCut <= Math.max(x1, x2) && xCut >= Math.min(a1, a2)
                    && xCut <= Math.max(a1, a2) && yCut >= Math.min(y1, y2) && yCut >= Math.min(b1, b2)
                    && yCut <= Math.max(y1, y2) && yCut <= Math.max(b1, b2)) {
                return cut;
            }
            return null;
        }
            if (m1 != m2) {
            double xCut = (m1 * x1 - y1 - m2 * a1 + b1) / (m1 - m2); //the x number of the cut point
            double yCut = m1 * xCut - m1 * x1 + y1; //the y number of the cut point
                Point cut = new Point(xCut, yCut);
                if (xCut >= Math.min(x1, x2) && xCut <= Math.max(x1, x2) && xCut >= Math.min(a1, a2)
                        && xCut <= Math.max(a1, a2) && yCut >= Math.min(y1, y2) && yCut >= Math.min(b1, b2)
                        && yCut <= Math.max(y1, y2) && yCut <= Math.max(b1, b2)) {
                    return cut;
                }
                return null;
        }
        return null;
    }

    /**The equals function Returns true if the lines equals, false otherwise.
     * @param other - the line we compare to check if the lines equals
     * @return true if they equals , false otherwise*/
    public boolean equals(Line other) {
        if (this.start == other.start && this.end == other.end || this.start == other.end && this.end == other.start) {
            return  true;
        }
        return false;
    }

    /**The closestIntersectionToStartOfLine function return the closest intersect point.
     * @param rect - the line we compare to check if the lines equals
     * @return geometry.Point if there is intersect with the rectangle , null otherwise*/
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.isIntersection(this)) {
            //array of the points that intersect with the rectangle
            List<Point> points = rect.intersectionPoints(this);
            Point closest = points.get(0); //define the first to be the closest
            for (Point p: points) {
                if (p.distance(this.start()) <= closest.distance(this.start())) {
                    closest = p;
                }
            }
            return closest;
        } else {
            return null;
        }
    }
    /**The getStart function return the end of the line.
     * @return this Start point*/
    public Point getStart() {
        return this.start;
    }
    /**The getEnd function return the end of the line.
     * @return this End point*/
    public Point getEnd() {
        return end;
    }

    /**The toString function return information of this line.
     * @return string*/
    @Override
    public String toString() {
        return "geometry.Line{" + "start=" + start + ", end=" + end + '}';
    }
}


