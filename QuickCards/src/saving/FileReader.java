package saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import backend.CardSet;
import myutilities.FileUtil;

public class FileReader
{
	/**
	 * todo: creates card sets from the local saves folder.
	 * @return The local card sets.
	 */
	public static CardSet[] getLocalCardSets()
	{
		File[] files = FileUtil.getAllTxtFilesFromDir("saves/cardsets");
		//System.out.println("Pass 0");
		if(files == null)
			return null;
		for(File file : files)
		{
			try
			{
				Scanner sn = new Scanner(file);
				while(sn.hasNextLine())
				{
					String str = sn.nextLine();
					if(str.equals(""))
						continue;
					
				}
				
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		//System.out.println("Pass 1");
		return null;
	}
}
