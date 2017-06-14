// The "GolfSolitaire" class.
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import hsa.Console;
public class GolfSolitaire extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
    // Initializing an array of decks.
    DeckClass[] deckArray;

    private boolean drawFlag = true;
    private boolean firstMove = true;

    Graphics g;

    public void init ()
    {
	g = getGraphics (); // gets canvas created by browser-
	setSize (800, 500);

	deckArray = new DeckClass [10];

	addMouseListener (this);
	addMouseMotionListener (this);

	initializeAllDecks ();

    } // init method


    public void initializeAllDecks ()
    {
	// Deck 0 is the entire deck.
	deckArray [0] = new DeckClass ("standard");

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

	/* As long as the main deck is not empty, move the remaining cards from the main deck into the "stock" deck,
	// and set the centre of the "stock" deck.*/
	while (!deckArray [0].isEmpty ())
	{
	    deckArray [8].addCard (0, deckArray [0].deal ());
	    deckArray [8].cardAt (0).setCentre (deckArray [8].getCentreX (), deckArray [8].getCentreY ());
	}


	// Redraw the game.
	repaint ();
    }


    /* Draw all the required decks for the game.
    // All the 7 "piles", "stock", and "foundation" decks are drawn to the screen.
    // If that deck isn't empty, then draw the deck that correlates to the index 'i',
    // and draw the certain amount of cards that correlates to the index 'j'*/
    public void paint (Graphics g)
    {
	for (int i = 1 ; i < 10 ; i++)
	{
	    if (!deckArray [i].isEmpty ())
	    {
		for (int j = deckArray [i].deckSize () - 1 ; j > -1 ; j--)
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
	/*
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
	    */
    }


    /* When the mouse is pressed, check if it is clicking on the last card of a "pile" deck.
	// If Deck 0 is empty, then repeat the following 7 times.
	// If it is, then move that card into Deck 0 to temporarily hold it, as Deck 0 is no longer being used.
	// Else set the centre of the card to the centre of the mouse. */
    public void mousePressed (MouseEvent e)
    {
	/*
	    if (deckArray [0].isEmpty ())
	    {
		for (int i = 1 ; i < 8 ; i++)
		{
		    if (!deckArray [i].isEmpty ())
		    {
			if (deckArray [i].cardAt (deckArray [i].deckSize () - 1).isPointInside (e.getX (), e.getY ()))
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
	    */
    }


    public void mouseDragged (MouseEvent e)
    {
	/*
	    if (!deckArray [0].isEmpty ())
	    {
		deckArray [0].setCentre (e.getX (), e.getY ());
	    }
	    */
    }


    /* Move a valid card into the foundation's deck
    // Do the following checks for 8 times
    // On the first click, any card from any clicked deck will be moved into the foundation's deck.
    //   */

    public void mouseClicked (MouseEvent e)
    {
	for (int i = 1 ; i < 9 ; i++)
	{
	    if (deckArray [i].isPointInside (e.getX (), e.getY ()))
	    {
		if (firstMove)
		{
		    deckArray [9].addCard (deckArray [i].deal ());
		    firstMove = false;
		    System.out.println ("First move");
		    break;
		}
		else if (i == 8)
		{
		    //deckArray [9].cardAt (deckArray [i].deckSize () - 1).setCentre (deckArray [9].getCentreX (), deckArray [9].getCentreY ());
		    deckArray [9].addCard (deckArray [i].deal ());
		    System.out.println ("Stock deck");
		    break;
		}
		else if (i >= 1 && i <= 7)
		{
		    if (deckArray [i].isPointInside (e.getX (), e.getY ()))
		    {
			if (!deckArray [i].isEmpty () && !firstMove)
			{
			    if (deckArray [i].cardAt (deckArray [i].deckSize () - 1).isPointInside (e.getX (), e.getY ()))
			    {
				int pileValue = deckArray [i].cardAt (deckArray [i].deckSize () - 1).getCardRankValue ();
				int foundationValue = deckArray [9].cardAt (deckArray [i].deckSize () - 1).getCardRankValue ();

				if (Math.abs (pileValue - foundationValue) == 1)
				{
				    deckArray [9].cardAt (deckArray [i].deckSize () - 1).setCentre (deckArray [9].getCentreX (), deckArray [9].getCentreY ());
				    deckArray [9].addCard (deckArray [i].deal ());
				    System.out.println ("Pile " + i);
				    break;
				}
			    }
			}
		    }
		}
	    }
	    repaint ();
	}
    }


    /*
	public void mouseClicked (MouseEvent e)
	{
	    for (int i = 1 ; i < 9 ; i++)
	    {
		//deckArray [9].cardAt (deckArray [i].deckSize () - 1).setCentre (deckArray [9].getCentreX (), deckArray [9].getCentreY ());
		deckArray [9].addCard (deckArray [i].deal ());
		deckArray [i].deleteCard (deckArray [i].deckSize ());
		break;
	    }
	    repaint ();
	}
	*/


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


