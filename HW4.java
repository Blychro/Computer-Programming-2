
/**
 * Write a description of class HW4v2 here.
 *
 *This program will take the unique words in a file and display them along with the nnumber of appearances of each unique word.
 *
 * @author Thomas Marshall
 * 
 * @version (a version number or a date)
 */

import java.io.*;
import java.util.Scanner;

public class HW4
{
    // This method uses user input to find and read the inputed file and returns it
    public static Scanner words() throws IOException {
        // Initializes quote
        String quote;
        
        // Gives instructions
        System.out.println("Enter the file name you wish to use:");
        
        // Creates a new scanner
        Scanner scnr = new Scanner(System.in);
        
        // Recieves the name given
        quote = scnr.nextLine();
        
        // Finds the file given
        Scanner fileInput = new Scanner(new FileInputStream(quote));
        
        // Returns file information
        return fileInput;
    }
    
    // This method builds the string array and count array
    public static void builder (Scanner quote, int num, String [] wordArray, int [] numList) {
        // Creates a counter
        int count = 0;
        
        // Sets up a loop to create an array as long as the quote is and limits the array incase the quote was too lomg
        while (quote.hasNext() && count < num) {
            // Defines each word for its time in the loop, removes symbols, and sets it to lowercase
            String word = quote.next();
            word = word.replaceAll("[^a-zA-Z]","");
            word = word.toLowerCase();
            
            // Method call to see if the word in use is unique
            int check = checkWord(word, count, wordArray);
            
            // If the word is unique it adds it to the string array and adds 1 to its counterpart in the int array
            if (check == -1) {
                wordArray[count] = word;
                numList[count++] = 1;
            }
            // Adds a count to the proper word if the word was not unique
            else {
                numList[check]++;
            }
        }
        
        // I know I do not need a return here but it serves as a reminder that it mutated the arrays
        return;
    }
    
    // Method that decides if the word is unique
    public static int checkWord(String word, int count, String [] wordArray) {
        // Default int that serves as a unique word
        int found = -1;
        
        // Loops through all the currently listed words
        for (int i = count - 1; i >= 0; --i) {
            if (word.compareTo(wordArray[i]) == 0) {
                // Sets up the location of the repeated word
                found = i;
            }
        }
        
        // Returns repeated location or -1 if it is unique
        return found;
    }
    
    // Method that rearranges the arrays to be in decending order of frequency
    public static void arrange (int num, String [] wordArray, int [] numList) {
        // Loop to go through each word
        for (int i = 0; i < num && wordArray[i] != null; ++i) {
            // Resets definitions for each loop
            int max = 0;
            int place = 0;
            
            // Sets up the word comparison
            for (int j = i; j < num && wordArray[j] != null; ++j) {
                // Sets the current comparison
                int count = numList[j];
                // Decides the current maximum count and placement
                if (count > max) {
                    max = count;
                    place = j;
                }
            }
            
            // Switches the max with the current location of i
            String tempStr = wordArray[i];
            wordArray[i] = wordArray[place];
            wordArray[place] = tempStr;
            
            int tempInt = numList[i];
            numList[i] = numList[place];
            numList[place] = tempInt;
        }
        
        // Same reason as the other return
        return;
    }
    
    // Changes the word count to frequency percentages
    public static double [] frequency (int num, int [] numList) {
        // Initialize total and double array
        double total = 0;
        double [] perc = new double [numList.length];
        
        // Add to total
        for (int i = 0; i < num && numList[i] != 0; ++i) {
            total += numList[i];
        }
        
        // Change each count to percent
        for (int i = 0; i < num && numList[i] != 0; ++i) {
            perc[i] = (numList[i] / total) * 100;
        }
        
        // Return percentages
        return perc;
    }
    
    // With the exception of the main, everything from here on out is table formatting. Unfortunately I couldn't get it to line up properly so I did the best I could
    
    // Method builds the horizontal lines depending on the length of each word
    public static String createBorder (int num, String [] wordArray) {
        String border = "";
        for (int i = 0; i < num && wordArray[i] != null; ++i) {
            border += "-";
            
            for (int j = 0; j < wordArray[i].length() + 1; ++j) {
                border += "-";
            }
            
            border += "-";
            
        }
        
        return border;
    }
    
    // Sets up String build
    public static String strDisplay(int num, String [] wordArray) {
        // Left edge
        String str = " | ";
        // Loops each word
        for (int i = 0; i < num && wordArray[i] != null; ++i) {
            // Adds more spaces depending on how many are needed if any
            if (wordArray[i].length() > 5) {
                str += wordArray[i] + " | ";
            }
            else {
                while (wordArray[i].length() < 5) {
                    wordArray[i] = " " + wordArray[i] + " ";
                }
                
                str += wordArray[i] + " | ";
            }
        }
        
        // returns the line
        return str;
    }
    
    // Sets up int build
    public static void intDisplay(int num, String [] wordArray, double [] numList) {
        // Left edge
        System.out.print(" |  ");
        
        // Loops each number
        for (int i = 0; i < num && wordArray[i] != null; ++i) {
            System.out.printf("%2.2f", numList[i]);
            System.out.print("%");
            System.out.print("  |  ");
        }
        
        // Resets line
        System.out.println();
    }
    
    // Main function
    public static void main(String [] args) throws IOException {
        // Array length and initialization
        final int num = 20000;
        String [] wordArray = new String [num];
        int [] numList = new int [num];
        
        // Builds the arrays from the file inout
        Scanner quote = words();
        builder(quote, num, wordArray, numList);
        arrange(num, wordArray, numList);
        double [] perc = frequency(num, numList);
        
        // Defines table parts
        String str = strDisplay(num, wordArray);
        String border = createBorder(num, wordArray);
        
        // Prints table
        System.out.println(border);
        System.out.println(str);
        System.out.println(border);
        intDisplay(num, wordArray, perc);
        System.out.println(border);
    }
    
    // After putting multiple quotes into the code, I do not think it is enough to decide who wrote the work, based on the frequency of the words used.
    // I did not notice many similarities in the works done by a common author in terms of how frequently words were used.  The only exception to this was the form of 
    // literature.  I noticed the third person point of view would use words like "he" or "she" more often because they are used in descriptions.  Plays used these words less.
    // I did not notice a big difference in the frequency of words between autors.  I did, however, notice that it was easier to tell when works where done because of the language used. 
    // I did, however, believe that this had less to do with frequency and more to do with the unique word display.  I did notice there was a consistent use of words like "the" or 
    // contractions because of how common they are in langage overall.
    
}
