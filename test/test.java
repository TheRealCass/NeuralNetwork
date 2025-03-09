package test;

import neuralNetwork.Preceptron;
import neuralNetwork.supervisedLearning.Trainer;
import neuralNetwork.supervisedLearning.data.ActivationMap;

public class test {
    public static void main(String[] args) {
        //preceptronTest();
        //activationMapTest();
        trainer();
    }

    private static void trainer () {
        Preceptron p = new Preceptron(2);
        Trainer t = new Trainer(p);
        t.train();
    }
    

    private static void activationMapTest() {
        System.out.println("Testing Activation Map class");
        ActivationMap map = new ActivationMap("./assets/traningData.txt");
        System.out.println(map.toString());
        double label = map.calculateLabel(4,8);
        System.out.println(label);

    }

    private static void preceptronTest() {
        System.out.println("Testing Preceptron class");
        //test1();
        //test2();
        //test3();
        System.out.println();

    }

    private static void test1() {
        Preceptron testPreceptron = new Preceptron(7);
        double[] preceptronInputs = testPreceptron.getInputs();
        double[] preceptronWeights = testPreceptron.getWeights();
        for (int i = 0; i < preceptronInputs.length; i++) {
            int humanReadableIndex = i + 1;
            String toPrint = "Input " + humanReadableIndex + ": " + preceptronInputs[i];
            toPrint += " has a weight of " + preceptronWeights[i];
            System.out.println(toPrint);
        }
        System.out.print("Test 1: Randomisazion----> ");
        System.out.println("Passed");
    }

    private static void test2() {
        System.out.print("Test 2: Activation Functions----> ");
        boolean passed = false;
        
        Preceptron testPreceptron = new Preceptron(4);
        testPreceptron.pulse();
        double output = testPreceptron.getOutput();
        if (output >= -1 && output <= 1) {
            passed = true;
        }
        System.out.println(passed ? "Passed" : "Failed");

    }
}
