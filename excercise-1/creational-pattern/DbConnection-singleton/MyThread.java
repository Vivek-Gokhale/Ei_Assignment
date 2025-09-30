// Thread class to test DatabaseConnection singleton
class MyThread extends Thread {

    @Override
    public void run() {
        // each thread tries to get the singleton instance
        DatabaseConnection db = DatabaseConnection.getInstance();

        // print the instance and current thread name
        System.out.println(Thread.currentThread().getName() + " got instance: " + db);
    }
}
