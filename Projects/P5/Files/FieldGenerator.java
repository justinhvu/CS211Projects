import java.util.Scanner;
import java.io.File;
import java.util.Random;
// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

/**
 * A utility class that provides two methods for generating a Field.
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public class FieldGenerator {
    
    /**
     * It generates a Field based on the data that is stored in a text file.
     * @param filename is the file to load the data from
     * @return a field of blocks
     * @throws FileNotFoundException if the filename could not be found
     */
    public static Field<Block> loadDataFromFile(String filename) {  
        int totalRows = 0;
        int totalCols = 0;
        File file = new File(filename);
        Field<Block> field = new Field<>(0, 0);

        try {
        //determine total rows
        Scanner rowScnr = new Scanner(file);
        while (rowScnr.hasNextLine()) {
            totalRows++;
            rowScnr.nextLine();
        }
        //System.out.println("TOTAL ROWS: " + totalRows);
        rowScnr.close();

        //determine total columns
        Scanner colScnr = new Scanner(file);
        if (colScnr.hasNextLine()) {
            String[] chars = colScnr.nextLine().split(" ");
            for (String character : chars) {
                if (character.compareTo(" ") != 0) {
                    totalCols++;
                }
            }
        }
        //System.out.println("TOTAL COLS: " + totalCols);
        colScnr.close();

        //instantiate a new field with total rows and columns
        field = new Field<Block>(totalRows, totalCols);

        Scanner scnr = new Scanner(file);
        //populate the field with data from the file
        int curRow = 0;
        int curCol = 0;
        while(scnr.hasNext()) {
            String temp = scnr.next();
            try {
                //if parseInt works, then it's a number and therefor a passage
                Passage passage = new Passage(Integer.parseInt(temp));
                field.setElement(curRow, curCol, passage);
            }
            catch (Exception e) {
                //if parseInt doesn't work, then it's a symbol and therefor an obstacle
                Obstacle obstacle = new Obstacle(temp);
                field.setElement(curRow, curCol, obstacle);
            }
            finally {
                //keep going through the file until the end
                curCol++;
                if (curCol >= field.getWidth()) {
                    curRow++;
                    curCol = 0;
                }
            }
        }
        }
        catch (Exception e) {
            System.out.println("error has occurred!");
            System.exit(0);
        }
        
        return field;
    }

    /**
     * helperIsObstacle is a recursive helper method used in method randomIntegers.
     * It is used when you try to set an obstacle at a location where there is already an obstacle.
     * @param row is the row to be checked
     * @param col is the col to be checked
     * @param field is the field used for its matrix and methods
     * @return String holding the new row and new col for the Obstacle to be set
     */
    private static String helperIsObstacle(int row, int col, Field<Block> field) {
        if (field.getElement(row, col).getClass().getName().compareTo("Obstacle") != 0) {
            return row + " " + col;
        }
        else {
            return helperIsObstacle(new Random().nextInt(field.getHeight()), new Random().nextInt(field.getWidth()), field);
        }
    }

    /**
     * randomIntegers is used to create a field with random values.
     * @param h is the height of the field
     * @param w is the width of the field
     * @param l is the lowest score a passage can have
     * @param m is the maximum score a passage can have
     * @param n is the number of obstacles a field must have
     * @return the field with the specified details
     */
    public static Field<Block> randomIntegers(int h, int w, int l, int m, int n) {
        //instantiate a new field with the height and width
        Field<Block> field = new Field<>(h, w);

        //loop through the matrix and set every block to a passage with random points
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                field.setElement(i, j, new Passage(new Random().nextInt(m - l + 1) + l));
            }
        }

        int curRow = 0;
        int curCol = 0;
        //while there aren't enough Obstacles, keep looping
        while (n > 0) {
            curRow = new Random().nextInt(field.getHeight());//random row
            curCol = new Random().nextInt(field.getWidth());//random col
            String[] index = (helperIsObstacle(curRow, curCol, field)).split(" ");
            curRow = Integer.parseInt(index[0]);
            curCol = Integer.parseInt(index[1]);
            field.setElement(curRow, curCol, new Obstacle("#"));
            n--;
        }

        return field;
    }
}