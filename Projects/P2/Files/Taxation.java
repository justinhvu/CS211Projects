import java.io.File;
import java.util.Scanner;
/**
 *
 *	Taxation holds the data and methods used by other classes to calculate taxes.
 *	All fields and methods are static because this class needs to be consistent.
 *	@author Justin Vu
 *	@version CS211 Project 2 Spring 2023
 *
 */
public class Taxation
{
	//fields
	private static float socialSecurityRate = (float)12.4;
	private static float socialSecurityIncomeLimit = (float)137700.0;
	private static float medicareRate = (float)2.9;
	private static float adultBaseExemption = (float)3000.0;
	private static float childBaseExemption = (float)2000.0;
	private static float medianIncomePerCapita = (float)31099.0;
	
	//consists of the upper limit for each tax bracket
	//bracket 5 excluded because it has no upper limit
	//each column represents filing status: 1, 2, 3 from left to right
	private static float[][] incomeBracket = {
		{(float)10000	,  (float)20000   ,   (float)12000}, //bracket 1
		{(float)40000   ,  (float)70000   ,   (float)44000}, //bracket 2
		{(float)80000   ,  (float)160000  ,   (float)88000}, //bracket 3
		{(float)160000  ,  (float)310000  ,   (float)170000},//bracket 4
	};
	
	private static float[][] taxRate = {
		{(float)0.1  , (float)0.1  , (float)0.1},
		{(float)0.12 , (float)0.12 , (float)0.12},
		{(float)0.22 , (float)0.23 , (float)0.24},
		{(float)0.24 , (float)0.25 , (float)0.26},
		{(float)0.32 , (float)0.33 , (float)0.35},
	};
	
	//setters
	
	
	//getters
	public static byte getNumTaxBrackets() {
		return (byte)5;
	}
	
	public static float getSocialSecurityRate() {
		return socialSecurityRate;
	}
	
	public static float getSocialSecurityIncomeLimit() {
		return socialSecurityIncomeLimit;
	}
	
	public static float getMedicareRate() {
		return medicareRate;
	}
	
	public static float getAdultBaseExemption() {
		return adultBaseExemption;
	}
	
	public static float getChildBaseExemption() {
		return childBaseExemption;
	}
	
	public static float getMedianIncomePerCapita() {
		return medianIncomePerCapita;
	}
	
	//other methods
	/**
	 *	LoadParameters is used to change the static fields from its default
	 *	@param a text file containing values to change the fields
	 */
	public static void loadParameters(String filename) throws Exception{
		Scanner scnr = new Scanner(new File(filename));
		byte counter = 0;
		
		while (counter < 6) {
			String line = (scnr.nextLine());
			int space = line.indexOf(" ");
			
			if(line.substring(0, space).equals("socialSecurityIncomeLimit")) {
				socialSecurityIncomeLimit = Float.parseFloat(line.substring(space + 1));
			}
			else if(line.substring(0, space).equals("medianIncomePerCapita")) {
				medianIncomePerCapita = Float.parseFloat(line.substring(space + 1));
			}
			else if (line.substring(0, space).equals("socialSecurityRate")) {
				socialSecurityRate = Float.parseFloat(line.substring(space + 1));
			}
			else if(line.substring(0, space).equals("adultBaseExemption")) {
				adultBaseExemption = Float.parseFloat(line.substring(space + 1));
			}
			else if(line.substring(0, space).equals("childBaseExemption")) {
				childBaseExemption = Float.parseFloat(line.substring(space + 1));
			}
			else if(line.substring(0, space).equals("medicareRate")) {
				medicareRate = Float.parseFloat(line.substring(space + 1));
			}
			
			counter++;
		}
	}
	
	/**
	 *	MaxIncomeTaxBracket finds the maximum tax bracket a family
	 *	fits in due to their taxable income.
	 *	@param the family to get the max tax bracket for
	 */
	public static byte maxIncomeTaxBracket(Family family) {
		float taxableIncome = family.getTaxableIncome();
		byte status = (byte)(family.getFilingStatus() - 1);
		byte bracket = 0;

		for (int i = 0; i < incomeBracket.length; i++) {
			//if reached bracket 4 and the taxable income is greater than the upper range, return max bracket
			if (i == 3 && taxableIncome >= incomeBracket[i][status]) {
				bracket = 5;
			}//if in bracket 1 and taxable income is less than the upper range, return lowest bracket
			else if (i == 0 && taxableIncome <= incomeBracket[i][status]) {
				bracket = 1;
				break;
			}//if taxable income is less than the upper range for any other bracket, return the bracket
			else if (taxableIncome <= incomeBracket[i][status]) {
				bracket = (byte)(i + 1);
				break;
			}
		}
		
		return bracket;
	}
	
	/**
	 *	BracketIncome finds the portion of a family's taxable income that falls
	 *	inside the given bracket.
	 *	@param the family to be checked
	 *	@param the bracket to be checked
	 */
	public static float bracketIncome(Family family, byte b) {
		float result = 0;
		float taxableIncome = family.getTaxableIncome();
		byte status = (byte)(family.getFilingStatus() - 1);
		byte bracket = (byte)(b-1);
		
		//if in bracket 1, and taxable income is less than the range max, return taxable income
		if (bracket == 0 && taxableIncome < incomeBracket[bracket][status]) {
			result = taxableIncome;
		}//if the bracket is 1, just return the range max
		else if (bracket == 0) {
			result = incomeBracket[bracket][status];
		}//if bracket is 5, return the difference between taxable income and the range max of bracket 4
		else if (bracket == 4) {
			result = taxableIncome - incomeBracket[bracket-1][status];
		}//if previous  false, return the range of the current bracket
		else if (taxableIncome > incomeBracket[bracket][status]) {
			result = incomeBracket[bracket][status] - incomeBracket[bracket - 1][status];
		}//if taxable inside the ranges of bracket, return difference between taxable income and lower range
		else {
			result = taxableIncome - incomeBracket[bracket-1][status];
		}	
		
		return result;
	}
	
	/**
	 *	BracketTaxRate returns the tax rate that corresponds to
	 *	the given bracket and filing status.
	 *	@param the bracket to enter
	 *	@param the filing status to enter
	 */
	public static float bracketTaxRate(byte b, byte f) {
		return taxRate[(byte)(b-1)][(byte)(f-1)];
	}
}