
/**
 * StringDuplicateException used to report duplicate strings.
 *
 * @author (McCauley)
 */
public class StringDuplicateException extends Exception
{
    public StringDuplicateException( )
    {
        super("A duplicate string detected.");
    }
	
    public StringDuplicateException(String message)
    {
        super(message);
    } 
}
