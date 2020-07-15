package backend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheng
 * A single card contains a front and a Explanation.
 */
public class Card
{
	private String front; //change to something more inclusive of all entries
	private List<String> back;
	private int timesPlayed;
	private int timesGottenWrong;
	private CardSet cardSet;
	
	public Card()
	{
		this("N/A");
	}
	
	public Card(String front)
	{
		this.front = front;
		back = new ArrayList<String>();
	}
	
	public Card(String front, String explanation)
	{
		this.front = front;
		back = new ArrayList<String>();
		back.add(explanation);
	}
	
	public Card(String front, List<String> back)
	{
		this.front = front;
		if(back == null)
			this.back = new ArrayList<String>();
		else
			this.back = back;
	}
	
	public String toString()
	{
		String info = "";
		for(String desc: back)
			info += desc + "\n";
		if(info.equals(""))
			info = "No Explanation";
		return front + "\n" + info;
	}

	public String getFront()
	{
		return front;
	}

	public void setFront(String front)
	{
		this.front = front;
	}

	public List<String> getBack()
	{
		return back;
	}
	
	/**
	 * 
	 * @return All the text on the back of the card.
	 */
	public String getStringback()
	{
		String result = "";
		for(int i = 0; i < back.size() - 1; i++)
		{
			result += back.get(i) + "\n";
		}
		result += back.get(back.size() - 1);
		return result;
	}

	public void setBack(List<String> back)
	{
		this.back = back;
	}
	
	public void addExplanation(String str)
	{
		back.add(str);
	}
	
	public void removeExplanation(int idx)
	{
		back.remove(idx);
	}
	
	public void incrementTimesPlayed()
	{ 
		timesPlayed++;
	}
	
	public void incrementTimesGottenWrong()
	{
		timesGottenWrong++;
	}
	
	public int getTimesPlayed() {
		return timesPlayed;
	}
	
	public int getTimesGottenWrong() {
		return timesGottenWrong;
	}
	
	public String getPercentageWrong(){
		return "You have gotten this wrong " + (timesGottenWrong*100)/timesPlayed + "% of the time.";
	}

	public CardSet getCardSet()
	{
		return cardSet;
	}

	public void setCardSet(CardSet cardSet)
	{
		this.cardSet = cardSet;
	}
	
	
}
