import java.io.*;

/**
 * Class Name: Game
 * 
 * This class is used to create the board and the referee as well as implementing the game-play of tic-tac-toe.
 * 
 * The board is constructed and the players/referee are determined by interacting with the user.
 * 
 * 
 * @author Calvin Giese (Copied from d2l) 
 * @version version 1.0
 * @since September 22, 2021
 *
 */

public class Game implements Constants {

	/**
	 * This is the board where the game will be played on
	 */
	private Board theBoard;
	
	/**
	 * This is the referee for the game
	 */
	private Referee theRef;
	
	/**
	 * Constructor calls for a new board to be built
	 */
    public Game( ) {
        theBoard  = new Board();
	}
    
    /**
     * 
     * This method assigns the referee to the values passed and begins/runs the game
     * 
     * @param r is the referee for the game
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
    	theRef.runTheGame();
    }
	
	public static void main(String[] args) throws IOException {
		Referee theRef;
		Player xPlayer, oPlayer;
		BufferedReader stdin;
		Game theGame = new Game();
		stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("\nPlease enter the name of the \'X\' player: ");
		String name= stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}

		xPlayer = new Player(name, LETTER_X);
		xPlayer.setBoard(theGame.theBoard);
		
		System.out.print("\nPlease enter the name of the \'O\' player: ");
		name = stdin.readLine();
		while (name == null) {
			System.out.print("Please try again: ");
			name = stdin.readLine();
		}
		
		oPlayer = new Player(name, LETTER_O);
		oPlayer.setBoard(theGame.theBoard);
		
		theRef = new Referee();
		theRef.setBoard(theGame.theBoard);
		theRef.setoPlayer(oPlayer);
		theRef.setxPlayer(xPlayer);
        
        theGame.appointReferee(theRef);
	}
	

}