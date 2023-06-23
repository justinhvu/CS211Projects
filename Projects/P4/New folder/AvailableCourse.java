/**
 * This is a generic class, with two type specifications, that represents a mapping between keys and
 * values.
 * The first type can be any type, the second type must implement the Comparable interface and be
 * comparable to other instances of the same type. The AvailableCourse class itself should also
 * implement Comparable, such that AvailableCourse instances are comparable to other
 * AvailableCourse instances of the same kind (same generic type specifiers).
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public class AvailableCourse <K, V extends Comparable<V>> implements Comparable<AvailableCourse<K, V>> {
    //fields
    private K key;
    private V value;
    
    //getters
    public final K getKey() {
        return key;
    }

    public final V getValue() {
        return value;
    }

    /**
     * AvailableCourse constructor sets the given key and value.
     * @param key is a reference of the first generic type.
     * @param value is a reference of the second generic type.
     */
    public AvailableCourse(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Overrides the parent’s method to return true if the other object is also a
     * AvailableCourse and has the same value. Otherwise, returns false.
     * @param o is the available course whose value is to be compared to
     * @return boolean according to rules
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof AvailableCourse) {
            if (value.compareTo(((AvailableCourse<K, V>)o).value) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * CompareTo overrides the Comparable interface's method.
     * Returns the result of comparing the value field.
     * @param ac is the available course whose value is to be compared
     * @return int is result of the values being compared
     */
    @Override
    public int compareTo(AvailableCourse<K, V> ac) {
        //comparing values
        return this.value.compareTo(ac.getValue());
    }
}