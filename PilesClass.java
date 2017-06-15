// The "PilesClass" class.
import java.awt.*;
import hsa.Console;

public class PilesClass extends DeckClass
{
    int sizeInterval;

    public PilesClass ()
    {
	super ("standard");
	sizeInterval = 20;
    }


    public PilesClass (String typeOfPile, int newCX, int newCY)
    {
	if (typeOfPile.equals ("piles"))
	{
	    super ("piles");
	    sizeInterval = 20;
	}
    }


    public void draw (Console c)
    {
    }


    public void draw (Graphics g)
    {
	for (int i = 0 ; i < 5 ; i++)
	{
	    cardAt [i].draw (g);
	}
    }
} // PilesClass class
