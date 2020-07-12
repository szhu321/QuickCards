package saving;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
			String name = file.getName();
			name = name.substring(0, name.length() - 4);
			CardSet cardset = new CardSet(name);
			//System.out.println(name);
			Scanner sn;
			try
			{
				sn = new Scanner(new InputStreamReader(new FileInputStream(file), "UTF8"));
				while(sn.hasNextLine())
				{
					String str = sn.nextLine();
					if(str.equals(""))
						continue;
					String[] mainSplit = str.split(FileSaver.FRONT_BACK_SEPERATOR);
					
					Card tempCard = new Card(mainSplit[0]);
					if(mainSplit.length > 1)
					{
						String[] otherSplit = mainSplit[1].split(FileSaver.BACK_EXPLAN_SEPERATOR);
					for(String e : otherSplit)
					{
						tempCard.addExplanation(e);
					}
					}
					cardset.addCard(tempCard);
				}
				sn.close();
			}
			catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	
	public static List<String> getAllFileNames()
	{
		File[] files = FileUtil.getAllTxtFilesFromDir("saves/cardsets");
		List<String> result = new ArrayList<String>();
		for(File file : files)
		{
			String name = file.getName();
			name = name.substring(0, name.length() - 4);
			result.add(name);
		}
		return result;
	}
}
