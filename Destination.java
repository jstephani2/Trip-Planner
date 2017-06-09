import java.util.ArrayList;

public class Destination {
	private String name;
	private ArrayList<String> packingList;
	private int numItemsInList;
//	private Destination next;
	private double distance;
	private int length;
	private String directions;
	
	public Destination(String name, ArrayList<String> packingList, double distance, int length,
			String directions)
	{
		this.name = name;
		this.packingList = packingList;
//		this.next = next;
		this.distance = distance;
		this.length = length;
		this.directions = directions;
	}
	public Destination(String name, Destination next, double distance, int length)
	{
		this.name = name;
		packingList = new ArrayList<String>();
//		this.next = next;
		this.distance = distance;
		this.length = length;
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
			System.out.println(item + " successfully removed.");
		else
			System.out.println(item + " did not exist in the list.");
	}
//	public void setNext(Destination place)
//	{
//		this.next = place;
//	}
//	public Destination getNext()
//	{
//		return next;
//	}
//	public void print()
//	{
//		System.out.println(name + " " + distance + " miles " + length + " minutes.");
//		if(null == next)
//			return;
//		next.print();
//	}
}
