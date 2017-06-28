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
		String getDirection = "https://maps.googleapis.com/maps/api/directions/json?origin=";

		getDirection = getDirection.concat(destinations[0] + "&destination=" + destinations[destinations.length - 1]);
		if(destinations.length > 2)
		{
			getDirection = getDirection.concat("&waypoints=");
			if(destinations.length > 3)
			{
				for(int i = 1; i < destinations.length-2; i++)
				{
					getDirection = getDirection.concat(destinations[i] + "|");
				}
			}
			getDirection = getDirection.concat(destinations[destinations.length-2]);
		}

		//	
		//		
//			try {
//				for(String place : destinations)
//				{
//				place = place.replaceAll(" ", "+");
//				URL url = new URL("https://maps.googleapis.com/maps/api/place/textsearch/json?query=" + place + "&key=AIzaSyDQ_iWzgtsKNnSExboEJsGBy4E7-hCrXGg");
//				Scanner reader = new Scanner(url.openStream());
//				String input = "";
//				while(reader.hasNextLine())
//				{
//					input = reader.nextLine();
//					if(input.contains("place_id"))
//					{
//						break;
//					}
//				}
//				//TODO just put the entered names straight into the directions API
//				String[] placeID = input.split("\"");
//				getDirection = getDirection.concat("place_id:" + placeID[3] + "|");
//				reader.close();
//				}
//				URL directionsURL = new URL("https://maps.googleapis.com/maps/api/directions/json?origin=" + 
//					getDirection.substring(0, 36) + "&destination=" + getDirection.substring(getDirection.length()-37, getDirection.length()-1).split("|")[0]
//							+ "&waypoints=" + getDirection.substring(37, getDirection.length()-29) + "&key=AIzaSyDQ_iWzgtsKNnSExboEJsGBy4E7-hCrXGg");
//				Scanner reader = new Scanner(directionsURL.openStream());
//				//TODO
//				while(reader.hasNextLine())
//				{
//					System.out.println(reader.nextLine());
//				}
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
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
	public Trip removeDestination(String dest)
	{
//<<<<<<< HEAD
	//TODO
		if(destinationList.remove(dest))
		{
			String[] names = new String[destinationList.size()];
			for(int i = 0; i < destinationList.size(); i++)
			{
				names[i] = destinationList.get(i).getName();
			}
			return createNewTrip(this.name, names);
		}
		else return this;
//=======
	
//>>>>>>> e36a1173ab483a545db4a17fd42b30fec5d5719b
	}
	public Trip addDestination(int pos, Destination destination)
	{
		destinationList.add(pos,destination);
		String[] names = new String[destinationList.size()];
		for(int i = 0; i < destinationList.size(); i++)
		{
			names[i] = destinationList.get(i).getName();
		}
		return createNewTrip(this.name, names);
	}
	public int getNumberOfDestinations()
	{
		return destinationList.size();
	}
}
