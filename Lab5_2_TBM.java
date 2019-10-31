
/**
 * Write a description of class Lab5_2_TBM here.
 *
 * @author (Thomas Marshall)
 * @version (a version number or a date)
 */

import java.util.*;
import java.io.*;

public class Lab5_2_TBM
{
    public static void main(String[] args) {
        int total = 0;
        int num = 0;
        
        File myFile = null;
        Scanner inputFile = null;
        
        myFile = new File("inFle.txt");
        try {
            inputFile = new Scanner(myFile);
        
            while (inputFile.hasNext()) {
                try {
                    num = inputFile.nextInt();
                    total += num;
                } catch (InputMismatchException ime) {
                    System.out.println("Illegal value found");
                    inputFile.next();
                }
            }// End while
            
            System.out.println("The total values is " + total);
            inputFile.close();
        } catch (FileNotFoundException fnf) {
             System.out.println("The total values is " + total);
             System.out.println(fnf.getMessage());
        }
    }
}
