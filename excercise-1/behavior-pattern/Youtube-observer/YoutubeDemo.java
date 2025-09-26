public class YoutubeDemo {
    public static void main(String[] args) {
        Channel techChannel = new Channel("TechExplained");
        Channel cookingChannel = new Channel("CookingMagic");

        User vivek = new User("Vivek");
        User ramesh = new User("Ramesh");

        // Subscribe users
        techChannel.subscribe(vivek);

        techChannel.unsubscribe(ramesh);

        cookingChannel.subscribe(vivek);

        // Publish videos
        techChannel.publishVideo("Observer Pattern in Java");
        cookingChannel.publishVideo("Best Pasta Recipe");

        // Unsubscribe a user
        techChannel.unsubscribe(ramesh);

        // Publish another video
        techChannel.publishVideo("Java Streams Tutorial");
    }
}
