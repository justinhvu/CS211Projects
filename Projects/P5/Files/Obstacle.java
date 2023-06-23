/**
 * Obstacle is a concrete class that represents a single cell of the field that is specifically an obstacle. 
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public class Obstacle extends Block {
	private String label;
	
	/**
	 * Obstacle constructor sets the obstacle's label
	 * @param label is the obstacle's label
	 */
	public Obstacle(String label) {
		this.label = label;
	}
	
	/**
	 * toString access the obstacle's label
	 * @return the obstacle's label
	 */
	public String toString() {
		return this.label;
	}
	
	/**
	 * getValue accesses the obstacles value
	 * Since it’s impossible to go through an obstacle, it is assigned 0 points.
	 * @return an obstacle's value of 0
	 */
	public int getValue() {
		return 0;
	}
}