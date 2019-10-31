
/**
 * Write a description of class LengthOrderedStringsList here.
 *
 * @author (Thomas Marshall)
 * 
 * Creates an array of Strings that organizes them by length and then the Strings with matching lengths are put in alphabetical order
 * 
 * I certify that this is entirely mt own work
 */
public class LengthOrderedStringsList extends AbstractStringsList
{
    // Constructor used from the superclass
    public LengthOrderedStringsList () {
        super();
    }
    
    // Adds a new string in the proper place
    public void add (String a) throws StringDuplicateException {
        try {
            if (contains(a)) {
                throw(new StringDuplicateException());
            }
            
            int place = 1;
            
            // Loops until it decides where it should go
            while (list[place - 1] != null && (a.length() > list[place - 1].length() || a.compareTo(list[place - 1]) > 0) && a.length() >=  list[place - 1].length()) {
                place++;
                
                if (place > list.length) {
                    // Prevents an error due to full capacity and then exceeding the array limit on the next iteration
                    break;
                }
            }
            
            // Uses a private method to be used to place the string in the appropriate place
            insert(a, place);
        } catch (StringDuplicateException ime) {
            System.out.println(ime.getMessage());
        }
    }
    
    // Places the string given in the right location
    private void insert (String a, int place) {
        if (size == list.length) {
            enlarge();
        }
        
        // have to move some elements over
        for (int index = size; index >= place; index--) {
           list[index] = list [index-1];
        }
        
        list[place-1] = a;
        size++;
    }
    
    // Checks if a string is in the array
    public boolean contains (String a) {
        // Search parameters
        int min = 0;
        int max = super.size() - 1;
        int mid = (max + min) / 2;
        
        // Loops until search is finished
        while (min <= max) {
            // Returns when the word is found
            if (list[mid].compareTo(a) == 0) {
                return true;
            }
            // Checks word length first before checking alphabetical order
            else if (list[mid].length() == a.length()) {
                // Removes the top half of search parameters if the string is determined to not be located in that half
                if (list[mid].compareTo(a) > 0) {
                    max = mid - 1;
                    mid = (max + min) / 2;
                }
                // Removes the bottom half of search parameters if the string is determined to not be located in that half
                else if (list[mid].compareTo(a) < 0) {
                    min = mid + 1;
                    mid = (max + min) / 2;
                }
            }
            // Removes the top half of search parameters if the string is determined to not be located in that half
            else if (list[mid].length() > a.length()) {
                max = mid - 1;
                mid = (max + min) / 2;
            }
            // Removes the bottom half of search parameters if the string is determined to not be located in that half
            else if (list[mid].length() < a.length()) {
                min = mid + 1;
                mid = (max + min) / 2;
            }
        }
        
        // Returns false if the word is not found
        return false;
    }
    
    // Finds the location of a given string
    public int find (String a) {
        if (contains(a)) {
            int found = 1;
            
            // Ends search if the string searched reaches the end of stings in the array or if the string searched is equal to or past the preferred string, lengthwise and alphabetically
            while (list[found - 1] != null && (list[found - 1].length() < a.length() || list[found - 1].compareTo(a) < 0)) {
                found++;
            }
            
            return found;
        }
        else {
            return -1;
        }
    }
    
    // Removes a given string from the array. Uses an exception to prevent the search for a string not in the list
    public void delete (String a) throws StringNotFoundException {
        try {
            int place = find(a);
            
            if (place == -1) {
                throw(new StringNotFoundException());
            }
            
            // just copy all the string that follow it, over it
            for (int i = (place - 1); i < size-1; i++) {
               list[i] = list[i + 1];
            }
            
            size--; // update size to reflect one fewer string stored
        } catch (StringNotFoundException ime) {
                System.out.println(ime.getMessage());
        }
    }
    
    public static void main(String [] args) throws StringDuplicateException, StringNotFoundException {
       LengthOrderedStringsList l1 = new LengthOrderedStringsList();
        l1.displayList();
        System.out.println();
        l1.add("pizza");
        l1.displayList();
        System.out.println();
        l1.add("pie");
        l1.displayList();
        System.out.println();
        l1.add("pepperoni");
        l1.displayList();
        System.out.println();
        l1.add("basil");
        l1.displayList();
        System.out.println();
        l1.add("to go");
        l1.displayList();
        System.out.println();
        l1.add("for");
        l1.add("dinner");
        l1.add("tonight");
        l1.add("and");
        l1.displayList();
        System.out.println();
        l1.add("every night");
        l1.displayList();
        System.out.println();
        l1.add("with");
        l1.add("salad");
        l1.displayList();
        System.out.println();
        l1.add("followed");
        l1.add("by");
        l1.add("chocolate chip");
        l1.add("cookies");
        l1.displayList();
        System.out.println();
        l1.add("thin");
        l1.displayList();
        System.out.println();
        l1.add("crust");
        l1.displayList();
        System.out.println();
        l1.add("several");
        l1.displayList();
        System.out.println();
        l1.add("for all");
        l1.add("- the end -");
        l1.displayList();
        System.out.println();
        // Is pizza in the list?
        System.out.print("\"pizza\" is ");
        if (l1.contains("pizza"))
            System.out.println("in the list at " + (l1.find("pizza")));
        else
            System.out.println("NOT in the list, find came back: " + (l1.find("pizza")));
        // Is sushi in the list?
        System.out.print("\"sushi\" is ");
        if (l1.contains("sushi"))
           System.out.println("in the list");
        else
            System.out.println("NOT in the list");
        
            System.out.println("in the list at " + (l1.find("sushi")));
        // Test delete method - optional bonus
        // Make a new list for testing - assumes "add" works
       LengthOrderedStringsList l2 = new LengthOrderedStringsList();
        l2.add("does");
        l2.add("delete");
        l2.add("pepperoni");
        l2.add("basil");
        l2.displayList();
        
        System.out.println();
        System.out.println("Add \"does\":");
        l2.add("does");
        l2.displayList();
        System.out.println();
        System.out.println("Add \"basil\":");
        l2.add("basil");
        l2.displayList();
        
        System.out.println();
        System.out.println("Delete \"does\":");
        l2.delete("does");
        l2.displayList();
        System.out.println();
        System.out.println("Delete \"basil\":");
        l2.delete("basil");
        l2.displayList();
        System.out.println();
        System.out.println("Delete \"pepperoni\":");
        l2.delete("pepperoni");
        l2.displayList();
        System.out.println();
        System.out.println("Delete \"banana\":");
        l2.delete("banana");
        l2.displayList();

        System.out.println();
        System.out.println("Delete \"delete\":");
        l2.delete("delete");
        l2.displayList();
        System.out.println();
        System.out.println("Delete \"guitar\":");
        l2.delete("guitar");
        l2.displayList();
        

    }
}
