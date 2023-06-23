// save this class in a file named E1.java
class E1
{
	// The main method will not be graded
	// You must use it for testing your code
	public static void main(String[] args)
	{
	////////////////// testing approach 1 ///////////////////////
	//       use the following code and run your program       //
	// by providing the three numbers directly in the terminal //
	// e.g. C:\> java E1 34 2 50 //
		int a = Integer.parseInt(args[0]); //
		int b = Integer.parseInt(args[1]); //
		int c = Integer.parseInt(args[2]); //
		System.out.println(calculate(a,b,c)); //
	/////////////////////////////////////////////////////////////
	////////////////// testing approach 2 ///////////////////////
	//  call the calculate method with any arguments you want  //
	// and print the returned value //
	//	System.out.println(calculate(7, 8, 6));
	/////////////////////////////////////////////////////////////
	}
	public static int calculate(int card1, int card2, int card3)
	{
	// You must put all your code here
	// this method must return an integer, for example:
	// return 0;
	
		//invalid card
		if ((card1 < 1) || (card1 > 52)) {
			return 0;
		}
		else if ((card2 < 1) || (card2 > 52)) {
			return 0;
		}
		else if ((card3 < 1) || (card3 > 52)) {
			return 0;
		}
	
		// set upper and lower bounds of each suit
		int clubsLower=1, clubsUpper=13;
		int diamondsLower=14, diamondsUpper=26;
		int heartsLower=27, heartsUpper=39;
		int spadesLower=40, spadesUpper=52;
		
		//order cards from least to greatest
		int firstCard=card1;
		int secondCard=0;
		int thirdCard=0;
		
		if (card2 > card1) {
			secondCard = card2;
		}
		else if (card2 < card1) {
			firstCard = card2;
			secondCard = card1;
		}
		
		if (card3 > secondCard) {
			thirdCard = card3;
		}
		else if (card3 < firstCard) {
			thirdCard = secondCard;
			secondCard = firstCard;
			firstCard = card3;
		}
		else {
			thirdCard = secondCard;
			secondCard = card3;
		}
		
		//determine points
		int points=1;
		
		//straight flush,staights, and flushes
		if ((thirdCard != 14) && (thirdCard != 27) && (thirdCard != 40)) { //accounts for aces
		//if ace is last card, cannot be straight or flush
			if ((firstCard >= clubsLower) && (thirdCard <= clubsUpper)) { //all clubs
				if ((firstCard == (secondCard - 1)) && (thirdCard == (secondCard + 1))) { //sequential order
					points = 10;
				}
				else { //will be flush regardless if all cards in same range
					points = 5;
				}
			}
			else if ((firstCard >= diamondsLower) && (thirdCard <= diamondsUpper)) { //all diamonds
				if ((firstCard == (secondCard - 1)) && (thirdCard == (secondCard + 1))) {
					points = 10;
				}
				else {
					points = 5;
				}
			}
			else if ((firstCard >= heartsLower) && (thirdCard <= heartsUpper)) { //all hearts
				if ((firstCard == (secondCard - 1)) && (thirdCard == (secondCard + 1))) {
					points = 10;
				}
				else {
					points = 5;
				}
			}
			else if((firstCard >= spadesLower) && (thirdCard <= spadesUpper)) { //all spades
				if ((firstCard == (secondCard - 1)) && (thirdCard == (secondCard + 1))) {
					points = 10;
				}
				else {
					points = 5;
				}
			}
			else {
				//convert cards to one range: 1-13
				if (firstCard >= spadesLower) {
					firstCard = firstCard - 39;
				}
				else if (firstCard >= heartsLower) {
					firstCard = firstCard - 26;
				}
				else if (firstCard >= diamondsLower) {
					firstCard = firstCard - 13;
				}
				
				if (secondCard >= spadesLower) {
					secondCard = secondCard - 39;
				}
				else if (secondCard >= heartsLower) {
					secondCard = secondCard - 26;
				}
				else if (secondCard >= diamondsLower) {
					secondCard = secondCard - 13;
				}
				
				if (thirdCard >= spadesLower) {
					thirdCard = thirdCard - 39;
				}
				else if (thirdCard >= heartsLower) {
					thirdCard = thirdCard - 26;
				}
				else if (thirdCard >= diamondsLower) {
					thirdCard = thirdCard - 13;
				}
				
				//straight
				if ((firstCard == (secondCard - 1)) && (thirdCard == (secondCard + 1))) { //sequential order
					points = 7;
				}
				//three of a kind
				else if ((firstCard == secondCard) && (thirdCard == secondCard)) {
					points = 8;
				}
				//pair
				else if ((firstCard == secondCard) || (firstCard == thirdCard) || (secondCard == thirdCard)) {
					points = 3;
				}
			}
		}
		return points;
	}
}
