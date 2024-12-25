public class Professors {
    private String firstName;
    private String lastName;
    private String telephone;
    private String address;
    private double salary;

    // Constructor
    public Professors (String firstName, String lastName, String telephone, String address, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.salary = salary;
    }

    // Methods
    public String fullName() {
        return firstName + " " + lastName;
    }

    public double getRaise(double ratio) {
        salary += salary * ratio;
        return salary;
    }

    // Getters and Setters
    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }
}
