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

    private double randInt(int min, int max) {
        int toReturn =  (int)(Math.random() * (max - min + 1) + min);
        return toReturn;
    }

    @Override
    public String toString() {
        String toReturn = "";
        toReturn += x + ", " + y;
        return toReturn;
    }
}
