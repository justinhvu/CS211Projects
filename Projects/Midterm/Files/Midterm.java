class Midterm
{
	public static void main(String[] args) throws Exception
	{
		if (args.length != 1) {
			System.err.println("ERROR U WRONG");
			return;
		}
		String input = args[0];
		Inventory inventory = new Inventory(input);
		
		System.out.println(inventory);
		System.out.println(inventory.cheapestCar());
		System.out.println(inventory.newestCar());
	}
}