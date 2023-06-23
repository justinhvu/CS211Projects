import java.util.Collection;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
/**
 * This is an abstract subclass of Course that represents different types of Lecture courses.
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public abstract class LectureCourse extends Course {
    //fields
    private String instructor;
    private int credit;
    private Set<MeetDay> meetDays;
    private Collection<String> gtas;

    //getters
    public final String getInstructor() {
        return instructor;
    }

    public final int getCredit() {
        return credit;
    }

    public final Set<MeetDay> getMeetDays() {
        return meetDays;
    }

    public final Collection<String> getGtas() {
        return gtas;
    }

    /**
     * LectureCourse constructor is used as base for child courses.
     * Validates parameters according to constrictions.
	 * @param crn is the course registration number
	 * @param title is the name of each course
	 * @param levels is a collection of strings that represent the possible levels
     * @param instructor is the name of the instructor of the course
     * @param credit is the number of credits for the course
     * @param meetDays is a collection of days the course meets
     * @param gtas is a collection of names of gtas for the course
     * @throws LectureCourseException when any of the parameters are invalid
     */
    public LectureCourse(String crn, String title, Set<String> levels, String instructor, int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
        //use Course constructor for first three parameters
        super(crn, title, levels);

        //check if instructor valid
        if (instructor == null) {
            throw new LectureCourseException("instructor");
        }
        
        //check if credit valid
        if (credit < 0) {
            throw new LectureCourseException("credit");
        }

        //check if meetdays valid
        if (meetDays == null || meetDays.size() < 1 || meetDays.size() > 2) {
            throw new LectureCourseException("meetDays");
        }
        else {
            for (MeetDay day: meetDays) {
                if (day == null) {
                    throw new LectureCourseException("meetDays");
                }
            }
        }

        //check if gta is valid
        if (gtas == null || gtas.size() == 0) {
            throw new LectureCourseException("gtas");
        }
        for (String gta : gtas) {
            if (gta == null) {
                throw new LectureCourseException("gtas");
            }
        }

        this.instructor = instructor;
        this.credit = credit;
        this.meetDays = new HashSet<MeetDay>(meetDays); //make hash set to get rid of duplicates
        this.gtas = new ArrayList<String>(gtas); //make arraylist to preserve order
    }

    /**
     * toString overrides parent toString to create a string represention of this course
     * uses the parent toString
     */
    @Override
    public String toString() {
        return "instructor: " + instructor + ", credit: " + credit + ", meetDays: " + Arrays.deepToString(meetDays.toArray()) + ", gtas: " + Arrays.deepToString(gtas.toArray()) + ", " + super.toString();
    }

    /**
     * CompareTo method returns an integer value representing whether the instance
     * given as an argument should be ordered before or after the calling instance. Negative numbers
     * indicate the calling instance (this) should be ordered first. Positive numbers indicate the argument
     * should be ordered first. Zero indicates that both instances have the same ordering.
     * The ordering rules are as follows:
     *     1. In-Person courses come before Hybrid courses and Hybrid courses come before Online
     *       courses.
     *     2. In-Person courses are sorted first by credit, then by title.
     *     3. Hybrid courses are sorted first by title, then by the number of credits.
     *     4. Online courses are sorted first by title, then by the number of meetDays.
     * @param other is course to be compared to
     * @return an int value according to above rules
     */
    @Override
    public int compareTo(Course other) {
        if (this instanceof InPersonCourse && other instanceof InPersonCourse) {
            InPersonCourse o = (InPersonCourse)other;
            //sort by credit then title
            if (this.credit != o.getCredit()) {
                return this.credit - o.getCredit();
            }
            else {
                if (this.getTitle().compareTo(o.getTitle()) != 0) {
                    return this.getTitle().compareTo(o.getTitle());
                }
            }

            return 0;
        }

        else if (this instanceof InPersonCourse && (other instanceof HybridCourse || other instanceof OnlineCourse)) {
            return -1;
        }

        else if (this instanceof HybridCourse && other instanceof HybridCourse) {
            HybridCourse o = (HybridCourse)other;
            //sort by title then credits
            if (this.getTitle().compareTo(o.getTitle()) != 0) {
                return this.getTitle().compareTo(o.getTitle());
            }
            else {
                if (this.credit != o.getCredit()) {
                    return this.credit - o.getCredit();
                }
            }
            return 0;
        }

        else if (this instanceof HybridCourse && other instanceof InPersonCourse) {
            return 1;
        }

        else if (this instanceof HybridCourse && other instanceof OnlineCourse) {
            return -1;
        }

        else if (this instanceof OnlineCourse && other instanceof OnlineCourse) {
            OnlineCourse o = (OnlineCourse)other;
            //sort by title then num of meetdays
            if (this.getTitle().compareTo(o.getTitle()) != 0) {
                return this.getTitle().compareTo(o.getTitle());
            }
            else {
                if (this.getMeetDays().size() != o.getMeetDays().size()) {
                    return this.getMeetDays().size() - o.getMeetDays().size();
                }
            }
            return 0;
        }

        else if (this instanceof OnlineCourse && (other instanceof InPersonCourse || other instanceof HybridCourse)) {
            return 1;
        }
        
        return 0;
    }
}