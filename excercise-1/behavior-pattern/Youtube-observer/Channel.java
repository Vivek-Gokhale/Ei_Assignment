import java.util.ArrayList;
import java.util.List;

class Channel implements Subject {
    private String name;
    private List<Observer> subscribers;

    public Channel(String name) {
        this.name = name;
        subscribers = new ArrayList<>();
    }

     // Method to add a subscriber
    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    // Method to remove a subscriber
    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    // Notify all subscribers about a new video
    @Override
    public void notifyAllSubscribers(String videoTitle) {
        for (Observer observer : subscribers) {
            observer.update(this.name, videoTitle);
        }
    }

    // Publish a new video and notify all subscribers
    public void publishVideo(String videoTitle) {
        System.out.println("Channel " + name + " published a new video: " + videoTitle);
        notifyAllSubscribers(videoTitle);
    }
}
