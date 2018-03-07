package pkgCore;
import pkgEnum.*;
public class Card implements Comparable {
	
	private eRank rank;
	private eSuit suit;
	
	public Card(eRank r, eSuit s) {
		rank = r;
		suit = s;
	}
	
	public Card(eSuit s ,eRank r) {
		rank = r;
		suit = s;
	}
	
	public eRank geteRank() {
		return rank;
	}

	private void seteRank(eRank rank) {
		this.rank = rank;
	}

	public eSuit geteSuit() {
		return suit;
	}

	private void seteSuit(eSuit suit) {
		this.suit = suit;
	}
	
	@Override
	public int compareTo(Object o) {
		Card c = (Card) o;
		return c.geteRank().compareTo(this.geteRank());
	}
	
}
