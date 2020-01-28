package a1;
/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author Danielle Reid & Andrew Troake
 */

public class Board {

    private char[][] board = new char[3][3];

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct an empty board (contains all space char's).
     */
    public Board() {
        /*
         * TBD
         */
    	for(int i = 0 ; i < 3 ; i++) {
    		for(int j = 0 ; j < 3 ; j++) {
    			this.board[i][j] = ' ';
    		}
    	}
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
        /*
         * TBD
         */
    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() {
        /*
         * TBD
         */
    	String returnString = "-------------\n";
    	for(int i = 0 ; i < 3 ; i++) {
    		returnString += "|";
    		for(int j = 0 ; j < 3 ; j++) {
    			returnString += " " + board[i][j] + " |";
    		}
    		returnString += "\n";
    	}
    	returnString += "-------------\n";
    	return returnString;
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        /*
         * TBD
         */
    	if(i >= 0 && i <= 2) {
    		if(j >= 0 && j <= 2) {
    			return this.board[i][j];
    		}
    	}
    	return ' ';
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        /*
         * TBD
         */
    	for(int i = 0 ; i < 3 ; i++) {
    		for(int j = 0 ; j < 3 ; j++) {
    			if(this.board[i][j] == ' ')
    				return false;
    		}
    	}
    	return true;
    }
    
    /**
     * Set the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public boolean set(int i, int j, char c) {
    	if(i >= 0 && i <= 2) {
    		if(j >= 0 && j <= 2) {
    	    	this.board[i][j] = c;
    	    	return true;
    		}
    	}
    	return false;
    }
    
    public boolean set(Move m) {
    	if(m.getI() >= 0 && m.getI() <= 2) {
    		if(m.getJ() >= 0 && m.getJ() <= 2) {
    	    	this.board[m.getI()][m.getJ()] = m.getPiece();
    	    	return true;
    		}
    	}
    	return false;
    }
}
