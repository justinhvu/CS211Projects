/**
 *
 *	Family is a storage of persons; it can contain Adults and Childs.
 *	This class is used to get information and calculations for Familys
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 *
 */
public class Family
{
	//fields
	private byte numMembers = 0;
	/**
	 *	filing status is either:
	 *	1 for single
	 *	2 for married filed jointly
	 *	3 for married filed sperately
	 */
	private byte filingStatus;
	private Person[] members;
	
	//constructor
	/**
	 *	Family constructor allocates memory for the storage of Persons
	 *	and sets the family's filing status.
	 *	@param numMembers sets the number of members in the family, used to
	 *		intialize the length of the array of Persons.
	 *	@param filingStatus sets the family's filing status
	 */
	public Family(byte numMembers, byte filingStatus) {
		this.numMembers = numMembers;
		this.members = new Person[this.numMembers];
		this.filingStatus = filingStatus;
	}
	
	//setters
	
	//getters
	/**
	 * GetNumAdults counts all of the Adults in family.
	 * @return the number of Adults in a family
	 */
	public byte getNumAdults() {
		byte counter = 0;
		for (int i = 0; i < this.members.length; i++) {
			if (this.members[i] instanceof Adult) {
				counter++;
			}
		}
		
		return counter;
	}
	
	/**
	 *	GetNumChildren counts all of the Childs in family.
	 *	@return the number of Childs in a family
	 */
	public byte getNumChildren() {
		byte counter = 0;
		for (int i = 0; i < this.members.length; i++) {
			if (this.members[i] instanceof Child) {
				counter++;
			}
		}
		
		return counter;
	}
	
	public byte getFilingStatus() {
		return this.filingStatus;
	}
	
	/**
	 *	GetTaxableIncome calculates the the total taxable income for a family.
	 *	A family's taxable income is based on the sums of all adult's adjusted income
	 *	and all child's gross income, minus any deductions.
	 *	@return the calculated taxable income for a family
	 */
	public float getTaxableIncome() {
		//create new family object to be passed as parameter of deduction
		Family family = new Family(this.numMembers, this.filingStatus);
		//repopulate the family object; else, the family is empty
		for (int i = 0; i < this.members.length; i++) {
			family.members[i] = this.members[i];
		}
		
		float result = 0;
		
		for (int i = 0; i < this.members.length; i++) {
			if (this.members[i] instanceof Adult) {
				result += ((Adult)this.members[i]).adjustedIncome();
				result -= ((Adult)this.members[i]).deduction(family);
			}
			else if (this.members[i] instanceof Child) {
				result += ((Child)this.members[i]).getGrossIncome();
				result -= ((Child)this.members[i]).deduction(family);
			}
		}
		
		return result;
	}
	
	public Person[] getMembers() {
		return this.members;
	}
	
	public byte getNumMembers() {
		return this.numMembers;
	}
	
	//other methods
	/**
	 *	AddMember adds a person into the family.
	 *	@param the person to be added into the family
	 */
	public void addMember(Person person) {
		//extend the length of the family by 1 each team this method is called
		if (this.members[this.numMembers - 1] != null) {
			Person[] tempMembers = new Person[this.numMembers + 1];
			tempMembers[this.numMembers] = person;
			//repopulate the new family and set this.members to the temp family
			for (int j = 0; j < this.members.length; j++) {
				tempMembers[j] = this.members[j];
			}
			this.members = tempMembers;
			this.numMembers++;
		}
		
		//add in the param person to the family
		for (int i = 0; i < this.numMembers; i++) {
			if (this.members[i] == null) {
				this.members[i] = person;
				break;
			}
		}
	}
	
	/**
	 *	TaxCredit calculates the amount of tax credit that a family can get.
	 *	@return the possible tax credit for a family
	 */
	public float taxCredit() {
		float result = 0;
		float credit = 0;
		float taxableIncome = getTaxableIncome();

		// A family is eligible for tax credit only if their taxable income is
		// less than the half the median income per capita.
		if (taxableIncome <= Taxation.getMedianIncomePerCapita() / 2) {
			//credit is increased by 30 dollars for every whole thousand of taxable income
			while (taxableIncome > 1000) {
				credit += 30;
				taxableIncome -= 1000;
			}
			// children are eligible for more credit; being the lower of their tuition or 1000
			for (int i = 0; i < this.numMembers; i++) {
				if (this.members[i] instanceof Child) {
					Child child = (Child)this.members[i];
					if (child.getTuition() < 1000) {
						credit += child.getTuition();
					}
					else {
						credit += 1000;
					}
				}
			}
		}
		if (credit > 2000) {
			credit = 2000;
		}
		
		if (credit < taxableIncome) {
			result = credit;
		}
		else {
			result = taxableIncome;
		}
		
		if (getFilingStatus() == 3) {
			result = result/2;
		}
		
		return result;
	}
	
	/**
	 *	CalculateTax calculates the amount of tax that a family owes or is refunded
	 *	@return how much tax a family owes or needs to be refunded
	 */
	public float calculateTax() {
		float result = 0;
		//new family object to pass as parameter to maxIncomeTaxBracket
		Family family = new Family(this.numMembers, this.filingStatus);
		for (int i = 0; i < this.numMembers; i++) {
			family.members[i] = this.members[i];
		}
		
		byte maxIncomeTaxBracket = Taxation.maxIncomeTaxBracket(family);
		
		//add amounts of tax for each tax bracket up till the max tax bracket
		for (int i = 1; i <= maxIncomeTaxBracket; i++) {
			float bracketTaxRate = Taxation.bracketTaxRate((byte)i, (byte)this.filingStatus);
			float bracketIncome = Taxation.bracketIncome(family, (byte)i);
			
			result += bracketTaxRate * bracketIncome;
		}		
		
		float taxCredit = taxCredit();
		
		result -= taxCredit;
		
		//subtract the tax withheld for every adult in the family
		for (int i = 0; i < this.members.length; i++) {
			if (this.members[i] instanceof Adult) {
				result -= ((Adult)this.members[i]).taxWithheld();
			}
		}
		
		return result;
	}
}