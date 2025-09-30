// Subject interface: channels implement this to manage subscribers
public interface Subject {

    // subscribe a new observer (add user to the subscriber list)
    void subscribe(Observer user);

    // unsubscribe an observer (remove user from the subscriber list)
    void unsubscribe(Observer user);

    // notify all subscribed observers about a new video
    void notifyAllSubscribers(String videoTitle);
}
