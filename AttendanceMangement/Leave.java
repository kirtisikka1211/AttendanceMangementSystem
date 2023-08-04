package AttendanceMangement;

import java.util.ArrayList; 
import java.util.List;
public class Leave {
    private List<Integer> userIds;
    private List<Integer> leaveList;

    public Leave() {
        userIds = new ArrayList<>();
        leaveList = new ArrayList<>();
    }

    public void addLeave(int userId, int numberOfDays) {
        if (!userIds.contains(userId)) {
            userIds.add(userId);
            leaveList.add(numberOfDays);
        }
    }

    public void editLeave(int userId, int numberOfDays) {
        if (userIds.contains(userId)) {
            int index = userIds.indexOf(userId);
            leaveList.set(index, numberOfDays);
        }
    }

    public void deleteLeave(int userId) {
        if (userIds.contains(userId)) {
            int index = userIds.indexOf(userId);
            userIds.remove(index);
            leaveList.remove(index);
        }
    }

    public int getLeaveDays(int userId) {
        if (userIds.contains(userId)) {
            int index = userIds.indexOf(userId);
            return leaveList.get(index);
        }
        return 0;
    }

    public List<Integer> searchLeave(int numberOfDays) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < userIds.size(); i++) {
            if (leaveList.get(i) == numberOfDays) {
                results.add(userIds.get(i));
            }
        }
        return results;
    }
}
