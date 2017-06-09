import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

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
		String getDirection = "";
		
			try {
				for(String place : destinations)
				{
				place = place.replaceAll(" ", "+");
				URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + place + "&key=AIzaSyDQ_iWzgtsKNnSExboEJsGBy4E7-hCrXGg");
				Scanner reader = new Scanner(url.openStream());
				String input = "";
				while(reader.hasNextLine())
				{
					input = reader.nextLine();
					if(input.contains("place_id"))
					{
						break;
					}
				}
				//TODO just put the entered names straight into the directions API
				String[] placeID = input.split("\"");
				getDirection = getDirection.concat("place_id:" + placeID[3] + "|");
				reader.close();
				}
				URL directionsURL = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + 
					getDirection.substring(0, 36) + "&destination=" + getDirection.substring(getDirection.length()-37, getDirection.length()-1).split("|")[0]
							+ "&waypoints=" + getDirection.substring(37, getDirection.length()-29) + "&key=AIzaSyDQ_iWzgtsKNnSExboEJsGBy4E7-hCrXGg");
				Scanner reader = new Scanner(directionsURL.openStream());
				//TODO
				while(reader.hasNextLine())
				{
					System.out.println(reader.nextLine());
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//TODO get directions between each destination
			//TODO create the new destination
			//TODO add the destination to newTrip's destinationList
		
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
