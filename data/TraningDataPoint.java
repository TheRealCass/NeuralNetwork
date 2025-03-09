package data;

public class TraningDataPoint {
    double x;
    double y;
    double target;

    public TraningDataPoint(double x, double y) {
        this.x = x;
        this.y = y;
        this.target = -999.999;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    
}