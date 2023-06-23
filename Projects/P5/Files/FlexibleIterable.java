import java.util.Iterator;

/**
 * A generic interface that extends the Iterable interface. The Iterable is a functional interface, i.e. it
 * has one method only, and we want to overload this method.
 * @author Justin Vu
 * @version CS211 Project 5 Spring 2023
 */
public interface FlexibleIterable<T> extends Iterable<T> {
	
    /**
     * Creates an iterator that iterates only on objects whose datatype name is iterableObjectName
     * and skips everything else in the iterable object.
     * @param iterableObjectName name of the block's dataype
     * @return an iterator object
     */
    public Iterator<T> iterator(String iterableObjectName);

}