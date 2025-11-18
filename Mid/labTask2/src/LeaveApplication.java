



import java.util.ArrayList;
import java.util.List;

public class LeaveApplication {

    // A simple list to store the string records
    private static List<String> acceptedLeaves = new ArrayList<>();

    // Add a record to the list
    public static void store(String record) {
        acceptedLeaves.add(record);
    }

    // Loop through the list and print everything
    public static void showAll() {
        System.out.println("\n=== All Accepted Leave Applications ===");

        if (acceptedLeaves.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (String record : acceptedLeaves) {
                System.out.println(record);
            }
        }
    }
}
