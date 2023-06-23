/**
 *
 *	Adult is a subclass of Person.
 *	This class has the same fields as Person, with additional employer.
 *	It contains methods for the calculations specific to Adults.
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 *
 */
public class Adult extends Person
{
	
	//fields
	private String employer;
	
	//constructor
	/**
	 *	Adult constructor takes in the information needed for every adult object.
	 *	The setters in Person class are used to validate the passed in parameters.
	 *	@param The possible name of an Adult.
	 *	@param The possible birthday of an Adult.
	 *	@param The possible ssn of an Adult.
	 *	@param The possible gross income of an Adult.
	 *	@param The employer of an adult.
	 */
	public Adult(String name, String birthday, String ssn, float grossIncome, String employer) {
		setName(name);
		setBirthday(birthday);
		setSSN(ssn);
		setGrossIncome(grossIncome);
		this.employer = employer;
	}
	
	//setters
	
	//getters
	public String getEmployer() {
		return this.employer;
	}
	
	//other methods
	/**
	 *	ToString prints out the desired format for an Adult.
	 *	It overrides the Person toString.
	 *	It uses the Person toString as super to use the base format of a person.
	 *	@return the desired format of an Adult's information.
	 */
	@Override
	public String toString() {
		String result = (super.toString() + " " + String.format("%.2f", getGrossIncome()));
		
		return result;
	}
	
	/**
	 *	AdjustedIncome will calculate the adjusted income of an Adult.
	 *	An adult's adjusted income is their gross income minus a social
	 *	security tax and medicare tax.
	 *	It uses the static variables of the Taxation class to do calculations.
	 *	@return the Adult's adjusted income.
	 */
	public float adjustedIncome() {
		float result = 0;
		float socialSecurityTax;
		float medicareTax;
		float tempGrossIncome = super.getGrossIncome();
		//only start calculations if the adult is employed
		if (getEmployer() != null) {
			
			/**
			 *	gross income cannot be greater than the social secutiy income limit
			 *	if it is, the max amount that can be used is the limit.
			 *	else, gross income is used.
			 */
			if (super.getGrossIncome() > Taxation.getSocialSecurityIncomeLimit()) {
				tempGrossIncome = Taxation.getSocialSecurityIncomeLimit();
			}
			
			//calculate each tax seperately and sum them, this is total tax
			socialSecurityTax = tempGrossIncome * (Taxation.getSocialSecurityRate() / (float)100.0);
			medicareTax = super.getGrossIncome() * (Taxation.getMedicareRate() / (float)100.0);

			//the total tax is split evenly between the adult and the employer
			result = super.getGrossIncome() - ((socialSecurityTax + medicareTax) / (float)2.0);
		}
		
		return result;
		
	}
	
	/**
	 *	TaxWithheld will calculate the amount of tax an withheld from an adult's pay.
	 *	Tax withheld is done at a progessive rate base on the adult's gross income.
	 *	@return the total tax withheld
	 */
	public float taxWithheld() {
		float result = 0;
		
		
		if (super.getGrossIncome() <= 50000) {
			result = (float)(super.getGrossIncome() * 0.10);
		}//add in 5000 because its the 10% of the first 50000
		else if (super.getGrossIncome() <= 150000) {
			result = (float)(5000 + ((super.getGrossIncome() - 50000) * 0.15));
		}//add in 15000 because its the 15% of the previous range of 100000
		else if (super.getGrossIncome() > 150000) {
			result = (float)(5000 + 15000 + ((super.getGrossIncome() - 150000) * 0.20));
		}
		
		return result;
		
	}
	
	/**
	 *	Deduction calculates the amount of an adult's adjusted that is exempt from taxation
	 *	Overrides the temproary deduction method in Person.
	 *	Uses the static variables of Taxation class for calculations.
	 *	@param family to get the number of children
	 *	@return the amount of the adult's taxes exempted
	 */
	@Override
	public float deduction(Family family) {
		float result = 0;
		float adultBaseExemption = Taxation.getAdultBaseExemption();
		float adjustedIncome = adjustedIncome();
		float tempAdjustedIncome = adjustedIncome - 100000;
		float percentCounter = 0;
		
		//if the family is filed as single parent with children
		if ((byte)family.getFilingStatus() == 1 && (byte)family.getNumChildren() != 0) {
			adultBaseExemption *= 2;
		}
		if (adjustedIncome > 100000) {
			//increments percent counter for every 1000 dollars above adjusted income
			while (tempAdjustedIncome > 1000 && percentCounter <= 0.3) {
				percentCounter += (float)0.005;
				tempAdjustedIncome -= (float)1000;
			}
			if (percentCounter > (float)0.3) {
				percentCounter = (float)0.3;
			}
			//exemption is reduced by the exemption multiplied by the percent counter
			adultBaseExemption = adultBaseExemption - (adultBaseExemption * percentCounter);
		}
		
		if (adultBaseExemption > adjustedIncome) {
			result = adjustedIncome;
		}
		else {
			result = adultBaseExemption;
		}
		
		return result;
	}
}