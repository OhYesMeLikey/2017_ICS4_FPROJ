// The "SuitClass" class.
import java.awt.*;
import hsa.Console;

public abstract class SuitClass extends ShapeClass                                              // SuitClass inherits ShapeClass.
{
    private int suitValue;                                                                      // Initialize encapsulated data,

    public SuitClass ()                                                                         // This is the default constructor that initializes default values to the encapsulated data.
    {
	super ();
	suitValue = 1;
	setHeight (50);
	setWidth (40);
    }


    public SuitClass (int newSuitValue)                                                         // This is an overloaded constructor.
    {
	super ();
	setSuitValue (newSuitValue);
	setHeight (50);
	setWidth (40);
    }


    public SuitClass (int newCX, int newCY, int newW, int newH, Color newC, boolean isFilled)   // This is another overloaded constructor.
    {
	super (newCX, newCY, newW, newH, newC, isFilled);
    }


    public void setSuitValue (int newSuitValue)                                                 // This is "set" method to set the value of a suit.
    {
	if ((newSuitValue >= 1 && newSuitValue <= 4) || (newSuitValue == 0))                    // This validates the data to see if I am allowed to changed the suit value of the shape.
	{
	    suitValue = newSuitValue;
	}
    }


    public int getSuitValue ()                                                                  // This is a "get" method to return the value of the suit.
    {
	return suitValue;
    }


    public void setHeight (int newHeight)                                                       // This is a "set" method to set the height (and width) of the shape.
    {
	super.setHeight (newHeight);
	super.setWidth ((newHeight * 4) / 5);
    }


    public void setWidth (int newWidth)                                                         // This is a "set" method to set the width (and height) of the shape.
    {
	super.setWidth (newWidth);
	super.setHeight ((newWidth * 5) / 4);
    }


    public void setColour (Color newColor)                                                      // This a "set" method to not set the colour of the shape.
    {
    }


    public abstract void draw (Console c);                                                      // This allows overriding of different types of draw methods using Console.
    public abstract void draw (Graphics g);                                                     // This allows overriding of different types of draw methods using Graphics.
} // SuitClass class
