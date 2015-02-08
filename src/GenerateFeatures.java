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
    	
    	int amountOfBoards = 1000;
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
        	        
        	        System.out.println("Player with most pieces in 3rd row: " + mostPiecesIn3rdRow(board));
        	        System.out.println("Player with most pieces in the middle (+/- 1) row(s): " + mostPiecesInMiddle(board));
        	        
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
    
    // Returns an Integer for the player with the most tokens in the middle row {1,2}, if tie between 1 & 2, return 0
    private static Integer mostPiecesIn3rdRow(Integer[][] board){
    	Integer most = 0;
    	
    	int count1 = 0;
    	int count2 = 0;
    	
    	for(int i = 0; i < 7; i++){
    		if(board[i][2] == 1){
    			count1++;
    		} else if(board[i][2] == 2){
    			count2++;
    		}
    	}
    	
    	if(count1 > count2){
    		most = 1;
    	} else if(count1 < count2){
    		most = 2;
    	} else {
    		most = 0;
    	}
    	
    	return most;
    }
    
 // Returns an Integer for the player with the most tokens in the 1 {or 3 if tied} middle columns of the board
    private static Integer mostPiecesInMiddle(Integer[][] board){
    	Integer most = 0;
    	
    	int count1 = 0;
    	int count2 = 0;
    	
    	for(int i = 0; i < 6; i++){
    		if(board[3][i] == 1){
    			count1++;
    		} else if(board[3][i] == 2){
    			count2++;
    		}
    	}
    	
    	if(count1 > count2){
    		most = 1;
    	} else if(count1 < count2){
    		most = 2;
    	} else {
    		for(int i = 0; i < 6; i++){
        		if(board[2][i] == 1){
        			count1++;
        		} else if(board[2][i] == 2){
        			count2++;
        		}
        	}
    		for(int i = 0; i < 6; i++){
        		if(board[4][i] == 1){
        			count1++;
        		} else if(board[4][i] == 2){
        			count2++;
        		}
        	}
    	}
    	
    	if(count1 > count2){
    		most = 1;
    	} else if(count1 < count2){
    		most = 2;
    	} else {
    		most = 0;
    	}
    	
    	return most;
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