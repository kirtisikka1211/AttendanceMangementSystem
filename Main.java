
import AttendanceMangement.Attendance;
import AttendanceMangement.Employee;
import AttendanceMangement.Leave;
import AttendanceMangement.Role;
import AttendanceMangement.Student;
import AttendanceMangement.User;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Leave leave = new Leave();
        Scanner scanner = new Scanner(System.in);

        User[] users = new User[100];
        int userCount = 0;

        while (true) {
            System.out.println("===== User Management System =====");
            System.out.println("1. Add User");
            System.out.println("2. Edit User");
            System.out.println("3. Delete User");
            System.out.println("4. Search User");
            System.out.println("5. Add Role");
            System.out.println("6. Edit Role");
            System.out.println("7. Delete Role");
            System.out.println("8. Search Role");
            System.out.println("9. Add Student");
            System.out.println("10. Edit Student");
            System.out.println("11. Delete Student");
            System.out.println("12. Search Student");
            System.out.println("13. Add Employee");
            System.out.println("14. Edit Employee");
            System.out.println("15. Delete Employee");
            System.out.println("16. Search Employee");
            System.out.println("17. Manage Attendance");
            System.out.println("18. Manage Leave");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add User
                    System.out.println("Enter user name:");
                    scanner.nextLine(); // Consume the newline character
                    String name = scanner.nextLine();
                    System.out.println("Enter user ID:");
                    int userId = scanner.nextInt();
                    System.out.println("Enter role name:");
                    scanner.nextLine(); // Consume the newline character
                    String roleName = scanner.nextLine();
                    Role role = Role.searchRole(roleName);
                    if (role == null) {
                        role = new Role(roleName);
                        Role.addRole(role);
                    }
                    User user = User.addUser(name, userId, role);
                    users[userCount] = user;
                    userCount++;
                    break;
                case 2:
                    // Edit User
                    System.out.println("Enter user ID to edit:");
                    int editUserId = scanner.nextInt();
                    User editUser = User.searchUser(users, editUserId);
                    if (editUser != null) {
                        System.out.println("Enter new user name:");
                        scanner.nextLine(); // Consume the newline character
                        String newName = scanner.nextLine();
                        System.out.println("Enter new role name:");
                        String newRoleName = scanner.nextLine();
                        Role newRole = Role.searchRole(newRoleName);
                        if (newRole == null) {
                            newRole = new Role(newRoleName);
                            Role.addRole(newRole);
                        }
                        editUser.editUser(newName, newRole);
                        System.out.println("User updated successfully!");
                    } else {
                        System.out.println("User not found!");
                    }
                    break;
                case 3:
                    // Delete User
                    System.out.println("Enter user ID to delete:");
                    int deleteUserId = scanner.nextInt();
                    User deleteUser = User.searchUser(users, deleteUserId);
                    if (deleteUser != null) {
                        deleteUser.deleteUser();
                        System.out.println("User deleted successfully!");
                    } else {
                        System.out.println("User not found!");
                    }
                    break;
                case 4:
                    // Search User
                    System.out.println("Enter user ID to search:");
                    int searchUserId = scanner.nextInt();
                    User searchUser = User.searchUser(users, searchUserId);
                    if (searchUser != null) {
                        System.out.println("User found:");
                        System.out.println("Name: " + searchUser.getName());
                        System.out.println("User ID: " + searchUser.getUserId());
                        System.out.println("Role: " + searchUser.getRole().getRoleName());
                    } else {
                        System.out.println("User not found!");
                    }
                    break;
                case 5:
                    // Add Role
                    System.out.println("Enter role name:");
                    scanner.nextLine(); // Consume the newline character
                    String newRoleName = scanner.nextLine();
                    Role newRole = Role.searchRole(newRoleName);
                    if (newRole == null) {
                        newRole = new Role(newRoleName);
                        Role.addRole(newRole);
                        System.out.println("Role added successfully!");
                    } else {
                        System.out.println("Role already exists!");
                    }
                    break;
                case 6:
                    // Edit Role
                    System.out.println("Enter index of the role to edit:");
                    int roleIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter new role name:");
                    String editedRoleName = scanner.nextLine();
                    Role.editRole(roleIndex, editedRoleName);
                    System.out.println("Role updated successfully!");
                    break;
                case 7:
                    // Delete Role
                    System.out.println("Enter index of the role to delete:");
                    int deleteRoleIndex = scanner.nextInt();
                    Role.deleteRole(deleteRoleIndex);
                    System.out.println("Role deleted successfully!");
                    break;
                case 8:
                    // Search Role
                    System.out.println("Enter role name to search:");
                    scanner.nextLine(); // Consume the newline character
                    String searchRoleName = scanner.nextLine();
                    Role searchRole = Role.searchRole(searchRoleName);
                    if (searchRole != null) {
                        System.out.println("Role found:");
                        System.out.println("Role name: " + searchRole.getRoleName());
                    } else {
                        System.out.println("Role not found!");
                    }
                    break;
                case 9:
                    // Add Student
                    System.out.println("Enter student ID:");
                    int studentId = scanner.nextInt();
                    System.out.println("Enter course:");
                    scanner.nextLine(); // Consume the newline character
                    String course = scanner.nextLine();
                    Student newStudent = new Student("Student", studentId, course);
                    Student.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;
                case 10:
                    // Edit Student
                    System.out.println("Enter index of the student to edit:");
                    int studentIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter new role name:");
                    String editedStudentRoleName = scanner.nextLine();
                    System.out.println("Enter new course:");
                    String editedCourse = scanner.nextLine();
                    Student.editStudent(studentIndex, editedStudentRoleName, editedCourse);
                    System.out.println("Student updated successfully!");
                    break;
                case 11:
                    // Delete Student
                    System.out.println("Enter index of the student to delete:");
                    int deleteStudentIndex = scanner.nextInt();
                    Student.deleteStudent(deleteStudentIndex);
                    System.out.println("Student deleted successfully!");
                    break;
                case 12:
                    // Search Student
                    System.out.println("Enter role name to search:");
                    scanner.nextLine(); // Consume the newline character
                    String searchStudentRoleName = scanner.nextLine();
                    System.out.println("Enter course to search:");
                    String searchCourse = scanner.nextLine();
                    Student searchStudent = Student.searchStudent(searchStudentRoleName, searchCourse);
                    if (searchStudent != null) {
                        System.out.println("Student found:");
                        System.out.println("Role name: " + searchStudent.getRoleName());
                        System.out.println("Course: " + searchStudent.getCourse());
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 13:
                    // Add Employee
                    System.out.println("Enter employee ID:");
                    int employeeId = scanner.nextInt();
                    System.out.println("Enter department:");
                    scanner.nextLine(); // Consume the newline character
                    String department = scanner.nextLine();
                    Employee newEmployee = new Employee("Employee", employeeId, department);
                    Employee.addEmployee(newEmployee);
                    System.out.println("Employee added successfully!");
                    break;
                case 14:
                    // Edit Employee
                    System.out.println("Enter index of the employee to edit:");
                    int employeeIndex = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter new role name:");
                    String editedEmployeeRoleName = scanner.nextLine();
                    System.out.println("Enter new department:");
                    String editedDepartment = scanner.nextLine();
                    Employee.editEmployee(employeeIndex, editedEmployeeRoleName, editedDepartment);
                    System.out.println("Employee updated successfully!");
                    break;
                case 15:
                    // Delete Employee
                    System.out.println("Enter index of the employee to delete:");
                    int deleteEmployeeIndex = scanner.nextInt();
                    Employee.deleteEmployee(deleteEmployeeIndex);
                    System.out.println("Employee deleted successfully!");
                    break;
                case 16:
                    // Search Employee
                    System.out.println("Enter role name to search:");
                    scanner.nextLine(); // Consume the newline character
                    String searchEmployeeRoleName = scanner.nextLine();
                    System.out.println("Enter department to search:");
                    String searchDepartment = scanner.nextLine();
                    Employee searchEmployee = Employee.searchEmployee(searchEmployeeRoleName, searchDepartment);
                    if (searchEmployee != null) {
                        System.out.println("Employee found:");
                        System.out.println("Role name: " + searchEmployee.getRoleName());
                        System.out.println("Department: " + searchEmployee.getDepartment());
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 17:
                    System.out.println("Enter 1 to Add Attendance, 2 to Edit Attendance, 3 to Delete Attendance, 4 to Search Attendance, 5 to Get Attendance: ");
                    int ch = scanner.nextInt();
                    switch (ch) {
                        case 1:
                            System.out.println("Enter user ID to add attendance:");
                            int addUserId = scanner.nextInt();
                            System.out.println("Enter 1 for Present, 0 for Absent:");
                            boolean isPresent = scanner.nextInt() == 1;
                            Attendance.addAttendance(addUserId, isPresent);
                            System.out.println("Attendance added successfully!");
                            break;
                        case 2:
                            System.out.println("Enter user ID to edit attendance:");
                            editUserId = scanner.nextInt();
                            System.out.println("Enter 1 for Present, 0 for Absent:");
                            boolean editIsPresent = scanner.nextInt() == 1;
                            Attendance.editAttendance(editUserId, editIsPresent);
                            System.out.println("Attendance edited successfully!");
                            break;
                        case 3:
                            System.out.println("Enter user ID to delete attendance:");
                            deleteUserId = scanner.nextInt();
                            Attendance.deleteAttendance(deleteUserId);
                            System.out.println("Attendance deleted successfully!");
                            break;
                        case 4:
                            System.out.println("Enter 1 for Present, 0 for Absent to search attendance:");
                            boolean searchIsPresent = scanner.nextInt() == 1;
                            searchUserId = Attendance.searchAttendance(searchIsPresent);
                            if (searchUserId != 0 && searchUserId != 0) {
                                System.out.println("Attendance found for user with ID: " + searchUserId);
                            } else {
                                System.out.println("Attendance not found!");
                            }
                            break;

                        case 5:
                            System.out.println("Enter user ID to get attendance:");
                            int getUserId = scanner.nextInt();
                            Boolean getIsPresent = Attendance.getAttendance(getUserId);
                            if (getIsPresent != null) {
                                System.out.println("Attendance for user with ID " + getUserId + " is " + (getIsPresent ? "Present" : "Absent"));
                            } else {
                                System.out.println("Attendance not found!");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;
                case 18:
                    // Manage Leave
                    System.out.println("===== Manage Leave =====");
                    System.out.println("1. Add Leave");
                    System.out.println("2. Edit Leave");
                    System.out.println("3. Delete Leave");
                    System.out.println("4. Get Leave Days");
                    System.out.println("5. Search Leave");
                    System.out.println("0. Go back");
                    System.out.println("Enter your choice: ");
                    int leaveChoice = scanner.nextInt();

                    switch (leaveChoice) {
                        case 1:
                            // Add Leave
                            System.out.println("Enter user ID:");
                            int leaveUserId = scanner.nextInt();
                            System.out.println("Enter number of leave days:");
                            int numberOfLeaveDays = scanner.nextInt();
                            leave.addLeave(leaveUserId, numberOfLeaveDays);
                            System.out.println("Leave added successfully!");
                            break;
                        case 2:
                            // Edit Leave
                            System.out.println("Enter user ID to edit leave:");
                            int editLeaveUserId = scanner.nextInt();
                            System.out.println("Enter new number of leave days:");
                            int editNumberOfLeaveDays = scanner.nextInt();
                            leave.editLeave(editLeaveUserId, editNumberOfLeaveDays);
                            System.out.println("Leave edited successfully!");
                            break;
                        case 3:
                            // Delete Leave
                            System.out.println("Enter user ID to delete leave:");
                            int deleteLeaveUserId = scanner.nextInt();
                            leave.deleteLeave(deleteLeaveUserId);
                            System.out.println("Leave deleted successfully!");
                            break;
                        case 4:
                            // Get Leave Days
                            System.out.println("Enter user ID to get leave days:");
                            int getLeaveDaysUserId = scanner.nextInt();
                            int leaveDays = leave.getLeaveDays(getLeaveDaysUserId);
                            System.out.println("Leave Days: " + leaveDays);
                            break;
                        case 5:
                            // Search Leave
                            System.out.println("Enter the number of leave days to search:");
                            int searchLeaveDays = scanner.nextInt();
                            List<Integer> leaveSearchResults = leave.searchLeave(searchLeaveDays);
                            if (!leaveSearchResults.isEmpty()) {
                                System.out.println("Users with the specified leave days:");
                                for (int UserId : leaveSearchResults) {
                                    System.out.println("User ID: " + UserId);
                                }
                            } else {
                                System.out.println("No users found with the specified leave days!");
                            }
                            break;
                        case 0:
                            // Go back
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                    break;

            }
        }
    }
}