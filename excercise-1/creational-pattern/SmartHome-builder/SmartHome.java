// SmartHome class represents a house with optional features
// Uses Builder pattern to create complex object step by step
public class SmartHome {
    // Optional features of the smart home
    private boolean lights;
    private boolean thermostat;
    private boolean securitySystem;
    private boolean entertainmentSystem;
    private boolean sprinklers;
    
    // Private constructor, only Builder can instantiate SmartHome
    public SmartHome(boolean lights, boolean thermostat, boolean securitySystem,
                      boolean entertainmentSystem, boolean sprinklers) {
        this.lights = lights;
        this.thermostat = thermostat;
        this.securitySystem = securitySystem;
        this.entertainmentSystem = entertainmentSystem;
        this.sprinklers = sprinklers;
    }

    // Display all features of the SmartHome
    @Override
    public String toString() {
        return "SmartHome Features: " +
                "\nLights: " + lights +
                "\nThermostat: " + thermostat +
                "\nSecurity System: " + securitySystem +
                "\nEntertainment System: " + entertainmentSystem +
                "\nSprinklers: " + sprinklers;
    }

    // Getter methods to check which features are present
    public boolean hasLights() { return lights; }
    public boolean hasThermostat() { return thermostat; }
    public boolean hasSecuritySystem() { return securitySystem; }
    public boolean hasEntertainmentSystem() { return entertainmentSystem; }
    public boolean hasSprinklers() { return sprinklers; }
}
