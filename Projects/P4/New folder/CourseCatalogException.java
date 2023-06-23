/**
 * This is an exception that inherits from IllegalStateException and represents the situation where
 * A course being added to the available course catalog, which CRN is already present in the
 * catalog
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public class CourseCatalogException extends IllegalStateException {
    //fields
    private String crn;
    private Course course;

    //getters
    public final String getCrn() {
        return crn;
    }

    public final Course getCourse() {
        return course;
    }

    /**
     * CourseCatalogException constructor sets the private fields and calls
     * the parent class constructor 
     * @param crn is a string that stores the CRN of the duplicate course that was being added.
     * @param course is a reference to the duplicate course.
     */
    public CourseCatalogException(String crn, Course course) {
        super("The course's CRN is already in the catalog.");
        this.crn = crn;
        this.course = course;
    }
}