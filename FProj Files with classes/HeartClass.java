import hsa.Console;
import java.awt.*;

public class HeartClass extends SuitClass                                                       // This is a Heart class inherits SuitClass.
{
    public HeartClass ()                                                                        // This is the default constructor which sets the colour of the club to red and to be filled..
    {
	setColour (Color.red);
	setFilled (true);
    }


    public HeartClass (int newCX, int newCY, int newW, int newH, Color newC, boolean isFilled)  // This is an overloaded constructor which calls its super class constructor to set the values of the variables.
    {
	super (newCX, newCY, newW, newH, newC, isFilled);
    }


    public void draw (Console c)                                                                // This is a "draw" method to draw a heart.
    {
	int iPointsX[] = new int [5];                                                           // Instansiate two new arrays of 5 integers.
	int iPointsY[] = new int [5];                                                           //

	iPointsX [0] = getCentreX () - getWidth () / 2;                                         // Calculate the points for the heart, and store them in the arrays.
	iPointsY [0] = getCentreY ();                                                           //
	iPointsX [1] = getCentreX () + getWidth () / 2;                                         //
	iPointsY [1] = getCentreY ();                                                           //
	iPointsX [2] = getCentreX ();                                                           //
	iPointsY [2] = getCentreY () + getHeight () / 2;                                        //
	iPointsX [3] = getCentreX () - getWidth () / 2;                                         //
	iPointsY [3] = getCentreY () - getHeight () / 4;                                        //
	iPointsX [4] = getCentreX ();                                                           //
	iPointsY [4] = getCentreY () - getHeight () / 4;                                        //

	c.setColor (getColour ());                                                              // Set the colour of the heart.


	if (getFilled ())                                                                       // If the heart is set to be filled, then draw a filled heart.
	{
	    c.fillArc (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2, 0, 180);
	    c.fillArc (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2, 0, 180);
	    c.fillPolygon (iPointsX, iPointsY, 3);
	}
	else                                                                                    // Just draw a heart that is not filled.
	{
	    c.drawArc (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2, 0, 180);
	    c.drawArc (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2, 0, 180);
	    c.drawPolygon (iPointsX, iPointsY, 3);
	}
    }


    public void draw (Graphics g)                                                               // This is an overloaded draw method.
    {
    }
}
