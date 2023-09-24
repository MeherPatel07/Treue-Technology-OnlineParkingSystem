package onlineParkingSystem;

import java.util.Scanner;

public class ParkingController {

	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter parking lot volume: ");
		int volume=scanner.nextInt();
		
		ParkingLot parkingLot=new ParkingLot(volume);
		
		while(true)
		{
			System.out.println("1.Register user \n2.Park Vehicle \n3.Search available spots \n4.Confirm booking \5.Exit");
			System.out.println("Enter your choice :");
			
			switch(scanner.nextInt())
			{
			case 1:
			{
				System.out.println("Enter username : ");
				String username=scanner.next();
				System.out.println("Enter password : ");
				String password=scanner.next();
				parkingLot.registerUser(username, password);
				System.out.println("User registered successfully.");
				break;
			}
			case 2:
			{
				System.out.println("Enter username : ");
				String username=scanner.next();
				System.out.println("Enter password : ");
				String password=scanner.next();
				User parkUser=parkingLot.getUser(username);
				
				if(parkUser != null && parkUser.getPassword().equals(password))
				{
					System.out.println("Enter vehicle number plate : ");
					String numberPlate=scanner.next();
					System.out.println("Enter vehicle type : ");
					String vehicleType=Vehicle.valueOf(scanner.nextLine().toUpperCase());
					
					Vehicle vehicle=new Vehicle(numberPlate, vehicleType);
					parkingLot.parkVehicle(vehicle, parkUser);
				}
				else
				{
					System.out.println("Invalid username or password.");
				}
				break;
			}
			case 3:
			{
				System.out.println("Enter username : ");
				String username=scanner.next();
				System.out.println("Enter password : ");
				String password=scanner.next();
				
				User searchUser=parkingLot.getUser(username);
				
				if(searchUser != null && searchUser.getPassword().equals(password))
				{
					parkingLot.searchSpot(searchUser);
				}
				else
				{
					System.out.println("Invalid username or password.");
				}
				break;
			}
			case 4:
			{
				System.out.println("Enter username : ");
				String username=scanner.next();
				System.out.println("Enter password : ");
				String password=scanner.next();
				
				User user=parkingLot.getUser(username);
				if(user != null && user.getPassword().equals(password))
				{
					System.out.println("Enter spot number to confirm booking: ");
					int spotnumber=scanner.nextInt();
					parkingLot.confirmBooking(user, spotnumber);
				}
				else
				{
					System.out.println("Invalid username or password.");
				}
				break;
			}
			case 5:
			{
				System.out.println("Exiting........");
				scanner.close();
				System.exit(0);
				break;
			}
			default :
			{
				System.out.println("Invalid choice.");
			}
			}
		}

	}

}
