// The "PilesClass" class.
import java.awt.*;
import hsa.Console;

public class PilesClass extends DeckClass
{
    int sizeInterval;

    public PilesClass ()
    {
	super ();
	sizeInterval = 20;
    }


    public PilesClass (char s, int newCX, int newCY)
    {

	super (s);
	sizeInterval = 20;

	if (s == 's')
	{
	    setCentre (newCX, newCY);


	}

    }
} // PilesClass class
