import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;

public class GenerateFeatures{
	
	static int boardWidth = 7;
	static int boardHeight = 6;
		
    public static void main (String[] args) throws IOException{
    	
    	Integer[][] board = new Integer[boardWidth][boardHeight];
    	Integer winner = 0;
    	FileWriter writer = new FileWriter("output.csv");
    	
    	
		writer.append("f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39,f40,f41,f42");
		writer.append(',');
		writer.append("Most3rdRow");
		writer.append(',');
		writer.append("MostMiddleColumns");
		writer.append(',');
		
		writer.append("Winner");
		writer.append(',');
		writer.append('\n');
	
    	
    	int amountOfBoards = 1000;
    	int currentBoards = 0;
    	
        Scanner dataFile = new Scanner(new File("trainDataSet.txt"));
    	//Scanner dataFile = new Scanner(new File(args[0]));

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
                		              		
						writer.append(board[currentColumn][count].toString());
						writer.append(',');
            			
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 1:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		
                		writer.append(board[currentColumn][count].toString());
						writer.append(',');
                		
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 2:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		
                		writer.write(i.toString());
						writer.append(',');
                		
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 3:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		
                		writer.write(i.toString());
						writer.append(',');
                		
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 4:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		
                		writer.write(i.toString());
						writer.append(',');
                		
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 5:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		
                		writer.write(i.toString());
						writer.append(',');
                		
                		count++;
                		break;
                	} else {
                		count = 0;
                		currentColumn++;
                	}
        		case 6:
        			if(count < 6){
                		board[currentColumn][count] = i;
                		
                		writer.write(i.toString());
						writer.append(',');
                		
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
        	        
        	        Integer most3rdRow = mostPiecesIn3rdRow(board);
        	        Integer mostMiddleColumn = mostPiecesInMiddle(board);
        	        
        	        System.out.println("Player with most pieces in 3rd row: " + most3rdRow);
        	        
					writer.write(most3rdRow.toString());
					writer.append(',');
        	        
        	        System.out.println("Player with most pieces in the middle (+/- 1) row(s): " + mostMiddleColumn);
        	        
        	        writer.write(mostMiddleColumn.toString());
					writer.append(',');
        	        
        	        System.out.println("Winner: " + winner);
        	        
        	        writer.write(winner.toString());
					writer.append(',');
					writer.append('\n');
        	        
        	        currentBoards++;
        	        if(currentBoards >= amountOfBoards){
        	        	break boardloop;
        	        }
        	}
        	        	
        }
        
        writer.flush();
        	writer.close();
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
    
}