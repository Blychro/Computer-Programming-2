/**
 *  Thomas Marshall
 *  Outputs the volume and diagonal of a rectangular prism.
 */
import java.util.Scanner;
public class PrismWork
{
    public static void main (String[] args)
    {
        // all prism values are expected to be positive
        int length = 0, width = 0, height = 0, volume = 0;
        double diagonal;
        
        // prompt the user to enter the needed data
        System.out.println("Enter length, width, and height ");
        Scanner keyboard = new Scanner(System.in);
        
        // Enter the data for the prism
        length = keyboard.nextInt();
        width = keyboard.nextInt();
        height = keyboard.nextInt();
        System.out.print("For a rectangle with length " + length + ", width " + width);
        System.out.println(", and height " + height);
        // compute the volume
        volume = length * width * height;
        System.out.println("The volume is " + volume);
        // compute the diagonal
        diagonal = Math.sqrt(Math.pow(length, 2.0) + Math.pow(width, 2.0) + Math.pow(height, 2.0));
        System.out.println("The diagonal is " + diagonal);
    }
}
