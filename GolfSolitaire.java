// The "GolfSolitaire" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import hsa.Console;
public class GolfSolitaire extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    /* Initialize 10 decks.
    // Index 0 is the main deck.
    // From index 1 - 7 are the piles deck.
    // Index 8 is stock deck.
    // Index 9 is foundations deck; this should be empty. */
    DeckClass[] deckArray;

    private boolean drawFlag = true;

    Graphics g;
    Console c;

    public void init ()
    {
	g = getGraphics (); // gets canvas created by browser-
	//c = new Console ();
	setSize (800, 500);

	deckArray = new DeckClass [10];

	addMouseListener (this);
	addMouseMotionListener (this);

	initializeAllDecks ();

    } // init method


    public void initializeAllDecks ()
    {
	// Deck 0 is the entire deck.
	deckArray [0] = new DeckClass ('s');

	// Initialize rest of the 9 decks to be empty.
	for (int i = 1 ; i < 10 ; i++)
	{
	    deckArray [i] = new DeckClass ();

	    // Set the initial postion for each deck.
	    if (i < 8)
	    {
		deckArray [i].setCentre (100 * i, 100);
	    }
	    else if (i == 8)
	    {
		deckArray [i].setCentre (100, 300);
	    }
	    else
	    {
		deckArray [i].setCentre (350, 300);
	    }
	}

	/* Move cards from main deck to other decks.
	// Move them into 7 "piles" decks.
	// Move 5 cards only.
	// Set the centre x of the card to be the same as the deck.
	// Increment the centre y of the card by 20 for each iteration. */
	for (int i = 1 ; i < 8 ; i++)
	{
	    for (int j = 0 ; j < 5 ; j++)
	    {
		deckArray [i].addCard (j, deckArray [0].deal ());
		deckArray [i].cardAt (j).setCentre (deckArray [i].getCentreX (), deckArray [i].getCentreY () + (j * 20));
	    }
	}

	// Move the remaining cards into the "stock" deck.
	// Set the centre of the "stock" deck.
	while (!deckArray [0].isEmpty ())
	{
	    deckArray [8].addCard (0, deckArray [0].deal ());
	    deckArray [8].cardAt (0).setCentre (deckArray [8].getCentreX (), deckArray [8].getCentreY ());
	}
	repaint ();
    }


    public void paint (Graphics g)
    {
	for (int i = 1 ; i < 10 ; i++)
	{
	    if (!deckArray [i].isEmpty ())
	    {
		for (int j = deckArray [i].cardsRemaining () - 1 ; j > -1 ; j--)
		{
		    if (drawFlag)
		    {
			deckArray [i].cardAt (j).draw (g);
		    }
		    else
		    {
			deckArray [i].cardAt (j).erase (g);
		    }
		}
	    }
	    else
	    {
		deckArray [i].draw (g);
	    }
	}
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
	if (deckArray [9].isPointInside (e.getX (), e.getY ()))
	{
	    if (deckArray [9].isEmpty ())
	    {
		deckArray [9].addCard (deckArray [0].deal ());
	    }
	    else if (Math.abs (deckArray [0].cardAt (0).getCardRankValue () - deckArray [9].cardAt (0).getCardRankValue ()) == 1)
	    {
		deckArray [9].addCard (deckArray [0].deal ());
	    }
	    else
	    {
		deckArray [0].cardAt (0).setCentre (deckArray [0].cardAt (0).getPreviousX (), deckArray [0].cardAt (0).getPreviousY ());
		deckArray [deckArray [0].cardAt (0).getPreviousDeckValue ()].addCard (deckArray [0].deal ());
	    }
	    System.out.println ("yes release");
	}
    }


    /* When the mouse is pressed, check if it is clicking on the last card of a "pile" deck.
	// If Deck 0 is empty, then repeat the following 7 times.
	// If it is, then move that card into Deck 0 to temporarily hold it, as Deck 0 is no longer being used.
	// Else set the centre of the card to the centre of the mouse. */
    public void mousePressed (MouseEvent e)
    {
	if (deckArray [0].isEmpty ())
	{
	    for (int i = 1 ; i < 8 ; i++)
	    {
		if (!deckArray [i].isEmpty ())
		{
		    if (deckArray [i].cardAt (deckArray [i].cardsRemaining () - 1).isPointInside (e.getX (), e.getY ()))
		    {
			deckArray [0].addCard (deckArray [i].deal ());
			deckArray [0].cardAt (0).setPrevious (e.getX (), e.getY (), i);
			break;
		    }
		}
	    }
	}
	else
	{
	    drawFlag = false;
	    repaint ();
	    deckArray [0].cardAt (0).setCentre (e.getX (), e.getY ());
	    drawFlag = true;
	    repaint ();
	}
    }


    public void mouseDragged (MouseEvent e)
    {
	if (!deckArray [0].isEmpty ())
	{
	    deckArray [0].setCentre (e.getX (), e.getY ());
	}
    }


    public void mouseClicked (MouseEvent e)
    {

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


