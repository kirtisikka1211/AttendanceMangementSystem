package AttendanceMangement;
    public class User {
        private String name;
        private int userId;
        private Role role;
    
        public User(String name, int userId, Role role) {
            this.name = name;
            this.userId = userId;
            this.role = role;
        }
    
        public String getName() {
            return name;
        }
    
        public int getUserId() {
            return userId;
        }
    
        public Role getRole() {
            return role;
        }
    
        public static User addUser(String name, int userId, Role role) {
            return new User(name, userId, role);
        }
    
        public void editUser(String name, Role role) {
            this.name = name;
            this.role = role;
        }
    
        public void deleteUser() {
            this.name = null;
            this.userId = 0;
            this.role = null;
        }
    
        public static User searchUser(User[] users, int userId) {
            for (User user : users) {
                if (user.getUserId() == userId) {
                    return user;
                }
            }
            return null;
        }
    }
    

