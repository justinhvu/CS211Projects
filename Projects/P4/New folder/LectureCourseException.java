/**
 * This is an exception that inherits from Exception and represents situations where:
 * The constructor of a lecture course receiving arguments that are null, empty collections, or
 * collections with null values
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public class LectureCourseException extends Exception {
    //fields
    private String fieldName;

    //getters
    public final String getFieldName() {
        return fieldName;
    }

    /**
     * LectureCourseException constructor setst the privage field and calls the 
     * parent class constructor with the required message.
     * @param fieldName is a string that stores the name of the null or illegal argument, 
     * it must match the name of the field that it was trying to set.
     */
    public LectureCourseException(String fieldName) {
        super("an argument has null or illegal value");
        this.fieldName = fieldName;
        
    }
}