package supervisedLearning;

import java.io.File;
import java.util.Scanner;

import data.DataPoint;
import data.TraningDataPoint;

public final class ActivationMap {
    int lengthOfYAxis;
    int lengthOfXAxis; 
    double[][] map;
    

    public ActivationMap(String path) {
        try {
            loadMap(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadMap(String path) throws Exception {        
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String[] fistLine = scanner.nextLine().split(" ");
 
        lengthOfYAxis = Integer.parseInt(fistLine[0]);
        lengthOfXAxis = Integer.parseInt(fistLine[1]);

        map = new double[lengthOfXAxis][lengthOfYAxis];
        for (int i = 0; i < lengthOfXAxis; i++) {
            if (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" ");
                
                // error checking
                if (line.length != lengthOfYAxis) {
                    throw new IllegalArgumentException("Line length does not match the expected length of Y axis.");
                }
                
                for (int j = 0; j < lengthOfYAxis; j++) {
                    double value = Double.parseDouble(line[j]);
                    if (value < 1.00) {
                        map[i][j] = -1.00;
                    } else {
                        map[i][j] = 1.00;
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * ToString
     * prints out the Activation Map to the console
     * @return String containing the activation map
     */
    @Override
    public String toString(){
        String toReturn = "";
        for (int i = 0; i < map.length; i++) {
            for(int j = 0; j< map[i].length; j++) {
                int temp = (int)map[i][j];
                if(temp >= 0.00) {
                    toReturn += "#";
                } else if (temp < 0.00) {
                    toReturn += "$";
                }
                toReturn += " ";
            }
            toReturn += "\n";
        }
        return toReturn;
    }

    
    public double calculateLabel(DataPoint point){
        int x = (int)point.getX();
        int y = (int)point.getY();
        
        double label = map[x][y];
        return label;

    }

    public int getLengthOfXAxis() {
        return lengthOfXAxis;
    }

    public int getLengthOfYAxis() {
        return lengthOfYAxis;
    }

    
}
