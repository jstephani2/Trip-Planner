
public class Edge {
	private double distanceInMiles;
	private int lengthInMinutes;
	private Destination start;
	private Destination end;
	
	public Edge(double distance, int length, Destination start, Destination end)
	{
		distanceInMiles = distance;
		lengthInMinutes = length;
		this.start = start;
		this.end = end;
	}
}
