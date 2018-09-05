package saving;

import java.io.File;

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
		File[] files = FileUtil.getAllTxtFilesFromDir("saves/players");
		
		//System.out.println(files.length);
		//return null;
		if(files == null)
			return null;
		return null;
	}
}
