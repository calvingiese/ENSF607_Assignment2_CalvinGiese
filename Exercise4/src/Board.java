/**
 * Class Name: Board
 * 
 * This class is used to build a board for the tic-tac-toe game. 
 * 
 * It first constructs the board with spaces to fill the 9 character places, offers the ability to check who if there is a winner,
 * which character won and all of the game board design display items
 * 
 * 
 * @author Calvin Giese (Copied from d2l) 
 * @version version 1.0
 * @since September 22, 2021
 *
 */

public class Board implements Constants {
	
	/**
	 * A 2D array used to identify the characters in each space of the board
	 */
	private char theBoard[][];
	
	/**
	 * A counter to keep track of the number of characters on the board
	 */
	private int markCount;

	/**
	 * Constructs a new game board with the constant value of a space character temporarily filling all places of the board
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		}
	}

	/**
	 * 
	 * This method provides the ability to check what character is currently filling a place on the board
	 * 
	 * @param row is the row to search for on the board
	 * @param col is the column to search for on the board
	 * @return the character value on the board in location row/column
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * 
	 * This method checks to see if the board is full of characters or not
	 * 
	 * @return true if the board is full and false if not
	 */
	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * 
	 * This method is used to check if the character x won or not
	 * 
	 * @return true if x won and false if not
	 */
	public boolean xWins() {
		if (checkWinner(LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * 
	 * This method is used to check if the character o won or not
	 * 
	 * @return true if o won and false if not
	 */
	public boolean oWins() {
		if (checkWinner(LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * This method organizes the board in the correct format to be shown to the player and referee.
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * 
	 * This method replaces the space character with a new character to be added to the game board
	 * 
	 * @param row is the row location to add the character
	 * @param col is the column location to add the character
	 * @param mark is the character to fill in the location determined
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}
	
	/**
	 * This method clears all characters off the game board and replaces with spaces again
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * 
	 * This method iterates through the current condition of the board to see if the supplied character is the winner or not
	 * 
	 * @param mark is the character to check for
	 * @return 1 if the character passed is the winner or not
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * This method builds the game board display for the column headers
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * This method builds a standard amount of hyphens in a string format to use for game board design
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * This method builds a standard amount of spaces in a string format to use for game board design
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}