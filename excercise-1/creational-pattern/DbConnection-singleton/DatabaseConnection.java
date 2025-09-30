// Singleton class: ensures only one instance of DatabaseConnection exists
public class DatabaseConnection {
    private static DatabaseConnection instance; // single shared instance

    // private constructor to prevent external instantiation
    private DatabaseConnection() {
        System.out.println("DatabaseConnection created!");
    }

    // get the single instance of DatabaseConnection
    public static DatabaseConnection getInstance() {
        if (instance == null) { // first check without locking
            synchronized (DatabaseConnection.class) { // lock for thread safety
                if (instance == null) { // second check inside synchronized block
                    instance = new DatabaseConnection(); // create instance
                }
            }
        }
        return instance; // return existing or newly created instance
    }
}
