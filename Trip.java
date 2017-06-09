import java.nio.file.*;
import java.util.ArrayList;
import java.io.*;

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
			//TODO test
		}
		
		return null;
	}
	public void saveTripToFile()
	{
		try {
			FileWriter output = new FileWriter(this.name + ".txt");
			for(Destination dest : destinationList)
			{
				output.write(dest.toString());
			}
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void removeDestination()
	{
	
	}
	public void addDestination(int pos, Destination destination)
	{
		destinationList.add(pos,destination);
	}
	public int getNumberOfDestinations()
	{
		return destinationList.size();
	}
}
