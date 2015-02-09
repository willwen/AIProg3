import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;

public class GenerateFeatures {

	static int boardWidth = 7;
	static int boardHeight = 6;
	static final int PLAYER1 = 1;
	static final int PLAYER2 = 2;

	public static void main(String[] args) throws IOException {

		Integer[][] board = new Integer[boardWidth][boardHeight];
		Integer winner = 0;
		FileWriter writer = new FileWriter("output.csv");

		writer.append("f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39,f40,f41,f42");
		writer.append(',');
		writer.append("Most3rdRow");
		writer.append(',');
		writer.append("MostMiddleColumns");
		writer.append(',');
		writer.append("TopMostOfColumns");
		writer.append(',');
		writer.append("FirstMove");
		writer.append(',');
		writer.append("HighestAdjacency");
		writer.append(',');
		writer.append("Winner");
		writer.append('\n');

		int amountOfBoards = 1000;
		int currentBoards = 0;

		// Scanner dataFile = new Scanner(new File("trainDataSet.txt"));
		Scanner dataFile = new Scanner(new File(args[0]));

		ArrayList<Integer> dataset = new ArrayList<Integer>();

		while (dataFile.hasNextLine()) {
			String line = dataFile.nextLine();

			Scanner scanner = new Scanner(line);
			scanner.useDelimiter(",");
			while (scanner.hasNextInt()) {
				dataset.add(scanner.nextInt());
			}
			scanner.close();
		}

		dataFile.close();

		System.out.println(dataset);

		int count = 0;
		int currentColumn = 0;

		boardloop: for (Integer i : dataset) {

			switch (currentColumn) {
			case 0:
				if (count < 6) {
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
				if (count < 6) {
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
				if (count < 6) {
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
				if (count < 6) {
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
				if (count < 6) {
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
				if (count < 6) {
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
				if (count < 6) {
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

				for (Integer[] piece : board) {
					System.out.println(Arrays.toString(piece));
				}

				Integer most3rdRow = mostPiecesIn3rdRow(board);
				Integer mostMiddleColumn = mostPiecesInMiddle(board);
				Integer countTopMost = countTopMost(board);
				Integer firstPlayer = firstMove();
				Integer higherAdjacency = adjacentMoreThanThree(board);

				System.out.println("Player with most pieces in 3rd row: "
						+ most3rdRow);

				writer.write(most3rdRow.toString());
				writer.append(',');

				System.out
						.println("Player with most pieces in the middle (+/- 1) row(s): "
								+ mostMiddleColumn);

				writer.write(mostMiddleColumn.toString());
				writer.append(',');

				System.out
						.println("Player with most pieces on top in all the columns: "
								+ countTopMost);

				writer.write(countTopMost.toString());
				writer.append(',');

				System.out.println("Player who went First: " + firstPlayer);

				writer.write(firstPlayer.toString());
				writer.append(',');

				System.out.println("Player who has higher adjacency: " + higherAdjacency);

				writer.write(higherAdjacency.toString());
				writer.append(',');
				
				System.out.println("Winner: " + winner);

				writer.write(winner.toString());
				writer.append('\n');

				currentBoards++;
				if (currentBoards >= amountOfBoards) {
					break boardloop;
				}
			}

		}

		writer.flush();
		writer.close();
	}

	// Returns an Integer for the player with the most tokens in the middle row
	// {1,2}, if tie between 1 & 2, return 0
	private static Integer mostPiecesIn3rdRow(Integer[][] board) {
		Integer most = 0;

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < 7; i++) {
			if (board[i][2] == 1) {
				count1++;
			} else if (board[i][2] == 2) {
				count2++;
			}
		}

		if (count1 > count2) {
			most = 1;
		} else if (count1 < count2) {
			most = 2;
		} else {
			most = 0;
		}

		return most;
	}

	// Returns an Integer for the player with the most tokens in the 1 {or 3 if
	// tied} middle columns of the board
	private static Integer mostPiecesInMiddle(Integer[][] board) {
		Integer most = 0;

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < 6; i++) {
			if (board[3][i] == 1) {
				count1++;
			} else if (board[3][i] == 2) {
				count2++;
			}
		}

		if (count1 > count2) {
			most = 1;
		} else if (count1 < count2) {
			most = 2;
		} else {
			for (int i = 0; i < 6; i++) {
				if (board[2][i] == 1) {
					count1++;
				} else if (board[2][i] == 2) {
					count2++;
				}
			}
			for (int i = 0; i < 6; i++) {
				if (board[4][i] == 1) {
					count1++;
				} else if (board[4][i] == 2) {
					count2++;
				}
			}
		}

		if (count1 > count2) {
			most = 1;
		} else if (count1 < count2) {
			most = 2;
		} else {
			most = 0;
		}

		return most;
	}

	/**
	 * feature num 1, determines who went first given a winning board state. if
	 * the number of pieces are odd, then whoever got the connect four went
	 * first if the number of pieces are even, then whoever got the connect four
	 * went second
	 * 
	 * EDIT: changed so that assuming player1 always went first.
	 * 
	 * @return playerNum of who went first
	 */
	public static int firstMove() {
		// int counter = 0;
		// for (int i = 0; i < this.height; i++)
		// for (int j = 0; j < this.width; i++)
		// if (board[i][j] == 1 || board[i][j] == 2)
		// counter++;
		// if (counter % 2 == 0) {
		// if (this.isConnectN() == 1)
		// return 2;
		// else
		// return 1;
		// } else {// odd number of pieces played
		// this.isConnectN();
		// }
		//
		// return 0;
		return PLAYER1;
	}

	/**
	 * Feature # 4 counts the number of pieces that are on the top most of every
	 * column. returns the id of the player who has the most pieces on top of
	 * all the column
	 * 
	 * @return player id, either 1 or 2
	 * 
	 *         in case of tie, returns 0 and prints out "its a tie".
	 */
	public static int countTopMost(Integer board[][]) {
		int player1Count = 0;
		int player2Count = 0;
		for (int j = 0; j < boardWidth; j++) {
			for (int i = boardHeight - 1; i >= 0; i--) {
				if (board[j][i] == 1) {
					player1Count++;
					break;
				} else if (board[j][i] == 2) {
					player2Count++;
					break;
				}
			}
		}
		if (player1Count > player2Count) {
			return PLAYER1;
		}

		else if (player2Count > player1Count) {

			return PLAYER2;
		} else { // equal
			System.out.println("equal number on topmost rows");
			return 0;
		}

	}
	
	/**
	 * Feature #5
	 *  
	 * @param board the active game board.
	 * @return the player ID with the most number of pieces that have adjacency >= 2
	 */
	public static int adjacentMoreThanThree(Integer board[][]) {
		int player1Counter = 0;
		int player2Counter = 0;
		for (int i = 0; i < boardWidth; i++) {
			for (int j = 0; j < boardHeight; j++) {
				if (board[i][j] != 0
						&& surroundingPoints(i, j, board[i][j], board) >= 2) {
					if (board[i][j] == 1) {
						player1Counter++;
					} else if (board[i][j] == 2) {
						player2Counter++;
					}

				}
			}
		}
		if (player1Counter > player2Counter) {
			return PLAYER1;

		}

		else if (player1Counter < player2Counter) {
			return PLAYER2;
		}

		else {
			System.out.println("equal");
			return 0;
		}

	}

	/**
	 * returns the number of surrounding friendly points
	 * 
	 * @param x
	 *            of point to look adjacent
	 * @param y
	 *            of point to look adjacent
	 * @return 
	 * 
	 * x max is 7-1
	 * y max is 6-1
	 */
	public static int surroundingPoints(int x, int y, int playerNum,
			Integer board[][]) {
		int surrounding = 0;
		if (x == 0) {
			if (y == 0) {
				if (board[x + 1][y + 1] == playerNum)
					surrounding++;
				if (board[x][y + 1] == playerNum)
					surrounding++;
				if (board[x + 1][y] == playerNum)
					surrounding++;

				return surrounding;
			}

			else if (y == boardHeight - 1) {
				if (board[x + 1][y - 1] == playerNum)
					surrounding++;
				if (board[x][y - 1] == playerNum)
					surrounding++;
				if (board[x + 1][y] == playerNum)
					surrounding++;
				return surrounding;
			}

			else {
				if(y != boardHeight-1){
					if (board[x + 1][y + 1] == playerNum)
						surrounding++;
					if (board[x][y + 1] == playerNum)
						surrounding++;
				}
				if (board[x + 1][y] == playerNum)
					surrounding++;
				if (board[x][y - 1] == playerNum)
					surrounding++;
				if (board[x + 1][y - 1] == playerNum)
					surrounding++;
				return surrounding;
			}
		} else { // height isnt the lowest level
			if (y == 0) {
				if (x != boardWidth - 1) {
					if (board[x + 1][y + 1] == playerNum)
						surrounding++;
					if (board[x + 1][y] == playerNum)
						surrounding++;
				}
				if (board[x][y + 1] == playerNum)
					surrounding++;
				if (board[x - 1][y] == playerNum)
					surrounding++;
				if (board[x - 1][y + 1] == playerNum)
					surrounding++;
				return surrounding;
			}

			else if (y == boardHeight - 1) {
				if (x != boardWidth - 1) {
					if (board[x + 1][y - 1] == playerNum)
						surrounding++;
					if (board[x + 1][y] == playerNum)
						surrounding++;
				}
				if (board[x][y - 1] == playerNum)
					surrounding++;

				if (board[x - 1][y] == playerNum)
					surrounding++;
				if (board[x - 1][y - 1] == playerNum)
					surrounding++;
				return surrounding;
			}

			else {
				if (x != boardWidth - 1) {
					if (board[x + 1][y] == playerNum)
						surrounding++;
					if (board[x][y + 1] == playerNum)
						surrounding++;
					if (board[x][y - 1] == playerNum)
						surrounding++;
					if (board[x + 1][y + 1] == playerNum)
						surrounding++;
					if (board[x + 1][y - 1] == playerNum)
						surrounding++;
					if (board[x - 1][y - 1] == playerNum)
						surrounding++;
					if (board[x - 1][y + 1] == playerNum)
						surrounding++;
					if (board[x - 1][y] == playerNum)
						surrounding++;
					return surrounding;
				} else {
					if (board[x][y + 1] == playerNum)
						surrounding++;
					if (board[x][y - 1] == playerNum)
						surrounding++;
					if (board[x - 1][y - 1] == playerNum)
						surrounding++;
					if (board[x - 1][y + 1] == playerNum)
						surrounding++;
					if (board[x - 1][y] == playerNum)
						surrounding++;
					return surrounding;
				}

			}
		}
	}

}