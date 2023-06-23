/**
 *
 *	TaxYear is a storage of Familys who have filed a tax return.
 *	It contains methods to get taxation info for Familys
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 *
 */
public class TaxYear
{
	//fields
	private int max;
	private Family[] familiesFiled;
	
	//constructors
	/**
	 *	TaxYear constructor sets the max number of familes that can be filed in one tax year.
	 *	It also allocates memory for the array of Familys
	 *	@param the max number of families for a tax year
	 */
	public TaxYear(int max) {
		this.max = max;
		this.familiesFiled = new Family[0];
	}
	
	//setters
	
	//getters
	public Family[] getFamiliesFiled() {
		return this.familiesFiled;
	}
	
	//other methods
	/**
	 *	TaxFiling is used to add a family into a tax year.
	 *	The family's information must be validated before it is added.
	 *	@param the family to be checked and possibly added
	 *	@return if the family information is valid
	 */
	public boolean taxFiling(Family family) {
		boolean result = true;
		
		//if trying to add in another family above the max amount of families allowed
		if (numberOfReturnsFiled() == this.max) {
			result = false;
		}
		
		//if the filing status is not 1, 2, 3
		if ((byte)family.getFilingStatus() < 1 || (byte)family.getFilingStatus() > 3) {
			result = false;
		}//if family has more than two adults or no adults
		if ((byte)family.getNumAdults() > 2 || (byte)family.getNumAdults() < 1) {
			result = false;
		}//if filed as single, but more than one adult
		if ((byte)family.getFilingStatus() == 1 && (byte)family.getNumAdults() != 1) {
			result = false;
		}//if filed as seperate, but more than one adult
		if ((byte)family.getFilingStatus() == 3 && (byte)family.getNumAdults() != 1) {
			result = false;
		}//if filed as married, but doesn't have two adults
		if ((byte)family.getFilingStatus() == 2 && (byte)family.getNumAdults() != 2) {
			result = false;
		}
		
		int numFamilies = this.familiesFiled.length;
		
		//if a family is valid to be added
		if (result) {
			//extends the array 
			Family[] tempFamiliesFiled = new Family[numFamilies + 1];
			if (tempFamiliesFiled[numFamilies] == null) {
				tempFamiliesFiled[numFamilies] = family;
			}
			
			//repopulates the temp array
			for (int i = 0; i < numFamilies; i++) {
				if (familiesFiled[i] != null) {
					tempFamiliesFiled[i] = this.familiesFiled[i];
				}
			}
			
			this.familiesFiled = tempFamiliesFiled;
		}
		
		return result;
	}
	
	/**
	 *	TaxWithheld calculates the total amount of tax withheld for all families in the tax year.
	 *	@return the total amount of tax withheld
	 */
	public float taxWithheld() {
		float result = 0;
		
		for (int i = 0; i < this.familiesFiled.length; i++) {
			for (int j = 0; j < this.familiesFiled[i].getMembers().length; j++) {
				//only Adults are possible to have tax withheld
				if (this.familiesFiled[i].getMembers()[j] instanceof Adult) {
					result += (((Adult)this.familiesFiled[i].getMembers()[j]).taxWithheld());
				}
			}
		}
		
		return result;
	}
	
	/**
	 *	TaxOwed calculates the total tax owed by all families in the tax year.
	 *	@return the sum of each family's tax owed
	 */
	public float taxOwed() {
		float result = 0;
		
		for (int i = 0; i < this.familiesFiled.length; i++) {
			byte maxIncomeTaxBracket = Taxation.maxIncomeTaxBracket(this.familiesFiled[i]);
			for (int j = 1; j <= maxIncomeTaxBracket; j++) {
				float bracketTaxRate = Taxation.bracketTaxRate((byte)j, (byte)this.familiesFiled[i].getFilingStatus());
				float bracketIncome = Taxation.bracketIncome(this.familiesFiled[i], (byte)j);
			
				result += bracketTaxRate * bracketIncome;
			}
		}
		
		return result;
	}
	
	/**
	 *	TaxDue calculates the total tax due or is to be refunded of all families in the tax year.
	 *	@return the sum of each family's calculated tax
	 */
	public float taxDue() {
		float result = 0;
		
		for (int i = 0; i < this.familiesFiled.length; i++) {
			result += this.familiesFiled[i].calculateTax();
		}

		return result;
	}
	
	/**
	 *	TaxCredits calculates the total tax credits given to all families in the tax year.
	 *	@return the sum of each family's tax credit
	 */
	public float taxCredits() {
		int result = 0;
		
		for (int i = 0; i < this.familiesFiled.length; i++) {
			result += this.familiesFiled[i].taxCredit();
		}
		
		return result;
	}
	
	/**
	 *	Gets the number of Familys filed in the tax year.
	 *	@return number of Familys filed
	 */
	public int numberOfReturnsFiled() {
		return this.familiesFiled.length;
	}
	
	/**
	 *	Gets the number of Persons filed in the tax year.
	 *	@return number of Persons filed
	 */
	public int numberOfPersonsFiled() {
		int result = 0;
		
		for (int i = 0; i < this.familiesFiled.length; i++) {
			for (int j = 0; j < this.familiesFiled[i].getMembers().length; j++) {
				result++;
			}
		}
		
		return result;
	}
	
	/**
	 *	Gets the Family stored at the given index in the storage of Familys in the tax year.
	 *	@param the index of desired family
	 *	@return the family at the index given
	 */
	public Family getTaxReturn(int index) {
		return this.familiesFiled[index];
	}
}