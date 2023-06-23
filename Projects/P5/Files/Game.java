import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * This class contains the main method that you can use to run and test your application (see the
 * sample code for more details), and two methods for solving the task of finding the best route
 * from one endline to the other.
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public class Game {
    /**
     * twoValues is a static inner class used to store two values
     */
    public static class TwoValues
    {
        public int startingColumn;
        public int totalPoints;
    }

    /**
     * recursion is a private static method used to in bestStartingPoint to determine
     * the highest total points nad best startingColumn
     * @param row is used to get the row of an element
     * @param col is used to get the column of an element
     * @param value is the number of points being incremented
     * @param board is the board for method access
     * @return value
     */
    private static int recursion(int row, int col, int value, Field<Block> board) {

        //base case: reached end of field
        if (row+1 >= board.getHeight()) {
            return value;
        }
        
        //check if the current element is an obstacle
        boolean isObstacle = false;
        if (board.getElement(row, col).getClass().getName().compareTo("Obstacle") == 0) {
            isObstacle = true;
        }

        if (!isObstacle) {
            //first col: only check current col and right
            if (col == 0) {
                value += Math.max(recursion(row+1, col+1, board.getElement(row+1, col+1).getValue(), board),
                                  recursion(row+1, col, board.getElement(row+1, col).getValue(), board));
            }
            //last col: only check current col and left
            else if (col+1 == board.getWidth()) {
                value += Math.max(recursion(row+1, col-1, board.getElement(row+1, col-1).getValue(), board),
                                  recursion(row+1, col, board.getElement(row+1, col).getValue(), board));
            }
            //add the highest point values possible
            else {
                value += Math.max(Math.max(recursion(row+1, col+1, board.getElement(row+1, col+1).getValue(), board), 
                                           recursion(row+1, col, board.getElement(row+1, col).getValue(), board)),
                                  Math.max(recursion(row+1, col-1, board.getElement(row+1, col-1).getValue(), board),
                                           recursion(row+1, col, board.getElement(row+1, col).getValue(), board)));
            }
        }
        //if its an obstacle just return -1
        else {return -1;}
        
        return value;
    }

    /**
     * It finds the best starting point, i.e. what column of the first row of the Field we must use in order
     * to collect the highest number of points while crossing the Field. It also calculates the sum of these
     * points.
     * @param board is the field to access its value and methods
     * @return an instance of innerClass TwoValues with the new values for its field
     */
    public static TwoValues bestStartingPoint(Field<Block> board){
        TwoValues twoValues = new TwoValues();
        twoValues.startingColumn = 0;
        twoValues.totalPoints = 0;

        for (int i = 0; i < board.getWidth(); i++) {
            int value = recursion(0, i, board.getElement(0, i).getValue(), board);
            if (value > twoValues.totalPoints) {
                twoValues.totalPoints = value;
                twoValues.startingColumn = i;
            }
        }
        
        return twoValues;
    }

    /**
     * recursion is a private static method used to in bestRoute to determine
     * the best path in a field starting from a specified column
     * @param row is used to get the row of an element
     * @param col is used to get the column of an element
     * @param path is the best path 
     * @param board is the board for method access
     * @return path
     */
    private static ArrayList<Block> recursion(int row, int col, ArrayList<Block> path, Field<Block> board) {
        //base case: pass last row
        if (row+1 >= board.getHeight()) {
            return path;
        }

        //first col, only check right
        if (col == 0) {
            if (board.getElement(row+1, col+1).getValue() > board.getElement(row+1, col).getValue()) {
                path.add(board.getElement(row+1, col+1));
                recursion(row+1, col+1, path, board);
            }
            else {
                path.add(board.getElement(row+1, col));
                recursion(row+1, col, path, board);
            }
        }
        //last col, only check left
        else if (col+1 == board.getWidth()) {
            if (board.getElement(row+1, col-1).getValue() > board.getElement(row+1, col).getValue()) {
                path.add(board.getElement(row+1, col-1));
                recursion(row+1, col-1, path, board);
            }
            else {
                path.add(board.getElement(row+1, col));
                recursion(row+1, col, path, board);
            }
        }
        //next row:cur col > next row left and next row right
        else if (board.getElement(row+1, col).getValue() > board.getElement(row+1, col-1).getValue() 
                && board.getElement(row+1, col).getValue() > board.getElement(row+1, col+1).getValue()) {
            path.add(board.getElement(row+1, col));
            recursion(row+1, col, path, board);
        }
        //next row:left > next row cur and next row right
        else if (board.getElement(row+1, col-1).getValue() > board.getElement(row+1, col).getValue() 
                && board.getElement(row+1, col-1).getValue() > board.getElement(row+1, col+1).getValue()) {
            path.add(board.getElement(row+1, col-1));
            recursion(row+1, col-1, path, board);
        }
        //next row:right > next row cur and next row left
        else if (board.getElement(row+1, col+1).getValue() > board.getElement(row+1, col).getValue() 
                && board.getElement(row+1, col+1).getValue() > board.getElement(row+1, col-1).getValue()) {
            path.add(board.getElement(row+1, col+1));
            recursion(row+1, col+1, path, board);
        }
        return path;
    }

    /**
     * Given a starting point, it returns the list of Blocks that form the best
     * route from one endline to the other one.
     * @param board is the field to access its values and methods
     * @param col is the inital starting point
     * @return an ArrayList of blocks that is the best route
     */
    public static ArrayList<Block> bestRoute(Field<Block> board, int col) {
        ArrayList<Block> result = new ArrayList<Block>();
        result.add(board.getElement(0, col));
        result = recursion(0, col, result, board);
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException{
        /**
        command line arguments validation
        */
        if (args.length != 1)
        {
            System.err.println("Usage: java " + Game.class.getName() + " <filename>");
            return;
        }

        /**
        example of loading data from a file
        */
        Field<Block> field = FieldGenerator.loadDataFromFile(args[0]);
        /**
        example of generating a random Field
        */
        //Field<Block> field = FieldGenerator.randomIntegers(8,11,0,9,10);
        
        /**
        print the whole field
        */
        System.out.println(field);
        System.out.println();

        /**
        Example of running a foreach loop
        This will invoke the default iterator (the one using the anonymous inner class)
        */
        for(Block b:field)
            System.out.println(b);
            System.out.println();

        /**
        Example of running a while loop
        This will invoke the overloaded iterator (the one using the FieldIterator class)
        */
        //Iterator<Block> it = field.iterator("Passage");
        Iterator<Block> it = field.iterator("Obstacle"); // same thing for Obstacle objects
        while(it.hasNext())
            System.out.println(it.next());

        System.out.println();
        /**
        find the best starting point and print the results
        */
        TwoValues br = bestStartingPoint(field);
        System.out.println("Best starting point is in column " + br.startingColumn + " and the total points collected from this route is " + br.totalPoints);
        System.out.println();
        /**
        find the best route and print it
        */
        ArrayList<Block> al = bestRoute(field, br.startingColumn);
        for (Block b : al)
            System.out.println(b);
        
        System.out.println();
        System.out.println("finishi!");
    }   
}