public enum EmployeeType {
    OFFICER(15, 10),
    STAFF(10, 7);

    private final int vacation;
    private final int sick;

    EmployeeType(int vacation, int sick) {
        this.vacation = vacation;
        this.sick = sick;
    }

    public int getVacation() {
        return vacation;
    }

    public int getSick() {
        return sick;
    }
}