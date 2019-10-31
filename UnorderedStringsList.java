
/**
 * A class to maintain of list of unordered strings.
 * 
 * @author (McCauley)
 * 
 * I, Thomas Marshall, used the original class as a template for my UnorderedStringsList subclass
 */
public class UnorderedStringsList extends AbstractStringsList
{
    /**
     * Constructor for objects of class UnorderedStringsList
     * Starts empty.
     */
    public UnorderedStringsList()
    {
        super();
    }
    
    /**
     * Add a new element to the end of the list. If this addtion
     *   causes the list size to exceed capacity, the list size 
     *   is doubled (by enlarge method)
     */
    public void add(String a) throws StringDuplicateException {
        try {
            if (contains(a)) {
                throw(new StringDuplicateException());
            }
            
            if (size == list.length) {
               enlarge();
            }
            
            list[size] = a;
            size++;
        } catch (StringDuplicateException ime) {
            System.out.println(ime.getMessage());
        }
    }
    
    /**
     * Insert a string at position (human-counted) specified.
     * If this insertion causes the list size to exceed capacity, the list size 
     *   is doubled (by enlarge method)
     * Precondition: position specified is in range 1 to size, so 
     *   no holes will be left in the list.
     */
    public void insert( String a, int position ) throws StringNotFoundException {
        try {
            if (contains(a)) {
                throw(new StringNotFoundException());
            }
            
            if (size == list.length) {
                enlarge();
            }
            
            // have to move some elements over
            for (int index = size; index >= position; index--)
               list[index] = list [index-1];
            list[position-1] = a;
            size++;
        } catch (StringNotFoundException ime) {
                System.out.println(ime.getMessage());
        }
    }
    
    /**
     * returns true if string parameter in the list
     * Precondition: case-sensitive, string must match exactly
     */
    public boolean contains ( String a ){
    
        boolean found = false; // not found yet
        int index = find(a); // can use find or duplicate loop here
        if (index != -1) 
        
           found = true;
        return found;
    }
    
    /**
     * returns true if string parameter in the list
     * Precondition: case-sensitive, string must match exactly
     */
    public int find ( String a ){
    
        int foundAt = -1; // not found yet
        int index = 0;
        // iterate over list until string found or list exhausted
        while (index < size && !list[index].equals(a)){
           index++;
        }
        if (index < size) // loop terminated because string found
           foundAt = index+1;
        return foundAt;
    }
    
    /**
     * delete the string at the position specified
     */
    public void delete( String a ) throws StringNotFoundException {
        try {
            int location = find(a);
            
            if (location == -1) {
                throw(new StringNotFoundException());
            }
            
            if (location != -1) // it must be a value 1 through size, so remove value at index location - 1
            {
                int removeAtIndex = location-1;
                // just copy all the string that follow it, over it
                for (int index = removeAtIndex; index < size-1; index++)
                   list[index] = list[index+1];
                size--; // update size to reflect one fewer string stored
            }
        } catch (StringNotFoundException ime) {
                System.out.println(ime.getMessage());
        }
    }

    public static void main(String [] args) throws StringDuplicateException, StringNotFoundException {
        UnorderedStringsList l1 = new UnorderedStringsList();
        l1.displayList();
        System.out.println();
        l1.add("pizza");
        l1.displayList();
        System.out.println();
        l1.add("pie");
        l1.displayList();
        System.out.println();
        l1.insert("pepperoni",1);
        l1.displayList();
        System.out.println();
        l1.insert("basil",2);
        l1.displayList();
        System.out.println();
        l1.insert("to go",l1.size());
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
        l1.insert("thin",1);
        l1.displayList();
        System.out.println();
        l1.insert("crust",2);
        l1.displayList();
        System.out.println();
        l1.insert("several",18);
        l1.displayList();
        System.out.println();
        l1.add("for all");
        l1.insert("- the end -",l1.size());
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
        UnorderedStringsList l2 = new UnorderedStringsList();
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
