
/**
 * Write a description of class HW1 here.
 *
 * This program takes the amount of bags ordered and how much it costs in total while also outputting the number of large, medium, and small boxes used to transport the bags
 *
 * @author (Thomas Marshall)
 * I certify that this is entirely my own work
 */
import java.util.Scanner;
public class HW1
{
    public static void main (String[] args) {
        System.out.println("How many bags?");
        Scanner scnr = new Scanner(System.in);
        
        int bags = scnr.nextInt();
        int newBags = bags;
        int bagCountFix = 0;
        double totalCost = bags * 5.50;
        int large;
        int med;
        int small;
        
        System.out.print("Number of bags ordered: " + bags + " bags, $");
        System.out.printf("%.2f", (totalCost));
        System.out.println("\n\n\tBoxes Used:");
        
        int largeCount = newBags / 20;
        if (newBags % 20 >= 16) {
            largeCount += 1;
            bagCountFix = newBags % 20;
        }
        
        if (largeCount > 0) {
            System.out.print("\n\t\t" + largeCount + " Large - $");
            double lCost = largeCount * 2;
            System.out.printf("%.2f", lCost);
            newBags -= (20 * largeCount) + bagCountFix;
            totalCost += lCost;
        }
        
        int medCount = newBags / 10;
        if (newBags % 10 >= 6) {
            medCount += 1;
            bagCountFix = newBags % 10;
        }
        
        if (medCount > 0) {
            System.out.print("\n\t\t" + medCount + " Medium - $");
            double mCost = medCount * 1.00;
            System.out.printf("%.2f", mCost);
            newBags -= (10 * medCount) + bagCountFix;
            totalCost += mCost;
        }
        
        int smallCount = newBags / 5;
        newBags -= 5 * smallCount;
        if (newBags > 0) {
            smallCount += 1;
        }
        
        if (smallCount > 0){
            System.out.print("\n\t\t" + smallCount + " Small - $");
            double sCost = smallCount * 0.50;
            System.out.printf("%.2f", sCost);
            totalCost += sCost;
        }
        
        System.out.print("\n\n\tTotal Cost:\t$");
        System.out.printf("%.2f", totalCost);
    }
}
