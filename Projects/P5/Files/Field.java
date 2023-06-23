import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic class that represents a field.
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public class Field<T> implements FlexibleIterable<T> {
    //fields
    private int curRow = 0;
    private int curCol = 0;
    private T[][] matrix;

    /**
     * The constructor allocates memory for the matrix.
     * @param height is the number of rows
     * @param width is the number of columns
     */
    public Field(int height, int width) {
        this.matrix = (T[][])new Object[height][width];
    }

    /**
     * getElement is a getter method for the matrix elements.
     * @param row of the element to get
     * @param col of the element to get
     * @return the element at the specified array index
     */
    public T getElement(int row, int col) {
        return matrix[row][col];
    }

    /**
     * setElement is a setter method for the matrix elements.
     * @param row of the element to set
     * @param col of the element to set
     * @param el is the element to be changed at the specified array index
     */
    public void setElement(int row, int col, T el) {
        matrix[row][col] = el;
    }

    /**
     * getHeight gets the height of the rectangular field
     * @return the length of the whole 2d array
     */
    public int getHeight() {
        return matrix.length;
    }

    /**
     * getWidth get the width of the rectangular field
     * @return the length of one row of the 2d array
     */
    public int getWidth() {
        return matrix[0].length;
    }

    /**
     * The string representations of all the matrix elements are merged into a single string.
     * @returns the matrix array as a string
     */
    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += matrix[i][j];
                if (j != matrix[i].length - 1) {
                    result += " ";
                }
            }
            if (i != matrix.length - 1) {
                result += "\n";
            }
        }

        return result;
    }

    /**
     * The default iterator implemented as an anonymous inner class.
     * @return the default iterator 
     */
    public Iterator<T> iterator() {
        //the iterator to be implemented
        Iterator<T> iterator = new Iterator<T>() {
            /**
             * hasNext determines if there is a next element to iterate through
             * @return true if there is a next element, false else
             */
            public boolean hasNext() {
                try {
                    T temp = matrix[curRow][curCol];
                }
                catch (Exception e) {return false;}
                return true;
            }

            /**
             * next moves the iterator to the next element
             * @return the next element
             * @throws NoSuchElementException if there is no next element
             */
            public T next() {
                if (curRow >= getHeight() || curCol >= getWidth()) {
                    throw new NoSuchElementException();
                }
                T result = matrix[curRow][curCol];
                curCol++;
                if (curCol >= getWidth()) {
                    curRow++;
                    curCol = 0;
                }
                return result;
            }

            /**
             * remove method is not to be fully implemented
             * @throws UnsupportedOperationException() when tried to call
             */
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        return iterator;
    }

    /**
     * This is the overloaded iterator method whose only purpose is 
     * to create and return a new FieldIterator object.
     * @param iterableObjectName is the name of the type of object to be iterated through
     * @return a new FieldIterator object
     */
    public Iterator<T> iterator(String iterableObjectName) {
        return new FieldIterator<T>(iterableObjectName, this);
    }
}