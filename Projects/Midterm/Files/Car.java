public class Car
{
	private int vin;
	private String make;
	private String model;
	private short year;
	private float price;
	
	public Car(int vin, String make, String model, short year, float price) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public short getYear() {
		return year;
	}
	
	public boolean cheaperThan(Car other) {
		boolean result = false;
		
		if (price < other.price) {
			result = true;
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return (make + " " + model + " " + year);
	}
}