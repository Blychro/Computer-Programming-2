
/**
 * HW5 drives the game of concentration - matching of cards
 * 
 * @author (McCauley) 
 */
import java.util.*;
public class HW5
{
    
    /**
     * Start the game.
     */
    public static void main(String [] args)
    {
        playIt();
        
    }
    /**
     * the user interface to the game of Concentration
     */
    public static void playIt()
    {
        final int BOARD_SIZE = 4;
        Scanner in = new Scanner (System.in);
        Game once = new Game(BOARD_SIZE); 
        once.startNewGame();
        System.out.println("Let's play Concentration!");
        boolean playMore = true;
        boolean aWinner = false;

        while (playMore)
        {
            System.out.println(once); // prints gameboard
            int row1, row2, col1, col2;
            boolean tryAgain;
            // choose first card
            do  // accept input and verify that card chosen has not yet been played
            {
                tryAgain = false;
                System.out.println("Which card do you want to see?  ");
                do  // accept and verify input is a valid row number
                {
                    System.out.print("Row (must be in range 1.." + BOARD_SIZE + ")? ");
                    row1 = in.nextInt();
                } while (row1 < 1 || row1 > BOARD_SIZE);
                do  // accept and verify input is a valid column number
                {
                    System.out.print("Column?  (must be in range 1.." + BOARD_SIZE+")");
                    col1 = in.nextInt();
                } while (col1< 1 || col1 > BOARD_SIZE);
                // verify that the card chosen is not already showing
                if (once.alreadyPlayed(row1-1, col1-1))
                {
                   System.out.println("That card has already been matched. Try again.");
                   tryAgain = true;
                }
            }while (tryAgain); // won't let player pick an already played card
            once.handleMove(row1-1, col1-1);  // good card chosen, play it
            System.out.println(once); // show board with chosen card face up
            // choose second card
            do // accept input and verify that card chosen has not yet been played
            {
                tryAgain = false;
                System.out.println("Which card do you want to match that one with?  ");
                do // accept and verify input is a valid row number
                {
                    System.out.print("Row (must be in range 1.." + BOARD_SIZE+")? ");
                    row2 = in.nextInt();
                } while (row2 < 1 || row2 > BOARD_SIZE);
                do // accept and verify input is a valid column number
                {
                    System.out.print("Column?(must be in range 1.." + BOARD_SIZE+")");
                    col2 = in.nextInt();
                } while (col2 < 1 || col2 > BOARD_SIZE);
                // verify that the card chosen is not already showing
                if (once.alreadyPlayed(row2-1, col2-1))
                {
                   System.out.println("That card has already been matched. Try again.");
                   tryAgain = true;
                }
            }while (tryAgain); // won't let player pick an already played card
            once.handleMove(row2-1, col2-1); // good card chosen, play it
            System.out.println(once); // show board with both cards showing
 
            // check for match
            if (once.checkMatch(row1-1, col1-1, row2-1, col2-1))
               System.out.println("A MATCH!!\n\n");
            else
               System.out.println("Try again!\n\n");
            System.out.println(once);
            if (once.noWin())
            {
                System.out.print("Want to try another pair? (type 0 to quit or any other number to continue)");
                int any = in.nextInt();
                if (any == 0)
                {
                    System.out.println("Tired playing? OK. Bye.");
                    playMore = false;
                }
                else
                   System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
             }
             else
             {
                playMore = false;
                aWinner = true;
             }    
                   
        } // while playMore
        if (aWinner)
        {
           System.out.println("Congratulations! You won.");
           System.out.println("Press 0 to quit, any other number to play again.");
           if (in.nextInt() != 0)
             playIt();
        }
        System.out.println("Hope you enjoyed the game!");          
        
    }
    

}
