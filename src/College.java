
import java.util.ArrayList;
import java.util.List;

public class College {
        private List<Departments> departments;
        private List<Students> students;
        private List<Professors> professors;
        private List<Courses> courses;

        // Constructor
        public College() {
            this.departments = new ArrayList<>();
            this.students = new ArrayList<>();
            this.professors = new ArrayList<>();
            this.courses = new ArrayList<>();
        }

        // Methods
        public int numberOfDepartments() {
            return departments.size();
        }

        public int numberOfCourses() {
            return courses.size();
        }

        public int numberOfProfessors() {
            return professors.size();
        }

        public int numberOfStudents() {
            return students.size();
        }

        public Departments findDepartment(String name) {
            for (Departments department : departments) {
                if (department.getName().equalsIgnoreCase(name)) {
                    return department;
                }
            }
            return null;
        }

        public Students findStudent(String name) {
            for (Students student : students) {
                if (student.fullName().equalsIgnoreCase(name)) {
                    return student;
                }
            }
            return null;
        }

        public Professors findProfessor(String name) {
            for (Professors professor : professors) {
                if (professor.fullName().equalsIgnoreCase(name)) {
                    return professor;
                }
            }
            return null;
        }

        public Courses findCourse(String name) {
            for (Courses course : courses) {
                if (course.getName().equalsIgnoreCase(name)) {
                    return course;
                }
            }
            return null;
        }

        // Add methods for adding departments, students, professors, and courses
        public void addDepartment(Departments department) {
            departments.add(department);
        }

        public void addStudent(Students student) {
            students.add(student);
        }

        public void addProfessor(Professors professor) {
            professors.add(professor);
        }

        public void addCourse(Courses course) {
            courses.add(course);
        }
    }


