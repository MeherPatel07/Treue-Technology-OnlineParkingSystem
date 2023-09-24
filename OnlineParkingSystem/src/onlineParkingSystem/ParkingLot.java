package onlineParkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot 
{
	private List<ParkingSpot> spots;
	private Map<String, User> users;
	
	public ParkingLot(int volume)
	{
		spots=new ArrayList<>();
		
		for(int i=1;i<=volume;i++)
		{
			spots.add(new ParkingSpot(i));
			
		}
		users=new HashMap<>();
	}
	
	public void registerUser(String username,String password)
	{
		users.put(username, new User(username, password));
	}
	
	public User getUser(String username)
	{
		return users.get(username);
	}
	
	public boolean parkVehicle(Vehicle vehicle,User user)
	{
		for(ParkingSpot parkingSpot:spots)
		{
			if(!parkingSpot.isOccupied()&& !parkingSpot.isBooked())
			{
				parkingSpot.parkVehicle(vehicle);
				parkingSpot.book();
				System.out.println("Vehicle parked successfully in spot "+parkingSpot.getSpotNumber());
				return true;
			}
		}
		System.out.println("No spots available.");
		return false;
	}
	
	public void searchSpot(User user)
	{
		for(ParkingSpot parkingSpot:spots)
		{
			if(!parkingSpot.isOccupied()&&!parkingSpot.isBooked())
			{
				System.out.println("Spot "+parkingSpot.getSpotNumber()+" is available");
			}
		}
	}
	
	public void confirmBooking(User user,int spotNumber)
	{
		ParkingSpot parkingSpot=spots.get(spotNumber-1);
		if(!parkingSpot.isOccupied() && !user.equals(parkingSpot))
		{
			parkingSpot.unbook();
			System.out.println("Booking confirmed for spot "+parkingSpot.getSpotNumber());
		}
		else
		{
			System.out.println("Spot "+parkingSpot.getSpotNumber()+" is not available for confirmaton.");
		}
	}
	
	public void removeVehicle(Vehicle vehicle)
	{
		for(ParkingSpot parkingSpot:spots)
		{
			if(parkingSpot.isOccupied()&&parkingSpot.getParkedVehicle().equals(vehicle))
			{
				parkingSpot.removeVehicle();
				break;
			}
		}
	}
	
	public void displayParkingStatus()
	{
		for(ParkingSpot parkingSpot:spots)
		{
			if(parkingSpot.isOccupied())
			{
				System.out.println("Spot :"+parkingSpot.getSpotNumber()+" occupied by "+parkingSpot.getParkedVehicle().getNumberplate());
			}
			else
			{
				System.out.println("Spot : "+parkingSpot.getSpotNumber()+"vacant");
			}
		}
	}
}
