package onlineParkingSystem;

public class Vehicle 
{
	private String numberplate;
	private String vehicleType;
	
	public Vehicle(String numberplate, String vehicleType) 
	{
		super();
		this.numberplate = numberplate;
		this.vehicleType = vehicleType;
	}
	
	public String getNumberplate() {
		return numberplate;
	}
	public void setNumberplate(String numberplate) {
		this.numberplate = numberplate;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	public static String valueOf(String vehicleType)
	{
		return vehicleType;
	}
	
	

}
