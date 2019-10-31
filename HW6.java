
/**
 * Write a description of class HW6 here.
 *
 * @author Thomas Marshall
 * 
 * I certify this is entirely my own work
 * 
 * Test driver for StringsList
 */

import java.util.*;

public class HW6
{
    public void main () {
        // Creates object
        StringsList strList = new StringsList();
        
        // fills object
        for (int i = 0; i < 10; ++i) {
            strList.add("hi");
        }
        
        // Shows object
        strList.displayList();
        
        // Uses insert and enlarge
        strList.insert("bye", 2);
        // Insert ineffective if placed incorrectly
        strList.insert("bye", 15);
        // uses size
        System.out.println("Array size: " + strList.size());
        
        // Shows object
        strList.displayList();
        
        // puts more into object
        for (int i = 0; i < 5; ++i) {
            strList.add("hello");
        }
        
        // uses contains
        System.out.println("hi: " + strList.contains("hi"));
        System.out.println("nice: " + strList.contains("nice"));
        
        // Uses find
        System.out.println("bye at position " + strList.find("bye"));
        System.out.println("nice at position " + strList.find("nice"));
        
        // Shows object
        strList.displayList();
        
        // Uses delete
        strList.delete("bye");
        // Shows end result
        strList.displayList();
    }
}
