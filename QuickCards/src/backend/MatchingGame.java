package backend;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MatchingGame {

	/**
	 * author Victor
	 * 
	 */
	
	private String[][] field; 
	private ArrayList<CardSet> selectedSets;
	private int score;
	private Card[] currentCards;
	
	private void selectCards() {
		for(int i = 0; i < 8; i++) {
			currentCards[i] = selectRandomCard();
		}
	}
	
	private void setUpField() {
		for() {
			
		}
	}
	
	private Card selectRandomCard() {
		boolean isUnique = false;
		int selectedSetPos = 0;
		int selectedCardPos = 0;
		Card selectedCard = null;
		while (!isUnique) {
			isUnique = true;
			selectedSetPos = (int) (Math.random()*selectedSets.size());
			selectedCardPos = (int) (Math.random()*selectedSets.get(selectedSetPos).getSize());
			selectedCard = selectedSets.get(selectedSetPos).getCard(selectedCardPos);
			for(Card c:currentCards) {
				if (c == selectedCard) {
					isUnique = false;	
				}
			}
		}
		return selectedCard;
	}
}
