package test;

import neuralNetwork.*;

public class test {
    public static void main(String[] args) {
        preceptronTest();
    }

    public static void preceptronTest() {
        System.out.println("Testing Preceptron class");
        System.out.println();
        test1();
        System.out.println();
        test2();
        System.out.println();

    }


    private static void test1() {
        System.out.print("Test 1: Randomisazion ----> ");
        Preceptron testPreceptron = new Preceptron(7);
        double[] preceptronInputs = testPreceptron.getInputs();
        double[] preceptronWeights = testPreceptron.getWeights();
        for (int i = 0; i < preceptronInputs.length; i++) {
            int humanReadableIndex = i + 1;
            String toPrint = "Input " + humanReadableIndex + ": " + preceptronInputs[i];
            toPrint += " has a weight of " + preceptronWeights[i];
            //System.out.println(toPrint);
        }
        System.out.println("Passed");
    }

    private static void test2() {
        System.out.println("Test 2: Activation Functions");
        System.out.print("Test 2.1: Sigh Activation ----> ");
        boolean passed = false;
        
        Preceptron testPreceptron = new Preceptron(4);
        testPreceptron.activate();
        double output = testPreceptron.getOutput();
        if (output >= -1 && output <= 1) {
            passed = true;
        }
        System.out.println(passed ? "Passed" : "Failed");

    }
}
