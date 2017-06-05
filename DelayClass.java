// The "DelayClass" class.
import java.awt.*;
import hsa.Console;

public class DelayClass                                             // This is a "Delay" class that can delay the appearances of objects.
{
    public void delay (int iDelayTime)                              // This is a "delay" method that can calculate how long an object appears on a screen.
    {
	long lFinalTime = System.currentTimeMillis () + iDelayTime; // Create a variable to store the total amount of delay time.

	do                                                          // Do nothing while the total amount of delay time is >= the current time of Java.
	{
	}
	while (lFinalTime >= System.currentTimeMillis ());
    }
} // DelayClass class
