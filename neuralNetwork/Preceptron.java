package neuralNetwork;
import math.ActivationFunctions;

public class Preceptron {

    //
    //input 1--->---(weight1)-----|
    //input 2--->---(weight2)-----(preceptron)---->----output
    //input 3--->---(weight3)-----|
    //

    //constants
    private static final String PREFERED_ACTIVATION_FUNC = "sigh";
    
    // Instance variables
    private int NumOfInputs;
    private double[] inputs;
    private double[] weights;
    private double output;
    private double weightedSum;
    private float learningRate = 0.1f;

    /**
     * Constructor for the Preceptron class
     * Initializes the weights with random values between -1 and 1
     * @param NumOfInputs Number of inputs to the preceptron
     * @return Preceptron object
     */
    public Preceptron(int NumOfInputs) {
        
        weightedSum = 0;
        output = 0;
        
        // Initialize the inputs & weights randomly
        this.NumOfInputs = NumOfInputs;
        inputs = new double[this.NumOfInputs];
        weights = new double[this.NumOfInputs];
        for (int i = 0; i < this.NumOfInputs ; i++) {
            inputs[i] = Math.random() * 2 - 1;
            inputs[i] = Double.valueOf(String.format("%.2f", inputs[i]));
            
            weights[i] = Math.random() * 2 - 1;
            weights[i] = Double.valueOf(String.format("%.2f", weights[i]));
        }
    }

    public void activate() {

        //compute the sum of the inputs
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }
        this.weightedSum = sum;

        // pass through a activation function
        this.output = ActivationFunctions.activate(weightedSum, PREFERED_ACTIVATION_FUNC);
    }







    // Getters and Setters
    public double[] getInputs() {
        return inputs;
    }

    public void setInputs(double[] inputs) {
        this.inputs = inputs;
        this.NumOfInputs = inputs.length;
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

    public float getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }
}