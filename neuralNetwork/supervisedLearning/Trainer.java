package neuralNetwork.supervisedLearning;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import neuralNetwork.Preceptron;
import neuralNetwork.supervisedLearning.data.ActivationMap;
import neuralNetwork.supervisedLearning.data.TraningDataPoint;

public class Trainer {

    Preceptron preceptron;
    double error;
    int maxNumberOfPoint = 20;
    
    TraningDataPoint[] points;
    double[][] inputs;
    
    double[] errors;
    ActivationMap map;
    
    public Trainer(Preceptron preceptron){

        this.preceptron = preceptron;

        //load activation map
        map = new ActivationMap("./assets/traningData.txt");
        int lengthOfXAxis = map.getLengthOfXAxis() -1;
        int lengthOfYAxis = map.getLengthOfYAxis() -1;
        
        //generate x,y point
        points = new TraningDataPoint[maxNumberOfPoint];
        for (int i = 0; i < points.length; i++) {
            points[i] = new TraningDataPoint(randInt(0,lengthOfXAxis), randInt(0,lengthOfYAxis));
            double label = map.calculateLabel(points[i]);
            points[i].setTarget(label);
        }

        // Your code to save the array to a text file
        saveArrayToFile(points, lengthOfXAxis, lengthOfYAxis);

        //initialize errors
        errors = new double[maxNumberOfPoint];

    }

    private double[] findError() {
        inputs = new double[maxNumberOfPoint][2];
        
        for (int i = 0; i < points.length; i++) {
            //get the inputs
            inputs[i][0] = points[i].getX();
            inputs[i][1] = points[i].getY();

            //activate the newron
            preceptron.setInputs(inputs[i]);
            preceptron.pulse();
            
            //calculate error
            errors[i] = points[i].getTarget() - preceptron.getOutput();
            
        }
        return errors;
    }

    public void train() {
        this.errors = findError();
        updateWeights(error);
        
    }

    public void updateWeights(double error) {     
        for (int i = 0; i < errors.length; i++) {
            double[] weights = preceptron.getWeights();
            for (int j = 0; j < weights.length; j++) {
                weights[j] += errors[i] * inputs[i][j] * preceptron.getLearningRate();
            }
            preceptron.setWeights(weights);
            if (i == errors.length - 1) {
                System.out.print("Updated Weights: ");
                System.out.println(weights[0] + ", " + weights[1]);
            }
        }
    }

    
    
    
    
    
    
    
    
    
    
    private double randInt(int min, int max) {
        int toReturn =  (int)(Math.random() * (max - min + 1) + min);
        return toReturn;
    }

    private static void saveArrayToFile(TraningDataPoint[] points, int rows, int cols) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./assets/randomInput.txt"))) {
            writer.write(rows + " " + cols);
            writer.newLine();
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    boolean isPoint = false;
                    for (TraningDataPoint point : points) {
                        if (point.getX() == i && point.getY() == j) {
                            writer.write((int) point.getTarget() + " ");
                            isPoint = true;
                            break;
                        }
                    }
                    if (!isPoint) {
                        writer.write("0 ");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
