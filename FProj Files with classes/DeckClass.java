// The "DeckClass" class.
import java.awt.*;
import hsa.Console;
import java.util.*;                                         // Vector class is in the 'util'  package

public class DeckClass                                      // This is a Deck class.
{
    private Vector deck = new Vector (0, 1);                // Instansiate a vector with a size of 0 and grows by 1.


    public DeckClass ()                                     // This is the default constructor.
    {
    }


    public DeckClass (char deckType)                        // This is an overloaded constructor.
    {
	if (deckType == "s")                                // If the type of deck is a standard deck of 52 cards, then add 52 cards to the deck.
	{

	}
    }


    public void addCard (CardClass aCardToAdd, int pos)     // This is a method to add a card.
    {
	if (deck.isEmpty ())                                // If the deck is empty, then just add the card(s) to deck from the beginning.
	{
	    deck.add (0, aCardToAdd);
	}
	else                                                // Just add the card(s) to the top of deck.
	{
	}
    }


    public void removeCard (CardClass aCardToAdd, int pos)  // This is a method to remove a card.
    {
    }


    public CardClass dealCard (int pos)                     // This is a method to deal a card out.
    {
	return CardClass;
    }


    public void shuffleDeck ()                              // This is a method to shuffle the deck
    {
    }
} // DeckClass class

