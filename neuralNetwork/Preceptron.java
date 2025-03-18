package neuralNetwork;
import math.ActivationFunctions;

public class Preceptron {

    //
    //input 1--->---(bias)--------|
    //input 2--->---(weight2)-----(preceptron)---->----output
    //input 3--->---(weight3)-----|
    //

    
    // Instance variables
    protected int NumOfInputs;
    protected double[] inputs;
    protected double[] weights;
    protected boolean hasOutput;
    protected double output;
    protected double weightedSum;
    protected double learningRate;
    protected double bias;

    /**
     * Constructor for the Preceptron class
     * Initializes the weights with random values between -1 and 1
     * @param NumOfInputs Number of inputs to the preceptron
     * @return Preceptron object
     */
    public Preceptron() {
        
        this.weightedSum = 0;
        this.output = -99.99;
        this.hasOutput = false;
        this.NumOfInputs = 2;
        this.bias = -1.00;
        this.learningRate = 0.01;

        
        // Initialize the inputs & weights randomly
        inputs = new double[NumOfInputs];
        weights = new double[NumOfInputs];
        for (int i = 0; i < NumOfInputs ; i++) {
            inputs[i] = Math.random() * 2 - 1;
            if (inputs[i] > 0.99) {
                inputs[i] = 1.00;
            }
            inputs[i] = Double.valueOf(String.format("%.2f", inputs[i]));
            
            weights[i] = Math.random() * 2 - 1;
            if (weights[i] > 0.99) {
                weights[i] = 1.00;
            }
            weights[i] = Double.valueOf(String.format("%.2f", weights[i]));
        }
    }

    /**
     * Activation Function
     * takes in the input, calulates the weighted sum,
     */
    public void pulse() {

        //compute the sum of the inputs
        double sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += inputs[i] * weights[i];
            sum += bias;
        }
        this.weightedSum = sum;

        // pass through a activation function
        this.output = ActivationFunctions.rubait(weightedSum);
        hasOutput = true;
    }







    // Getters and Setters
    public double[] getInputs() {
        return inputs;
    }

    public void setInputs(double[] inputs) {
        this.inputs = inputs;
        this.NumOfInputs = inputs.length;
        hasOutput = false;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        if (weights.length != NumOfInputs) {
            throw new IllegalArgumentException("Number of weights must be equal to the number of inputs");
        }
        this.weights = weights;
    }

    public double getOutput() {
        return output;
    }

    public double getWeightedSum() {
        return weightedSum;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }

    public int getNumOfInputs() {
        return NumOfInputs;
    }

    @Override
    public String toString() {
        String toReturn = "";
        toReturn += inputs[0] +" and " + inputs[1];
        if (hasOutput) {
            toReturn += " is ";
            toReturn += output;
        }
        return toReturn;
    }
}