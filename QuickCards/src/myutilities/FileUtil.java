package myutilities;

import java.io.File;
import java.io.FileFilter;

public class FileUtil
{
	/**
	 * Finds all text files in a directory and returns them
	 * @param url The abstract location of the directory starting from the root folder.
	 * @return A array of txt files that is in the directory.
	 */
	public static File[] getAllTxtFilesFromDir(String url)
	{
		File file = new File(url);
		if(!file.isDirectory())
			return null;
		File[] files = file.listFiles(new FileFilter() 
		{
			@Override
			public boolean accept(File file)
			{
				String path = file.getPath().toString();
				if(path.substring(path.length() - 3).equals("txt"))
					return true;
				return false;
			}
		});
		return files;
	}
}
