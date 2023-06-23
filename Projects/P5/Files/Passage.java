/**
 * Passage is a concrete class that represents a single cell of the field that is specifically a passage.
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public class Passage extends Block {
	private int value;
	/**
	 * Passage constructor sets the passage's value
	 * @param value is the passage's value
	 */
	public Passage(int value) {
		this.value = value;
	}
	
	/**
	 * toString accesses the passage's label, which is it's value
	 * @return the passage's value as a string
	 */
	public String toString() {
		return ("" + this.value + "");
	}
	
	/**
	 * getValue accesses the number of points assigned to the object when constructed.
	 * @return the passage's value as an int
	 */
	public int getValue() {
		return this.value;
	}
}