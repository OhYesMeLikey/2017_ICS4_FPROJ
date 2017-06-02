import hsa.Console;
import java.awt.*;

class ClubClass extends SuitClass                                                               // ClubClass inherits SuitClass
{
    public ClubClass ()                                                                         // This is the default constructor which sets the colour of the club to black and to be filled..
    {
	setColour (Color.black);
	setFilled (true);
    }


    public ClubClass (int newCX, int newCY, int newW, int newH, Color newC, boolean isFilled)   // This is an overloaded constructor which calls its super class constructor to set the values of the variables.
    {
	super (newCX, newCY, newW, newH, newC, isFilled);
    }


    public void draw (Console c)                                                                // This is a "draw" method to draw a club.
    {
	int iPointsX[] = new int [5];                                                           // Instansiate two new arrays of 5 integers.
	int iPointsY[] = new int [5];                                                           //

	iPointsX [0] = getCentreX () - getWidth () / 2;                                         // Calculate the points for the club, and store them in the arrays.
	iPointsY [0] = getCentreY ();                                                           //
	iPointsX [1] = getCentreX () + getWidth () / 2;                                         //
	iPointsY [1] = getCentreY ();                                                           //
	iPointsX [2] = getCentreX ();                                                           //
	iPointsY [2] = getCentreY () - getHeight () / 2;                                        //
	iPointsX [3] = getCentreX () - getWidth () / 2;                                         //
	iPointsY [3] = getCentreY () - getHeight () / 4;                                        //
	iPointsX [4] = getCentreX ();                                                           //
	iPointsY [4] = getCentreY () - getHeight () / 4;                                        //

	int triPointsX[] = new int [3];                                                         // Instansiate two new arrays of 3 integers.
	int triPointsY[] = new int [3];                                                         //

	triPointsX [0] = getCentreX ();                                                         // Calculate the points for the club, and store them in the arrays.
	triPointsY [0] = getCentreY () - getHeight () / 4;                                      //
	triPointsX [1] = getCentreX () - getWidth () / 8;                                       //
	triPointsY [1] = getCentreY () + getHeight () / 2;                                      //
	triPointsX [2] = getCentreX () + getWidth () / 8;                                       //
	triPointsY [2] = getCentreY () + getHeight () / 2;                                      //

	c.setColor (getColour ());                                                              // Set the colour of the club.

	if (getFilled ())                                                                       // If the club is set to be filled, then draw a filled club.
	{
	    c.fillOval (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2);
	    c.fillOval (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2);
	    c.fillOval (getCentreX () - getWidth () / 4, getCentreY () - 4 * (getHeight () / 7), getWidth () / 2, getHeight () / 2);
	    c.fillPolygon (triPointsX, triPointsY, 3);
	}
	else                                                                                    // Just draw a club that is not filled.
	{
	    c.drawOval (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2);
	    c.drawOval (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2);
	    c.drawOval (getCentreX () - getWidth () / 4, getCentreY () - 4 * (getHeight () / 7), getWidth () / 2, getHeight () / 2);
	    c.drawPolygon (triPointsX, triPointsY, 3);
	}
    }


    public void draw (Graphics g)                                                               // This is an overloaded draw method.
    {
    }
}
