/**
 * Write a description of class HW2 here.
 * This program accepts a mad-lib story and allows the user to input the set words into the story. It then outputs the complete story and prints it into an output file.
 * The input file needs to be given with the .txt suffix, and the mad-lib insertions in custom mad-lib text files should be written like <noun> or <verb>
 *
 * @author Thomas Marshall
 * @version 2/4/18
 * 
 * I certify that this is entirely my own work
 */

import java.io.*;
import java.util.Scanner;
public class HW2
{
    public static void main (String [] args) throws IOException 
    {
        // Line being read later
        String inputLine;
        
        // Explanation of the program
        System.out.println("Welcome to the game of Mad Libs.\nI will ask you to provide various words\nand phrases to fill in a story.\nThe result will be written to an output file.\n");

        // Asks for a file name
        System.out.println("Input file name:");
        
        // Open a Scanner object for console/keyboard input
        Scanner keyboard = new Scanner(System.in);
        
        // input file name
        String inFile = keyboard.nextLine();
        
        // Open a Scanner object with the intent to read
        // from a given filename. If no file with this 
        // name is in the same directory as this HW2.java file
        // an exception will be thrown - this is not good!
        Scanner fileInput = new Scanner(new FileInputStream(inFile));
        
        // Output file namer
        String outStr = inFile.substring(0, (inFile.length() - 4));

        // Output stream associated with a file for output
        // You'll name it as directed when you get to that
        PrintWriter outFile = new PrintWriter(new FileOutputStream(outStr + "story.txt"));
        
        // Create the final print statement
        String finalOut = "";
 
        // while there are still lines to be read from the file
        while (fileInput.hasNext()){
            // Sets up statement for later
            String info = "Please type a";
            
            // read a line
            inputLine = fileInput.nextLine();
            
            // checks each letter in the line
            for (int i = 0; i < inputLine.length(); i++) {
                // A boolean checks to see if an input is needed
                boolean comp = inputLine.charAt(i) == '<';
                
                // Starts replacement if needed
                if (comp == true) {
                    // Sets up length of the inside
                    int count = inputLine.indexOf(">");
                    
                    // Creates what is asked for
                    String words = inputLine.substring(i + 1, count);
                    // Removes -
                    String newWords = words.replace("-", " ");
                    // Sets case to lower for an accurate check
                    String check = inputLine.toLowerCase();
                    
                    // Checks for a vowel as the first letter
                    if (check.charAt(i + 1) == 'a' || check.charAt(i + 1) == 'e' || check.charAt(i + 1) == 'i' || check.charAt(i + 1) == 'o' || check.charAt(i + 1) == 'u') {
                        // Gives the statement with an
                        System.out.println(info + "n " + newWords + ":");
                    }
                    else {
                        // Gives the statement with an a
                        System.out.println(info + " " + newWords + ":");
                    }
                    // Scanner for each specific input
                    Scanner enter = new Scanner(System.in);
                    
                    // Replaces request with the actual word
                    inputLine = inputLine.replaceFirst(("<" + words + ">"), enter.nextLine());
                }
            }

            // Adds each new line to the final output
            finalOut += (inputLine + "\n");
            
            // Adds each new line to the output file
            outFile.println(inputLine);
 
        }
        
        // Completion message
        System.out.println("Your mad-lib has been created!\n\n");
        // Prints completed mad-lib
        System.out.println(finalOut);
        
        // Finishes and closes the output file
        outFile.flush();
        outFile.close();   
    }

}
