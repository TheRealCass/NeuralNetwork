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
    protected double learningRate = 0.01;

    /**
     * Constructor for the Preceptron class
     * Initializes the weights with random values between -1 and 1
     * @param NumOfInputs Number of inputs to the preceptron
     * @return Preceptron object
     */
    public Preceptron(int NumOfInputs) {
        
        weightedSum = 0;
        output = -99.99;
        hasOutput = false;
        
        // Initialize the inputs & weights randomly
        this.NumOfInputs = NumOfInputs;
        inputs = new double[this.NumOfInputs];
        weights = new double[this.NumOfInputs];
        for (int i = 0; i < this.NumOfInputs ; i++) {
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
        String toReturn = "Inputs:\n";
        for (int i = 0; i < inputs.length; i++) {
            toReturn += i + ". ";
            toReturn += inputs[i] + ", " + weights[i] + "\n";
        }
        if (hasOutput) {
            toReturn += "Output:\n";
            toReturn += output;
        }
        return toReturn;
    }
}