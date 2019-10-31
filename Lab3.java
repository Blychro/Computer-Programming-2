
/**
 * Write a description of class Lab3 here.
 *
 * This program will accept an array of doubles and output the array's minimum, maximum, average, and varience.
 *
 * YOUR NAME GOES HERE: Thomas Marshall
 */
public class Lab3 {
    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to the minimum method
        double max = maximum(data); // change this to a call to maximum method
        double average = average(data); // change this to a call to average method
        double var = varience(data, average); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Average = %.3f, Variance = %.3f",
              min, max, average, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x) {
        double smallest = x[0];
        
        for (int i = 1; i < x.length; i++)
           if (x[i] < smallest)
              smallest = x[i];
              
        return smallest;   
    }
    
    public static double maximum (double [] x) {
        double largest = x[0];
        
        for (int i = 1; i < x.length; i++)
           if (x[i] > largest)
              largest = x[i];
              
        return largest;
    }
   
    public static double average (double [] x) {
        double average;
        double total = 0;
        
        for (int i = 0; i < x.length; ++i) {
            total += x[i];
        }
        
        average = total / x.length;
        
        return average;
    }
    
    public static double varience (double [] x, double average) {
        double varience = 0;
        
        for (int i = 0; i < x.length; ++i) {
            varience += Math.pow((x[i] - average), 2);
        }
        
        varience /= x.length;
        
        return varience;
    }
}