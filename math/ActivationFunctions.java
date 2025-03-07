package math;

public abstract class ActivationFunctions {
    
    public static double activate(double input, String activationFunction) {
        switch (activationFunction) {
            case "sigmoid":
                return sigmoid(input);
            case "tanh":
                return tanh(input);
            case "relu":
                return relu(input);
            case "leaky_relu":
                return leakyRelu(input);
            case "elu":
                return elu(input);
            default:
                return sigh(input);
        }
    }
    
    /**
     * sigh activation function
     * @param input
     * @return value between -1 and 1
     */
    private static double sigh(double input) {
        double toReturn = 0;
        if (input >= 0) {
            toReturn = 1.00;
        }
        toReturn = -1.00;
        return toReturn;
    }



    /**
     * Sigmoid activation function
     * @param input
     * @return value between 0 and 1
     */
    private static double sigmoid(double input) {
        return 1 / (1 + Math.exp(-input));
    }

    /**
     * Derivative of the sigmoid function
     * @param input
     * @return value between 0 and 1
     */
    private static double sigmoidDerivative(double input) {
        return input * (1 - input);
    }

    /**
     * Hyperbolic tangent activation function
     * @param input
     * @return value between -1 and 1
     */
    private static double tanh(double input) {
        return Math.tanh(input);
    }

    /**
     * Derivative of the hyperbolic tangent function
     * @param input
     * @return value between -1 and 1
     */
    private static double tanhDerivative(double input) {
        return 1 - (input * input);
    }

    /**
     * Rectified Linear Unit (ReLU) activation function
     * @param input
     * @return value between 0 and input
     */
    private static double relu(double input) {
        return Math.max(0, input);
    }

    /**
     * Derivative of the ReLU function
     * @param input
     * @return value between 0 and 1
     */
    private static double reluDerivative(double input) {
        return input > 0 ? 1 : 0;
    }

    /**
     * Leaky ReLU activation function
     * @param input
     * @return value between 0 and input
     */
    private static double leakyRelu(double input) {
        return Math.max(0.01 * input, input);
    }

    /**
     * Derivative of the Leaky ReLU function
     * @param input
     * @return value between 0 and 1
     */
    private static double leakyReluDerivative(double input) {
        return input > 0 ? 1 : 0.01;
    }

    /**
     * Exponential Linear Unit (ELU) activation function
     * @param input
     * @return value between 0 and input
     */
    private static double elu(double input) {
        return input > 0 ? input : 0.01 * (Math.exp(input) - 1);
    }

    /**
     * Derivative of the ELU function
     * @param input
     * @return value between 0 and 1
     */
    private static double eluDerivative(double input) {
        return input > 0 ? 1 : elu(input) + 0.01;
    }
}
