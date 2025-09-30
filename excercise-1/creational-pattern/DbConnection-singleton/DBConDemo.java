// Demo class to test DatabaseConnection singleton with multiple threads
public class DBConDemo {
    public static void main(String[] args) {
        // create two threads
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // start threads (they will try to get the singleton instance)
        t1.start();
        t2.start();
    }
}
