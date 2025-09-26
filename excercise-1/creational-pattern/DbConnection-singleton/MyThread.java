class MyThread extends Thread {
    
    public void run() {
        DatabaseConnection db = DatabaseConnection.getInstance();
        System.out.println(Thread.currentThread().getName() + " got instance: " + db);
    }
}
