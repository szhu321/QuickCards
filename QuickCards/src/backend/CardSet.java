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
		cards.add(card);
	}

	public void removeCards(Card card) {
		cards.remove(card);
	}
	
	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}
	
	public int getSize() {
		return cards.size();
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
