// Leaf in Composite pattern: represents a single host with an IP mapping
class HostRecord implements DomainComponent {
    private String name; // hostname
    private String ip;   // IP address

    public HostRecord(String name, String ip) {
        this.name = name; // set hostname
        this.ip = ip;     // set IP
    }

    // display host record with indentation level
    public void show(int level) {
        System.out.println("  ".repeat(level) + "- " + name + " -> " + ip);
    }
}
