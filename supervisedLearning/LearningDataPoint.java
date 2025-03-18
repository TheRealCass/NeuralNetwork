package supervisedLearning;

public class LearningDataPoint {
    
    private double[] inputs;
    private int totalNumberOfInputs;
    private double expectedOutput;
    private double error;

    /**
     * constructor
     * created a data point from a AND table of 2 operators
     * thus meaning, number of input is 2
     */
    public LearningDataPoint() {

        expectedOutput = 0;
        totalNumberOfInputs = 2;
        inputs = new double[totalNumberOfInputs];
        fillInputs();
        calculateTarget();
    }

    /**
     * calculates the result of the and based on the A and B inputs
     */
    private void calculateTarget() {

        double a = inputs[0];
        double b = inputs[1];

        if ((a > 0.00) && (b > 0.00)) {
            expectedOutput = 1.00; // a(t) and b(t) = true
        } else {
            expectedOutput = 0.00;
        }
    }

    /**
     * picks between random all the 4 possibilites A and B could be arragned
     */
    private void fillInputs() {
        double randomVal = Math.random() * 100;

        if (randomVal >= 0 && randomVal < 50) {
            inputs[0] = 0.00; // a
        } else {
            inputs [0] = 1.00;
        }

        randomVal = Math.random() * 100;

        if (randomVal >= 50  && randomVal < 100) {
            inputs[1] = 0.00;
        } else {
            inputs[1] = 1.00;
        }
    }

    /**
     * Basic info about the data point
     * @return string represnting the data point
     */
    public String toString() {
        String toReturn = "";
        if (inputs[0] > 0.00) {
            toReturn += "1 and";
        } else {
            toReturn += "0 and";
        }

        if (inputs[1] > 0.00) {
            toReturn += " 1 is ";
        } else {
            toReturn += " 0 is ";
        }

        if (expectedOutput > 0.00) {
            toReturn += "1.";
        } else {
            toReturn += "0.";
        }

        return toReturn;
    }


    public double getExpectedOutput() {
        return expectedOutput;
    }

    public double[] getInputs() {
        return inputs;
    }

    public int getTotalNumberOfInputs() {
        return totalNumberOfInputs;
    }
    
    public void setError(double error) {
        this.error = error;
    }
}
