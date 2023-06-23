import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * This class represents the catalog of available courses. It contains a list of courses and provides
 * methods for courses with the CRN it has been registered with, returning a subset of items in the
 * catalog given some search terms, and sorting the catalog.
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public class CourseCatalog {
    //fields
    private List<AvailableCourse<String, Course>> catalog;

    //getters
    public final List<AvailableCourse<String, Course>> getCatalog() {
        return catalog;
    }

    /**
     * CourseCatalog constructor is a default constructor which initializes the catalog field
     */
    public CourseCatalog() {
        this.catalog = new ArrayList<AvailableCourse<String, Course>>();
    }

    /**
     * Add is a method for adding courses to the catalog
     * @param crn is a string representing the course's crn
     * @param course is the course to be attempted to be added
     */
    public void add(String crn, Course course) {
        AvailableCourse<String, Course> ac = new AvailableCourse<String, Course>(crn, course);
        //check if crn already in catalogs
        for (AvailableCourse<String, Course> c : catalog) {
            if (c.getKey().compareTo(ac.getKey()) == 0) {
                throw new CourseCatalogException(c.getKey(), c.getValue());
            }
        }
        catalog.add(ac);
    }

    /**
     * Search creates and returns a new list of available courses. This new
     * list should contain all available courses from the catalog for which the given searchable's matches
     * method returns true.
     * @param s is an instance of searchable class, used for the matches method
     * @return a list as stated above
     */
    public List<AvailableCourse<String, Course>> search(Searchable s) {
        CourseSearcher cs = (CourseSearcher)s;
        ArrayList<AvailableCourse<String, Course>> result = new ArrayList<AvailableCourse<String, Course>>();

        for (AvailableCourse<String, Course> ac : catalog) {
            if (cs.matches(ac)) {
                result.add(ac);
            }
            
        }
        return result;
    }

    /**
     * Sort sorts the catalog according to the compare to rules stated in
     * the course class. 
     */
    public void sort() {
        //collection's sort method automatically uses the overriden compareTo
        Collections.sort(catalog);
    }
}