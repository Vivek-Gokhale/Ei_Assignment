// Builder class for constructing SmartHome objects step by step
public class SmartHomeBuilder {
    private boolean lights;
    private boolean thermostat;
    private boolean securitySystem;
    private boolean entertainmentSystem;
    private boolean sprinklers;

    // Set lights feature and return builder for chaining
    public SmartHomeBuilder lights(boolean lights) {
        this.lights = lights;
        return this;
    }

    // Set thermostat feature and return builder for chaining
    public SmartHomeBuilder thermostat(boolean thermostat) {
        this.thermostat = thermostat;
        return this;
    }

    // Set securitySystem feature and return builder for chaining
    public SmartHomeBuilder securitySystem(boolean securitySystem) {
        this.securitySystem = securitySystem;
        return this;
    }

    // Set entertainmentSystem feature and return builder for chaining
    public SmartHomeBuilder entertainmentSystem(boolean entertainmentSystem) {
        this.entertainmentSystem = entertainmentSystem;
        return this;
    }

    // Set sprinklers feature and return builder for chaining
    public SmartHomeBuilder sprinklers(boolean sprinklers) {
        this.sprinklers = sprinklers;
        return this;
    }

    // Build and return the SmartHome object with the selected features
    public SmartHome build() {
        return new SmartHome(lights, thermostat, securitySystem, entertainmentSystem, sprinklers);
    }
}
