import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
/**
 * This is an abstract class for representing different kinds of courses (Lecture, Laboratory, etc). All
 * the courses in the course catalog will be descendants of this class. It should implement the
 * Comparable interface. Specifying the generic type for that interface so that Course can be
 * compared to another Course. However, the details of the compareTo method should be left to
 * subclasses.
 * @author Justin Vu
 * @version CS211 Project 4 Spring 2023
 */
public abstract class Course implements Comparable<Course>
{
	//fields
	private String crn;
	private String title;
	private Set<String> levels;

	//getter for type determined by child classes
	public abstract String getType();

	//getters
	public final String getCrn() {
		return crn;
	}

	public final String getTitle() {
		return title;
	}

	public final Set<String> getLevels() {
		return levels;
	}

	/** 
	 * Course constructor is used as the base for all child courses.
	 * It validates the three parameters according to constrictions.
	 * @param crn is the course registration number
	 * @param title is the name of each course
	 * @param levels is a collection of strings that represent the possible levels
	 */
	public Course(String crn, String title, Set<String> levels) throws LectureCourseException{
		//check if crn is valid
		if (crn == null) {
			throw new LectureCourseException("crn");
		}

		//check if levels is valid
		if (levels == null || levels.size() < 1) {
			throw new LectureCourseException("levels");
		}

		//title at least 15 chars, no more than 40 chars
		if (title == null || title.length() < 15 || title.length() > 40) {
			throw new LectureCourseException("title");
		}

		//strings must be unique, level must be provided: Graduate, Non-Degree, Undergraduate
		for (String level : levels) {
			if (level == null) {
				throw new LectureCourseException("levels");
			}
			if (!(level.equals("Graduate") || level.equals("Non-Degree") || level.equals("Undergraduate"))) {
				throw new LectureCourseException("levels");
			}
		}

		this.crn = crn;
		this.title = title;
		this.levels = new HashSet<String>(levels); //make hash set to remove duplicates

	}

	/**
	 * Equals overrides parent to return true if the given object is also a Course, and their CRNs
	 * match. Otherwise, return false.
	 * @param o is the course to be compared to
	 * @return boolean according to rules
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Course) {
			Course otherCourse = (Course)o;
			if (this.crn == otherCourse.crn) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ToString returns a string representation of this course.
	 */
	@Override
	public String toString() {
		return "type: " + getType() + ", CRN: " + crn + ", title: " + title + ", levels: " + Arrays.deepToString(levels.toArray());
	}

	/**
	 * CompareTo overrides the Comparable interface's compareTo.
	 * The implementation is left to the child class
	 * @param other is the course to be compared to
	 */
	@Override
	public abstract int compareTo(Course other);
}