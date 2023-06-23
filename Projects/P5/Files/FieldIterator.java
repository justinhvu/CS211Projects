import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A generic class that provides an iterator for the Field. It implements the Iterator interface.
 * The purpose of this iterator is to provide an alternative to the default iteration. Based on the value of the
 * argument iterableObjectName this iterator will not iterate over the entire Field but it will restrict
 * itself to Blocks of specific datatype, e.g. Passage or Obstacle.
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public class FieldIterator<T> implements Iterator<T> {
    //fields
    private String iterableObjectName;
    private int curRow;
    private int curCol;
    private Field<T> field;

    /**
     * FieldIterator constructor is used to create a new FieldIterator object
     * @param iterableObjectName is the block type that this iterator is supposed to go through
     * @param field is a field class used to access it's matrix and methods
     */
    public FieldIterator(String iterableObjectName, Field<T> field) {
        this.iterableObjectName = iterableObjectName;
        this.field = field;
    }

    /**
     * next moves the iterator to the next element
     * @return the next element
     * @throws NoSuchElementException if there is no next element
     */
    public T next() {
        if (curRow >= field.getHeight() || curCol >= field.getWidth()) {
            throw new NoSuchElementException();
        }
        T result = field.getElement(curRow, curCol);
        curCol++;
        if (curCol >= field.getWidth()) {
            curRow++;
            curCol = 0;
        }

        return result;
    }

    /**
     * hasNext determines if there is a next element to iterate through
     * It keeps iterating until it finds an element of iterableObjectName
     * @return true if there is a next element, false else
     */
    public boolean hasNext() {
        try {
            T temp = field.getElement(curRow, curCol);
            while(temp.getClass().getName().compareTo(iterableObjectName) != 0) {
                curCol++;
                if (curCol >= field.getWidth()) {
                    curRow++;
                    curCol = 0;
                }
                temp = field.getElement(curRow, curCol);
            }
            if (temp.getClass().getName().compareTo(iterableObjectName) == 0) {
                return true;
            }
        }
        catch (Exception e) {return false;}
        return false;
    }

    /**
     * remove method is not to be fully implemented
     * @throws UnsupportedOperationException() when tried to call
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }
}