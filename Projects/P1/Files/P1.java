public class P1
{
	public static void main(String[] args)
	{
		//System.out.println(stringValue("55 Cent"));
		//System.out.println(expValue(1, 0.001));
		//System.out.println(mirrorNum(0123));
		//System.out.println(raisedNum(244389457));
		//int[][] myArray = {{0,1,2,3}, {10,11,12,13}, {20,21,22,23}};
		//System.out.println(smallestSubarray(myArray, 70));
		//int[][] myArray = {{0,1,2},{-4,5,6},{7,8,3}};
		//System.out.println(smallestSubarray(myArray,5));
		//int[][] myArray = {{0,1,2},{-4,2,6},{2,8,3}};
		//int[] arrayElems = {};
		//replaceElement(myArray, 2, arrayElems);
		//print2dInt(myArray);
		//int[][] myArray = {{0,6,0,6},{6,7,8}};
		//int[] arrayElems = {1,2,3,4};
		//replaceElement(myArray, 6, arrayElems);
		//int[][] myArray = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
		//print1dInt(vortex(myArray));
		//int[][] myArray = {{1,2,2,2,3,4,5,5},{5,5,5,5},{5,5,9}};
		//print2dInt(removeDuplicates(myArray));
	}
	
	//print 1d array
	public static void print1dInt(int[] array) 
	{
		for (int i=0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	//print 2d array
	public static void print2dInt(int[][] array)
	{
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//helper method for stringValue
	public static String removeDupes(String word)
	{
		char previous = ' ';
		char[] wordArray = word.toCharArray();
		String newString = "";
		int i;
		int count = 0;
	
		for (i=0; i < wordArray.length; i++) {
			//if double, resets to be able to count doubles again; ignore numbers
			if (wordArray[i] == previous && count > 0 && !(wordArray[i] >= 48) && !(wordArray[i] <= 57)) {
				count = 0;
				continue;
			}
			else {
				count++;
				previous = wordArray[i];
				newString += previous;
			}
		}
		return newString;
	}
	
	public static int stringValue(String word)
	{
		int i;
		int totalValue=0;
		int max=0;
		String newWord = removeDupes(word);
		
		//store highest ASCII value
		for (i=0; i < newWord.length(); i++) {
			//ignore any numbers
			if (!((newWord.charAt(i) >= 48) && (newWord.charAt(i) <= 57))) {
				if (newWord.charAt(i) > max) {
					max = newWord.charAt(i);
				}
			}
		}
		
		//iterate through word
		for (i=0; i < newWord.length(); i++) {
			//multiply number by highest ASCII value
			if ((newWord.charAt(i) >= 48) && (newWord.charAt(i) <= 57)) {
				totalValue += (int)(newWord.charAt(i) * max);
				continue;
			}
			//ignore space
			if (newWord.charAt(i) == ' ') {
				continue;
			}
			
			totalValue += (int)(newWord.charAt(i));
		}
		return totalValue;
	}
	
	public static double expValue(int x, double precision)
	{
		int i;
		int denominator = 1;
		double sum=1.0;
		double afterSum=1.0;
		
		for (i=1; i > 0; i++) {
			afterSum += (Math.pow(x, i) / denominator);//get next iteration
			if (Math.abs(afterSum - sum) < precision) {
				break;
			}
			else {
				sum += (Math.pow(x, i) / denominator);
				denominator = denominator * (i+1);
			}
		}
		return sum;
	}
	
	public static int mirrorNum(int num)
	{
		int mirroredNum = 0;
		int digit;
		boolean negative = false;
		
		if (num < 0) {
			num *= -1;
			negative = true;
		}
		
		while (num != 0) {
			digit = num % 10; //get last digit
			mirroredNum = (mirroredNum * 10) + digit;
			num = num / 10;
		}
		
		if (negative == true) {
			mirroredNum *= -1;
		}
		
		return mirroredNum;
	}
	
	public static boolean raisedNum(long num)
	{
		int x=0;
		int y=0;
		boolean isRaised = false;
		long raised = 0;
		
		if (raised == num) {
			isRaised = true;
		}
		else {
			for (x=2; raised <= num; x++) {
				y = 2; //resets y to 2 after y's for loop
				raised = (long)Math.pow(x,y) + (long)Math.pow(y,x);
				if (raised == num) {
					isRaised = true;
					break;
				}
				else {
					for (y=2; raised <= num; y++) {
						raised = (long)Math.pow(x,y) + (long)Math.pow(y,x);
						if (raised == num) {
							isRaised = true;
							break;
						}
						else if (raised > num) {
							raised = 0; //reset raised to 0
							break;
						}
					}
				}
			}
		}
		
		return isRaised;
	}
	
	public static int[][] smallestSubarray(int[][] array,int sum)
	{
		int boundRow = array[0].length;
		int boundColumn = array.length;
		
		//create the largest square size array possible
		while (boundRow != boundColumn) {
			if (boundRow > boundColumn) {
				boundRow -= 1;
			}
			else if (boundColumn > boundRow) {
				boundColumn -= 1;
			}
		}
		//System.out.println("max Row: " + boundRow);
		//System.out.println("max Column: " + boundColumn);
		
		//movement
		int squareDimensions = 2;
		int startColumn = 0;
		int startRow = 0;
		int endColumn = array[0].length;
		int endRow = array.length;
		//array values
		int greatestSum = 0;
		int greatestSize = boundRow * boundColumn;
		int tempSum = 0;
		int tempSize = 0;
		//use this to iterate through array and add to result
		int resultStartRow = 0;
		int resultStartColumn = 0;
		int resultEndRow = 0;
		int resultEndColumn = 0;
		
		while (squareDimensions <= array.length) {//increase size of sub array
			for (int i=startRow; i < endRow - squareDimensions + 1; i++) {//move array right
				for (int j=startColumn; j < endColumn - squareDimensions + 1; j++) {//move array down
					for (int k=0; k < squareDimensions; k++) {//iterate through sub array row
						for (int m=0; m < squareDimensions; m++) {//iterate through sub array col
							tempSum += array[k+i][m+j];
							tempSize++;
							//System.out.print(array[k+i][m+j] + " ");
						}
						//System.out.println();
					}
					//System.out.println("tempSum: " + tempSum);
					//System.out.println("tempSize: " + tempSize);
					if (tempSum >= sum) {
						if (tempSum > greatestSum && tempSize <= greatestSize) {
							greatestSum = tempSum;
							greatestSize = tempSize;
							resultStartRow = i;
							resultStartColumn = j;
							resultEndRow = i + (squareDimensions);
							resultEndColumn = j + (squareDimensions);
						}
					}
					//System.out.println("Greatest Sum: " + greatestSum);
					//System.out.println("Greatest Size: " + greatestSize);
					tempSum = 0;
					tempSize = 0;
					//System.out.println();
				}
				//System.out.println();
			}
			squareDimensions++;
		}
		
		int[][] result = new int[resultEndRow - resultStartRow][resultEndColumn - resultStartColumn];
		//System.out.println(resultStartRow +" " + resultStartColumn);
		//System.out.println(resultEndRow + " " + resultEndColumn);
		
		int resultX = 0;
		int resultY = 0;
		for (int i=resultStartRow; i < resultEndRow; i++) {
			for (int j=resultStartColumn; j < resultEndColumn; j++) {
				result[resultX][resultY] = array[i][j];
				System.out.print(result[resultX][resultY] + " ");
				resultY++;
			}
			resultY = 0;
			resultX++;
			System.out.println();
		}
		
		return result;
	}
	
	public static void replaceElement(int[][] array, int elem, int[] newElem)
	{
		int count = 0;
		int shift = 0;
		int addLength = 0;
		
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < array[i].length; j++) {
				if (array[i][j] == elem) {
					count += 1;
				}
			}
			addLength = count * (newElem.length - 1);
			int[] subArray = new int[array[i].length + addLength];
			for (int j=0; j < subArray.length; j++) {
				if (array[i][j-shift] == elem) {
					for (int k=0; k < newElem.length; k++) {
						subArray[j+k] = newElem[k];
					}
					j += newElem.length - 1;
					shift += newElem.length - 1;
				}
				else if (array[i][j-shift] != elem) {
					subArray[j] = array[i][j-shift];
				}
			}
			array[i] = subArray;
			count = 0;
			shift = 0;
		}
	}
	
	public static int[][] removeDuplicates(int[][] array)
	{
		int subArrayPosition = 0;
		int count = 0;
		
		int[][] result = new int[array.length][];
		int previousInt = -17147000;
		
		for (int i=0; i < array.length; i++) {
			int[] subArray = new int[array[i].length];
			for (int j=0; j < array[i].length; j++) {
				if (array[i][j] == previousInt) {
					count++;
					continue;
				}
				else {
					previousInt = array[i][j];
					subArray[subArrayPosition] = array[i][j];
					subArrayPosition++;
				}
			}
			result[i] = subArray;
			subArrayPosition = 0;

			int[] tempArray = new int[result[i].length - count];
			for (int k=0; k < tempArray.length; k++) {
				tempArray[k] = result[i][k];
			}
			result[i] = tempArray;
			count = 0;
		}
		
		
		int emptyArrays = 0;
		
		for (int i=0; i < result.length; i++) {
			if (result[i].length == 0) {
				emptyArrays++;
			}
		}
		
		int shift = 0;
		int[][] newResult = new int[result.length - emptyArrays][];
		for (int i=0; i < result.length; i++) {
			if (result[i].length == 0) {
				shift++;
			}
			else {
				newResult[i-shift] = result[i];
			}
		}
		
		return newResult;
	}
	
	public static int[] vortex(int[][] array)
	{
		int[] result = new int[array.length * array[0].length];
		int position = 0;
		
		int topBound = 0;
		int rightBound = array[0].length;
		int bottomBound = array.length;
		int leftBound = 0;
		
		int startCol = 0;
		int startRow = 0;
		
		while (position < result.length) {
			for (int i=startCol; i < rightBound; i++) {
				result[position] = array[startRow][i];
				startCol++;
				position++;
			}
			startCol--;
			startRow++;
			topBound++;
			if (position == result.length) {
				break;
			}
			
			for (int j=startRow; j < bottomBound; j++) {
				result[position] = array[j][startCol];
				startRow++;
				position++;
			}
			startRow--;
			startCol--;
			rightBound--;
			if (position == result.length) {
				break;
			}
			
			for (int k=startCol; k >= leftBound; k--) {
				result[position] = array[startRow][k];
				startCol--;
				position++;
			}
			startCol++;
			startRow--;
			bottomBound--;
			if (position == result.length) {
				break;
			}
			
			for (int m=startRow; m >= topBound; m--) {
				result[position] = array[m][startCol];
				startRow--;
				position++;
			}
			startRow++;
			startCol++;
			leftBound++;
			if (position == result.length) {
				break;
			}
		}
		
		return result;
	}
}