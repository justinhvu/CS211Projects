import java.util.Scanner;
import java.io.File;

public class Inventory
{
	private Car[] vehicles;
	
	public Inventory(String filename) throws Exception {
		Scanner scnr = new Scanner(new File(filename));
		
		vehicles = new Car[scnr.nextInt()];
		for (int i = 0; i < vehicles.length; i++) {
			int vin = scnr.nextInt();
			String make = scnr.next();
			String model = scnr.next();
			short year = scnr.nextShort();
			float price = scnr.nextFloat();
			
			vehicles[i] = new Car(vin, make, model, year, price);
		}
		
		scnr.close();
	}
	
	public String cheapestCar() {
		int index = 0;
		
		for (int i = 1; i < vehicles.length; i++) {
			if (vehicles[i].cheaperThan(vehicles[index])) {
				index = i;
			}
		}
		return (vehicles[index].toString());
	}
	
	public String newestCar() {
		int newest = 0;
		
		for (int i = 1; i < vehicles.length; i++) {
			if (vehicles[i].getYear() > vehicles[newest].getYear()) {
				newest = i;
			}
			else if (vehicles[i].getYear() == vehicles[newest].getYear() && vehicles[i].cheaperThan(vehicles[newest])) {
				newest = i;
			}
		}
		
		return (vehicles[newest].toString());
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for (int i = 0; i < vehicles.length; i++) {
			result += vehicles[i].toString();
			if (i < vehicles.length - 1) {
				result += "\n";
			}
		}
		
		return result;
	}
}