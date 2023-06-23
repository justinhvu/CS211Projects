import java.util.Collection;
import java.util.Set;
/**
 * This is a concrete class that inherits from LectureCourse and represents hybrid courses.
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public class HybridCourse extends LectureCourse {
    //getter
    public String getType() {
        return "Hybrid";
    }

    /**
     * HybridCourse constructor calls the parent class constructor with the given arguments.
	 * @param crn is the course registration number
	 * @param title is the name of each course
	 * @param levels is a collection of strings that represent the possible levels
     * @param instructor is the name of the instructor of the course
     * @param credit is the number of credits for the course
     * @param meetDays is a collection of days the course meets
     * @param gtas is a collection of names of gtas for the course
     */
    public HybridCourse(String crn, String title, Set<String> levels, String instructor, int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException{
        super(crn, title, levels, instructor, credit, meetDays, gtas);
    }
}