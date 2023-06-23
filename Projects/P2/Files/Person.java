/**
 *
 *	Person class is the parent to Adult and Child.
 *	It contains the methods used to validate info passed
 *	through Adult and child.
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 *
 */
public class Person
{
	//fields
	private int id = 1;
	//unique id is static so it can be incremented for every call of Person
	private static int uniqueId = 1;
	private String name;
	private String birthday;
	private String ssn;
	private float grossIncome;
	
	//constructor
	/**
	 *	Person constructor takes no parameters.
	 *	It is used everytime a new adult or child
	 *	object is called.
	 *	It sets the ID to the object,
	 *	then it increments the static variable uniqueId
	 *	to be used to assign a consecutive id to the next person.
	 */
	public Person() {
		id = uniqueId;
		uniqueId++;
	}
	
	//setters
	/**
	 *	SetName checks if the param consists of only letters
	 *	@param the name to checked
	 *	@return true if name is only letters, false otherwise
	 */
	public boolean setName(String name) {
		boolean result = false;
		for (int i = 0; i < name.length(); i++) {
			if (Character.isLetter(name.charAt(i)) || name.charAt(i) == 32) {
				result = true;
			}
			else {
				result = false;
				break;
			}
		}
		if (result == true) {
			this.name = name;
		}
		
		return result;
	}
	
	/**
	 *	SetBirthday checks if the birthday is in the correct format
	 *	@param birthday to be checked
	 *	@return true if format is correct, false otherwise
	 */
	public boolean setBirthday(String birthday) {
		boolean result = false;
		//length of birthday string must be 10 chars
		if (birthday.length() != 10) {
			result = false;
		}
		else {
			//only parenthesis must be the 5th and 8 character ****/**/**
			if (birthday.charAt(4) != 47 || birthday.charAt(7) != 47) {
				result = false;
			}
			else {
				//check if the year is valid
				String year = birthday.substring(0,4);
				for (int i = 0; i < year.length(); i++) {
					if (Character.isDigit(year.charAt(i))) {
						result = true;
					}
					else {
						result = false;
						break;
					}
				}
				//only continue to month if year is valid
				//check if month is valid
				if (result == true) {
					String month = birthday.substring(5,7);
					for (int i = 0; i < month.length(); i++) {
						if (Character.isDigit(month.charAt(i))) {
							result = true;
						}
						else {
							result = false;
							break;
						}
					}
					//only continue if month is valid
					//check if date is valid
					if (result == true) {
						String day = birthday.substring(8);
						for (int i = 0; i < day.length(); i++) {
							if (Character.isDigit(day.charAt(i))) {
								result = true;
								
							}
							else {
								result = false;
								break;
							}
						}
					}
				}
			}
		}
		//if everything is valid, set birthday and return the boolean
		if (result == true) {
			this.birthday = birthday;
		}
		
		return result;
	}
	
	/**
	 *	SetSSN checks if the ssn is in the correct format
	 *	@param ssn to be checked
	 *	@return true if format is correct, false otherwise
	 */
	public boolean setSSN(String ssn) {
		boolean result = false;
		//length of ssn string must be 11 chars
		if (ssn.length() != 11) {
			result = false;
		}
		else {
			//only dashes must be the 4th and 7th character ***-**-****
			if (ssn.charAt(3) != 45 || ssn.charAt(6) != 45) {
				result = false;
			}
			else {
				//check if first part of ssn is valid
				String first = ssn.substring(0,3);
				for (int i = 0; i < first.length(); i++) {
					if (Character.isDigit(first.charAt(i))) {
						result = true;
					}
					else {
						result = false;
						break;
					}
				}
				//only continue if first part valid
				//check if second part valid
				if (result == true) {
					String second = ssn.substring(4,6);
					for (int i = 0; i < second.length(); i++) {
						if (Character.isDigit(second.charAt(i))) {
							result = true;
						}
						else {
							result = false;
							break;
						}
					}
					//only continue if second part valid
					//check if third part valid
					if (result == true) {
						String third = ssn.substring(7);
						for (int i = 0; i < third.length(); i++) {
							if (Character.isDigit(third.charAt(i))) {
								result = true;
							}
							else {
								result = false;
								break;
							}
						}
					}
				}
			}
		}
		//if everything valid, set ssn and return true
		if (result == true) {
			this.ssn = ssn;
		}
		
		return result;
	}
	
	/**
	 *	setGrossIncome checks if the gross income is negative
	 *	@param grossIncome to be checked
	 *	@return true if grossIncome is positive or 0, false otherwise
	 */
	public boolean setGrossIncome(float grossIncome) {
		boolean result = false;
		//gross income cannot be negative
		if (grossIncome < 0) {
			result = false;
		}
		else {
			result = true;
			this.grossIncome = grossIncome;
		}
		
		return result;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public String getBirthday() {
		return this.birthday;
	}
	
	public String getSsn() {
		return this.ssn;
	}
	
	public float getGrossIncome() {
		return this.grossIncome;
	}
	
	public int getId() {
		return this.id;
	}
	
	//other methods
	/**
	 *	toString prints out the desired format for the informationo of a person
	 */
	public String toString() {
		String result = (this.name + " xxx-xx-" + this.ssn.substring(7) + " " + this.birthday.substring(0,4) + "/**/**");
		
		return result;
	}
	
	/**
	 *	Deduction is a temp method to be overriden by Adult or Child class
	 */
	public float deduction(Family family) {
		return 0;
	}
}