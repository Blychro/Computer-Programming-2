
/**
 * Write a description of class HW8 here.
 *
 * @author (Thomas Marshall)
 * 
 * Test driver for UnorderedStringsList, OrderedStringsList, and LengthOrderedStringsList
 * 
 */
public class HW8
{
    public static void main(String [] args) throws StringDuplicateException, StringNotFoundException {
        System.out.println("UnorderedStringsList:");
        UnorderedStringsList l1 = new UnorderedStringsList();
        l1.displayList();
        System.out.println();
        l1.add("pizza");
        l1.add("pie");
        l1.insert("pepperoni",1);
        l1.insert("basil",2);
        l1.insert("to go",l1.size());
        l1.add("for");
        l1.add("dinner");
        l1.add("tonight");
        l1.add("and");
        l1.displayList();
        System.out.println();
        l1.add("every night");
        l1.add("with");
        l1.add("salad");
        l1.add("followed");
        l1.add("by");
        l1.add("chocolate chip");
        l1.add("cookies");
        l1.insert("thin",1);
        l1.insert("crust",2);
        l1.insert("several",18);
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
        
        
        System.out.println("\nOrderedStringsList");
        OrderedStringsList l3 = new OrderedStringsList();
        l3.displayList();
        System.out.println();
        l3.add("pizza");
        l3.add("pie");
        l3.add("pepperoni");
        l3.add("basil");
        l3.add("to go");
        l3.displayList();
        System.out.println();
        l3.add("for");
        l3.add("dinner");
        l3.add("tonight");
        l3.add("and");
        l3.add("every night");
        l3.add("with");
        l3.add("salad");
        l3.displayList();
        System.out.println();
        l3.add("followed");
        l3.add("by");
        l3.add("chocolate chip");
        l3.add("cookies");
        l3.add("thin");
        l3.add("crust");
        l3.add("several");
        l3.add("for all");
        l3.add("- the end -");
        l3.displayList();
        System.out.println();
        // Is pizza in the list?
        System.out.print("\"pizza\" is ");
        if (l3.contains("pizza"))
            System.out.println("in the list at " + (l3.find("pizza")));
        else
            System.out.println("NOT in the list, find came back: " + (l3.find("pizza")));
        // Is sushi in the list?
        System.out.print("\"sushi\" is ");
        if (l3.contains("sushi"))
           System.out.println("in the list");
        else
            System.out.println("NOT in the list");
        
            System.out.println("in the list at " + (l3.find("sushi")));
        // Test delete method - optional bonus
        // Make a new list for testing - assumes "add" works
        OrderedStringsList l4 = new OrderedStringsList();
        l4.add("does");
        l4.add("delete");
        l4.add("pepperoni");
        l4.add("basil");
        l4.displayList();
        
        System.out.println();
        System.out.println("Add \"does\":");
        l4.add("does");
        l4.displayList();
        System.out.println();
        System.out.println("Add \"basil\":");
        l4.add("basil");
        l4.displayList();
        
        System.out.println();
        System.out.println("Delete \"does\":");
        l4.delete("does");
        l4.displayList();
        System.out.println();
        System.out.println("Delete \"basil\":");
        l4.delete("basil");
        l4.displayList();
        System.out.println();
        System.out.println("Delete \"pepperoni\":");
        l4.delete("pepperoni");
        l4.displayList();
        System.out.println();
        System.out.println("Delete \"banana\":");
        l4.delete("banana");
        l4.displayList();

        System.out.println();
        System.out.println("Delete \"delete\":");
        l4.delete("delete");
        l4.displayList();
        System.out.println();
        System.out.println("Delete \"guitar\":");
        l4.delete("guitar");
        l4.displayList();
        
        
        System.out.println("\nLengthOrderedStringsList");
        LengthOrderedStringsList l5 = new LengthOrderedStringsList();
        l5.displayList();
        System.out.println();
        l5.add("pizza");
        l5.add("pie");
        l5.add("pepperoni");
        l5.add("basil");
        l5.add("to go");
        l5.displayList();
        System.out.println();
        l5.add("for");
        l5.add("dinner");
        l5.add("tonight");
        l5.add("and");
        l5.add("every night");
        l5.add("with");
        l5.add("salad");
        l5.displayList();
        System.out.println();
        l5.add("followed");
        l5.add("by");
        l5.add("chocolate chip");
        l5.add("cookies");
        l5.add("thin");
        l5.add("crust");
        l5.add("several");
        l5.add("for all");
        l5.add("- the end -");
        l5.displayList();
        System.out.println();
        // Is pizza in the list?
        System.out.print("\"pizza\" is ");
        if (l5.contains("pizza"))
            System.out.println("in the list at " + (l5.find("pizza")));
        else
            System.out.println("NOT in the list, find came back: " + (l5.find("pizza")));
        // Is sushi in the list?
        System.out.print("\"sushi\" is ");
        if (l5.contains("sushi"))
           System.out.println("in the list");
        else
            System.out.println("NOT in the list");
        
            System.out.println("in the list at " + (l5.find("sushi")));
        // Test delete method - optional bonus
        // Make a new list for testing - assumes "add" works
        LengthOrderedStringsList l6 = new LengthOrderedStringsList();
        l6.add("does");
        l6.add("delete");
        l6.add("pepperoni");
        l6.add("basil");
        l6.displayList();
        
        System.out.println();
        System.out.println("Add \"does\":");
        l6.add("does");
        l6.displayList();
        System.out.println();
        System.out.println("Add \"basil\":");
        l6.add("basil");
        l6.displayList();
        
        System.out.println();
        System.out.println("Delete \"does\":");
        l6.delete("does");
        l6.displayList();
        System.out.println();
        System.out.println("Delete \"basil\":");
        l6.delete("basil");
        l6.displayList();
        System.out.println();
        System.out.println("Delete \"pepperoni\":");
        l6.delete("pepperoni");
        l6.displayList();
        System.out.println();
        System.out.println("Delete \"banana\":");
        l6.delete("banana");
        l6.displayList();

        System.out.println();
        System.out.println("Delete \"delete\":");
        l6.delete("delete");
        l6.displayList();
        System.out.println();
        System.out.println("Delete \"guitar\":");
        l6.delete("guitar");
        l6.displayList();
    }
}
