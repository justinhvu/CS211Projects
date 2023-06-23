/**
 * This interface contains a single method, matches, which returns true if a given course matches
 * the criteria of this search.
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public interface Searchable {
    /**
     * Matches is the method that will be called by the course
     * catalog when searching. Items that return true will be included, but items that return false will not
     * be.
     * @param ac is the available course to be checked
     * @return boolean based on rules
     */
    public boolean matches(AvailableCourse <String, Course> ac);
}