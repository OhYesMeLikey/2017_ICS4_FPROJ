// The "ShapeClass" class.
import java.awt.*;
import hsa.Console;

public abstract class ShapeClass                                                                // This is a Shape class.
{
    private int shapeCentreX;                                                                   // Initialize encapsulated data, with no values, for this class.
    private int shapeCentreY;                                                                   //
    private int shapeWidth;                                                                     //
    private int shapeHeight;                                                                    //
    private Color shapeColour;                                                                  //
    private boolean shapeFilled;                                                                //

    public ShapeClass ()                                                                        // This is the default constructor that initializes the encapsulated data with values.
    {
	shapeCentreX = 100;
	shapeCentreY = 100;
	shapeWidth = 50;
	shapeHeight = 50;
	shapeColour = Color.black;
	shapeFilled = true;
    }


    public ShapeClass (int newCX, int newCY, int newW, int newH, Color newC, boolean isFilled)  // This is an overloaded constructor.
    {
	shapeCentreX = newCX;
	shapeCentreY = newCY;
	shapeWidth = newW;
	shapeHeight = newH;
	shapeColour = newC;
	shapeFilled = isFilled;
    }


    public void setCentre (int iNewCentreX, int iNewCentreY)                                    // This is a "set" method to set the centre of the shape.
    {
	shapeCentreX = iNewCentreX;
	shapeCentreY = iNewCentreY;
    }


    public void setCentreX (int iNewCentreX)                                                    // This is a "set" method to set the centre x of the shape.
    {
	shapeCentreX = iNewCentreX;
    }


    public int getCentreX ()                                                                    // This is a "get" method to return the centre x of the shape.
    {
	return shapeCentreX;
    }


    public void setCentreY (int iNewCentreY)                                                    // This is a "set" method to set the centre y of the shape.
    {
	shapeCentreY = iNewCentreY;
    }


    public int getCentreY ()                                                                    // This is a "get" method to return the centre y of the shape.
    {
	return shapeCentreY;
    }


    public void setWidth (int iNewWidth)                                                        // This is a "set" method to set the width of the shape.
    {
	shapeWidth = iNewWidth;
    }


    public int getWidth ()                                                                      // This is a "get" method to return the width of the shape.
    {
	return shapeWidth;
    }


    public void setHeight (int iNewHeight)                                                      // This is a "set" method to set the heighr of the shape.
    {
	shapeHeight = iNewHeight;
    }


    public int getHeight ()                                                                     // This is a "get" method to return the height of the shape.
    {
	return shapeHeight;
    }


    public void setColour (Color cNewColor)                                                     // This is a "set" method to set the colour of the shape.
    {
	shapeColour = cNewColor;
    }


    public Color getColour ()                                                                   // This is a "get" method to return the colour of the shape.
    {
	return shapeColour;
    }


    public void setFilled (boolean newfilled)                                                   // This is a "set" method to set the shape to be filled or not.
    {
	shapeFilled = newfilled;
    }


    public boolean getFilled ()                                                                 // This is a "get" method to return if the shape is filled or not.
    {
	return shapeFilled;
    }


    public void erase (Console c)                                                               // This is an "erase" method which erases a shape object using Console.
    {
	Color cOldColor = getColour ();                                                         // Create a temporary variable to store the current colour which is used to recover back the colour.
	setColour (Color.white);                                                                // Set the current colour to white.
	draw (c);                                                                               // Draw the object.
	setColour (cOldColor);                                                                  // Revert the current colour to the original colour.
    }


    public void erase (Graphics g)                                                              // This is an overloaded erase method.
    {
	Color cOldColor = getColour ();                                                         // Create a temporary variable to store the current colour which is used to recover back the colour.
	setColour (Color.white);                                                                // Set the current colour to white.
	draw (g);                                                                               // Draw the object.
	setColour (cOldColor);                                                                  // Revert the current colour to the original colour.
    }


    public abstract void draw (Console c);                                                      // This allows overriding of different types of draw methods using Console.
    public abstract void draw (Graphics g);                                                     // This allows overriding of different types of draw methods using Graphics.
} // ShapeClass class
