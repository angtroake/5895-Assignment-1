package a1;
/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author Danielle Reid & Andrew Troake
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private boolean playerIsX;

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
    	this.playerIsX = playerIsX;
    	this.status = GameStatus.IN_PROGRESS;
    	this.ai = challenging ? new SmartAI(!playerIsX) : new DumbAI(!playerIsX);
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
    	return this.board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
    	return this.status;
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) {
    	if(this.board.get(i, j) != ' ') {
    		return this.board.set(i, j, playerIsX ? 'X' : 'O');
    	}
    	return false;
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
    	Move move = ai.chooseMove(this.board);
    	this.board.set(move);
    }
}
