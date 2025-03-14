package test;

import java.util.function.Predicate;

import neuralNetwork.Preceptron;
import supervisedLearning.LearningDataPoint;

public class test {
    
    public static void main(String[] args) {

        // for (int i = 0; i < 100; i++) {
        //    LearningDataPoint l = new LearningDataPoint();
        //    System.out.println(l);
        // }

        Preceptron p = new Preceptron();
        p.setInputs(new LearningDataPoint().getInputs());
        p.pulse();
        System.out.println(p);
    }
}
