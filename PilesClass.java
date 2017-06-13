// The "PilesClass" class.
import java.awt.*;
import hsa.Console;

public class PilesClass extends DeckClass
{
    int sizeInterval;

    public PilesClass ()
    {
	super ('s');
	sizeInterval = 20;
    }


    public PilesClass (char typeOfPile, int newCX, int newCY)
    {

	super ('s');
	sizeInterval = 20;

	if (typeOfPile == 's')
	{
	    setCentre (newCX, newCY);


	}

    }
} // PilesClass class
