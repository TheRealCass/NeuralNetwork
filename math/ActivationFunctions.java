package math;

public abstract class ActivationFunctions {    

    /**
     * sin activation function
     * @param input
     * @return value between -1 and 1
     */
    public static double sin(double input) {
        return Math.sin(input);
    }

    /**
     * Rubait's Super Simple(RSS) activation function
     * PS: I am Rubait xD
     * 
     * @param input
     * @return value of -1 or 1
     */
    public static double rubait(double input) {
        double toReturn = 0.00;
        if (input >= 0) {
            toReturn = 1.00;
            return toReturn;
        }
        return toReturn;
    }



    /**
     * Sigmoid activation function
     * @param input
     * @return value between 0 and 1
     */
    public static double sigmoid(double input) {
        return 1 / (1 + Math.exp(-input));
    }

    /**
     * Derivative of the sigmoid function
     * @param input
     * @return value between 0 and 1
     */
    public static double sigmoidDerivative(double input) {
        return input * (1 - input);
    }

    /**
     * Hyperbolic tangent activation function
     * @param input
     * @return value between -1 and 1
     */
    public static double tanh(double input) {
        return Math.tanh(input);
    }

    /**
     * Derivative of the hyperbolic tangent function
     * @param input
     * @return value between -1 and 1
     */
    public static double tanhDerivative(double input) {
        return 1 - (input * input);
    }

    /**
     * Rectified Linear Unit (ReLU) activation function
     * @param input
     * @return value between 0 and input
     */
    public static double relu(double input) {
        return Math.max(0, input);
    }

    /**
     * Derivative of the ReLU function
     * @param input
     * @return value between 0 and 1
     */
    public static double reluDerivative(double input) {
        return input > 0 ? 1 : 0;
    }

    /**
     * Leaky ReLU activation function
     * @param input
     * @return value between 0 and input
     */
    public static double leakyRelu(double input) {
        return Math.max(0.01 * input, input);
    }

    /**
     * Derivative of the Leaky ReLU function
     * @param input
     * @return value between 0 and 1
     */
    public static double leakyReluDerivative(double input) {
        return input > 0 ? 1 : 0.01;
    }

    /**
     * Exponential Linear Unit (ELU) activation function
     * @param input
     * @return value between 0 and input
     */
    public static double elu(double input) {
        return input > 0 ? input : 0.01 * (Math.exp(input) - 1);
    }

    /**
     * Derivative of the ELU function
     * @param input
     * @return value between 0 and 1
     */
    public static double eluDerivative(double input) {
        return input > 0 ? 1 : elu(input) + 0.01;
    }
}
