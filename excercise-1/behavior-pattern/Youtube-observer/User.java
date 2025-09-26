// User class implements Observer and receives updates from channels
class User implements Observer {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }


    // Called when a channel publishes a video
    public void update(String channelName, String videoTitle) {
        System.out.println("User " + userName + " notified: New video \"" + videoTitle + "\" from " + channelName);
    }
}
