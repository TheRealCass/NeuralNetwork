package test;

import java.util.function.Predicate;

import neuralNetwork.Preceptron;
import neuralNetwork.Trainer;
import supervisedLearning.LearningDataPoint;

public class test {
    
    public static void main(String[] args) {
       train(100000);
        
    }

    public static void train(int itterations) {
        Preceptron p = new Preceptron();
        Trainer t = new Trainer(p);
        for (int i = 0; i <= itterations; i++) {
            LearningDataPoint dataPoint = new LearningDataPoint();
            t.train(dataPoint);

            if (i == itterations) {
                double[] temp = p.getWeights();
                for (int j = 0; j < temp.length; j++) {
                    System.out.print("w[" + j + "] = " + temp[j] + ", ");
                }
                System.out.println();
            }

        }

        System.out.println("Trained over 20 points.\nLets try 1 and 1 and see if we get a 1");
        double[] afterTrainTestInput0 = {1.00, 1.00};
        p.setInputs(afterTrainTestInput0);
        p.pulse();
        System.out.println(p);

        System.out.println("Now Lets try 0 and 1 and see if we get a 0");
        double[] afterTrainTestInput1 = {0.00, 1.00};
        p.setInputs(afterTrainTestInput1);
        p.pulse();
        System.out.println(p);

        System.out.println("Now Lets try 1 and 0 and see if we get a 0");
        double[] afterTrainTestInput2 = {1.00, 0.00};
        p.setInputs(afterTrainTestInput2);
        p.pulse();
        System.out.println(p);

        System.out.println("Now Lets try 0 and 0 and see if we get a 0");
        double[] afterTrainTestInput3 = {0.00, 0.00};
        p.setInputs(afterTrainTestInput3);
        p.pulse();
        System.out.println(p);
    }
}
