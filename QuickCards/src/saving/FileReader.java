package saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import backend.Card;
import backend.CardSet;
import myutilities.FileUtil;

public class FileReader
{
	/**
	 * creates card sets from the local saves folder.
	 * @return The local card sets.
	 */
	public static List<CardSet> getLocalCardSets()
	{
		File[] files = FileUtil.getAllTxtFilesFromDir("saves/cardsets");
		//System.out.println("Pass 0");
		if(files == null)
			return null;
		List<CardSet> cardSets = new ArrayList<CardSet>();
		for(File file : files)
		{
			CardSet cardset = new CardSet(file.getName());
			try
			{
				Scanner sn = new Scanner(file);
				while(sn.hasNextLine())
				{
					String str = sn.nextLine();
					if(str.equals(""))
						continue;
					String[] mainSplit = str.split(FileSaver.FRONT_BACK_SEPERATOR);
					String[] otherSplit = mainSplit[1].split(FileSaver.BACK_EXPLAN_SEPERATOR);
					Card tempCard = new Card(mainSplit[0]);
					for(String e : otherSplit)
					{
						tempCard.addExplanation(e);
					}
					cardset.addCard(tempCard);
				}
				
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			cardSets.add(cardset);
		}
		//System.out.println("Pass 1");
		return cardSets;
	}
}
