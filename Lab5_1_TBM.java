
/**
 * Write a description of class Lab5_1_TBM here.
 *
 * @author (Thomas Marshall)
 * @version (a version number or a date)
 */

import java.util.*;

public class Lab5_1_TBM
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = 0;
        
        while (num < 1 || num > 10) {
            try {
                System.out.println("Enter a number between 1 and 10 ");
                num = scan.nextInt();
        
                if (num < 1 || num > 10) {
                    throw (new NumberOutOfRangeException());
                }
            } catch (InputMismatchException ime) {
                System.out.println("Enter whole numbers only, with no spaces or other characters");
                scan.next(); // clearthe scanner buffer
            } catch (NumberOutOfRangeException ime) {
                System.out.println(ime.getMessage());
            }
        } // While
        
        System.out.println("\nValues correctly entered!");
    }
} // Class
