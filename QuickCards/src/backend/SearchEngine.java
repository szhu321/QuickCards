package backend;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine
{
	private List<Card> cards;
	
	public SearchEngine(List<CardSet> allCardSets)
	{
		cards = new ArrayList<Card>();
		for(CardSet cs: allCardSets)
		{
			for(Card crd: cs.getCards())
			{
				cards.add(crd);
			}
		}
		sortCardByName(cards);
	}
	
	public static void sortCardByName(List<Card> cards)
	{
		//selection sort
		for(int i = 0; i < cards.size() - 1; i++)
		{
			//The pivot is going to be the card with the lowest alphabetical order.
			int pivot = i;
			for(int j = i + 1; j < cards.size(); j++)
			{
				//compare the two card upper case strings.
				if(cards.get(pivot).getFront().toUpperCase().compareTo(cards.get(j).getFront().toUpperCase()) > 0)
				{
					//swap if the pivot card is "larger" than the current card.
					cards.set(pivot, cards.set(j, cards.get(pivot)));
				}
			}
		}
	}
	
	public List<Card> findCards(String str)
	{
		//this list contains all the cards.
		List<Card> tempCards = new ArrayList<Card>();
		//this list contains the final result.
		List<Card> finalCards = new ArrayList<Card>();
		
		if(str.length() == 0)
			return finalCards;
		
		for(Card crd: cards)
		{
			tempCards.add(crd);
		}
		
		//multiple binary searches
		boolean complete = false;
		while(!complete)
		{
			//search the string list for matches. 
			int min = 0;
			int max = tempCards.size() - 1;
			while(true)
			{
				//if nothing is found break out of both loops.
				if(max < min)
				{
					complete = true;
					break;
				}
				int middle = (int)((max + min) / 2);
				int size = 0;
				if(tempCards.get(middle).getFront().length() < str.length())
					size = tempCards.get(middle).getFront().length();
				else
					size = str.length();
				int compareNum = tempCards.get(middle).getFront().toUpperCase().substring(0, size).compareTo(str.toUpperCase());
				//if match is found add card to the finalCard list.
				//then remove card from the tempCard list.
				if(compareNum == 0)
				{
					finalCards.add(tempCards.get(middle));
					tempCards.remove(middle);
					break;
				}
				if(compareNum < 0)
					min = middle + 1;
				else
					max = middle - 1;
			}
		}
		return finalCards;
	}
	
	public String toString()
	{
		String result = "";
		for(int i = 0; i < cards.size(); i++)
		{
			Card temp = cards.get(i);
			result += temp.getFront() + "\n";
		}
		return result;
	}
	
	public List<Card> getCards()
	{
		return cards;
	}
}
