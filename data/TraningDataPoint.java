package data;

import supervisedLearning.ActivationMap;

public class TraningDataPoint extends DataPoint{

    double target;
    double error;

    public TraningDataPoint(ActivationMap map) {
        //choose a random x,y coordinate value from the map-grid
        super((int)(Math.random() * map.getLengthOfXAxis()), (int)(Math.random() * map.getLengthOfYAxis()));
        this.target = map.calculateLabel(this);
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    } 

    public String toString(){
        String toReturn = super.toString();
        toReturn += " : " + target;
        return toReturn;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getError() {
        return error;
    }

    
}