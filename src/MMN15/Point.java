package MMN15;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Point {
    private int _x;
    private int _y;

    public Point(int x, int y) {
        this._x = x;
        this._y = y;
    }

    public Point(Point other) {
        this._x = other.getX();
        this._y = other.getY();
    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public void setX(int num) {
        this._x = num;
    }

    public void setY(int num) {
        this._y = num;
    }

    public String toString() {
        return "(" + this._x + "," + this._y + ")";
    }

    public boolean equals(Point other) {
        return other != null && this._x == other.getX() && this._y == other.getY();
    }

    public boolean isAbove(Point other) {
        return this._y > other.getY();
    }

    public boolean isUnder(Point other) {
        return other.isAbove(this);
    }

    public boolean isLeft(Point other) {
        return this._x < other.getX();
    }

    public boolean isRight(Point other) {
        return other.isLeft(this);
    }

    public double distance(Point p) {
        return Math.sqrt((double)((this._x - p.getX()) * (this._x - p.getX()) + (this._y - p.getY()) * (this._y - p.getY())));
    }

    public void move(int deltaX, int deltaY) {
        this._x += deltaX;
        this._y += deltaY;
    }
}
