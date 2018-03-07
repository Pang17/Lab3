package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void TestDeck() {
		//	TODO: Build a deck(1), make sure there are 52 cards in the deck
		Deck d1 = new Deck(1);
		if (d1.getDeck().size() == 52) 
		{
			
		}
		else
		{
			fail("Size of deck is incorrect");
		}
		//	TODO: Build a deck(6), make sure there are 312 cards in the deck
		Deck d2 = new Deck(6);
		if (d2.getDeck().size() == 312) 
		{
			
		}
		else
		{
			fail("Size of deck is incorrect");
		}
	}

}
