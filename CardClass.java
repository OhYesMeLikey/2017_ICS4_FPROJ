// The "CardClass" class.
import java.awt.*;
import hsa.Console;

// CardClass inherits ShapeClass
public class CardClass extends ShapeClass
{
    // Initialize encapsulated data.
    private int cardFaceUp;
    private int cardSize;
    private int cardRankValue;
    private int cardSuit;

    private int previousX;
    private int previousY;

    private int previousDeckValue;

    // Default constructor
    public CardClass ()
    {
	cardFaceUp = 1;
	cardSize = 1;
	cardRankValue = 1;
	cardSuit = 1;

	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    // Overloaded constructor
    public CardClass (int newFaceUpOrDown)
    {
	setCardFaceUpOrDown (newFaceUpOrDown);

	cardSize = 1;
	cardRankValue = 1;
	cardSuit = 1;

	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    // Another overloaded constructor
    public CardClass (int newFaceUpOrDown, int newCardSize, int newCardRankValue, int newCardSuit)
    {
	setCardFaceUpOrDown (newFaceUpOrDown);
	setCardSize (newCardSize);
	setCardRankValue (newCardRankValue);
	setCardSuit (newCardSuit);
	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    // Another overloaded constructor
    public CardClass (int newCardSize, int newCardRankValue, int newCardSuit)
    {
	setCardFaceUpOrDown (1);
	setCardSize (newCardSize);
	setCardRankValue (newCardRankValue);
	setCardSuit (newCardSuit);
	setHeight (60);
	setWidth ((int) (getHeight () * 0.7));
    }


    // A set method that sets the following variable(s) with value(s) from the parameter(s) that sets the following variables with values from the parameters.
    public void setPrevious (int oldX, int oldY, int oldDeck)
    {
	previousX = oldX;
	previousY = oldY;
	previousDeckValue = oldDeck;
    }


    // A get method that returns the value of the previousX.
    public int getPreviousX ()
    {
	return previousX;
    }


    // A get method that returns the value of the previousY.
    public int getPreviousY ()
    {
	return previousY;
    }


    // A get method that returns the value of the previousDeckValue.
    public int getPreviousDeckValue ()
    {
	return previousDeckValue;
    }


    // A set method that sets the card to be faced up or down.
    public void setCardFaceUpOrDown (int newFaceUpOrDown)
    {
	// Data validation
	if (newFaceUpOrDown == 1)
	{
	    // Set the card to be faced up.
	    cardFaceUp = 1;
	}
	// Data validation
	else if (newFaceUpOrDown == 0)
	{
	    // Set the card to be face down.
	    cardFaceUp = 0;
	}
    }


    // A get method that returns whether the card is faced up or down.
    public int getCardFaceUpOrDown ()
    {
	return cardFaceUp;
    }


    // A set method that sets the size of the card.
    public void setCardSize (int newCardSize)
    {
	// Data validation
	if (newCardSize >= 1 && newCardSize <= 4)
	{
	    // Set the size of the card from the value of the parameter.
	    cardSize = newCardSize;
	}
	else
	{
	    // Set the size of the card to 1.
	    cardSize = 1;
	}
    }


    // A get method that returns the value of the size of the card.
    public int getCardSize ()
    {
	return cardSize;
    }


    // A set method that sets the rank value of the card.
    public void setCardRankValue (int newCardRankValue)
    {
	// Data validation
	if (newCardRankValue >= 1 && newCardRankValue <= 13)
	{
	    // Set the rank value of the card from the value of the parameter.
	    cardRankValue = newCardRankValue;
	}
	else
	{
	    // Set the rank value of the card to 1.
	    cardRankValue = 1;
	}
    }


    // A get method that returns the rank value of the card.
    public int getCardRankValue ()
    {
	return cardRankValue;
    }


    // A set method that sets the suit of the card.
    public void setCardSuit (int newCardSuit)
    {
	// Data validation
	if (newCardSuit >= 1 && newCardSuit <= 4)
	{
	    // Set the suit of the card to the value of the parameter.
	    cardSuit = newCardSuit;
	}
	else
	{
	    // Set the suit of the card to 1.
	    cardSuit = 1;
	}
    }


    // A get method that returns the suit value of the card.
    public int getCardSuit ()
    {
	return cardSuit;
    }


    public void flipCard ()
    {
	if (cardFaceUp == 1)
	{
	    cardFaceUp = 0;
	}
	else
	{
	    cardFaceUp = 1;
	}
    }


    // A method that reizes the width and height of the card.
    public void resizeCard ()
    {
	if (cardSize == 1)
	{
	    setHeight (60);
	}
	else if (cardSize == 2)
	{
	    setHeight (80);
	}
	else if (cardSize == 3)
	{
	    setHeight (100);
	}
	else if (cardSize == 4)
	{
	    setHeight (120);
	}
	setWidth ((int) (getHeight () * 0.7));
    }


    // A method that returns the size of the rank value of the card.
    public int resizeText ()
    {
	if (cardSize == 1 || cardSize == 2)
	{
	    return 15;
	}
	else if (cardSize == 3 || cardSize == 4)
	{
	    return 20;
	}
	else
	{
	    return 15;
	}
    }


    // A draw method that either draws a blank or coloured card.
    public void drawCard (Console c)
    {
	resizeCard ();

	int x1 = getCentreX () - (getWidth () / 2);
	int y1 = getCentreY () - (getHeight () / 2);

	c.setColour (getColour ());
	if (cardSuit >= 1 && cardSuit <= 4)
	{
	    cardFaceUp = 1;
	    c.drawRect (x1, y1, getWidth (), getHeight ());
	}
	else if (cardSuit == 0)
	{
	    cardFaceUp = 0;
	    c.fillRect (x1, y1, getWidth (), getHeight ());
	}
    }


    // A draw method that draws the rank value of the card.
    public void drawText (Console c)
    {
	// Instansiate the Font Class.
	Font f1 = new Font ("SanSerif", Font.PLAIN, resizeText ());

	// Set the font.
	c.setFont (f1);

	// Create the positions of the text of the card value.
	int xPosOfText = (int) (getCentreX () - (getWidth () / 2) + 2);
	int yPosOfText = (int) (getCentreY () - (getHeight () / 2) + 15);

	c.drawString (Integer.toString (cardRankValue), xPosOfText, yPosOfText);
    }


    // A draw method that draws the suit of the card.
    public void drawSuit (Console c)
    {
	// Initialize variables with values to can be used to draw a suit.
	int suitWidth = (int) (getHeight () * 0.25);
	int suitHeight = (int) (getHeight () * 0.25);
	int suitCX = getCentreX () + (getWidth () / 4);
	int suitCY = getCentreY () - (getHeight () / 2) + (suitWidth / 2);
	Color suitColour = getColour ();
	boolean suitIsFilled = getFilled ();

	// Check to see if I can change the suit colour of the card, and this applies to the suit colours of a diamond (1) and a heart (3).
	if (cardSuit == 1 || cardSuit == 3)
	{
	    // Check to see if the suit is being drawn, and if it's being drawn, then change the colour of the suit.
	    if (suitColour != Color.white)
	    {
		suitColour = Color.red;
	    }
	}


	if (cardSuit == 1)
	{
	    DiamondClass diamondObject = new DiamondClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    diamondObject.draw (c);
	}


	else if (cardSuit == 2)
	{
	    ClubClass clubObject = new ClubClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    clubObject.draw (c);
	}


	else if (cardSuit == 3)
	{
	    HeartClass heartObject = new HeartClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    heartObject.draw (c);
	}


	else if (cardSuit == 4)
	{
	    SpadeClass spadeObject = new SpadeClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    spadeObject.draw (c);
	}
    }


    // Overloaded draw method
    public void draw (Console c)
    {

    }


    // A method that uses all the previous stated draws method to draw the entire the card.
    public void draw (Graphics g)
    {
	drawCard (g);

	if (cardFaceUp == 1)
	{
	    // Draw the rest of card if the card is faced up.
	    drawText (g);
	    drawSuit (g);
	}
    }


    // Overloaded draw method
    public void drawCard (Graphics g)
    {
	resizeCard ();

	int x1 = getCentreX () - (getWidth () / 2);
	int y1 = getCentreY () - (getHeight () / 2);

	g.setColor (getColour ());

	if (cardSuit >= 1 && cardSuit <= 4)
	{
	    cardFaceUp = 1;
	    g.drawRect (x1, y1, getWidth (), getHeight ());
	}
	else if (cardSuit == 0)
	{
	    cardFaceUp = 0;
	    g.fillRect (x1, y1, getWidth (), getHeight ());
	}
    }


    // Overloaded draw method
    public void drawText (Graphics g)
    {
	Font f1 = new Font ("SanSerif", Font.PLAIN, resizeText ());
	g.setFont (f1);
	int xPosOfText = (int) (getCentreX () - (getWidth () / 2) + 2);
	int yPosOfText = (int) (getCentreY () - (getHeight () / 2) + 15);
	g.drawString (Integer.toString (cardRankValue), xPosOfText, yPosOfText);
    }


    // Overloaded draw method
    public void drawSuit (Graphics g)
    {
	int suitWidth = (int) (getHeight () * 0.25);
	int suitHeight = (int) (getHeight () * 0.25);
	int suitCX = getCentreX () + (getWidth () / 4);
	int suitCY = getCentreY () - (getHeight () / 2) + (suitWidth / 2);
	Color suitColour = getColour ();
	boolean suitIsFilled = getFilled ();

	if (cardSuit == 1 || cardSuit == 3)
	{
	    if (suitColour != Color.white)
	    {
		suitColour = Color.red;
	    }
	}


	if (cardSuit == 1)
	{
	    DiamondClass diamondObject = new DiamondClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    diamondObject.draw (g);
	}
	else if (cardSuit == 2)
	{
	    ClubClass clubObject = new ClubClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    clubObject.draw (g);
	}
	else if (cardSuit == 3)
	{
	    HeartClass heartObject = new HeartClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    heartObject.draw (g);
	}
	else if (cardSuit == 4)
	{
	    SpadeClass spadeObject = new SpadeClass (suitCX, suitCY, suitWidth, suitHeight, suitColour, suitIsFilled);
	    spadeObject.draw (g);
	}
    }


    // Checks to see if the mouse click is inside the card.
    public boolean isPointInside (int px, int py)
    {
	// Checks to see if the mouse click x is in range of the width of the deck.
	if ((px >= getCentreX () - (getWidth () / 2)) && (px <= getCentreX () + (getWidth () / 2)))
	{
	    //Checks to see if the mouse click y is in range of the height of the deck.
	    if ((py >= getCentreY () - (getHeight () / 2)) && (py <= getCentreY () + (getHeight () / 2)))
	    {
		return true;
	    }
	    else
	    {
		return false;
	    }
	}
	else
	{
	    return false;
	}
    } // CardClass class
}


