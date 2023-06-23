public class Point
{
	//fields
	private double x;
	private double y;
	private double z;

	//constructor
	public Point(double x, double y, double z) {
		if (x < 0) {
			throw new ArithmeticException("Invalid value " + x + " for coordinate x");
		}
		else {
			this.x = x;
		}

		if (y < 0) {
			throw new ArithmeticException("Invalid value " + y + " for coordinate y");
		}
		else {
			this.y = y;
		}
		
		if (z < 0) {
			throw new ArithmeticException("Invalid value " + z + " for coordinate z");
		}
		else {
			this.z = z;
		}
		// this.x = x;
		// this.y = y;
		// this.z = z;
	}

	@Override
	public String toString() {
		return ("{"+this.x+","+this.y+","+this.z+"}");
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point)) {
			return false;
		}
		else {
			Point other = (Point)o;
			if (this.x == other.x && this.y == other.y && this.z == other.z) {
				return true;
			}
		}
		return false;
	}

	public double distance(Point other) {
		return Math.sqrt( (Math.pow(this.x - other.x, 2)) + 
						  (Math.pow(this.y - other.y, 2)) + 
						  (Math.pow(this.z - other.z, 2)) );
	}
}