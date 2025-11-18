import java.time.LocalDate;

public class Employee {
    final private String id;
    final private String name;
    final private String email;
    final private LocalDate dob;
    final private LocalDate joiningDate;
    final private EmployeeType type;

    public Employee(String id, String name, String email, LocalDate dob,
                    LocalDate joiningDate, EmployeeType type) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.joiningDate = joiningDate;
        this.type = type;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getDob() { return dob; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public EmployeeType getType() { return type; }



    public String getInfo() {
        return "\nEmployee Details:\n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Date of Birth: " + dob + "\n" +
                "Email: " + email + "\n" +
                "Joining Date: " + joiningDate + "\n" +
                "Employee Type: " + type;
    }
}
