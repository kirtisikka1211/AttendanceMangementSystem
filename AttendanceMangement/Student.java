package AttendanceMangement;

import java.util.ArrayList;
import java.util.List;


    public class Student extends Role {
    private static List<Student> studentsList = new ArrayList<>();
    private int studentId;
    private String course;

    public Student(String roleName, int studentId, String course) {
        super(roleName);
        this.studentId = studentId;
        this.course = course;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public static List<Student> getStudentsList() {
        return studentsList;
    }

    public static void addStudent(Student student) {
        studentsList.add(student);
    }

    public static void editStudent(int index, String roleName, String course) {
        Student student = studentsList.get(index);
        student.setRoleName(roleName);
        student.setCourse(course);
    }

    public static void deleteStudent(int index) {
        studentsList.remove(index);
    }

    public static Student searchStudent(String roleName, String course) {
        for (Student student : studentsList) {
            if (student.getRoleName().equalsIgnoreCase(roleName) && student.getCourse().equalsIgnoreCase(course)) {
                return student;
            }
        }
        return null;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
    

