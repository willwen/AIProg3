public class Features {
	Integer board[][];
	final int width = 7;
	final int height = 6;
	final int PLAYER1 = 1;
	final int PLAYER2 = 2;
	final int N = 4;
	final int NOCONNECTION = -1;
	final int TIE = 0;

	Features() {
//		board = new Integer[this.height][this.width];
	}

	/**
	 * feature num 1, determines who went first given a winning board state. if
	 * the number of pieces are odd, then whoever got the connect four went
	 * first if the number of pieces are even, then whoever got the connect four
	 * went second
	 * 
	 * @return playerNum of who went first
	 */
	public int firstMove() {
//		int counter = 0;
//		for (int i = 0; i < this.height; i++)
//			for (int j = 0; j < this.width; i++)
//				if (board[i][j] == 1 || board[i][j] == 2)
//					counter++;
//		if (counter % 2 == 0) {
//			if (this.isConnectN() == 1)
//				return 2;
//			else
//				return 1;
//		} else {// odd number of pieces played
//			this.isConnectN();
//		}
//
//		return 0;
		return PLAYER1;
	}
	/**
	 * Feature # 4
	 * counts the number of pieces that are on the top most of every column.
	 * returns the id of the player who has the most pieces on top of all the column
	 * 
	 * @return player id, either 1 or 2
	 * 
	 * in case of tie, returns 0 and prints out "its a tie".
	 */
	public int countTopMost() {
		int player1Count = 0;
		int player2Count = 0;
		for (int j = 0; j < this.height; j++) {
			for (int i = this.width - 1; i >= 0; i--) {
				if (board[j][i] == 1){
					player1Count++;
					break;
				}
				else if (board[j][i] == 2){
					player2Count++;
					break;
				}
			}
		}
		if (player1Count > player2Count){
			return this.PLAYER1;			
		}

		else if (player2Count > player1Count){

			return this.PLAYER2;
		}
		else{ //equal
			System.out.println("equal number on topmost rows");
			return 0;
		}

	}
	
	
	public int adjacentMoreThanThree(){
		int player1Counter = 0;
		int player2Counter = 0;
		for (int i = 0; i < this.height; i++){
			for (int j = 0; j < this.width; j++){
				if(board[i][j] != 0 && surroundingPoints(j, i, board[i][j]) >= 3){
					if( board[i][j] == 1){
						System.out.println(i + " " + j + "counts player1");
						player1Counter++;
					}
					else if (board [i][j] == 2){
						System.out.println(i + " " + j + "counts player2");
						player2Counter++;
					}
					
				}
				System.out.println(surroundingPoints(i, j, board[i][j]) + "surround "+ i +" " + j);
						
			}
		}
		if(player1Counter > player2Counter ){
			debugPrintScores(player1Counter, player2Counter);

			return PLAYER1;
			
		}
			
		else if (player1Counter < player2Counter ){
			debugPrintScores(player1Counter, player2Counter);

			return PLAYER2;
		}

		else{
			System.out.println("equal");
			return 0;
		}
			
		
	}
	/**
	 * returns the number of surrounding friendly points
	 * 
	 * @param height
	 *            of point to look adjacent
	 * @param width
	 *            of point to look adjacent
	 * @return
	 */
	public int surroundingPoints(int height, int width ,int playerNum) {
		int surrounding = 0;
		if (height == 0) {
			if (width == 0) {
				if (board[height + 1][width + 1] == playerNum)
					surrounding++;
				if (board[height][width + 1] == playerNum)
					surrounding++;
				if (board[height + 1][width] == playerNum)
					surrounding++;

				return surrounding;
			}

			else if (width == this.width - 1) {
				if (board[height + 1][width - 1] == playerNum)
					surrounding++;
				if (board[height][width - 1] == playerNum)
					surrounding++;
				if (board[height + 1][width] == playerNum)
					surrounding++;
				return surrounding;
			}

			else {
				if (board[height + 1][width] == playerNum)
					surrounding++;
				if (board[height][width + 1] == playerNum)
					surrounding++;
				if (board[height][width - 1] == playerNum)
					surrounding++;
				if (board[height + 1][width + 1] == playerNum)
					surrounding++;
				if (board[height + 1][width - 1] == playerNum)
					surrounding++;
				return surrounding;
			}
		} else { // height isnt the lowest level
			if (width == 0) {
				if(height != this.height -1){
					if (board[height + 1][width + 1] == playerNum)
						surrounding++;
					if (board[height + 1][width] == playerNum)
						surrounding++;
				}
				if (board[height][width + 1] == playerNum)
					surrounding++;
				if (board[height - 1][width] == playerNum)
					surrounding++;
				if (board[height - 1][width + 1] == playerNum)
					surrounding++;
				return surrounding;
			}

			else if (width == this.width - 1) {
				if(height != this.height -1){
					if (board[height + 1][width - 1] == playerNum)
						surrounding++;
					if (board[height + 1][width] == playerNum)
						surrounding++;
				}
				if (board[height][width - 1] == playerNum)
					surrounding++;

				if (board[height - 1][width] == playerNum)
					surrounding++;
				if (board[height - 1][width - 1] == playerNum)
					surrounding++;
				return surrounding;
			}

			else {
				if (height != this.height - 1) {
					if (board[height + 1][width] == playerNum)
						surrounding++;
					if (board[height][width + 1] == playerNum)
						surrounding++;
					if (board[height][width - 1] == playerNum)
						surrounding++;
					if (board[height + 1][width + 1] == playerNum)
						surrounding++;
					if (board[height + 1][width - 1] == playerNum)
						surrounding++;
					if (board[height - 1][width - 1] == playerNum)
						surrounding++;
					if (board[height - 1][width + 1] == playerNum)
						surrounding++;
					if (board[height - 1][width] == playerNum)
						surrounding++;
					return surrounding;
				} else {
					if (board[height][width + 1] == playerNum)
						surrounding++;
					if (board[height][width - 1] == playerNum)
						surrounding++;
					if (board[height - 1][width - 1] == playerNum)
						surrounding++;
					if (board[height - 1][width + 1] == playerNum)
						surrounding++;
					if (board[height - 1][width] == playerNum)
						surrounding++;
					return surrounding;
				}

			}
		}
	}
	

	/**
	 * Check if one of the players gets N checkers in a row (horizontally,
	 * vertically or diagonally)
	 * 
	 * @return the value of winner. If winner=-1, nobody win and game continues;
	 *         If winner=0/TIE, it's a tie; If winner=1, player1 wins; If
	 *         winner=2, player2 wins. This code is created for cs 4341 AI 2013a
	 *         at WPI. All rights are reserved.
	 * @author lzhu
	 */

	public int isConnectN() {
		int tmp_winner = checkHorizontally();

		if (tmp_winner != this.NOCONNECTION)
			return tmp_winner;

		tmp_winner = checkVertically();
		if (tmp_winner != this.NOCONNECTION)
			return tmp_winner;

		tmp_winner = checkDiagonally1();
		if (tmp_winner != this.NOCONNECTION)
			return tmp_winner;
		tmp_winner = checkDiagonally2();
		if (tmp_winner != this.NOCONNECTION)
			return tmp_winner;

		return this.NOCONNECTION;

	}

	public int checkHorizontally() {
		int max1 = 0;
		int max2 = 0;
		boolean player1_win = false;
		boolean player2_win = false;
		// check each row, horizontally
		for (int i = 0; i < this.height; i++) {
			max1 = 0;
			max2 = 0;
			for (int j = 0; j < this.width; j++) {
				if (board[i][j] == PLAYER1) {
					max1++;
					max2 = 0;
					if (max1 == N)
						player1_win = true;
				} else if (board[i][j] == PLAYER2) {
					max1 = 0;
					max2++;
					if (max2 == N)
						player2_win = true;
				} else {
					max1 = 0;
					max2 = 0;
				}
			}
		}
		if (player1_win && player2_win)
			return this.TIE;
		if (player1_win)
			return this.PLAYER1;
		if (player2_win)
			return this.PLAYER2;

		return this.NOCONNECTION;
	}

	public int checkVertically() {
		// check each column, vertically
		int max1 = 0;
		int max2 = 0;
		boolean player1_win = false;
		boolean player2_win = false;

		for (int j = 0; j < this.width; j++) {
			max1 = 0;
			max2 = 0;
			for (int i = 0; i < this.height; i++) {
				if (board[i][j] == PLAYER1) {
					max1++;
					max2 = 0;
					if (max1 == N)
						player1_win = true;
				} else if (board[i][j] == PLAYER2) {
					max1 = 0;
					max2++;
					if (max2 == N)
						player2_win = true;
				} else {
					max1 = 0;
					max2 = 0;
				}
			}
		}
		if (player1_win && player2_win)
			return this.TIE;
		if (player1_win)
			return this.PLAYER1;
		if (player2_win)
			return this.PLAYER2;

		return this.NOCONNECTION;
	}

	public int checkDiagonally1() {
		// check diagonally y=-x+k
		int max1 = 0;
		int max2 = 0;
		boolean player1_win = false;
		boolean player2_win = false;
		int upper_bound = height - 1 + width - 1 - (N - 1);

		for (int k = N - 1; k <= upper_bound; k++) {
			max1 = 0;
			max2 = 0;
			int x, y;
			if (k < width)
				x = k;
			else
				x = width - 1;
			y = -x + k;

			while (x >= 0 && y < height) {
				// System.out.println("k: "+k+", x: "+x+", y: "+y);
				if (board[height - 1 - y][x] == PLAYER1) {
					max1++;
					max2 = 0;
					if (max1 == N)
						player1_win = true;
				} else if (board[height - 1 - y][x] == PLAYER2) {
					max1 = 0;
					max2++;
					if (max2 == N)
						player2_win = true;
				} else {
					max1 = 0;
					max2 = 0;
				}
				x--;
				y++;
			}

		}
		if (player1_win && player2_win)
			return this.TIE;
		if (player1_win)
			return this.PLAYER1;
		if (player2_win)
			return this.PLAYER2;

		return this.NOCONNECTION;
	}

	public int checkDiagonally2() {
		// check diagonally y=x-k
		int max1 = 0;
		int max2 = 0;
		boolean player1_win = false;
		boolean player2_win = false;
		int upper_bound = width - 1 - (N - 1);
		int lower_bound = -(height - 1 - (N - 1));
		// System.out.println("lower: "+lower_bound+", upper_bound: "+upper_bound);
		for (int k = lower_bound; k <= upper_bound; k++) {
			max1 = 0;
			max2 = 0;
			int x, y;
			if (k >= 0)
				x = k;
			else
				x = 0;
			y = x - k;
			while (x >= 0 && x < width && y < height) {
				// System.out.println("k: "+k+", x: "+x+", y: "+y);
				if (board[height - 1 - y][x] == PLAYER1) {
					max1++;
					max2 = 0;
					if (max1 == N)
						player1_win = true;
				} else if (board[height - 1 - y][x] == PLAYER2) {
					max1 = 0;
					max2++;
					if (max2 == N)
						player2_win = true;
				} else {
					max1 = 0;
					max2 = 0;
				}
				x++;
				y++;
			}

		} // end for y=x-k

		if (player1_win && player2_win)
			return this.TIE;
		if (player1_win)
			return this.PLAYER1;
		if (player2_win)
			return this.PLAYER2;

		return this.NOCONNECTION;
	}
	
	public void debugPrintScores(int x, int y){
		System.out.println("p1: " + x);
		System.out.println("p2: " + y);
		}

}
