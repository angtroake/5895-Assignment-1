package a1;
/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author Danielle Reid & Andrew Troake
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();

    /*
     * TBD: Create additional private members if useful.
     */
    private boolean isX;
    
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
    	this.isX = aiIsX;
    }
    
    /**
     * Chooses a random empty location on the board 
     * 
     * @returns Move object.
     */
    public Move chooseMove(Board board) {
    	Random r = new Random();
    	int i, j;
    	do {
    		i = r.nextInt(3);
        	j = r.nextInt(3);
    	}
    	while(board.get(i, j) != ' ');
    	
    	return new Move(i, j, this.isX ? 'X' : 'O');
    }
}
