
/**
 * Write a description of class Game here.
 * 
 * This class will build a matching game board and check if a match was made. It will reveal matches and hide them wrong matches.
 *
 * @author (Thomas Marshall)
 * 
 * @version (a version number or a date)
 * 
 * I certify this is entirely my own work
 * 
 */

import java.util.*;

public class Game
{
    // Initializes the board size name and array name to be used by all the methods in the class
    int board;
    GameCard [][] cards;
    
    // Initializes the board size and array size
    public Game (int BOARD_SIZE) {
        board = BOARD_SIZE;
        cards = new GameCard [board][board];
    }
    
    // Sets up s game
    public void startNewGame () {
        // number of matches on the board
        int matches = board * board / 2;
        // all possible symbols for the largest board (10 X 10 or 50 matches)
        String [] symbols = {")", "!", "@", "#", "$", "%", "^", "&", "?", "(", "]", "[", "\\", "/", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                             "s", "t", "u", "v", "w", "x", "y", "z", "~", "}", "{", "+", "-", ";", ":", "<", ">", "="};
        // Counter for the symbol array
        int count = 0;
        
        // Builds the array of cards
        for (int i = 0; i < board; ++i){
            for (int j = 0; j < board; ++j) {
                // Makes sure only to include symbols up to the match limit and start over to ensure there are two of each symbol
                cards[i][j] = new GameCard(symbols[count++ % matches]);
            }
        }
        
        // Shuffles the array to make each symbol's location unknown
        shuffle();
    }
    
    // Creates the board. Since the string had to be returned, I could not use printf so I used if statements to account for double digits
    public String showBoard () {
        // Column count
        String shown = "   ";
        for (int i = 0; i < board; ++i) {
            // Changes for the 10th column
            if (i < 9) {
                shown += ("  " + (i + 1));
            }
            else {
                shown += (" " + (i + 1));
            }
        }
        
        // Creates border between column count and cards
        shown += "\n  -";
        
        for (int i = 0; i < board; ++i) {
                shown += "---";
        }
        
        shown += "\n";
        
        // Builds each row
        for (int i = 0; i < board; ++i) {
            // Accounts for double digits
            if (i < 9) {
                shown += (i + 1) + " |";
            }
            else {
                shown += (i + 1) + "|";
            }
            for (int j = 0; j < board; ++j) {
                shown += "  " + cards[i][j];
            }
            shown += "\n";
        }
        
        // returns the built board
        return shown;
    }
    
    // Uses .isShowing() to return if the card has already been turned over
    public boolean alreadyPlayed (int row, int column) {
        return cards[row][column].isShowing();
    }
    
    // Uses .show() to flip the card face up
    public void handleMove (int row, int column) {
        cards[row][column].show();
    }
    
    // Checks to see if the two selected cards are equal to eachother by using .getCard() and then .hide() if they are not a match to flip them back over
    public boolean checkMatch (int row1, int column1, int row2, int column2) {
        boolean match = cards[row1][column1].getCard().compareTo(cards[row2][column2].getCard()) == 0;
        
        if (match == false) {
            cards[row1][column1].hide();
            cards[row2][column2].hide();
        }
        
        return match;
    }
    
    // Checks if the board is completely face up to show victory
    public boolean noWin () {
        // defaults to victory
        boolean win = false;
        
        for (int i = 0; i < board; ++i) {
            for (int j = 0; j < board; ++j) {
                // if any card is face down it sets it to still playing
                if (cards[i][j].isShowing() == false) {
                    win = true;
                }
            }
        }
        
        return win;
    }
    
    // Shuffles the array values
    private void shuffle () {
        // Randomizer
        Random random = new Random();
        
        // Changes each card. Starts high and decreases to be used with the randomizer
        for (int i = cards.length - 1; i > 0; i--) {
            for (int j = cards[i].length - 1; j > 0; j--) {
                // Stays within the boundaries and uses a different location each time
                int row2 = random.nextInt(i + 1);
                int col2 = random.nextInt(j + 1);

                // Switches the location of the two cards
                GameCard temp = cards[i][j];
                cards[i][j] = cards[row2][col2];
                cards[row2][col2] = temp;
            }
        }
    }
    
    // Sets the board up as the print statement
    public String toString () {
        return showBoard();
    }
}
