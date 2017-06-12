import hsa.Console;
import java.awt.*;

class SpadeClass extends SuitClass                                                              // This is a Spade class which inherits SuitClass.
{
    public SpadeClass ()                                                                        // This is the default constructor which sets the colour of the spade to black and to be filled..
    {
	setColour (Color.black);
	setFilled (true);
    }


    public SpadeClass (int newCX, int newCY, int newW, int newH, Color newC, boolean isFilled)  // This is an overloaded constructor which calls its super class constructor to set the values of the parameters.
    {
	super (newCX, newCY, newW, newH, newC, isFilled);
    }


    public void draw (Console c)                                                                // This is a "draw" method to draw a spade.
    {
	int iPointsX[] = new int [5];                                                           // Instansiate two new arrays of 5 integers.
	int iPointsY[] = new int [5];                                                           //

	iPointsX [0] = getCentreX () - getWidth () / 2;                             // Calculate the points for the spade, and store them in the arrays.
	iPointsY [0] = getCentreY ();                                                     //
	iPointsX [1] = getCentreX () + getWidth () / 2;                             //
	iPointsY [1] = getCentreY ();                                                     //
	iPointsX [2] = getCentreX ();                                                     //
	iPointsY [2] = getCentreY () - getHeight () / 2;                            //
	iPointsX [3] = getCentreX () - getWidth () / 2;                             //
	iPointsY [3] = getCentreY () - getHeight () / 4;                            //
	iPointsX [4] = getCentreX ();                                                     //
	iPointsY [4] = getCentreY () - getHeight () / 4;                            //

	int triPointsX[] = new int [3];                                                         // Instansiate two new arrays of 3 integers.
	int triPointsY[] = new int [3];                                                         //

	triPointsX [0] = getCentreX ();                                                   // Calculate the points for the spade, and store them in the arrays.
	triPointsY [0] = getCentreY ();                                                   //
	triPointsX [1] = getCentreX () - getWidth () / 8;                           //
	triPointsY [1] = getCentreY () + getHeight () / 2;                          //
	triPointsX [2] = getCentreX () + getWidth () / 8;                           //
	triPointsY [2] = getCentreY () + getHeight () / 2;                          //

	c.setColor (getColour ());                                                        // Set the colour of the spade.

	if (getFilled ())                                                                       // If the spade is set to be filled, then draw a filled spade.
	{
	    c.fillArc (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2, 180, 180);
	    c.fillArc (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2, 180, 180);
	    c.fillPolygon (iPointsX, iPointsY, 3);
	    c.fillPolygon (triPointsX, triPointsY, 3);
	}
	else                                                                                    // Just draw a spade that is not filled.
	{
	    c.drawArc (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2, 180, 180);
	    c.drawArc (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2, 180, 180);
	    c.drawPolygon (iPointsX, iPointsY, 3);
	    c.drawPolygon (triPointsX, triPointsY, 3);
	}
    }


    public void draw (Graphics g)                                                               // This is an overloaded draw method.
    {
	int iPointsX[] = new int [5];                                                           // Instansiate two new arrays of 5 integers.
	int iPointsY[] = new int [5];                                                           //

	iPointsX [0] = getCentreX () - getWidth () / 2;                             // Calculate the points for the spade, and store them in the arrays.
	iPointsY [0] = getCentreY ();                                                     //
	iPointsX [1] = getCentreX () + getWidth () / 2;                             //
	iPointsY [1] = getCentreY ();                                                     //
	iPointsX [2] = getCentreX ();                                                     //
	iPointsY [2] = getCentreY () - getHeight () / 2;                            //
	iPointsX [3] = getCentreX () - getWidth () / 2;                             //
	iPointsY [3] = getCentreY () - getHeight () / 4;                            //
	iPointsX [4] = getCentreX ();                                                     //
	iPointsY [4] = getCentreY () - getHeight () / 4;                            //

	int triPointsX[] = new int [3];                                                         // Instansiate two new arrays of 3 integers.
	int triPointsY[] = new int [3];                                                         //

	triPointsX [0] = getCentreX ();                                                   // Calculate the points for the spade, and store them in the arrays.
	triPointsY [0] = getCentreY ();                                                   //
	triPointsX [1] = getCentreX () - getWidth () / 8;                           //
	triPointsY [1] = getCentreY () + getHeight () / 2;                          //
	triPointsX [2] = getCentreX () + getWidth () / 8;                           //
	triPointsY [2] = getCentreY () + getHeight () / 2;                          //

	g.setColor (getColour ());                                                        // Set the colour of the spade.

	if (getFilled ())                                                                       // If the spade is set to be filled, then draw a filled spade.
	{
	    g.fillArc (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2, 180, 180);
	    g.fillArc (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2, 180, 180);
	    g.fillPolygon (iPointsX, iPointsY, 3);
	    g.fillPolygon (triPointsX, triPointsY, 3);
	}
	else                                                                                    // Just draw a spade that is not filled.
	{
	    g.drawArc (iPointsX [3], iPointsY [3], getWidth () / 2, getHeight () / 2, 180, 180);
	    g.drawArc (iPointsX [4], iPointsY [4], getWidth () / 2, getHeight () / 2, 180, 180);
	    g.drawPolygon (iPointsX, iPointsY, 3);
	    g.drawPolygon (triPointsX, triPointsY, 3);
	}
    }
}
