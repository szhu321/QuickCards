package backend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheng
 * A single card contains a question and a Explanation.
 */
public class Card
{
	private String question; //change to something more inclusive of all entries
	private List<String> explanations;
	private int timesPlayed;
	private int timesGottenWrong;
	
	public Card()
	{
		this("N/A");
	}
	
	public Card(String question)
	{
		this.question = question;
		explanations = new ArrayList<String>();
	}
	
	public Card(String question, String explanation)
	{
		this.question = question;
		explanations = new ArrayList<String>();
		explanations.add(explanation);
	}
	
	public Card(String question, List<String> explanations)
	{
		this.question = question;
		if(explanations == null)
			this.explanations = new ArrayList<String>();
		else
			this.explanations = explanations;
	}
	
	public String toString()
	{
		String info = "";
		for(String desc: explanations)
			info += desc + "\n";
		if(info.equals(""))
			info = "No Explanation";
		return question + "\n" + info;
	}

	public String getQuestion()
	{
		return question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public List<String> getExplanations()
	{
		return explanations;
	}
	
	public String getStringExplanations() {
		String result = "";
		for(String s:explanations) {
			result += s + "\n";
		}
		return result;
	}

	public void setExplanations(List<String> explanations)
	{
		this.explanations = explanations;
	}
	
	public void addExplanation(String str)
	{
		explanations.add(str);
	}
	
	public void removeExplanation(int idx)
	{
		explanations.remove(idx);
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
	
	public String getPercentageWrong() {
		return "You have gotten this wrong " + (timesGottenWrong*100)/timesPlayed + "% of the time.";
	}
}
