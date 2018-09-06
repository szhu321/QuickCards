package saving;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;

import backend.Card;
import backend.CardSet;

public class FileSaver
{
	private Formatter formatter;
	public static final String FRONT_BACK_SEPERATOR = "@#";
	public static final String BACK_EXPLAN_SEPERATOR = "%$";
	
	public FileSaver(String name)
	{
		try
		{
			formatter = new Formatter(name + ".txt");
			System.out.println("File Created");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeFile()
	{
		formatter.close();
	}
	
	public void writeToFile(String str)
	{
		formatter.format("%s", str);
	}
	
	public void writeCardToFile(Card card)
	{
		String result = "";
		result += card.getQuestion() + FRONT_BACK_SEPERATOR;
		List<String> explanations = card.getExplanations();
		for(int i = 0; i < explanations.size(); i++)
		{
			if(i < explanations.size() - 1)
				result += explanations.get(i) + BACK_EXPLAN_SEPERATOR;
			else
				result += explanations.get(i);
		}
		result += "\n";
		writeToFile(result);
	}
	
	public static void writeCardSetToFile(CardSet cardset)
	{
		FileSaver fs = new FileSaver(cardset.getName());
		for(Card card: cardset.getCards())
		{
			fs.writeCardToFile(card);
		}
		fs.closeFile();
	}
}
