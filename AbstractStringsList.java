
/**
 * MyAbstractList provides the data and specifies
 * the functionity applicable to all different types of
 * string lists.
 * 
 * The methods size, enlarge, and display are the same for every
 * type of list, so they are included here.
 * 
 * The methods add, delete, find, and contains vary depending on the
 * type of strings list. All subclasses must implement these.
 *
 * @author (McCauley)
 */
import java.util.*;
public abstract class AbstractStringsList
{
    // instance variables 
    protected String [] list; 
    protected int size;  // number of string stored
    
    final int INITIAL_CAPACITY = 10;

        public AbstractStringsList()
        {
            // initialise instance variables
            list = new String[INITIAL_CAPACITY];
            size = 0;
        }
    
    /**
     * Returns number of string currently stored
     */
    public int size(){
        return size;
    }
    
        
    /**
     * double list capacity
     */
    protected void enlarge(){
        // make a new list
        String [] newList = new String[list.length*2];
        // copy old values into new list
        for (int index = 0; index < list.length; index++)
           newList[index] = list[index];
        list = newList;
    }
        
    /**
     * Print contents of list with size and
     * capacity details
     */
    public void displayList(){
        System.out.println("StringList: capacity " + list.length + ", size " +  size());
        for (int index = 0; index < size(); index++)
           System.out.println("[" + (index+1) + "] " + list[index]);
        for (int index = size+1; index <= list.length; index++)
           System.out.println("[" + (index) + "] null");
    }
    
    // Add string a to the list in its proper position
    // "proper" determined by nature of list
    public abstract void add(String a) throws StringDuplicateException;
    
    // Remove a from list as efficiently as possible,
    // assuming that a is in the list
    public abstract void delete(String a) throws StringNotFoundException;
    
    // Find an return the human-understood position of String a in the
    // list. Return -1 if a is not in the list.
    public abstract int find(String a);
    
    // Return true if a is in the list, false otherwise.
    public abstract boolean contains(String a);
}
