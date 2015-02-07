import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateFeatures{
	
	static int boardHeight = 6;
	static int boardWidth = 7;
	
    public static void main (String[] args) throws FileNotFoundException{

    	int count = 0;
    	
        Scanner dataFile = new Scanner(new File("trainDataSet.txt"));

        ArrayList<Integer> dataset = new ArrayList<Integer>();

        while(dataFile.hasNextLine()){
            String line = dataFile.nextLine();

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while(scanner.hasNextInt()){
            	if(count < 6){
            		dataset.add(scanner.nextInt());
            	} else {
            		
            	}
                
            }
            scanner.close();
        }

        dataFile.close();

        System.out.println(dataset);
    }
}