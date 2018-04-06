package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import pkgConstants.*;
import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;
	private HandScorePoker HSP;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}
	
	
	public HandScorePoker getHSP() {
		return (HandScorePoker) this.getHS();

	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScore ScoreHand() {

		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {
			HSP.seteHandStrength(eHandStrength.RoyalFlush);
		} else if (isStraightFlush()) {
			HSP.seteHandStrength(eHandStrength.StraightFlush);
		} else if (isFourOfAKind()) {
			HSP.seteHandStrength(eHandStrength.FourOfAKind);
		} else if (isFullHouse()) {
			HSP.seteHandStrength(eHandStrength.FullHouse);
		} else if (isFlush()) {
			HSP.seteHandStrength(eHandStrength.Flush);
		} else if (isStraight()) {
			HSP.seteHandStrength(eHandStrength.Straight);
		} else if (isThreeOfAKind()) {
			HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
		} else if (isTwoPair()) {
			HSP.seteHandStrength(eHandStrength.TwoPair);
		} else if (isPair()) {
			HSP.seteHandStrength(eHandStrength.Pair);
		} else if (isHighCard()) {
			HSP.seteHandStrength(eHandStrength.HighCard);
		}

		return HSP;
	}

	private boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;
		if (isStraightFlush() && super.getCards().get(0).geteRank() == eRank.ACE
				&& super.getCards().get(1).geteRank() == eRank.KING) {
			bIsRoyalFlush = true;
			HSP.seteHandStrength(eHandStrength.RoyalFlush);

		}
		return bIsRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;

		if (isFlush() && isStraight()) {
			bisStraightFlush = true;
			HSP.seteHandStrength(eHandStrength.StraightFlush);

		}
		return bisStraightFlush;
	}

	// TODO : Implement this method
	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;

		if (this.getCRC().size() == 2) {
			if (this.getCRC().get(0).getiCnt() == Constants.FOUR_OF_A_KIND) {
				bisFourOfAKind = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FourOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(super.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisFourOfAKind;
	}

	// TODO : Implement this method
	public boolean isFullHouse() {
		boolean bisFullHouse = false;

		if (CRC.size() == 2) {
			if ((CRC.get(0).getiCnt() == 3) && (CRC.get(1).getiCnt() == 2)) {
				bisFullHouse = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FullHouse);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(this.getCards().get(this.getCRC().get(1).getiCardPosition()));
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}

		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt) {
			bisFlush = true;

			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Flush);
			HSP.setHiCard(super.getCards().get(0));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			HSP.getKickers().remove(0);
			this.setHS(HSP);
		}

		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = true;
		int a = 0;
		Card highCard = null;
		highCard = super.getCards().get(0);

		if (super.getCards().get(0).geteRank() == eRank.ACE) {
			a = 1;
		}
		for (; a < super.getCards().size() - 1; a++) {
			if (super.getCards().get(a).geteRank().getiRankNbr() - 1 != super.getCards().get(a + 1).geteRank()
					.getiRankNbr()) {

				bisStraight = false;
			}
		}

		if ((super.getCards().get(0).geteRank() == eRank.ACE) && (super.getCards().get(1).geteRank() == eRank.KING)) {
			
		}
		else if ((super.getCards().get(1).geteRank() != eRank.FIVE) && (super.getCards().get(0).geteRank() == eRank.ACE)) {

			bisStraight = false;
		} else if ((super.getCards().get(1).geteRank() == eRank.FIVE)
				&& (super.getCards().get(0).geteRank() == eRank.ACE)) {
			highCard = super.getCards().get(1);
		}

		if (bisStraight) {
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Straight);
			HSP.setHiCard(highCard);
			HSP.setLoCard(null);
			HSP.setKickers(null);
			this.setHS(HSP);
		}

		return bisStraight;
	}

	// This is how to implement one of the 'counting' hand types. Testing to see if
	// there are three of the same rank.
	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;
		if (this.getCRC().size() == 3) {

			if (this.getCRC().get(0).getiCnt() == Constants.THREE_OF_A_KIND) {
				bisThreeOfAKind = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		if (CRC.size() == 3) {
			if ((CRC.get(0).getiCnt() == 2) && (CRC.get(1).getiCnt() == 2)) {
				bisTwoPair = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.TwoPair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		if (CRC.size() == 4) {
			if (CRC.get(0).getiCnt() == 2) {
				bisPair = true;
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.Pair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
			}
		}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = false;
		if (CRC.size() == 5) {
			bisHighCard = true;
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.HighCard);
			int iGetCard = this.getCRC().get(0).getiCardPosition();
			HSP.setHiCard(this.getCards().get(iGetCard));
			HSP.setLoCard(null);
			HSP.setKickers(FindTheKickers(this.getCRC()));
			this.setHS(HSP);
		}
		return bisHighCard;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	private void Frequency() {
		CRC = new ArrayList<CardRankCount>();
		int iCnt = 0;
		int iPos = 0;
		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

}