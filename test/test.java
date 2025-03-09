package test;

import data.DataPoint;
import data.TraningDataPoint;
import math.ActivationFunctions;
import neuralNetwork.Preceptron;
import supervisedLearning.ActivationMap;
import supervisedLearning.Trainer;

public class test {
    public static void main(String[] args) {
        //preceptron();
        //activationFunctions();
        //dataPoint();
        activationMap();
    }

    public static void activationMap() {
        System.out.println("Testing ActivationMap class...");
        String path = "./assets/traningData.txt";
        ActivationMap map = new ActivationMap(path);
        System.out.println("Ploting the ActivationMap:");
        System.out.println(map);
        System.out.println("Running others tests...");
        TraningDataPoint dataPoint = new TraningDataPoint(map);
        dataPoint.setX(3.00);
        dataPoint.setY(2.0);
        double label = map.calculateLabel(dataPoint);

        dataPoint.setX(3.00);
        dataPoint.setY(3.0);
        double label1 = map.calculateLabel(dataPoint);

        if (label == 1.00 && label1 ==-1.00) {
           System.out.println("ActivationMap tests PASSED."); 
        }
    }





    public static void dataPoint() {
        System.out.print("Testing DataPoint ---->");

        boolean passed = true;

        // Test DataPoint creation
        DataPoint point1 = new DataPoint(3.0, 4.0);
        if (point1.getX() != 3.0 || point1.getY() != 4.0) {
            passed = false;
            System.out.println(" Failed at creation test.");
        }

        // Test getX method
        if (point1.getX() != 3.0) {
            passed = false;
            System.out.println(" Failed at getX test.");
        }

        // Test getY method
        if (point1.getY() != 4.0) {
            passed = false;
            System.out.println(" Failed at getY test.");
        }

        // Test toString method
        if (!point1.toString().equals("3.0, 4.0")) {
            passed = false;
            System.out.println(" Failed at toString test.");
        }

        if (passed) {
            System.out.println(" Passed.");
        }
    }




    public static void activationFunctions() {
        System.out.print("Testing Activation Function: Rubait ---->");
        boolean passed = false;
        // Test with a positive value
        if(ActivationFunctions.rubait(5.0) == 1.0){
            passed = true;
        }
        // Test with zero
        if(ActivationFunctions.rubait(0.0) == 1.0){
            passed = true;
        }
        if(ActivationFunctions.rubait(-3.0) == -1.0){
            passed = true;
        }

        if(ActivationFunctions.rubait(0.01) == 1.0){
            passed = true;
        }

        if(ActivationFunctions.rubait(-0.01) == -1.0){
            passed = true;
        }
        if(passed){
            System.out.println(" Passed.");
        }

    }

    public static void preceptron() {
        System.out.print("Testing Preceptron ---->");
    
        // Initialize a Preceptron with 3 inputs
        Preceptron preceptron = new Preceptron(2);
    
        // Set some inputs
        double[] testInputs = {0.5, -0.7, 0.2};
        preceptron.setInputs(testInputs);
    
        // Pulse the Preceptron to compute the output
        preceptron.pulse();
        
        // Get the output
        double output = preceptron.getOutput();
    
        // Check if the output is computed (not the initial value)
        boolean passed = output != -99.99;
    
        // Output the result of the test
        if(passed){
            System.out.println(" Passed.");
        } else {
            System.out.println(" Failed.");
        }
    }
}