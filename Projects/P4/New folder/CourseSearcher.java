import java.util.Collection;
/**
 * This is a concrete class that implements the Searchable interface, and represents a search with
 * multiple terms, matching courses that contain a given search strings among their fields
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public class CourseSearcher implements Searchable {
    //fields
    private Collection<String> searchTerms;

    /**
     * CourseSearcher constructor takes a collection of strings and should set the field searchTerms.
     * @param searchTerms is a collection of strings to search for in each available course.
     */
    public CourseSearcher(Collection<String> searchTerms) {
        this.searchTerms = searchTerms;
    }

    /**
     * Matches returns true if the available course contains any of the searchTerms.
     * @param ac is the AvailableCourse object whose terms we will search through
     * @return boolean according to rules
     */
    public boolean matches(AvailableCourse <String, Course> ac) {
        //use the toString to get details of the course
        String courseDetails = ac.getValue().toString();

        for (String searchTerm : searchTerms) {
            if (courseDetails.contains(searchTerm)) {
                return true;
            }
        }
        return false;
    }
}