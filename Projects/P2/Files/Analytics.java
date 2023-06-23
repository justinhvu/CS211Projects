/**
 *	
 *	Analytics contains methods to calculate typical statistics for the tax year.
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 * 
 */
public class Analytics
{
	//fields
	private static float povertyThreshold = (float)27750.0;
	private TaxYear taxYear;
	
	//constructors
	/**
	 * Analytics sets taxYear in order to use it in the methods.
	 * @param taxYear sets the taxYear to be analysed
	 */
	public Analytics(TaxYear taxYear) {
		this.taxYear = taxYear;
	}
	
	//setters
	/**
	 *	SetPovertyThreshold sets the field povertyThreshold to the desired value.
	 *	@param the poverty threshold to be set
	 */
	public void setPovertyThreshold(float povertyThreshold) {
		povertyThreshold = povertyThreshold;
	}
	
	//getters
	
	//other methods
	/**
	 *	AverageFamilyIncome calculates the average income of all families in a tax year.
	 *	@return the average taxable income for all families in the tax year
	 */
	public float averageFamilyIncome() {
		float result = 0;
		int numFamiliesFiled = taxYear.numberOfReturnsFiled();
		
		for (int i = 0; i < numFamiliesFiled; i++) {
			result += taxYear.getFamiliesFiled()[i].getTaxableIncome();
		}
		
		result = result / numFamiliesFiled;
		
		return result;
	}
	
	/**
	 *	AveragePersonIncome calculates the average income of all persons in a tax year.
	 *	@return the average taxable income for all Persons in the tax year
	 */
	public float averagePersonIncome() {
		float result = 0;
		int numFamiliesFiled = taxYear.numberOfReturnsFiled();
		
		for (int i = 0; i < numFamiliesFiled; i++) {
			result += taxYear.getFamiliesFiled()[i].getTaxableIncome();
		}
		
		result = result / taxYear.numberOfPersonsFiled();
		
		return result;
	}
	
	/**
	 * MaxFamilyIncome finds the family with the highest taxable income.
	 * @return the highest taxable income of all families in the tax year
	 */
	public float maxFamilyIncome() {
		float result = 0;
		int numFamiliesFiled = taxYear.numberOfReturnsFiled();
		
		for (int i = 0; i < numFamiliesFiled; i++) {
			if (taxYear.getFamiliesFiled()[i].getTaxableIncome() > result) {
				result = taxYear.getFamiliesFiled()[i].getTaxableIncome();
			}
		}
		
		return result;
	}
	
	/**
	 *	MaxPersonIncome finds the person with the highest taxable income.
	 *	@return the highest taxable income of all persons in the tax year
	 */
	public float maxPersonIncome() {
		float result = 0;
		int numFamiliesFiled = taxYear.numberOfReturnsFiled();
		
		for (int i = 0; i < numFamiliesFiled; i++) {
			for (int j = 0; j < (byte)taxYear.getFamiliesFiled()[i].getNumMembers(); j++) {
				float tempResult = 0;
				Person member = taxYear.getFamiliesFiled()[i].getMembers()[j];
				
				//the algorithm for finding the taxable income of a Person
				if (member instanceof Adult) {
					tempResult += ((Adult)member).adjustedIncome();
					tempResult -= ((Adult)member).deduction(taxYear.getFamiliesFiled()[i]);
				}
				else if (member instanceof Child) {
					tempResult += ((Child)member).getGrossIncome();
					tempResult -= ((Child)member).deduction(taxYear.getFamiliesFiled()[i]);
				}
				
				if (tempResult > result) {
					result = tempResult;
				}
			}
		}
		
		return result;
	}
	
	/**
	 *	FamiliesBelowPovertyLimit finds the number of families who's taxable
	 *	income is below the set poverty threshold.
	 *	@return the number of families with taxable income below the poverty line
	 */
	public int familiesBelowPovertyLimit() {
		int result = 0;
		int numFamiliesFiled = taxYear.numberOfReturnsFiled();
		
		for (int i = 0; i < numFamiliesFiled; i++) {
			if (taxYear.getFamiliesFiled()[i].getTaxableIncome() < this.povertyThreshold) {
				result++;
			}
		}
		
		return result;
	}
	
	/**
	 * FamilyRank finds the ranking of a family in the respective tax year based
	 * on all families taxable income.
	 * The family with the highest taxable income is ranked as 1.
	 * @param the family to be checked
	 * @return the relative ranking of the family passed
	 */
	public int familyRank(Family family) {
		int rank = 1;
		
		for (int i = 0; i < taxYear.getFamiliesFiled().length; i++) {
			if (family.getTaxableIncome() < taxYear.getFamiliesFiled()[i].getTaxableIncome()) {
				rank++;
			}
		}
		
		return rank;
	}
}