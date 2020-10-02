package geometry;

/**@author:Sapir Hirak
 * 207376567
 * sapiroosh1h@gmail.com**/
public class Velocity {
    private double dx; //x geometry.Velocity
    private double dy; //y velocity

    /**The geometry.Velocity function is the velocity constructor.
     * @param dx - the xVelocity
     * @param dy - the yVelocity**/
     public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**The getDx function return this x value of this velocity.
     * @return this dx*/
    public double getDx() {
        return this.dx;
    }
    /**The geDX function return this x value of this velocity.
     * @return this dy*/
    public double getDy() {
        return this.dy;
    }

    /**The getDx function change this x value of this velocity.
     * @param newdx - will be the x change*/
    public void setDx(double newdx) {
         this.dx = newdx;
    }
    /**The geDX function change this x value of this velocity.
     * @param newdy - y change*/
    public void setDy(double newdy) {
         this.dy = newdy;
    }
    /**The fromAngleAndSpeed function .
     * @param   angle - the angle of the velocity
     * @param  speed - the speed of the velocity
     * @return the new velocity*/
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -1 * speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    /** Take a point with position (x,y) and return a new point with position (x+dx, y+dy).
     * @param p - the point
     * @return the new point after the move**/
    public Point applyToPoint(Point p) {
        Point newPoint = new Point((p.getX() + this.dx), (p.getY() + this.dy));
        return  newPoint;
    }

    @Override
    public String toString() {
        return "geometry.Velocity{" + "dx=" + dx + ", dy=" + dy + '}';
    }
}