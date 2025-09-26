// Leaf (Host Record: final IP mapping)
class HostRecord implements DomainComponent {
    private String name;
    private String ip;

    public HostRecord(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public void show(int level) {
        System.out.println("  ".repeat(level) + "- " + name + " -> " + ip);
    }
}
