/**
 *
 *	Child is subclass of Person.
 *	This class has same fields as Person, with additional school and tuition.
 *	It contains methods for calculations specific to Childs.
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 *
 */
public class Child extends Person
{
	//fields
	private String school;
	private float tuition;
	
	//constructor
	/**
	 *	Child constructor takes in the information needed for every adult object.
	 *	The setters in Person class are used to validate the passed in parameters.
	 *	@param The possible name of a Child.
	 *	@param The possible birthday of a Child.
	 *	@param The possible ssn of a Child.
	 *	@param The possible gross income of a Child.
	 *	@param The school of a Child.
	 *	@param The tuition of a Child.
	 */
	public Child(String name, String birthday, String ssn, float grossIncome, String school, float tuition) {
		setName(name);
		setBirthday(birthday);
		setSSN(ssn);
		setGrossIncome(grossIncome);
		this.school = school;
		this.tuition = tuition;
	}
	
	//setters
	
	//getters
	public float getTuition() {
		return this.tuition;
	}
	
	//other methods
	/**
	 *	ToString prints out the desired format for a Child.
	 *	It overrides the Person toString.
	 *	It uses the Person toString as super to use the base format of a person.
	 *	@return the desired format of a Child's information.
	 */
	@Override
	public String toString() {
		String result = (super.toString() + " " + this.school);
		
		return result;
	}
	
	/**
	 *	Deduction calculates the amount of a child's adjusted that is exempt from taxation
	 *	Overrides the temproary deduction method in Person.
	 *	Uses the static variables of Taxation class for calculations.
	 *	@param family to get the number of children
	 *	@return the amount of the child's taxes exempted
	 */
	@Override
	public float deduction(Family family) {
		float result = 0;
		float childBaseExemption = Taxation.getChildBaseExemption();
		float percentCounter = 0;
		
		//if family has more than two children, percent increased by 5% for each additional child
		if ((byte)family.getNumChildren() > 2) {
			percentCounter = (float)0.05 * ((byte)family.getNumChildren() - 2);
		}
		
		if (percentCounter > 0.5) {
			percentCounter = (float)0.5;
		}
		//exemption is reduced by the exemption multiplied by the percent counter
		childBaseExemption = childBaseExemption - (childBaseExemption * percentCounter);
		
		if (childBaseExemption > super.getGrossIncome()) {
			result = super.getGrossIncome();
		}
		else {
			result = childBaseExemption;
		}
		
		return result;
	}
}