
/**
 * Write a description of class HW7 here.
 *
 * @author (Thomas Marshall)
 * 
 * Test driver for OrderedStringsList.
 * 
 * Statements taken from StringsList changed to OrderedStringsList objects to test order and changed methods.
 */

import java.util.*;

public class HW7
{
    public static void main(String [] args){
        OrderedStringsList l1 = new OrderedStringsList();
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
           System.out.println("sushi is in the list");
        else
            System.out.println("sushi is NOT in the list");
        
            System.out.println("in the list at " + (l1.find("sushi")));
        // Test delete method - optional bonus
        // Make a new list for testing - assumes "add" works
        OrderedStringsList l2 = new OrderedStringsList();
        l2.add("does");
        l2.add("delete");
        l2.add("pepperoni");
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
