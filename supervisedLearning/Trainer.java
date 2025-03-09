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
            System.out.println(points[i].toString());
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
        
        visualisePonts();
    }

    private void visualisePonts() {
         
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
        for (int i = 0; i < points.length; i++) {
            double xCoordinate = points[i].getX();
            double yCoordinate = points[i].getY();
            double[] preceptronInputs = {xCoordinate, yCoordinate};
            
            preceptron.setInputs(preceptronInputs);
            preceptron.pulse();
            
            double guess = preceptron.getOutput();
            
        }
        
    }

    
    
    
    
    
    
    
    
    
    
    
    

    
    
}
