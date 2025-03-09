package supervisedLearning;

import data.TraningDataPoint;
import neuralNetwork.Preceptron;

public class Trainer {

    Preceptron preceptron;
    TraningDataPoint[] points;
    String[][] graph;    
    ActivationMap map;
    
    public Trainer(Preceptron preceptron, String pathToActivationMap, int NumberOfTraningData){

        this.preceptron = preceptron;
        this.points = new TraningDataPoint[NumberOfTraningData];

        //load activation map
        map = new ActivationMap(pathToActivationMap);
        for (int i = 0; i < points.length; i++) {
            points[i] = new TraningDataPoint(map);
        }

        //initialise graph dimention based on activation map
        int lengthX = map.getLengthOfXAxis();
        int lengthY = map.getLengthOfYAxis();
        graph = new String[lengthX][lengthY];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                graph[i][j] = "*";
            }
        }
        
        visualiseMap();
    }

    private void visualiseMap() {
         
        //plot traning data on grid
        for (int i = 0; i < points.length; i++) {
            int x = (int)points[i].getX();
            int y = (int)points[i].getY();
            if(points[i].getTarget() > 0.00) {
                graph[x][y] = "#";
            } else if (points[i].getTarget() < 0.00) {
                graph[x][y] = "$";
            }
        }

        //display grid
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }


    }

    public void train() {
        findError();
        

        //update weights based on the errors
        double[] weight = preceptron.getWeights();
        double[] input = preceptron.getInputs();
        for (int j = 0; j < weight.length; j++) {
            weight[j] += input[j] * points[j].getError() * preceptron.getLearningRate() +1 ;
        }
        //preceptron.setWeights(weight);

        
    }

    public void findError() {
        //find error for each data point
        for (int i = 0; i < points.length; i++) {
            double xCoordinate = points[i].getX();
            double yCoordinate = points[i].getY();
            double[] preceptronInputs = {xCoordinate, yCoordinate};
            
            preceptron.setInputs(preceptronInputs);
            preceptron.pulse();
            
            double guess = preceptron.getOutput();
            double target = map.calculateLabel(points[i]);
            double error = target - guess;
            points[i].setError(error);
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    

    
    
}
