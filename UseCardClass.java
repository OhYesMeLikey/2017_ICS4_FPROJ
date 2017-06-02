// The "UseCardClass" class.
import java.awt.*;
import hsa.Console;

public class UseCardClass
{
    static Console c;           // The output console

    public static void main (String[] args)
    {
	c = new Console ();
	DelayClass delay = new DelayClass ();

	CardClass cardObject = new CardClass (true);
	//cardObject.draw (c);
	cardObject.setCentre (300, 250);
	cardObject.draw (c);
	//cardObject.setCentre (300, 250);
	//cardObject.draw (c);
	//c.println (cardObject.getCentreX ());
	//c.println (cardObject.getCentreY ());
	//c.println (cardObject.getHeight ());
	//c.println (cardObject.getWidth ());
	c.println ("wait");
	delay.delay (1000);
	//cardObject.erase (c);

	c.println ("done");
	// Place your program here.  'c' is the output console
    } // main method
} // UseCardClass class
