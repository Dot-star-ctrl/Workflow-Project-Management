package workflow.api.user;

public class User {
    private final int userId;
    private final String name;

    public User() {
        userId = 0;
        name = null;
    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
