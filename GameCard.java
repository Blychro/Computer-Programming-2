
/**
 * Write a description of class GameCard here.
 * 
 * This class will allow a single game card to be created. It can show the current face, flip it over to the front or back, check which way the card is facing and give the card's value.
 *
 * @author (Thomas Marshall)
 * 
 * @version (a version number or a date)
 * 
 * I certify this is entirely my own work
 */
public class GameCard
{
    // Strings used throughout the class
    String cardVal;
    String showing;
    
    // initializer gives card value and sets it face down
    public GameCard (String card) {
        cardVal = card;
        showing = "*";
    }
    
    // Gives the card's value
    public String getCard () {
        return cardVal;
    }
    
    // Turns the card face down
    public void hide () {
        showing = "*";
    }
    
    // Turns the card face up
    public void show () {
        showing = cardVal;
    }
    
    // Returns a boolean saying whether or not the card is face up
    public boolean isShowing () {
        boolean check = true;
        
        // If the face up part is "*" then it is face down
        if (showing == "*") {
            check = false;
        }
    
        return check;
    }
    
    // Print statement set to give the card's current face up value
    public String toString () {
        return showing;
    }
}
