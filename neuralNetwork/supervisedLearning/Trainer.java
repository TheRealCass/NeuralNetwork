package neuralNetwork.supervisedLearning;

import neuralNetwork.Preceptron;
import neuralNetwork.supervisedLearning.data.ActivationMap;
import neuralNetwork.supervisedLearning.data.TraningDataPoint;

public class Trainer {

    Preceptron preceptron;
    int maxNumberOfPoint = 100000;
    
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

        //initialize errors
        errors = new double[maxNumberOfPoint];

        //initialise inputs
        inputs = new double[maxNumberOfPoint][preceptron.getNumOfInputs()];

    }

    private double[] findError() {
        
        
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
        updateWeights(errors);
        
    }

    public void updateWeights(double[] errors) {     
        double[] weights = preceptron.getWeights();

        for (int i = 0; i < errors.length; i++) {
            
            for (int j = 0; j < weights.length; j++) {
                weights[j] += errors[i] * inputs[i][j] * preceptron.getLearningRate();
            }
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

    
    
}
