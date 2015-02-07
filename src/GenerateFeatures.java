import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class GenerateFeatures{
	
	static int boardWidth = 7;
	static int boardHeight = 6;
		
    public static void main (String[] args) throws FileNotFoundException{
    	
    	Integer[][] board = new Integer[boardWidth][boardHeight];
    	Integer winner = 0;
    	Integer next = 0;
    	
    	int amountOfBoards = 10;
    	int currentBoards = 0;
    	
        Scanner dataFile = new Scanner(new File("trainDataSet.txt"));

        ArrayList<Integer> dataset = new ArrayList<Integer>();

        while(dataFile.hasNextLine()){
            String line = dataFile.nextLine();

            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while(scanner.hasNextInt()){
                dataset.add(scanner.nextInt());
            }
            scanner.close();
        }

        dataFile.close();

        System.out.println(dataset);
        
        int count = 0;
        int currentColumn = 0;
        
        boardloop:
        for (Integer i : dataset){
        	switch (currentColumn){
        		case 0:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 1:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 2:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 3:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 4:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 5:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 6:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 7:
        			winner = i;
        			
        			count = 0;
        	        currentColumn = 0;
        	        
        	        System.out.println();
        	        
        	        for (Integer[] piece : board){
        	        	System.out.println(Arrays.toString(piece));
        	        }
        	        
        	        System.out.println("Winner: " + winner);
        	        
        	        currentBoards++;
        	        if(currentBoards >= amountOfBoards){
        	        	break boardloop;
        	        }
        	}	
        }
        
        /*
        System.out.println();
        
        for (Integer[] i : board){
        	System.out.println(Arrays.toString(i));
        }
        
        System.out.println("Winner: " + winner);
        */
        
        /*
        System.out.println();
        
        rotate(board);
        rotate(board);
        rotate(board);
        
        for (Integer[] i : board){
        	System.out.println(Arrays.toString(i));
        }
        */
        
        //System.out.println(Arrays.deepToString(board));
    }
    
    private static int[][] rotate( final Integer[][] array ) {
        final int[][] res = new int[array[0].length][array.length];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[0].length; y++) {
                res[(res.length-1)-y][x] = array[x][y];
            }
        }
        return res;
    }
    
}