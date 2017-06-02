// The "DeckClass" class.
import java.awt.*;
import hsa.Console;
import java.util.*;                                         // Vector class is in the 'util'  package

public class DeckClass                                      // This is a Deck class.
{
    private Vector deck = new Vector (0, 1);                // Instansiate a vector that has a size of 0 and grows by 1.


    public DeckClass ()                                     // This is the default costructor.
    {
    }


    public DeckClass (char deckType)
    {
	if (deckType == "s")                                // If the type of deck is a standard deck of 52 cards, then add 52 cards to the deck.
	{

	}
    }


    public addCard (CardClass aCardToAdd, int pos)
    {

    }
} // DeckClass class

