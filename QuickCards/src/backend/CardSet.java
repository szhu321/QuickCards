package backend;

import java.util.ArrayList;
import java.util.List;

public class CardSet
{
	private String name;
	private List<Card> cards;
	
	public CardSet()
	{
		this("");
	}
	
	public CardSet(String name)
	{
		this.name = name;
		cards = new ArrayList<Card>();
	}

	public String getName()
	{
		return name;
	}

	public List<Card> getCards()
	{
		return cards;
	}
	
	public Card getCard(int pos) {
		return cards.get(pos);
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void addCard(Card card)
	{
		card.setCardSet(this);
		cards.add(card);
	}

	public void removeCards(Card card)
	{
		boolean isremoved = cards.remove(card);
		if(isremoved)
			card.setCardSet(null);
	}
	
	public void setCards(List<Card> cards)
	{
		for(Card card: cards)
			card.setCardSet(this);
		this.cards = cards;
	}
	
	public int getSize() {
		return cards.size();
	}
	
	public void shuffle()
	{
		List<Card> shuffledList = new ArrayList<Card>();
		while(cards.size() > 0)
		{
			shuffledList.add(cards.remove((int)(Math.random() * cards.size())));
		}
		cards = shuffledList;
	}
	
	public String toString()
	{
		String result = "";
		for(Card card : cards)
		{
			result += card.toString();
		}
		return result;
	}
}
