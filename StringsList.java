
/**
 * Write a description of class StringsList here.
 *
 * @author Thomas Marshall
 * 
 * This class creates a StringsList object that builds an array of strings
 * 
 * I certify this is entirely my own work
 */
public class StringsList
{
    // Count and strArray initializers
    String [] strArray;
    int count;
    
    // Constructor creates an initial capacity of 10 and sets the count to 0
    public StringsList () {
        strArray = new String[10];
        count = 0;
    }
    
    // Returns the amount of items in the array
    public int size () {
        return count;
    }
    
    // Adds an inputed item on to the back of the array and adds 1 to the count to match the number of items in the array
    public void add (String append) {
        strArray[count++] = append;
    }
    
    // Adds an inputed item into an inputed location in the array and increases count to match the item count in the array.
    public void insert (String str, int spot) {
        // Removes the possibility of space between items in the array
        if (1 < spot && spot <= count + 1) {
            // i initialized here to be used multiple places
            int i;
            
            // Checks if the array capacity needs to be enlarged
            if (count == strArray.length) {
                enlarge();
            }
            
            // Sets up a temporary array
            String [] temp = new String[strArray.length];
            
            // Adds the items to the temp before the new item
            for (i = 0; i < spot - 1; ++i) {
                temp[i] = strArray[i];
            }
            // Adds the new item to temp in the appropriate place
            temp[spot - 1] = str;
            // Adds the remaining items behind the new item
            while (i < count) {
                temp[i + 1] = strArray[i++];
            }
            
            // Sets the strArray equal to the temp
            strArray = temp;
            
            // Count increased to match the number of items
            count++;
        }
    }
    
    // Checks if a given String is in the array
    public boolean contains (String str) {
        // Starts as false
        boolean check = false;
        
        for (int i = 0; i < strArray.length && strArray[i] != null; ++i) {
            // If the String is present in the array check becomes true
            if (str.compareTo(strArray[i]) == 0) {
                check = true;
            }
        }
        
        // Returns check
        return check;
    }
    
    // Locates where in the array an item is. If it is not present it returns a -1
    public int find (String str) {
        // Initializes location to -1
        int found = -1;
        
        // Searches each item in the list (The instructions did not specify so I set it to give the last location found in the array if there were repeat matches
        for (int i = 0; i < count; ++i) {
            if (str == strArray[i]) {
                // Sets location starting from 1 not 0
                found = i + 1;
            }
        }
        
        // Returns found location
        return found;
    }
    
    // Removes all instances of a given String and removes them from count to match the number of items
    public void delete (String str) {
        // Initializes how many to delete to 0
        int move = 0;
        
        // Sets up newArray
        String newArray [] = new String[strArray.length];
        
        for (int i = 0; i < count; ++i) {
            // If a match is made, it adds an item to delete
            if (str != strArray[i]) {
                // Skips deleted item(s)
                newArray[i - move] = strArray[i];
            }
            else {
                move++;
            }
        }
        
        //compare(strArray, newArray);
        
        // Canges count and resets strArray accordingly
        count -= move;
        strArray = newArray;
    }
    
    // Prints out the capacity, item count, and all of the items at their respective locations
    public void displayList () {
        System.out.println ("StringsList: capacity " + strArray.length + ", size " + count);
        
        for (int i = 0; i < strArray.length; ++i) {
            System.out.println("[" + (i + 1) + "]  " + strArray[i]);
        }
    }
    
    // Doubles the capacity of the array when necessary. Instance variables modifued elsewhere
    private void enlarge () {
        // Doubles array length
        String [] increase = new String[strArray.length * 2];
        
        // Adds items to the new array
        for (int i = 0; i < strArray.length; ++i) {
            increase[i] = strArray[i];
        }
        
        //Sets strArray to equal increase.
        strArray = increase;
    }
}
