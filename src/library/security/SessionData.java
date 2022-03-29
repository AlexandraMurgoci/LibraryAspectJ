package library.security;

public class SessionData {
    private static String activeUsername;
    private static Role activeRole;

    private SessionData() {
        activeUsername = null;
        activeRole = null;
    }

    public static String getActiveUsername() {
        return activeUsername;
    }

    public static Role getActiveRole() {
        return activeRole;
    }

    public static void setActiveUsername(String activeUsername) {
        SessionData.activeUsername = activeUsername;
    }

    public static void setActiveRole(Role activeRole) {
        SessionData.activeRole = activeRole;
    }
}
