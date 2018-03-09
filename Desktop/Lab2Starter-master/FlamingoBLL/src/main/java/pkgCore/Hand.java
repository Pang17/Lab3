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
	
	public int[] ScoreHand()
	{	
		int[] iScore = new int[2];
		iScore[0] = 0;
		iScore[1] = 0;
		
		Collections.sort(cards);
		
		boolean isAce = false;
		
		for (Card c: cards)
		{
			iScore[0] = iScore[0] + c.geteRank().getMin();
			if (c.geteRank() == eRank.ACE)
				isAce = true;
		}
		if (isAce)
			iScore[1] = iScore[0] + 10;
		else
			iScore[1] = iScore[0];
		setHandScore(iScore);
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
	
	public void setHandScore(int[] Scores) {
		this.iScore = Scores[0];
		if (Scores[1] <= 21)
			iScore = Scores[1];
	}
	
}
