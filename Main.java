import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
//		Destination origin = new Destination("home", null, 0, 0);
//		Destination tail = origin;
//		
//		Scanner in = new Scanner(System.in);
//		while(true)
//		{
//			System.out.println("(a)dd a new destination");
//			System.out.println("(p)rint out report");
//			System.out.println("(r)emove a destination");
//			System.out.println("add a packing (l)ist");
//			
//			String input = in.next();
//			switch(input)
//			{
//			case "a":
//				tail.setNext(addNewDestination(in, tail));
//				tail = tail.getNext();
//				break;
//			case "p":
//				origin.print();
//				break;
//			}
//			
//		}
	}
	private static Destination addNewDestination(Scanner in, Destination tail)
	{
		System.out.println("Enter Destination Name: ");
		String name = in.next();
		System.out.println("Distance from previous destination: ");
		double distance = in.nextDouble();
		System.out.println("Length from previous destination (in mins):");
		int length = in.nextInt();
		Destination newPlace = new Destination(name, null, distance, length);
		return newPlace;
	}

}
