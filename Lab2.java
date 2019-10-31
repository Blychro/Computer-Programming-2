
/**
 * Lab2 exercises - using loops.
 *
 *author(Thomas Marshall)
 */
public class Lab2
{
    public static void main (String [] args)
    {
        // you should be able to change any of the values
        // below and still get correct results based on the new values
       final int SIZE = 8;
       int n = 438921; 
 
       System.out.println("Thomas Marshall");
       System.out.println();

        System.out.println("Number entered is: " + n);
       /* Add code here to pull the number apart, using the digits,
        * to determine what digit to print and how many copies to 
        * print on each line. If n = 421, output should be
        * 1
        * 22
        * 4444
        * Hint - use % to pull out digits and / to update number
        */
       int digit;
       int m;
       do {
            m = n;
            digit = n % 10;
            for (int i = 0; i < digit; i++) {
                System.out.print(digit);
            }
            
            n /= 10;
            System.out.println();
            
       } while (n != m);
       
       System.out.println();
        
        /////// draw triangle
        /* Add code to draw the upside down $ triangle as shown
         * on the Lab spec sheet. If SIZE is 3, result is:
         * $$$
         * $$
         * $
         */
       String layer;
       int len = SIZE;
       do {
            
            layer = "";
            
            for (int i = 0; i < len; i++) {
                layer += "$";
            }
            
            System.out.println(layer);
            len--;
            
       } while (layer.length() > 0);
        
        /// draw times table
        System.out.println("\nTimes tables through " + SIZE + " x " + SIZE + "\n");
        /* See the lab spec sheet for the exact format of the output.
         * Getting the lines and alignments right might take time, but
         * do it. Consider printf statements to get values lines up. The 
         * answer colums are formatted to be 4 spaces wide.
         */
        
        System.out.print("  ");
        
        for (int i = 1; i <= SIZE; i++) {
           System.out.printf("%4d", i);
        }
        
        System.out.print("\n__");
        
        for (int i = 1; i <= SIZE; i++) {
            System.out.print("____");
        }
        
        System.out.println();
        
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + "|");
            
            for (int j = 1; j <= SIZE; j++) {
                System.out.printf("%4d", (j * i));
            }
            
            System.out.println();
        }
    }
}
