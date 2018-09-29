package backend;

import java.util.ArrayList;
import java.util.List;

public class CardStorage
{
	private List<CardSet> allCardSets;
	
	public CardStorage()
	{
		allCardSets = new ArrayList<CardSet>();
	}
	
	public CardStorage(List<CardSet> cardsets)
	{
		allCardSets = cardsets;
	}
	
	public List<CardSet> getAllCardSets()
	{
		return allCardSets;
	}
}
