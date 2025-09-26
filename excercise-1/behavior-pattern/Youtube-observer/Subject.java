// Subject interface (channels implement this)
public interface Subject {
    void subscribe(Observer user);
    void unsubscribe(Observer user);
    void notifyAllSubscribers(String videoTitle);
}