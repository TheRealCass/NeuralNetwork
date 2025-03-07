import math.ActivationFunctions;

public class Preceptron {

    //
    //input 1--->---(weight1)-----|
    //input 2--->---(weight2)-----(preceptron)---->----output
    //input 3--->---(weight3)-----|
    //

    // Instance variables
    private double[] inputs;
    private double[] weights;
    private double output;
    
    private float learningRate = 0.1f;

    /**
     * Constructor for the Preceptron class
     * Initializes the weights with random values between -1 and 1
     * @param NumOfInputs Number of inputs to the preceptron
     * @return Preceptron object
     */
    public Preceptron(int NumOfInputs) {
        // Initialize the inputs & weights randomly
        inputs = new double[NumOfInputs];
        weights = new double[NumOfInputs];
        for (int i = 0; i < NumOfInputs ; i++) {
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

        // pass through a activation function
        this.output = ActivationFunctions.activate(sum, "sigh");
    }







    // Getters and Setters
    public double[] getInputs() {
        return inputs;
    }

    public void setInputs(double[] inputs) {
        this.inputs = inputs;
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public double getOutput() {
        return output;
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public float getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }
}