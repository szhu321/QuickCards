package backend;

import java.util.ArrayList;
import java.util.List;

import saving.FileSaver;

/**
 * This class manages cardsets. 
 * @author Sheng Wei
 *
 */
public class CardManager
{
	/**
	 * All The cards loaded into this CardManager.
	 */
	private List<CardSet> allCardSets;
	/**
	 * The currentCardSets used by this manager.
	 */
	private CardSet currentCardSet;
	
	public CardManager()
	{
		allCardSets = new ArrayList<CardSet>();
	}
	
	public CardManager(List<CardSet> cardsets)
	{
		allCardSets = cardsets;
	}
	
	//useful methods
	public void addCardSetAndSave(CardSet cardset)
	{
		//FileSaver.writeCardSetToFile(cardset);
	}
	
	//getters and setters
	public List<CardSet> getAllCardSets()
	{
		return allCardSets;
	}

	public CardSet getCurrentCardSet()
	{
		return currentCardSet;
	}
	
	public void setCurrentCardSet(CardSet currentCardSet)
	{
		this.currentCardSet = currentCardSet;
	}
}
