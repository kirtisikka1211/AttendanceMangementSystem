package AttendanceMangement;

import java.util.ArrayList;
import java.util.List;

public class Role {
    private static List<Role> rolesList = new ArrayList<>();
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public static List<Role> getRolesList() {
        return rolesList;
    }

    public static void addRole(Role role) {
        rolesList.add(role);
    }

    public static void editRole(int index, String roleName) {
        Role role = rolesList.get(index);
        role.roleName = roleName;
    }

    public static void deleteRole(int index) {
        rolesList.remove(index);
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role searchRole(String roleName) {
        for (Role role : rolesList) {
            if (role.getRoleName().equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        return null;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
