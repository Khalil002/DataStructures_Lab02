package Graph;

public class Vector {

    private double x, y;

    public Vector() {
        this.setX(0);
        this.setY(0);
    }

    public Vector(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public Vector add(Vector v) {
        return new Vector(x + v.getX(), y + v.getY());
    }

    public Vector sub(Vector v) {
        return new Vector(x - v.getX(), y - v.getY());
    }

    public Vector mul(double m) {
        return new Vector(x * m, y * m);
    }

    public double Dot(Vector v) {
        return x * v.getX() + y * v.getY();
    }

    public double Size() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector Unit() {
        double s = Size();
        return new Vector(x / s, y / s);
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

}
