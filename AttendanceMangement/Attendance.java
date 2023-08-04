package AttendanceMangement;

import java.util.ArrayList;
import java.util.List;

public class Attendance {
    private static List<Integer> userIds;
    private static List<Boolean> attendanceList;

    public Attendance() {
        userIds = new ArrayList<>();
        attendanceList = new ArrayList<>();
    }

    public static void addAttendance(int userId, boolean isPresent) {
        if (!userIds.contains(userId)) {
            userIds.add(userId);
            attendanceList.add(isPresent);
        }
    }

    public static void editAttendance(int userId, boolean isPresent) {
        if (userIds.contains(userId)) {
            int index = userIds.indexOf(userId);
            attendanceList.set(index, isPresent);
        }
    }

    public static void deleteAttendance(int userId) {
        if (userIds.contains(userId)) {
            int index = userIds.indexOf(userId);
            userIds.remove(index);
            attendanceList.remove(index);
        }
    }

    public static Boolean getAttendance(int userId) {
        if (userIds.contains(userId)) {
            int index = userIds.indexOf(userId);
            return attendanceList.get(index);
        }
        return null;
    }

    public static Integer searchAttendance(boolean isPresent) {
        int index = attendanceList.indexOf(isPresent);
        if (index >= 0) {
            return userIds.get(index);
        }
        return null;
    }
}