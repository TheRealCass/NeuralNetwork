package data;

public class DataPoint {
    double x;
    double y;

    public DataPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        String toReturn = "";
        toReturn += x + ", " + y;
        return toReturn;
    }
}
