public class EmployeeDemo {
    public static void main(String[] args) {

        FullTimeEmployee full = new FullTimeEmployee();
        full.setEmployeeId(101);
        full.setEmployeeName("Nandini");
        full.setMonthlySalary(50000);

        PartTimeEmployee part = new PartTimeEmployee();
        part.setEmployeeId(102);
        part.setEmployeeName("Riya");
        part.setHoursWorked(80);
        part.setHourlyRate(300);

        full.displayEmployeeInfo();
        System.out.println("Salary: " + full.calculateSalary());

        System.out.println();

        part.displayEmployeeInfo();
        System.out.println("Salary: " + part.calculateSalary());
    }
}
