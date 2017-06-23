import java.util.ArrayList;

public class Destination {
	private String name;
	private ArrayList<String> packingList;
	private int numItemsInList;
//	private Destination next;
	private double distance;
	private int length;
	private ArrayList<String> directions;
	
	public Destination(String name, ArrayList<String> packingList, double distance, int length,
			ArrayList<String> directions)
	{
		this.name = name;
		this.packingList = packingList;
//		this.next = next;
		this.distance = distance;
		this.length = length;
		this.directions = directions;
	}
	public Destination(String name, double distance, int length)
	{
		this.name = name;
		packingList = new ArrayList<String>();
//		this.next = next;
		this.distance = distance;
		this.length = length;
	}
	public Destination(String name, double distance, int length, ArrayList<String> directions)
	{
		this.name = name;
		packingList = new ArrayList<String>();
//		this.next = next;
		this.distance = distance;
		this.length = length;
		this.directions = directions;
	}
	public void addToPackingList(String item)
	{
		packingList.add(item);
		packingList.sort(null);
	}
	public ArrayList<String> getPackingList()
	{
		return packingList;
	}
	public void removeFromList(int index)
	{
		packingList.remove(index);
	}
	public void removeFromList(String item)
	{
		if(packingList.remove(item))
			//TODO change to GUI
			System.out.println(item + " successfully removed.");
		else
			System.out.println(item + " did not exist in the list.");
	}
	public String getName()
	{
		return name;
	}
	public String getDuration()
	{
		int mins = length%60;
		int hrs = length/60;
		return hrs + " hours, " + mins + " mins";
	}
	public String getDistance()
	{
		return distance + "miles";
	}
	@Override
	public String toString()
	{
		String toReturn = name + "\n";
		for(String packingItem : packingList)
		{
			toReturn = toReturn.concat(packingItem + ",");
		}
		toReturn = toReturn.concat("\n" + numItemsInList + "\n" + distance + " miles\n" + length + " mins\n" + directions);
		//TODO
		return toReturn;
		
	}
	public String getDirectionString()
	{
		String toReturn = "";
		for(String dir : directions)
		{
			toReturn = toReturn.concat(dir + "\n");
		}
		return toReturn;
	}
	public String getPackingListString()
	{
		String toReturn = "";
		for(String item : packingList)
		{
			toReturn = toReturn.concat(item + "\n");
		}
		return toReturn;
	}
}
