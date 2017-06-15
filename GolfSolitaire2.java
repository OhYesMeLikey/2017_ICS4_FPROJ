// The "GolfSolitaire" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import hsa.Console;
public class GolfSolitaire2 extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    // Initializing three different types of decks.
    DeckClass[] pilesDeck;
    DeckClass stockDeck;
    DeckClass foundationDeck;

    // Initialize boolean variables.
    private boolean drawFlag = true;
    private boolean firstMove = true;
    private int intervalSize = 20;

    Graphics g;

    public void init ()
    {
	g = getGraphics ();
	setSize (800, 500);

	// Instansiating the three previous decks.
	pilesDeck = new DeckClass [7];
	stockDeck = new DeckClass ("stock");
	foundationDeck = new DeckClass ();

	addMouseListener (this);
	addMouseMotionListener (this);

	initializeAllDecks ();
    } // init method


    public void initializeAllDecks ()
    {
	// Set the position of all of the 7 pilesDeck.
	for (int i = 0 ; i < 7 ; i++)
	{
	    pilesDeck [i] = new DeckClass ("piles");
	    pilesDeck [i].setCentre (100 * i + 100, 100);
	}

	// Set the position of all the cards in the 7 pilesDeck.
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 5 ; j++)
	    {
		pilesDeck [i].cardAt (j).setCentre (pilesDeck [i].getCentreX (), pilesDeck [i].getCentreY () + (j * intervalSize));
	    }
	}

	// Set the position of the stockDeck.
	stockDeck.setCentre (100, 300);

	// Set the position of the foundationDeck.
	foundationDeck.setCentre (300, 300);

	// Redraw the game.
	repaint ();
    }


    /* Draw all the required decks for the game.
    // All the 7 "piles", "stock", and "foundation" decks are drawn to the screen.
    // If that deck isn't empty, then draw the deck that correlates to the index 'i',
    // and draw the certain amount of cards that correlates to the index 'j'*/
    public void paint (Graphics g)
    {
	if (drawFlag)
	{
	    // Draw all of the cards of the 7 piles deck.
	    for (int i = 0 ; i < 7 ; i++)
	    {
		if (!pilesDeck [i].isEmpty ())
		{
		    for (int j = 0 ; j < 5 ; j++)
		    {
			pilesDeck [i].cardAt (j).draw (g);
		    }
		}
	    }

	    // Draw the stock deck.
	    stockDeck.draw (g);

	    // Draw the foundation deck.
	    foundationDeck.draw (g);
	}
	else
	{
	    // Erase all of the cards of the 7 piles deck.
	    for (int i = 0 ; i < 7 ; i++)
	    {
		if (!pilesDeck [i].isEmpty ())
		{
		    for (int j = 0 ; j < 5 ; j++)
		    {
			pilesDeck [i].cardAt (j).draw (g);
		    }
		}
	    }

	    // Draw the stock deck.
	    stockDeck.erase (g);
	}
    }


    public void mouseClicked (MouseEvent e)
    {
	/*
	    // Check if the mouse was clicked in any of the 7 piles deck.
	    for (int i = 0 ; i < 7 ; i++)
	    {
		if (pilesDeck [i].isPointInside (e.getX (), e.getY ()))
		{
		    // Check if the mouse was clicked in any of the cards from that piles deck.
		    for (int j = 0 ; j < 5 ; j++)
		    {
			if (pilesDeck [i].cardAt (pilesDeck [i].deckSize () - 1).isPointInside (e.getX (), e.getY ()))
			{
			    if (firstMove)
			    {
				foundationDeck.addCard (pilesDeck [i].cardAt (pilesDeck [i].deckSize () - 1));
				foundationDeck.cardAt ((foundationDeck.deckSize () - 1)).setCentre (300, 300);
				pilesDeck [i].removeCardFromPos (pilesDeck [i].deckSize () - 1);
				System.out.println ("piles decks " + i);
				firstMove = false;
			    }
			    //else
			    {
			    }
			}

		    }
		}
	    }
	    */

	// Check if the mouse was clicked in the stock deck.
	if (stockDeck.isPointInside (e.getX (), e.getY ()))
	{
	    // Add a card to the foundation deck by dealing a card from the stock deck.
	    foundationDeck.addCard (stockDeck.deal ());

	    // Set the centre of the added card.
	    foundationDeck.cardAt ((foundationDeck.deckSize () - 1)).setCentre (300, 300);

	    // Flip the added card.
	    foundationDeck.cardAt ((foundationDeck.deckSize () - 1)).flipCard ();
	    System.out.println ("stock deck");
	    System.out.println (stockDeck.deckSize () - 1);
	}

	repaint ();
    }


    /* When the mouse is released, check if it is on thegetCentreY() "foundations" deck.
    // If it is, then check if the dragged card can be placed on there.
    // If the "foundations" deck is empty, then put it on there,
    // Else if the value of the top card in the "foundations" deck is
    // one more or one less than the dragged card, then put it on top
    // of the "foundations" deck.
    // Else change back the centre of the dragged card back to its
    // original position, and put it back to to its original "pile"
    // deck. */
    public void mouseReleased (MouseEvent e)
    {
	/*
	    if (pilesDeck [9].isPointInside (e.getX (), e.getY ()))
	    {
		if (pilesDeck [9].isEmpty ())
		{
		    pilesDeck [9].addCard (pilesDeck [0].deal ());
		}
		else if (Math.abs (pilesDeck [0].cardAt (0).getCardRankValue () - pilesDeck [9].cardAt (0).getCardRankValue ()) == 1)
		{
		    pilesDeck [9].addCard (pilesDeck [0].deal ());
		}
		else
		{
		    pilesDeck [0].cardAt (0).setCentre (pilesDeck [0].cardAt (0).getPreviousX (), pilesDeck [0].cardAt (0).getPreviousY ());
		    pilesDeck [pilesDeck [0].cardAt (0).getPreviousDeckValue ()].addCard (pilesDeck [0].deal ());
		}
		System.out.println ("yes release");
	    }
	    */
    }


    /* When the mouse is pressed, check if it is clicking on the last card of a "pile" deck.
	// If Deck 0 is empty, then repeat the following 7 times.
	// If it is, then move that card into Deck 0 to temporarily hold it, as Deck 0 is no longer being used.
	// Else set the centre of the card to the centre of the mouse. */
    public void mousePressed (MouseEvent e)
    {
	/*
	    if (pilesDeck [0].isEmpty ())
	    {
		for (int i = 1 ; i < 8 ; i++)
		{
		    if (!pilesDeck [i].isEmpty ())
		    {
			if (pilesDeck [i].cardAt (pilesDeck [i].deckSize () - 1).isPointInside (e.getX (), e.getY ()))
			{
			    pilesDeck [0].addCard (pilesDeck [i].deal ());
			    pilesDeck [0].cardAt (0).setPrevious (e.getX (), e.getY (), i);
			    break;
			}
		    }
		}
	    }
	    else
	    {
		drawFlag = false;
		repaint ();
		pilesDeck [0].cardAt (0).setCentre (e.getX (), e.getY ());
		drawFlag = true;
		repaint ();
	    }
	    */
	for (int i = 0 ; i < 7 ; i++)
	{
	    if (!pilesDeck [i].isEmpty)
	    {
		if (pilesDeck [i].cardAt (pilesDeck [i].deckSize () - 1).isPointInside (e.getX (), e.getY ()))
		{
		}
	    }
	}
    }


    public void mouseDragged (MouseEvent e)
    {
	/*
	    if (!pilesDeck [0].isEmpty ())
	    {
		pilesDeck [0].setCentre (e.getX (), e.getY ());
	    }
	    */
    }


    public void mouseEntered (MouseEvent e)
    {
    }


    public void mouseExited (MouseEvent e)
    {

    }


    public void mouseMoved (MouseEvent e)
    {
    }


    public void actionPerformed (ActionEvent e)
    {
    }
} // GolfSolitaire class





