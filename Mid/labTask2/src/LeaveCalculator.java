


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class LeaveCalculator<T extends Employee> {

    public double calculate(T emp, String leaveType) {


        LocalDate joining = emp.getJoiningDate();
        int year = joining.getYear();
        LocalDate endOfYear = LocalDate.of(year, 12, 31);

        //  Calculate Total Days in Year (366 if leap, else 365)
        int totalDaysInYear = joining.isLeapYear() ? 366 : 365;

        //  Calculate Days Worked: (Dec 31 - Joining) + 1

        long daysWorked = ChronoUnit.DAYS.between(joining, endOfYear) + 1;

        //  Total Leave Allowed based on type
        int totalLeaveAllowed;
        if (leaveType.equalsIgnoreCase("Vacation")) {
            totalLeaveAllowed = emp.getType().getVacation();
        } else {
            totalLeaveAllowed = emp.getType().getSick();
        }


        double result = (double) (daysWorked * totalLeaveAllowed) / totalDaysInYear;



        if (result < 0.5) {
            return Math.floor(result);
        } else {
            return Math.ceil(result);
        }
    }
}
