
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        LeaveCalculator<Employee> calculator = new LeaveCalculator<>();

        System.out.print("Enter number of employees (min 3): ");
        // Handle the integer input safely
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Employee " + i + " Details ---");

            System.out.print("ID: ");
            String id = sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Date of Birth (dd/MM/yyyy): ");
            LocalDate dob = LocalDate.parse(sc.nextLine(), df);

            System.out.print("Joining Date (dd/MM/yyyy): ");
            LocalDate joining = LocalDate.parse(sc.nextLine(), df);

            System.out.print("Type (1 = Officer, 2 = Staff): ");
            int typeInput = Integer.parseInt(sc.nextLine());
            EmployeeType type = (typeInput == 1) ? EmployeeType.OFFICER : EmployeeType.STAFF;

            // Create Employee Object
            Employee emp = new Employee(id, name, email, dob, joining, type);

            // Calculate Leaves (Pass "Vacation" or "Sick")
            double vacation = calculator.calculate(emp, "Vacation");
            double sick = calculator.calculate(emp, "Sick");

            // Create the Summary String
            String record = emp.getInfo() +
                    "\nVacation Leave: " + (int) vacation +
                    "\nSick Leave: " + (int) sick +
                    "\n---------------------------------";

            // Store and display
            LeaveApplication.store(record);
            System.out.println("\n Calculated: Vacation=" + (int)vacation + ", Sick=" + (int)sick);
        }

        // Show final list
        LeaveApplication.showAll();
    }
}
