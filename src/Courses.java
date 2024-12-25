import java.util.ArrayList;
import java.util.List;

public class Courses {
    private String name;
    private String description;
    private int maxNumberOfStudents;
    private int numberOfLectures;
    private List<Students> students;
    private Professors professor;
    private Departments department;

    // Constructor
    public Courses(String name, String description, int maxNumberOfStudents, int numberOfLectures, Departments department) {
        this.name = name;
        this.description = description;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.numberOfLectures = numberOfLectures;
        this.students = new ArrayList<>();
        this.department = department;
    }

    // Methods
    public int numberOfStudents() {
        return students.size();
    }

    public boolean assignProfessor(Professors p) {
        if (this.professor == null) {
            this.professor = p;
            return true;
        }
        return false;
    }

    public void unassignProfessor() {
        this.professor = null;
    }

    public boolean isAssigned() {
        return professor != null;
    }

    public String professorName() {
        return professor != null ? professor.fullName() : "No Professor Assigned";
    }

    public boolean isFull() {
        return students.size() >= maxNumberOfStudents;
    }

    public boolean enroll(Students s) {
        if (isFull() || !department.getStudents().contains(s)) {
            return false;
        }
        if (!students.contains(s)) {
            students.add(s);
            return true;
        }
        return false;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartment() {
        return department.getName();
    }

    public int getNumberOfLectures() {
        return numberOfLectures;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }
}
