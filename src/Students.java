import java.util.ArrayList;
import java.util.List;

public class Students {
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private int age;
    private Departments department;
    private List<Courses> courses;

    // Constructor
    public Students(String firstName, String lastName, String telephone, String address, int age, Departments department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.age = age;
        this.department = department;
        this.courses = new ArrayList<>();
    }

    // Methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    // Getters and Setters
    public List<Courses> getCourses() {
        return courses;
    }

    public Departments getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getTelephone() {
        return telephone;
    }
}
