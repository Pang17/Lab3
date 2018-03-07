package pkgCore;
import pkgEnum.*;
import java.util.ArrayList;
import java.util.Collections;

public class Hand {

	private int iScore = 0;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public int ScoreHand()
	{	
		
		for (Card c: cards)
		{
			if ((c.geteRank() == eRank.ACE) && (iScore > 10) ) {
				iScore += 1;
			} else {
				iScore += c.geteRank().getiRankNbr();
			}
		}
		
		return iScore;
	}
	
	public void Draw(Deck d) throws Exception
	{
		cards.add(d.draw());
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
	
}
