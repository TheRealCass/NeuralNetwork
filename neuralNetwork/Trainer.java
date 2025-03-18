package neuralNetwork;

import supervisedLearning.LearningDataPoint;

public class Trainer {
    
    Preceptron preceptron;

    public Trainer (Preceptron toTrain) {

        preceptron = toTrain;
    }

    public void train(LearningDataPoint corrDataPoint) {

        double error = findError(corrDataPoint);
        double[] inputs = preceptron.getInputs();
        double[] weights = preceptron.getWeights();
        double learningRate = preceptron.getLearningRate();

        for (int i = 0; i < weights.length; i++) {
            weights[i] += inputs[i] * error * learningRate;
        }
        preceptron.setWeights(weights);
    }

    private double findError(LearningDataPoint corrDataPoint) {
        double[] input = corrDataPoint.getInputs();
        preceptron.setInputs(input);
        preceptron.pulse();
        double output = preceptron.getOutput();
        double error = corrDataPoint.getExpectedOutput() - output;
        corrDataPoint.setError(error);
        return error;
    }
}