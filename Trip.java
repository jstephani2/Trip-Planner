import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Trip {
//	private Destination start;
	private String name;
	private ArrayList<Destination> destinationList;
	
	public Trip(String name, ArrayList<Destination> destinations)
	{
		this.destinationList = destinations;
		this.name = name;
	}

	public static Trip createTripFromFile()
	{
		return null;
	}

	private static String instructionsHelper(String line)
	{
		String temp = line.split("\"")[3].replaceAll("\\\\u003cb\\\\u003e", "");
		temp = temp.replaceAll("\\\\u003c/b\\\\u003e", "");
		return temp;
	}
	private static String parseStep(Scanner reader)
	{
		String directions = "";
		while(true)
		{
			String temp = reader.nextLine();
			if(temp.contains("distance"))
			{
				directions = directions.concat(reader.nextLine().split("\"")[3] + ", ");
			}
			else if(temp.contains("duration"))
			{
				directions = directions.concat(reader.nextLine().split("\"")[3] + ", ");
			}
			else if(temp.contains("html_instructions"))
			{
				directions = directions.concat(instructionsHelper(temp) + ", ");
			}
			else if(temp.contains("travel_mode"))
			{
				return directions;
			}
			else if(temp.contains("traffic_speed_entry")) return "null";
		}
	}
	private static ArrayList<Destination> parseLegs(Scanner reader)
	{
		String name = "";
		double distance = 0;
		int duration = 0;
		ArrayList<Destination> destinations = new ArrayList<Destination>();
		while(true)
		{
			ArrayList<String> directions = new ArrayList<String>();
			String curr = reader.nextLine();
			if(curr.contains("end_address"))
			{
				name = curr.split("\"")[3];
			}
			else if(curr.contains("distance"))
			{
				distance = Double.parseDouble(reader.nextLine().split("\"")[3].replaceAll(",", "").split(" ")[0]);
			}
			else if(curr.contains("duration"))
			{
				reader.nextLine();
				duration = Integer.parseInt(reader.nextLine().split("\"")[2].split(":")[1].trim());
			}
			else if(curr.contains("steps"))
			{
				while(!reader.nextLine().contains("via_waypoint"))
				{
					String temp = parseStep(reader);
					if(!temp.equals("null"))
						directions.add(temp);
				}
				destinations.add(new Destination(name, distance, duration, directions));
			}
			else if(curr.contains("summary"))
			{
				return destinations;
			}
		}
	}
	public static Trip createNewTrip(String name, String[] destinations)
	{
		for(int i = 0; i < destinations.length; i++)
		{
			String place = destinations[i];
			destinations[i] = place.replaceAll(" ", "+");
		}
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
		getDirection = getDirection.concat("&key=AIzaSyDQ_iWzgtsKNnSExboEJsGBy4E7-hCrXGg");

			try {
				URL url;
				url = new URL(getDirection);
				Scanner reader = new Scanner(url.openStream());
				while(reader.hasNextLine())
				{
					String temp = reader.nextLine();
					if(temp.contains("legs"))
					{
						newTrip.destinationList = parseLegs(reader);
						break;
					}
					
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return newTrip;
	}
	@Override
	public String toString()
	{
		String toReturn = "";
		toReturn = name + " ";
		for(Destination dest : destinationList)
		{
			toReturn = toReturn.concat(dest.toString() + "\n");
		}
		return toReturn;
	}
	public void saveTripToFile()
	{
		//TODO
		try {
			FileWriter output = new FileWriter(this.name + ".txt");
			for(Destination dest : destinationList)
			{
				output.write(dest.toString());
			}
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void removeDestination()
	{
	//TODO
	}
	public void addDestination(int pos, Destination destination)
	{
		destinationList.add(pos,destination);
	}
	public Destination getDestination(int pos)
	{
		return destinationList.get(pos);
	}
	public int getNumberOfDestinations()
	{
		return destinationList.size();
	}
	public String getFullDirectionString()
	{
		String toReturn = "";
		for(Destination dest : destinationList)
		{
			toReturn = toReturn.concat(dest.getDirectionString() + "\n");
		}
		return toReturn;
	}
	public String getFullPackingListString()
	{
		String toReturn = "";
		for(Destination dest : destinationList)
		{
			toReturn = toReturn.concat(dest.getPackingListString() + "\n");
		}
		return toReturn;
	}
}
