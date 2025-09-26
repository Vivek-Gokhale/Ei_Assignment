public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("DatabaseConnection created!");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) { // First check
            synchronized (DatabaseConnection.class) {
                if (instance == null) { // Second check
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
}
