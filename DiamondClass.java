import java.awt.*;
import hsa.Console;

public class DiamondClass extends SuitClass                                                         // This is a Diamond class which inherits SuitClass.
{
    public DiamondClass ()                                                                          // This is the default constructor which sets the colour of the diamond to red and to be filled..
    {
	setColour (Color.red);
	setFilled (true);
    }


    public DiamondClass (int newCX, int newCY, int newW, int newH, Color newC, boolean isFilled)    // This is an overloaded constructor which calls its super class constructor to set the values of the variables.
    {
	super (newCX, newCY, newW, newH, newC, isFilled);
    }


    public void draw (Console c)                                                                    // This is a "draw" method to draw a diamond.
    {
	int iPointsX[] = new int [4];                                                               // Instansiate two new arrays of 4 integers.
	int iPointsY[] = new int [4];                                                               //

	iPointsX [0] = getCentreX () - getWidth () / 2;                                             // Calculate the points for the diamond, and store them in the arrays.
	iPointsY [0] = getCentreY ();                                                               //
	iPointsX [1] = getCentreX ();                                                               //
	iPointsY [1] = getCentreY () - getHeight () / 2;                                            //
	iPointsX [2] = getCentreX () + getWidth () / 2;                                             //
	iPointsY [2] = getCentreY ();                                                               //
	iPointsX [3] = getCentreX ();                                                               //
	iPointsY [3] = getCentreY () + getHeight () / 2;                                            //

	c.setColor (getColour ());                                                                  // Set the colour of the diamond.

	if (getFilled ())                                                                           // If the diamond is set to be filled, then draw a filled diamond.
	{
	    c.fillPolygon (iPointsX, iPointsY, 4);
	}
	else
	{
	    c.drawPolygon (iPointsX, iPointsY, 4);                                                  // Just draw a diamond that is not filled.
	}
    }


    public void draw (Graphics g)                                                                   // This is an overloaded draw method.
    {
    }
}
