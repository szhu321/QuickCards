package backend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sheng
 * A single card contains a name and descriptions.
 */
public class Card
{
	private String name;
	private List<String> descriptions;
	
	public Card()
	{
		this("N/A");
	}
	
	public Card(String name)
	{
		this(name, null);
	}
	
	public Card(String name, List<String> descriptions)
	{
		this.name = name;
		if(descriptions == null)
			this.descriptions = new ArrayList<String>();
		else
			this.descriptions = descriptions;
	}
	
	public String toString()
	{
		String info = "";
		for(String desc: descriptions)
			info += desc + "\n";
		if(info.equals(""))
			info = "No Description";
		return name + "\n" + info;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<String> getDescriptions()
	{
		return descriptions;
	}

	public void setDescriptions(List<String> descriptions)
	{
		this.descriptions = descriptions;
	}
	
	public void addDescription(String str)
	{
		descriptions.add(str);
	}
	
	public void removeDescription(int idx)
	{
		descriptions.remove(idx);
	}
}
