import java.nio.file.*;
import java.util.ArrayList;

public class Trip {
//	private Destination start;
	private String name;
	private ArrayList<Destination> destinationList;
	
	public Trip(String name, ArrayList<Destination> destinations)
	{
		this.destinationList = destinations;
		this.name = name;
	}
//	public Destination getStart()
//	{
//		return start;
//	}
	public static Trip createTripFromFile()
	{
		return null;
	}
	public static Trip createNewTrip(String name, String[] destinations)
	{
		Trip newTrip = new Trip(name, new ArrayList<Destination>());
		for(String place : destinations)
		{
			//TODO get directions between each destination
			//TODO create the new destination
			//TODO add the destination to newTrip's destinationList
		}
		
		return null;
	}
	public void saveTripToFile()
	{
		
	}
	public void removeDestination()
	{
	
	}
	public void addDestination(int pos)
	{
		
	}
	public int getNumberOfDestinations()
	{
		return destinationList.size();
	}
}
