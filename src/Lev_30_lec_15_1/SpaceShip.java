package Lev_30_lec_15_1;

public class SpaceShip extends BaseObject {
    private double dx = 0;
    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
    @Override
    public void draw(Canvas canvas) { }
    @Override
    public void move() {
        x = x + dx;
        checkBorders(radius, Space.game.getWidth() - radius, radius, Space.game.getHeight() - radius);
    }
    public void moveLeft() { dx = -1; }
    public void moveRight() { dx = 1; }

    public void fire() {
        Rocket r1 = new Rocket(x - 2, y);
        Rocket r2 = new Rocket(x + 2, y);
        Space.game.getRockets().add(r1);
        Space.game.getRockets().add(r2);
    }
}
