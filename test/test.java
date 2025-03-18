package test;


import neuralNetwork.Preceptron;
import neuralNetwork.Trainer;
import supervisedLearning.LearningDataPoint;

public class test {
    
    public static void main(String[] args) {
        //int itterations = 10000000;
        int itterations = 1000;
        Preceptron preceptron = train(itterations);
        printOutro(itterations, preceptron);
        
    }

    public static Preceptron train(int itterations) {
        Preceptron p = new Preceptron();
        Trainer t = new Trainer(p);
        for (int i = 0; i <= itterations; i++) {
            LearningDataPoint dataPoint = new LearningDataPoint();
            t.train(dataPoint);

            if (i == itterations) {
                double[] temp = p.getWeights();
                System.out.println("Final Weight are...");
                for (int j = 0; j < temp.length; j++) {
                    System.out.print("w[" + j + "] = " + temp[j] + ", ");
                }
                System.out.println();
            }

        }
        return p;
    }

    public static void printOutro(int itterations, Preceptron p) {

        System.out.println("Trained over " + itterations + " points.");
        double[] afterTrainTestInput0 = {1.00, 1.00};
        p.setInputs(afterTrainTestInput0);
        p.pulse();
        System.out.println(p);

        double[] afterTrainTestInput1 = {0.00, 1.00};
        p.setInputs(afterTrainTestInput1);
        p.pulse();
        System.out.println(p);

        double[] afterTrainTestInput2 = {1.00, 0.00};
        p.setInputs(afterTrainTestInput2);
        p.pulse();
        System.out.println(p);

        double[] afterTrainTestInput3 = {0.00, 0.00};
        p.setInputs(afterTrainTestInput3);
        p.pulse();
        System.out.println(p);
    }
        
}
