package AttendanceMangement;



import java.util.ArrayList;
import java.util.List;





public class Employee extends Role {
    private static List<Employee> employeesList = new ArrayList<>();
    private int employeeId;
    private String department;

    public Employee(String roleName, int employeeId, String department) {
        super(roleName);
        this.employeeId = employeeId;
        this.department = department;
    }

    public static List<Employee> getEmployeesList() {
        return employeesList;
    }

    public static void addEmployee(Employee employee) {
        employeesList.add(employee);
    }

    public static void editEmployee(int index, String roleName, String department) {
        Employee employee = employeesList.get(index);
        employee.setRoleName(roleName);
        employee.setDepartment(department);
    }

    public static void deleteEmployee(int index) {
        employeesList.remove(index);
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static Employee searchEmployee(String roleName, String department) {
        for (Employee employee : employeesList) {
            if (employee.getRoleName().equalsIgnoreCase(roleName)
                    && employee.getDepartment().equalsIgnoreCase(department)) {
                return employee;
            }
        }
        return null;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}




