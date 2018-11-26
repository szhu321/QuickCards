package saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.List;

import backend.Card;
import backend.CardSet;
import myutilities.FileUtil;

public class FileSaver
{
	private Formatter formatter;
	public static final String FRONT_BACK_SEPERATOR = "@#";
	public static final String BACK_EXPLAN_SEPERATOR = "%$";
	
	public FileSaver(String name)
	{
		createCardSetSavesFolder();
		try
		{
			formatter = new Formatter("saves/cardsets/" + name + ".txt");
			//System.out.println("File Created");
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
		result += card.getFront() + FRONT_BACK_SEPERATOR;
		List<String> explanations = card.getBack();
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
	
	public static void writeCardToCardSet(CardSet cardset, Card tempcard)
	{
		FileSaver fs = new FileSaver(cardset.getName());
		for(Card card: cardset.getCards())
		{
			fs.writeCardToFile(card);
		}
		fs.writeCardToFile(tempcard);
		fs.closeFile();
	}
	
	//todo: find a way so that the file wont override.
	public static void writeCardSetToFile(CardSet cardset)
	{
		String cardsetName = cardset.getName();
//		if(isFileInSavesFolder(cardset.getName() + ".txt"))
//		{
//			cardsetName = cardset.getName() + "(1)";
//		}
		FileSaver fs = new FileSaver(cardsetName);
		for(Card card: cardset.getCards())
		{
			fs.writeCardToFile(card);
		}
		fs.closeFile();
	}
	
	public static boolean isFileInSavesFolder(String name)
	{
		File[] allFiles = FileUtil.getAllTxtFilesFromDir("saves/cardsets");
		if(allFiles == null)
			return false;
		for(File file: allFiles)
		{
			if(file.getName().equals(name))
				return true;
		}
		return false;
	}
	
	private static void createCardSetSavesFolder()
	{
		File file = new File("saves");
		if(!file.exists())
		{
			file.mkdirs();
			//System.out.println("saves directory was successfully created.");
		}
		
		File file2 = new File("saves/cardsets");
		if(!file2.exists())
		{
			file2.mkdirs();
			//System.out.println("saves/players directory was successfully created.");
		}
	
	}
}
