import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Test
{
    public static void main(String[] args) {
        System.out.println("\n----------COURSES CHECK---------");
        
        //setting defaults
        HashSet<String> levels1 = new HashSet<String>();
        levels1.add("Undergraduate");
        HashSet<MeetDay> meetdays1 = new HashSet<MeetDay>();
        meetdays1.add(MeetDay.Monday);
        meetdays1.add(MeetDay.Wednesday);
        ArrayList<String> gtas1 = new ArrayList<String>();
        gtas1.add("idk");
        gtas1.add("idc");

        //in-person course: fails crn (null)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse(null, "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("01) Expected Error: crn        - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails title (null)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", null, levels1, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("02) Expected Error: title      - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails title (too short)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to OOP", levels1, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("03) Expected Error: title      - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails title (too long)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Hippopotomonstrosesquippedaliophobiaaaaaaaaaaaaaaaaaaaaaa", levels1, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("04) Expected Error: title      - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails level (null)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", null, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("05) Expected Error: levels     - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails level (null value inside collection)
        HashSet<String> levels2 = new HashSet<String>();
        levels2.add(null);
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels2, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("06) Expected Error: levels     - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails level (value not correct level)
        HashSet<String> levels3 = new HashSet<String>();
        levels3.add("lmao you suck");
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels3, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("07) Expected Error: levels     - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails level (empty collection)
        HashSet<String> levels4 = new HashSet<String>();
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels4, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("08) Expected Error: levels     - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails instructor (null)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, null, 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("09) Expected Error: instructor - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails (credit < 0)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", -1, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("10) Expected Error: credits    - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails meetdays (null)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, null, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("11) Expected Error: meetdays   - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails meetdays (null value inside collection)
        HashSet<MeetDay> meetdays2 = new HashSet<>();
        meetdays2.add(MeetDay.Monday);
        meetdays2.add(null);
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays2, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("12) Expected Error: meetdays   - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails meetdays (empty collection)
        HashSet<MeetDay> meetdays3 = new HashSet<>();
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays3, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("13) Expected Error: meetdays   - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails meetdays (more than two meetdays)
        HashSet<MeetDay> meetdays4 = new HashSet<>();
        meetdays4.add(MeetDay.Monday);
        meetdays4.add(MeetDay.Wednesday);
        meetdays4.add(MeetDay.Friday);
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays4, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("14) Expected Error: meetdays   - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails gtas (null)
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, null);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("15) Expected Error: gtas       - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails gtas (null value inside collection)
        ArrayList<String> gtas2 = new ArrayList<>();
        gtas2.add("lol");
        gtas2.add(null);
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas2);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("16) Expected Error: gtas       - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        //in-person course: fails gtas (empty collection)
        ArrayList<String> gtas3 = new ArrayList<>();
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas3);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println("17) Expected Error: gtas       - Error thrown: " + lce.getMessage() + ": " + lce.getFieldName());
        }

        System.out.println();

        //in-person course: passes
        try {
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas1);
            System.out.println(inPersonCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println(lce.getMessage() + ": " + lce.getFieldName());
        }

        System.out.println();

        //hybrid course: passes
        try {
            HybridCourse hybridCourse1 = new HybridCourse("112", "Intro to Programming", levels1, "Kamberi", 3, meetdays1, gtas1);
            System.out.println(hybridCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println(lce.getMessage() + ": " + lce.getFieldName());
        }

        System.out.println();

        //online course: passes
        try {
            OnlineCourse onlineCourse1 = new OnlineCourse("110", "Essentials of Computer Science", levels1, "Otten", 3, meetdays1, gtas1);
            System.out.println(onlineCourse1.toString());
        }
        catch (LectureCourseException lce) {
            System.out.println(lce.getMessage() + ": " + lce.getFieldName());
        }

        System.out.println();

        System.out.println("----------COURSE CATALOG CHECKS----------");
        //Course Catalog
        try {
            CourseCatalog courseCatalog = new CourseCatalog();
            InPersonCourse inPersonCourse1 = new InPersonCourse("211", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas1);
            HybridCourse hybridCourse1 = new HybridCourse("112", "Intro to Programming", levels1, "Kamberi", 3, meetdays1, gtas1);
            OnlineCourse onlineCourse1 = new OnlineCourse("110", "Essentials of Computer Science", levels1, "Otten", 3, meetdays1, gtas1);
            courseCatalog.add("112", hybridCourse1);
            courseCatalog.add("110", onlineCourse1);
            courseCatalog.add("211", inPersonCourse1);
            System.out.println(Arrays.deepToString(courseCatalog.getCatalog().toArray()));
            for (AvailableCourse<String, Course> course : courseCatalog.getCatalog()) {
                System.out.println(course.getValue().toString());
            }
        }
        catch (Exception e) {System.out.println("wrong exception thrown");}

        System.out.println();

        //course catalog : try adding course with crn that already exists
        try {
            CourseCatalog courseCatalog = new CourseCatalog();
            HybridCourse hybridCourse1 = new HybridCourse("112", "Intro to Programming", levels1, "Kamberi", 3, meetdays1, gtas1);
            HybridCourse hybridCourse2 = new HybridCourse("112", "Intro to Programming", levels1, "Kamberi", 3, meetdays1, gtas1);
            courseCatalog.add("112", hybridCourse1);
            courseCatalog.add("112", hybridCourse2);
        }
        catch (CourseCatalogException cce) {
            System.out.println("Message Expected:  The course's CRN is already in the catalog. Dupe CRN: 112");
            System.out.println("Resulting Message: " + cce.getMessage() + " Dupe CRN: " + cce.getCrn());
        }
        catch (Exception e) {System.out.println("wrong exception thrown");}

        System.out.println();

        //course catalog sort with many different things
        try {
            CourseCatalog cc = new CourseCatalog();
            
            //fourth
            HybridCourse hybridCourse1 = new HybridCourse("4004", "Communication in Public", levels1, "Mead", 1, meetdays1, gtas1);
            cc.add("4004", hybridCourse1);

            //seventh
            OnlineCourse onlineCourse1 = new OnlineCourse("7007", "Essentials of Computer Science", levels1, "Otten", 3, meetdays1, gtas1);
            cc.add("7007", onlineCourse1);

            //second
            InPersonCourse inPersonCourse1 = new InPersonCourse("2002", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas1);
            cc.add("2002", inPersonCourse1);

            //eighth
            HashSet<MeetDay> meetdaysa = new HashSet<MeetDay>();
            meetdaysa.add(MeetDay.Monday);
            OnlineCourse onlineCourse2 = new OnlineCourse("8008", "Intro to World History", levels1, "Pandin", 3, meetdaysa, gtas1);
            cc.add("8008", onlineCourse2);

            //sixth
            HybridCourse hybridCourse2 = new HybridCourse("6006", "Intro to Programming", levels1, "Kamberi", 3, meetdays1, gtas1);
            cc.add("6006", hybridCourse2);

            //ninth
            OnlineCourse onlineCourse3 = new OnlineCourse("9009", "Intro to World History", levels1, "Karayannis", 3, meetdays1, gtas1);
            cc.add("9009", onlineCourse3);

            //third
            InPersonCourse inPersonCourse2 = new InPersonCourse("3003", "Intro to Physical Geology", levels1, "Goldspiel", 3, meetdays1, gtas1);
            cc.add("3003", inPersonCourse2);

            //first
            InPersonCourse inPersonCourse3 = new InPersonCourse("1001", "Intro to Physical Geology", levels1, "Meirdos", 1, meetdays1, gtas1);
            cc.add("1001", inPersonCourse3);

            //fifth
            HybridCourse hybridCourse3 = new HybridCourse("5005", "Communication in Public", levels1, "Sazerah", 3, meetdays1, gtas1);
            cc.add("5005", hybridCourse3);

            System.out.println("Before Sort: " + Arrays.deepToString(cc.getCatalog().toArray()));
            for (AvailableCourse<String, Course> course : cc.getCatalog()) {
                System.out.println(course.getValue().getCrn());
            }
            System.out.println();
            cc.sort();
            System.out.println("After Sort:  " + Arrays.deepToString(cc.getCatalog().toArray()));
            for (AvailableCourse<String, Course> course : cc.getCatalog()) {
                System.out.println(course.getValue().getCrn());
            }
            
        }
        catch (Exception e) {System.out.println(e.getMessage());}

        System.out.println();

        System.out.println("----------SEARCH SHIT----------");
        try {
            CourseCatalog cc = new CourseCatalog();
            HybridCourse hybridCourse1 = new HybridCourse("4004", "Communication in Public", levels1, "Mead", 1, meetdays1, gtas1);
            cc.add("4004", hybridCourse1);
            OnlineCourse onlineCourse1 = new OnlineCourse("7007", "Essentials of Computer Science", levels1, "Otten", 3, meetdays1, gtas1);
            cc.add("7007", onlineCourse1);
            InPersonCourse inPersonCourse1 = new InPersonCourse("2002", "Intro to Object Oriented Programming", levels1, "Socrates", 3, meetdays1, gtas1);
            cc.add("2002", inPersonCourse1);
            HashSet<MeetDay> meetdaysa = new HashSet<MeetDay>();
            meetdaysa.add(MeetDay.Monday);
            OnlineCourse onlineCourse2 = new OnlineCourse("8008", "Intro to World History", levels1, "Pandin", 3, meetdaysa, gtas1);
            cc.add("8008", onlineCourse2);
            HybridCourse hybridCourse2 = new HybridCourse("6006", "Intro to Programming", levels1, "Kamberi", 3, meetdays1, gtas1);
            cc.add("6006", hybridCourse2);
            OnlineCourse onlineCourse3 = new OnlineCourse("9009", "Intro to World History", levels1, "Karayannis", 3, meetdays1, gtas1);
            cc.add("9009", onlineCourse3);
            InPersonCourse inPersonCourse2 = new InPersonCourse("3003", "Intro to Physical Geology", levels1, "Goldspiel", 3, meetdays1, gtas1);
            cc.add("3003", inPersonCourse2);
            InPersonCourse inPersonCourse3 = new InPersonCourse("1001", "Intro to Physical Geology", levels1, "Meirdos", 1, meetdays1, gtas1);
            cc.add("1001", inPersonCourse3);
            HybridCourse hybridCourse3 = new HybridCourse("5005", "Communication in Public", levels1, "Sazerah", 3, meetdays1, gtas1);
            cc.add("5005", hybridCourse3);

            ArrayList<String> searchTerms = new ArrayList<>();
            //add search terms for whatever you want to search
            //searchTerms.add("Intro");
            searchTerms.add("5005");
            searchTerms.add("Socrates");

            CourseSearcher searcher = new CourseSearcher(searchTerms);
            List<AvailableCourse<String, Course>> results = cc.search(searcher);
            for (AvailableCourse<String, Course> result : results) {
                System.out.println(result.getKey() + " " + result.getValue().getTitle());
            }
        }
        catch (Exception e) {System.out.println(e.getMessage());}
    }
}