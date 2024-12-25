import java.util.ArrayList;
import java.util.List;

public class Departments {
    private String name;
    private String description;
    private int maxNumberOfStudents;
    private List<Courses> courses;
    private List<Students> students;

    // Constructor
    public Departments(String name, String description, int maxNumberOfStudents) {
        this.name = name;
        this.description = description;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // Methods
    public int numberOfCourses() {
        return courses.size();
    }

    public int numberOfStudents() {
        return students.size();
    }

    public Courses findCourse(String name) {
        for (Courses course : courses) {
            if (course.getName().equalsIgnoreCase(name)) {
                return course;
            }
        }
        return null;
    }

    public boolean isFull() {
        return students.size() >= maxNumberOfStudents;
    }

    public boolean enroll(Students s) {
        if (isFull()) {
            return false;
        }
        if (!students.contains(s)) {
            students.add(s);
            return true;
        }
        return false;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public List<Students> getStudents() {
        return students;
    }
}
