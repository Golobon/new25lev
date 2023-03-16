package Lev_30_lec_15_1;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;
    private boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    abstract public void draw();
    abstract public void move();
    public void die() {
        isAlive = false;
    }

    public boolean isIntersect(BaseObject o) {
        double distance = Math.hypot(getX()-o.getX(), getY()-o.getY());
        return distance < Math.max(radius, o.radius);
    }
}