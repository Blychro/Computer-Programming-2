
/**
 * Write a description of class HW3 here.
 *
 * This program will allow the user to print a rocket made of symbols that scales to the size variable
 *
 * I certify this program is entirely my own work
 *
 * @author Thomas Marshall
 * @version (a version number or a date)
 */
public class HW3
{
    // size used to scale the rocket
    static final int size = 5;
    
    // Top and bottom of the rocket
    public static void cone()
    {
        // Definition set up
        String pyramid = "**";
        int wide = pyramid.length();
        int line = (4 * size);
        // Loop scales to horizontal length
        do {
            // Reset definitions each loop
            String empty = " ";
            wide = pyramid.length();
            double space = (line - 2) - wide;
            
            // Set appropriate formats
            for (int i = 0; i < (space / 2); i++) {
                empty += " ";
            }
            
            // Builds each row
            pyramid = (empty + "/" + pyramid + "\\");
            System.out.println(pyramid);
            // Set while comparison
            pyramid = pyramid.replace(" ", "");
        } while (wide < line - 2);
    }
    
    // Upright triangle
    public static void top() {
        // Definitions
        int len = 2 + size * 4;
        String line = "||";
        String mid = "";
        
        // Builds each row
        for (int i = 0; i < size; i++) {
            // Definitions that need o be reset each loop
            String empty = "";
            mid += "/\\";
            int space = len - (2 * mid.length()) - 2;
            
            // Builds formatting spaces
            for (int j = 0; j < (space / 4); j++) {
                empty += ".";
            }
            // Each line build and print
            line = "|" + empty + mid + empty + empty + mid + empty + "|";
            System.out.println(line);
        }
    }
    
    // Divider line
    public static void line() {
        // Edges of the line
        String divider = "++";
        // Builds the line to the appropriate length
        for (int i = 0; i < size; i++) {
            divider = divider.substring(0, 1) + "=*=*" + divider.substring(1);
        }
        
        // Prints the line
        System.out.println(divider);
    }
    
    // Upside down triangle
    public static void bottom() {
        // Definitions
        int len = 2 + size * 4;
        String line;
        String empty = "";
        int count = size;
        
        // Loops the appropriate number of times
        for (int i = 0; i < size; i++) {
            // Define the string
            String mid = "";
            
            // Loops the right number of times
            for (int j = 0; j < count; j++) {
                mid += "\\/";
            }
            
            // Builds and prints the created line
            line = "|" + empty + mid + empty + empty + mid + empty + "|";
            System.out.println(line);
            
            // Setup next loop
            count--;
            empty += ".";
        }
    }
    
    // Builds full rocket
    public static void main() {
        cone();
        line();
        top();
        bottom();
        line();
        bottom();
        top();
        line();
        cone();
    }
}
