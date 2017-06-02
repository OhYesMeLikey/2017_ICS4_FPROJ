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

	iPointsX [0] = super.getCentreX () - super.getWidth () / 2;                             // Calculate the points for the spade, and store them in the arrays.
	iPointsY [0] = super.getCentreY ();                                                     //
	iPointsX [1] = super.getCentreX () + super.getWidth () / 2;                             //
	iPointsY [1] = super.getCentreY ();                                                     //
	iPointsX [2] = super.getCentreX ();                                                     //
	iPointsY [2] = super.getCentreY () - super.getHeight () / 2;                            //
	iPointsX [3] = super.getCentreX () - super.getWidth () / 2;                             //
	iPointsY [3] = super.getCentreY () - super.getHeight () / 4;                            //
	iPointsX [4] = super.getCentreX ();                                                     //
	iPointsY [4] = super.getCentreY () - super.getHeight () / 4;                            //

	int triPointsX[] = new int [3];                                                         // Instansiate two new arrays of 3 integers.
	int triPointsY[] = new int [3];                                                         //

	triPointsX [0] = super.getCentreX ();                                                   // Calculate the points for the spade, and store them in the arrays.
	triPointsY [0] = super.getCentreY ();                                                   //
	triPointsX [1] = super.getCentreX () - super.getWidth () / 8;                           //
	triPointsY [1] = super.getCentreY () + super.getHeight () / 2;                          //
	triPointsX [2] = super.getCentreX () + super.getWidth () / 8;                           //
	triPointsY [2] = super.getCentreY () + super.getHeight () / 2;                          //

	c.setColor (super.getColour ());                                                        // Set the colour of the spade.

	if (getFilled ())                                                                       // If the spade is set to be filled, then draw a filled spade.
	{
	    c.fillArc (iPointsX [3], iPointsY [3], super.getWidth () / 2, super.getHeight () / 2, 180, 180);
	    c.fillArc (iPointsX [4], iPointsY [4], super.getWidth () / 2, super.getHeight () / 2, 180, 180);
	    c.fillPolygon (iPointsX, iPointsY, 3);
	    c.fillPolygon (triPointsX, triPointsY, 3);
	}
	else                                                                                    // Just draw a spade that is not filled.
	{
	    c.drawArc (iPointsX [3], iPointsY [3], super.getWidth () / 2, super.getHeight () / 2, 180, 180);
	    c.drawArc (iPointsX [4], iPointsY [4], super.getWidth () / 2, super.getHeight () / 2, 180, 180);
	    c.drawPolygon (iPointsX, iPointsY, 3);
	    c.drawPolygon (triPointsX, triPointsY, 3);
	}
    }


    public void draw (Graphics g)                                                               // This is an overloaded draw method.
    {
    }
}
