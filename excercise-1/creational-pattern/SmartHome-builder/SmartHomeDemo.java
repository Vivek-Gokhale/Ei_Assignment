public class SmartHomeDemo {
    public static void main(String[] args) {
        // Basic Smart Home
        SmartHome basicHome = new SmartHomeBuilder()
                .lights(true)
                .thermostat(true)
                .build();

        // Luxury Smart Home
        SmartHome luxuryHome = new SmartHomeBuilder()
                .lights(true)
                .thermostat(true)
                .securitySystem(true)
                .entertainmentSystem(true)
                .sprinklers(true)
                .build();

        System.out.println("Basic Home:\n" + basicHome);
        System.out.println("\nLuxury Home:\n" + luxuryHome);
    }
}
