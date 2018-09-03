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
	
	public void selectCards() {
		for(int i = 0; i < 8; i++) {
			currentCards[i] = selectRandomCard();
		}
	}
	
	public void setUpField() {
		int[] a = new int[2];
		for(Card c: currentCards) {
			for(int i = 0; i < 2; i++) {
				a = getRandomCoordinates();
				if(i == 0) {
					field[a[0]][a[1]] = c.getQuestion();
				}else {
					field[a[0]][a[1]] = c.getStringExplanations();
				}
			}
		}
	}
	
	private int[] getRandomCoordinates() {
		boolean isUnique = false;
		int pos1 = 0;
		int pos2 = 0;
		int[] coords = new int[2];
		while (!isUnique) {
			isUnique = true;
			pos1 = (int) (Math.random()*field.length);
			pos2 = (int) (Math.random()*field[0].length);
			if(field[pos1][pos2].equals("")) {
				isUnique = true;
				coords[0] = pos1;
				coords[1] = pos2;
			}
		}
		return coords;
	}

	public void selectString(String s) {
		String sel1 = "";
		String sel2 = "";
		if(sel1.equals("")) { 
			sel1 = s;
		}else {
			if(sel2.equals("")) {
				sel2 = s;
			}
		}
	}
	
	public boolean checkMatch(String s1, String s2) {
		for(Card c:currentCards) {
			if(c.getQuestion().equals(s1) && c.getStringExplanations().equals(s2) || c.getQuestion().equals(s2) && c.getStringExplanations().equals(s1))
				return true;
		}
		return false;
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
