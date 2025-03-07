public class Preceptron {
 
    double[] weights = new double[2];
    float learningRate = 0.1f;

    public Preceptron() {
        for (int i = 0; i < weights.length; i++) {
            weights[i] = Math.random() * 2 - 1;
            weights[i] = Double.valueOf(String.format("%.2f", weights[i]));
        }
    }

    public double[] getWeights() {
        return weights;
    }

    public void setWeights(double[] weights) {
        this.weights = weights;
    }

    public float getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(float learningRate) {
        this.learningRate = learningRate;
    }
}