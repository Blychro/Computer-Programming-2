
/**
 * Write a description of class NumberOutOfRangeException here.
 *
 * An exception created to prevent a number to be used outside the accepted range.
 *
 * @author (Thomas Marshall)
 * @version (a version number or a date)
 */

import java.util.*;

public class NumberOutOfRangeException extends Exception
{
    public NumberOutOfRangeException() {
        super("The number entered is out of the acceptable range of 1 - 10.");
    }
    
    public NumberOutOfRangeException(String message) {
        super(message);
    }
}
