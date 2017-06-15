// The "DeckClass" class.
import java.awt.*;
import hsa.Console;
import java.util.*;

public class DeckClass extends ShapeClass
{
    // Initialize a vector.
    private Vector deck;

    // Default constructor
    public DeckClass ()
    {
	// Initialize encapsulated data with default values.
	super ();

	// Instansiate the deck with a size of 0 and increment the size by 1.
	deck = new Vector (0, 1);
    }


    // Overloaded constructor
    public DeckClass (String deckType)
    {
	// Initialize encapsulated data with default values.
	super ();

	// Create a standard deck of 52 cards.
	if (deckType.equals ("standard"))
	{
	    // Instansiate the deck with a size of 52 and does not increment.
	    deck = new Vector (52, 0);

	    // Assign the suit values for the cards.
	    for (int suitValue = 1 ; suitValue < 5 ; suitValue++)
	    {
		// Assign the rank values for the cards.
		for (int rankValue = 1 ; rankValue < 14 ; rankValue++)
		{
		    // Instansiate a card object by assigning it from the given rank and suit values.
		    CardClass card = new CardClass (1, 1, rankValue, suitValue);
		    addCard (card);
		}
	    }
	}
	// Create a deck of 5 random cards.
	else if (deckType.equals ("piles"))
	{
	    // Instansiate the deck with a size of 5 and does not increment.
	    deck = new Vector (5, 0);

	    // Create 5 random cards by assigning the card with random rank and suit values.
	    for (int i = 0 ; i < 5 ; i++)
	    {
		int randomRankValue = (int) (Math.random () * 14);
		int randomSuitValue = (int) (Math.random () * 4);
		CardClass card = new CardClass (1, 1, randomRankValue, randomSuitValue);
		addCard (card);
	    }
	}
	// Create a deck of 17 random cards.
	else if (deckType.equals ("stock"))
	{
	    // Instansiate the deck with a size of 17 and does not increment.
	    deck = new Vector (17, 0);

	    // Create 17 random cards by assigning the card with random rank and suit values.
	    for (int i = 0 ; i < 17 ; i++)
	    {
		int randomRankValue = (int) (Math.random () * 14);
		int randomSuitValue = (int) (Math.random () * 4);
		CardClass card = new CardClass (0, 1, randomRankValue, randomSuitValue);
		addCard (card);
	    }
	}
	shuffleDeck ();
    }


    // Checks if the deck is empty.
    public boolean isEmpty ()
    {
	return deck.isEmpty ();
    }


    // Returns the size of the deck.
    public int deckSize ()
    {
	return deck.size ();
    }


    // Add a card to the deck from the given position and a card.
    public void addCard (int givenPos, CardClass aCardToAdd)
    {
	deck.add (givenPos, aCardToAdd);
    }


    // Add a card to the end of the deck.
    public void addCard (CardClass aCardToAdd)
    {
	deck.add (aCardToAdd);
    }


    // Remove a card from the beginning of the deck.
    public void removeCard ()
    {
	deck.remove (0);
    }


    // Remove a card from the deck from the given position.
    public void removeCardFromPos (int pos)
    {
	deck.remove (pos);
    }


    // Returns a card from the end of the deck.
    public CardClass deal ()
    {
	return (CardClass) (deck.remove (deckSize () - 1));
    }


    // Checks to see if the mouse click is inside the deck.
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

    }


    // Shuffle the deck by taking a random card in the deck and putting it on top of the deck.
    public void shuffleDeck ()
    {
	for (int shuffleTimes = 0 ; shuffleTimes < deck.size () ; shuffleTimes++)
	{
	    deck.add (deck.size () - 1, (CardClass) (deck.remove ((int) (Math.random () * deck.size ()))));
	}
    }


    // Returns a card object from the given position.
    public CardClass cardAt (int pos)
    {
	if (!isEmpty ())
	{
	    if (pos < deckSize () && pos > -1)
	    {
		return (CardClass) (deck.elementAt (pos));
	    }
	    else
	    {
		return null;
	    }
	}
	else
	{
	    return null;
	}
    }


    // Overloaded draw method.
    public void draw (Console c)
    {
    }


    // Draws a deck.
    public void draw (Graphics g)
    {
	if (isEmpty ())
	{
	    g.setColor (Color.black);
	    g.drawRect (getCentreX (), getCentreY (), getHeight (), getWidth ());
	}
	else
	{
	    //g.setColor (Color.red);
	    //g.fillRect (getCentreX (), getCentreY (), getHeight (), getWidth ());
	    cardAt (deck.size () - 1).setCentre (getCentreX (), getCentreY ());
	    cardAt (deck.size () - 1).draw (g);
	}
    }
} // DeckClass class


