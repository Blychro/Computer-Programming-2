
/**
 * StringNotFoundException used to report string searched for not found.
 *
 * @author (McCauley)
 */
public class StringNotFoundException extends Exception
{
    public StringNotFoundException( )
    {
        super("String not found.");
    }
	
    public StringNotFoundException(String message)
    {
        super(message);
    } 
}
