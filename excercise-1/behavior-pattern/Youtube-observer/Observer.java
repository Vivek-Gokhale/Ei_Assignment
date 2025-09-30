// Observer interface: subscribers implement this to get updates
interface Observer {
    // called by Subject/Publisher to notify subscriber
    void update(String channelName, String videoTitle);
}
