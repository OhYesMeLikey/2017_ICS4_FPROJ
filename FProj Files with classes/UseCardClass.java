// The "UseCardClass" class.
import java.awt.*;
import hsa.Console;
import java.util.Random;

public class UseCardClass
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();

	Random rand = new Random ();
	DelayClass delayObject = new DelayClass ();

	for (;;)
	{
	    CardClass cardObject = new CardClass (rand.nextInt (4), rand.nextInt (4), rand.nextInt (4));
	    cardObject.draw (c);
	    //c.println ("wait");
	    delayObject.delay (1000);
	    cardObject.erase (c);
	}

	//c.println ("done");
	// Place your program here.  'c' is the output console
    } // main method
} // UseCardClass class
