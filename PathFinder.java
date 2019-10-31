
import java.util.Random;
import java.util.Scanner;

public class PathFinder
{   
    // RNG for any number sided die to play pathfinder with or any game dice are needed.
    public PathFinder()
    {
        while (true){
            System.out.println("How many sides is the die? ");
            Scanner scnr = new Scanner(System.in);
        
            Random rand = new Random();

            int  n = rand.nextInt(scnr.nextInt()) + 1;
            System.out.println(n);
        }
    }
}
