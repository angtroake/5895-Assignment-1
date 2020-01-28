package a1;
/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author Danielle Reid & Andrew Troake
 */

import java.util.Scanner;

public class ConsoleRunner {

    /**
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;
    private boolean challenging;
    private GameStatus status;

    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * TBD
         *
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
        playAsX();
        pickAnAI();

        // Creating the game:
        game = new Game(playerIsX, challenging);

        // Initializing the status:
        status = game.getStatus();

        // Printing the board:
        game.getBoard().toString();

        // Starting the game:
        mainLoop();
    }

    // Determining whether the user wants to play as X:
    private void playAsX() {
        System.out.println("Do you want to play as X (Y/N):");
        String beX = scanner.nextLine();
        playerIsX = beX.contains("Y") ? true : false;
    }

    // Determining whether to use DumbAI or SmartAI:
    private void pickAnAI() {
        System.out.println("Do you want a challenge (Y/N):");
        String challenge = scanner.nextLine();
        challenging = challenge.contains("Y") ? true : false;
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        /*
         * TBD
         *
         * Use the 'nextInt' method of Scanner class to read user responses as
         * integers.
         *
         * There is enough work to do here that you may want to introduce
         * private methods (i.e. helper methods).
         */

         while (status == GameStatus.IN_PROGRESS) {
             if (playerIsX) {
                 // Player moves first:
                 playerMove();
                 game.checkWin();
                 if (!checkStatus()) { break; }

                 // Then AI moves:
                 AIMove();
                 game.checkWin();
                 if (!checkStatus()) { break; }
             } else {
                 // AI moves first:
                 AIMove();
                 game.checkWin();
                 if (!checkStatus()) { break; }

                // Then player moves:
                playerMove();
                game.checkWin();
                if (!checkStatus()) { break; }
             }
         }

         // Determining the result:
         if (status == GameStatus.X_WON) {
            if (playerIsX) {
                System.out.println("You won!");
            } else {
                System.out.println("You lost!");
            }
         } else if (status == GameStatus.O_WON) {
            if (playerIsX) {
                System.out.println("You lost!");
            } else {
                System.out.println("You won!");
            }
        } else if (status == GameStatus.DRAW) {
             System.out.println("It's a draw!");
         }

         return;
    }

    // Determines the player's move:
    private void playerMove() {
        // Get the x-coordinate:
        System.out.println("Enter desired x-coordinate:");
        int xCoordinate = scanner.nextInt();

        // Get the y-coordinate:
        System.out.println("Enter desired y-coordinate:");
        int yCoordinate = scanner.nextInt();

        // Making the player's move:
        game.placePlayerPiece(xCoordinate, yCoordinate);

        System.out.println("After your move:");
        System.out.println(game.getBoard().toString());
    }

    // Executes an AI move:
    private void AIMove() {
        // Making the AI's move:
        game.aiPlacePiece();

        // Printing the AI's move:
        System.out.println("After AI move:");
        System.out.println(game.getBoard().toString());
    }

    /**
     * Checks the game's status.
     * 
     * @return true if the game is still in progress, false otherwise.
     */
    private boolean checkStatus() {
        status = game.getStatus();

        return (status == GameStatus.IN_PROGRESS);
    }
}
