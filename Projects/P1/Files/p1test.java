import java.util.Arrays;

class p1test {
    // write a printarray method that prints out the contents of a 2d array
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // this is a tester file for the P1.java file
        // it should print out the test cases and results. include a pass/fail and score
        // message

        int score = 0;
        int scorePotential = 0;
        System.out.println("This is a tester file for the CS211 java assignment P1.java");
        System.out.println(
                "It will print out the input and output of the test case, as well as the result. At the end, of each test case you will receive a pass/fail");

        System.out.println("Test case 1 is StringValue: ");
        System.out.println("Official cases: ");
        System.out.println("Input: Mason. Expected output: 510. Actual output: " + P1.stringValue("Mason"));
        if (P1.stringValue("Mason") == 510) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: Mas on. Expected output: 510. Actual output: " + P1.stringValue("Mas on"));
        if (P1.stringValue("Mas on") == 510) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: mass. Expected output: 321. Actual output: " + P1.stringValue("mass"));
        if (P1.stringValue("mass") == 321) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: massss. Expected output: 436. Actual output: " + P1.stringValue("massss"));
        if (P1.stringValue("massss") == 436) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: masssss. Expected output: 551. Actual output: " + P1.stringValue("masssss"));
        if (P1.stringValue("masssss") == 551) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 50 Cent. Expected output: 12110. Actual output: " + P1.stringValue("50 Cent"));
        if (P1.stringValue("50 Cent") == 12110) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println();

        System.out.println("Test case 2 is ExpValue: ");
        System.out.println("Official cases: ");
        System.out.println(
                "Input: 1, 0.0000001. Expected output: 2.7182818011463845. Actual output: "
                        + P1.expValue(1, 0.0000001));
        if (P1.expValue(1, 0.0000001) == 2.7182818011463845) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 1, 0.00000001. Expected output: 2.718281826198493. Actual output: "
                + P1.expValue(1, 0.00000001));
        if (P1.expValue(1, 0.00000001) == 2.718281826198493) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println();

        System.out.println("Test case 3 is mirrorNum: ");
        System.out.println("Official cases: ");
        System.out.println("Input: 6. Expected output: 6. Actual output: " + P1.mirrorNum(6));
        if (P1.mirrorNum(6) == 6) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 17. Expected output: 71. Actual output: " + P1.mirrorNum(17));
        if (P1.mirrorNum(17) == 71) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 98014. Expected output: 41089. Actual output: " + P1.mirrorNum(98014));
        if (P1.mirrorNum(98014) == 41089) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: -593 Expected output: -395. Actual output: " + P1.mirrorNum(-593));
        if (P1.mirrorNum(-593) == -395) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 12300. Expected output: 321. Actual output: " + P1.mirrorNum(12300));
        if (P1.mirrorNum(12300) == 321) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        System.out.println("Test case 4 is RaisedNum: ");
        System.out.println("Official cases: ");
        System.out.println("Input: 6. Expected output: false. Actual output: " + P1.raisedNum(6));
        if (P1.raisedNum(6) == false) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 17. Expected output: true. Actual output: " + P1.raisedNum(17));
        if (P1.raisedNum(17) == true) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 593. Expected output: true. Actual output: " + P1.raisedNum(593));
        if (P1.raisedNum(593) == true) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        System.out.println("Input: 1125. Expected output: false. Actual output: " + P1.raisedNum(1125));
        if (P1.raisedNum(1125) == false) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println();

        System.out.println("Test case 5 is smallestSubarray: ");
        System.out.println("Official cases: ");
        int[][] test1 = { { 0, 1, 2 }, { -4, 5, 6 }, { 7, 8, 3 } };
        int[][] test1Ans = { { 5, 6 }, { 8, 3 } };
        int test1Sum = 5;
        int[][] test2 = { { 0, 1, 2 }, { -4, 5, 6 }, { 7, 8, 3 } };
        int[][] test2Ans = { { 0, 1, 2 }, { -4, 5, 6 }, { 7, 8, 3 } };
        int test2Sum = 23;
        // print out test case 1 and results
        System.out.println("Test case 1: ");
        System.out.println("Input: {{0,1,2},{-4,5,6},{7,8,3}}, 5. Expected output: [[5,6],[8,3]]. Actual output: "
                + Arrays.deepToString(P1.smallestSubarray(test1, test1Sum)));
        if (Arrays.deepEquals(P1.smallestSubarray(test1, test1Sum), test1Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }
        // print out test case 2 and results
        System.out.println("Test case 2: ");
        System.out.println(
                "Input: {{0,1,2},{-4,5,6},{7,8,3}}, 23. Expected output: [[0,1,2],[-4,5,6],[7,8,3]]. Actual output: "
                        + Arrays.deepToString(P1.smallestSubarray(test2, test2Sum)));
        if (Arrays.deepEquals(P1.smallestSubarray(test2, test2Sum), test2Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println();

        System.out.println("Test case 6 is replaceElement: ");
        System.out.println("Official cases: ");
        int[][] replaceElem1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } };
        int elem1 = 2;
        int[] newElem1 = { 0 };
        int[][] replaceElem1Ans = { { 1, 0, 3, 4, 5 }, { 6, 7, 8 } };

        int[][] replaceElem2 = { { 1, 2, 3, 4, 5 }, { 5, 4, 3, 2 } };
        int elem2 = 5;
        int[] newElem2 = { -5, 5 };
        int[][] replaceElem2Ans = { { 1, 2, 3, 4, -5, 5 }, { -5, 5, 4, 3, 2 } };

        int[][] replaceElem3 = { { 0, 1, 2, 3, 4, 5 }, { 5, 4, 3, 4 } };
        int elem3 = 4;
        int[] newElem3 = { 1, 2, 3 };
        int[][] replaceElem3Ans = { { 0, 1, 2, 3, 1, 2, 3, 5 }, { 5, 1, 2, 3, 3, 1, 2, 3 } };

        // print out test case 1 and results
        System.out.println("Test case 1: ");
        System.out.println(
                "Input: {{1,2,3,4,5}}, 2, {0}. \nExpected output: [[ 1, 0, 3, 4, 5 ], [ 6, 7, 8 ]].\n Actual output: ");
        P1.replaceElement(replaceElem1, elem1, newElem1);
        System.out.println(Arrays.deepToString(replaceElem1));
        if (Arrays.deepEquals(replaceElem1, replaceElem1Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        // print out test case 2 and results
        System.out.println("Test case 2: ");
        System.out.println(
                "Input: {{1,2,3,4,5},{5,4,3,2}}, 5, {-5,5}. \nExpected output: [[ 1, 2, 3, 4, -5, 5 ], [ -5, 5, 4, 3, 2 ]].\n Actual output: ");
        P1.replaceElement(replaceElem2, elem2, newElem2);
        System.out.println(Arrays.deepToString(replaceElem2));
        if (Arrays.deepEquals(replaceElem2, replaceElem2Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        // print out test case 3 and results
        System.out.println("Test case 3: ");
        System.out.println(
                "Input: {{0,1,2,3,4,5},{5,4,3,4}}, 4, {1,2,3}. \nExpected output: [[ 0, 1, 2, 3, 1, 2, 3, 5 ], [ 5, 1, 2, 3, 3, 1, 2, 3 ]].\n Actual output: ");
        P1.replaceElement(replaceElem3, elem3, newElem3);
        System.out.println(Arrays.deepToString(replaceElem3));
        if (Arrays.deepEquals(replaceElem3, replaceElem3Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        // next test case is removeDuplicates
        System.out.println("Test case 7 is removeDuplicates: ");
        System.out.println("Official cases: ");
        int[][] removeDup1 = { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } };
        int[][] removeDup1Ans = { { 1, 2, 3, 4, 5 }, { 6, 7, 8 } };
        int[][] removeDup2 = { { 1, 2, 2, 2, 3, 4, 5, 5 }, { 6, 7, 8, 8, 8, 9 } };
        int[][] removeDup2Ans = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9 } };
        int[][] removeDup3 = { { 1, 2, 2, 2, 3, 4, 5, 5 }, { 5, 5, 5, 5 }, { 5, 5, 9 } };
        int[][] removeDup3Ans = { { 1, 2, 3, 4, 5 }, { 9 } };

        // print out test case 1 and results
        System.out.println("Test case 1: ");
        System.out.println(
                "Input: {{1,2,3,4,5},{6,7,8}}. \nExpected output: [[ 1, 2, 3, 4, 5 ], [ 6, 7, 8 ]].\n Actual output: ");
        P1.removeDuplicates(removeDup1);
        System.out.println(Arrays.deepToString(removeDup1));
        if (Arrays.deepEquals(removeDup1, removeDup1Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        // print out test case 2 and results
        System.out.println("Test case 2: ");
        System.out.println(
                "Input: {{1,2,2,2,3,4,5,5},{6,7,8,8,8,9}}. \nExpected output: [[ 1, 2, 3, 4, 5 ], [ 6, 7, 8, 9 ]].\n Actual output: ");
        P1.removeDuplicates(removeDup2);
        System.out.println(Arrays.deepToString(removeDup2));
        if (Arrays.deepEquals(removeDup2, removeDup2Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        // print out test case 3 and results
        System.out.println("Test case 3: ");
        System.out.println(
                "Input: {{1,2,2,2,3,4,5,5},{5,5,5,5},{5,5,9}}. \nExpected output: [[ 1, 2, 3, 4, 5 ], [ 5 ], [ 5, 9 ]].\n Actual output: ");
        P1.removeDuplicates(removeDup3);
        System.out.println(Arrays.deepToString(removeDup3));
        if (Arrays.deepEquals(removeDup3, removeDup3Ans)) {
            System.out.println("Pass");
            score++;
            scorePotential++;
        } else {
            System.out.println("Fail");
            scorePotential++;
        }

        // print the score
        System.out.println("Your score is: " + score + "/" + scorePotential);

    }
}