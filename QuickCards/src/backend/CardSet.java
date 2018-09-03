package backend;

import java.util.List;

public class CardSet
{
	private String name;
	private List<Card> cards;
	
	public CardSet()
	{
		
	}
	
	public CardSet(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public List<Card> getCards()
	{
		return cards;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void addCard(Card card)
	{
		cards.add(card);
	}
	
	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}
}
