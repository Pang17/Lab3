package pkgCore;

import java.util.LinkedList;

public class Round {

	private int ComeOutScore;
	private eGameResult eGameResult;
	private LinkedList<Roll> rolls = new LinkedList<Roll>();

	public Round() {
		Roll comeOut = new Roll();
		ComeOutScore = comeOut.getScore();

		if (isNatural(ComeOutScore)) {
			eGameResult = eGameResult.NATURAL;
		} else if (isCraps(ComeOutScore)) {
			eGameResult = eGameResult.CRAPS;
		} else {
			do {
				rollDice();
			} while ((rolls.getLast().getScore() != 7) || (rolls.getLast().getScore() != ComeOutScore));
		}
		if (rolls.getLast().getScore() == 7) {
			eGameResult = eGameResult.SEVEN_OUT;
		} else if ((rolls.getLast().getScore() != 7) && (rolls.getLast().getScore() == ComeOutScore)){
			eGameResult = eGameResult.POINT;
		}
	}

	public int RollCount() {
		return rolls.size();
	}
	
	public void rollDice() {
		rolls.add(new Roll());
	}
	
	public boolean isNatural(int score) {
		if((score == 7) || (score == 11))
			return true;
		else return false;
		}
	
	public boolean isCraps(int score) {
		if((score == 3) || (score == 2) || (score == 12))
			return true;
		return false;
	}
	

}
